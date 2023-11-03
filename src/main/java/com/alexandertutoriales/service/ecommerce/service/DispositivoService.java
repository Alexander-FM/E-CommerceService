package com.alexandertutoriales.service.ecommerce.service;

import static com.alexandertutoriales.service.ecommerce.utils.Global.OPERACION_CORRECTA;
import static com.alexandertutoriales.service.ecommerce.utils.Global.OPERACION_ERRONEA;
import static com.alexandertutoriales.service.ecommerce.utils.Global.RPTA_ERROR;
import static com.alexandertutoriales.service.ecommerce.utils.Global.RPTA_OK;
import static com.alexandertutoriales.service.ecommerce.utils.Global.RPTA_WARNING;
import static com.alexandertutoriales.service.ecommerce.utils.Global.TIPO_DATA;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import com.alexandertutoriales.service.ecommerce.entity.Dispositivo;
import com.alexandertutoriales.service.ecommerce.repository.DispositivoRepository;
import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import com.alexandertutoriales.service.ecommerce.utils.SendNotification;
import org.springframework.stereotype.Service;

@Service
public class DispositivoService {

  private final DispositivoRepository repository;

  private static final String FCM_APIKEY =
      "AAAAcx-D8LU:APA91bF_OGWRo1MYE57GgYqF4WSTNePIy_NMSLnDomycLj4"
          + "-bnhTa0KnwedSRBblYZ50z0dbL3miMvsobHe45jwksubI43feJ3BZ2Es8l0U6As0QJArTFnWDqtmtzeMAwFfjqVqZk1zh";

  private static final String URL = "https://fcm.googleapis.com/fcm/send";

  public DispositivoService(DispositivoRepository repository) {
    this.repository = repository;
  }

  public GenericResponse<Dispositivo> registerDevice(Dispositivo dispositivo) {
    return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA,
        this.repository.save(dispositivo));
  }

  public GenericResponse sendNotification(SendNotification notification, int deviceID) throws MalformedURLException {
    Optional<Dispositivo> dispositivo = this.repository.findById(deviceID);
    if (dispositivo.isPresent()) {
      notification.setId(dispositivo.get().getDeviceId());
      try {
        URL url = new URL(URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // Configurar la conexión
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "key=" + FCM_APIKEY);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);
        // Construir el cuerpo de la solicitud
        String body = buildNotificationBody(notification);
        // Enviar la solicitud
        OutputStream os = conn.getOutputStream();
        os.write(body.getBytes());
        os.flush();
        // Verificar la respuesta
        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
          // La notificación se envió correctamente
          System.out.println("Notificación enviada correctamente.");
          return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA,
              notification);
        } else {
          // Hubo un error al enviar la notificación
          System.out.println("Error al enviar la notificación. Código de respuesta: " + responseCode);
          return new GenericResponse(TIPO_DATA, RPTA_ERROR, OPERACION_ERRONEA,
              "Error al enviar la notificación. Código de respuesta");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return new GenericResponse(TIPO_DATA, RPTA_WARNING, OPERACION_ERRONEA,
        "El deviceID no ha sido encontrado");
  }

  private static String buildNotificationBody(SendNotification notification) {
    return String.format(
        "{\"to\":\"%s\",\"notification\":{\"title\":\"%s\",\"body\":\"%s\"}}",
        notification.getId(), notification.getTitle(), notification.getMessage()
    );
  }
}
