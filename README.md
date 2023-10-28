# Servicio de Ecommerce con Spring Boot
Este proyecto es un servicio de comercio electrónico desarrollado en Spring Boot que utiliza diversas tecnologías como Java 8, Web Sockets, JasperReports, MySQL y Firebase Cloud Messaging para proporcionar funcionalidades avanzadas.

# Requisitos
Asegúrate de tener instalados los siguientes componentes:

* Java 8
* MySQL
* Firebase Cloud Messaging (para notificaciones push)
* JasperReports (para generación de informes)

# Configuración
## Base de Datos
Crea una base de datos MySQL e importa el script de base de datos proporcionado en bd_ecommerce.sql.

Configura las credenciales de la base de datos en el archivo src/main/resources/application.properties.

```bash
  spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
  spring.datasource.username=tu_usuario
  spring.datasource.password=tu_contraseña
```
## Firebase Cloud Messaging
Obtén las credenciales de Firebase y configúralas en el archivo src/main/resources/application.properties.

```bash
  firebase.api.key=tu_api_key
  firebase.project.id=tu_project_id
```
## WebSockets
En este proyecto, utilizamos WebSockets para enviar notificaciones en tiempo real a la aplicación web cuando se registra una compra desde el aplicativo móvil.
## JasperReports
Asegúrate de tener JasperStudio correctamente instalado y configurado en tu sistema por si deseas agregar más reportes.

# Ejecución
Para ejecutar el servicio, simplemente ejecuta el siguiente comando en la raíz del proyecto: 

```bash
  mvn spring-boot:run
```
Pero antes de todo, recomendamos hacer un clean install para que asegurarte de que los mappers generados estén actualizados y correctamente incorporados en la aplicación.
```bash
  mvn clean
  mvn install
```

# Uso
El servicio proporciona una API REST documentada con Swagger. Puedes acceder a la documentación en: [documentation.local.](http://localhost:8080/swagger-ui.html)

# Pantallazos

![App](https://lh3.googleusercontent.com/pw/ADCreHcnlNQnGz01GfkJ8by7fszPb2UmCuy8SxUEXkyN_8QC--ripzXbqFTkHsXs-ohHhtkihOTgma4f296Ye8xFUbWx5sNn5WYbxiC9WDnsbxKJaZv4BSev-Uyo6RkcZ4t0_QsTWJvaMysEyoLmGvk59uriN8BpbeCxdXsXOEA-61qBmSVoFtdORnVGPRAKe_tphRp5xmxS6f-_DH9d9nXBBSRuXUkToFzgIwp8yl1FObTnreksNirf-ZHCtP9tVGKWwx9v6jLRu5YEpVoCtoITsL_ZVhfm_2Z8ehC8BRAf3H7brJ8OV6xj106kzAVw2_xknCC5QP60giak9LlaVb66FQfcYE2NQASjsKKJ5Kkv4-eTmO9P-lCvI_Wtmslbk6RlljPiGNHtmEhW5Aicuqf9O8JD4Flq_24o6UDj8OnvJUDyjXihDgZFkZzRc66zwP0E755zeFOdpV0WNjV-CuAgvJ0f0V4LmGQB3sOOIcA6m4NZVkwACtA7MqDRuiosRHP_PPIIUv-LDlSDUC82tBh9DSYXUFrfU5qkT5y5W6-YlXWzW0b_MeeyGlIMbysvtHRwpudA0sryVXqHO5hzlJ4pYaUMutngPFldtvG8xpyRKEE38KVKXvy2QGdbT3UO9KI8CKEg2tiTt6R8Ro19E-3Nbm4gdSA90iboyAaFpYD1hXDN3olAGVduye2D2A78ftmSG1e-QlQfQ1EaDGubLfX6QXMTWJoWT5EoCWkWKONGwlsJ_9dRc_DKMApB31M9NSOGgOfIX3YRlwco-MOMflT6vEoAy7RlbDbFls8yp48-3wd1I10kCejZVvma58mY5BXP1M0-fQDH4_v4eqfKa3C7an4HARpQC0raXBuBr6OS6aZK8zTArufB6IZWPAkKNpuM8TrUq8q89nbnoH6Eqi-Nzk0=w1130-h202-s-no-gm?authuser=0)
![Home Controller](https://lh3.googleusercontent.com/pw/ADCreHebnjtgFpgDZM0r5EVN_Px9-IUTCtJaud_h9y3Tm81ZKmmH2fywjClaS8qQpXUUjD8PGd5WeYvZ-2SL4LbCmFG5ee7lkKS81pXeVVIWhpCu2Ll8ZjMZGbP50TzHVAu_2Y4VFZpd6oteTZywvwCAzrzrQWI5BnQptKX3-aIQk2Ue0qrR2qh91XCwIZ-eBq9Ojj7EeNySDRDAiVLygd3IdV9MnU2zNiKRTTiniDcYsUegg54Bn_ZbjLfs4xpU2HlRsvdlLgWfzmCPxTs3gSZ2_728-REWxxOCsDSuIfcTa_Xcxab2u47sqX7DqO2yFQZpmfPUYDJgKGyHktafyzk6xPlwQ137oz1ISEcB7Pc03MW40D2JzrspnBSwpiMiIyCZEv67C675JK0mxOqnqWlgDV71KxkQk-TsziFK1Rmk2V0IG9fYE-YmcUxut4PLGo2TjnMdpUfFV3CZopteQQ8gB3Yu2aIMksRZryD0ACPfIZX2AA9Pc3_pRFQo9bu_Op2Om7w4wmSwI4p3DnoK8ZvpspjpvYUfKE6Q6BqcE9B4_s3MujfdCTrRHFfMNRYaMzyKZOANSl3jsYRt-kyr_NkVINMra4blWWByY1SeM7x5GtvRvLcO6sJbqOaLjzB2-O_0Px7pmTB6HFLlNCW17xqNOaFh3-NB9TThEyxlBWFykssQNEZMNiCqf-3dq-yXi4dcNWLCQAYxmXJ7C7WaU0noat_EnqEZRFXqflgrauFs1bV5UmibzBccDyYz2A3aYcfKEnk43I-8VeVxLw35F2tt1sQaSZAjRcM65GMDzjemgoWcLl6cj4Aam40dmA6knLqiRIRvO7Z-3GlfY1pw1L-SmlsznnV5KDL1qPPkR9VabXL_ORPT2LNsVbVWIToRlzmVqezLUrEdL6ympRfZR6pZre0=w1100-h225-s-no-gm?authuser=0)
![Navegador](https://lh3.googleusercontent.com/pw/ADCreHfF95dr0UELC-3BTDXmsngu-Bq5LK4uGYSTfyKIBUij4fn3jWxoghpP2ZGdNgmfWDmDoGEJhFG9dre_9VFmMWsuNiK10roaJPjkw9yX4icblF4uRq3bE3A8p4G5sONWEcM3txbZyFYVEiE6_V6STCUolvyM4288WTyLFfmISXgycfimT6LDz0KhBEwiTM8tdnzRJ-CMNmdkR_nYstUsu-Ur3CcmuLfshsBOZYzuhgrN02ecaS02bXVTz0N4y3bAYJmpZK3F2RJgX7G6zQK5PLA0Vio5s04CTcVLI7Fr3CUhbAvA1YmawZSQY69nkVsTsphHGo5CIGd5VQuvEahhMgofYvkklS4qWswANdn_zC0dxwuNS1h91VbW133o_XxmkX2wmuCtl0EnYIYn4CmkdkuY-fvoDFnnSeTL2OggzTCwHUaxubMbjdM350tAuryQuoqeTFb8fmBwNWlCT8nuThts3mzYOlSIOQH2vaf3s0wZaBx4XJtHRuinB0taaf2k0yIwC5dFoxdRYPXc7oiCgO6mueMV80MoMpP2a284pyzzWM-P6BsCtawdrN7CgeldorW4wZSFZ1HTKyQDOzK4xGd4FNebWHbGwHUUYF5U622Oreg5-ehkewG_IroE5J8rWPLvPhYme4MPN7yOYXFdgNmoUZAlDd1DqEyY5Qz3jvJDrrZ3zK5yRM7ueo8PyyX_jmMasigaehSVCkX7H4RSJM7GY4vmy7ZFhfprl18-bDw3FVMZpgiIeVK-Sm4BGXgWKulwoFOrp6ZpWO757lW-kmGwtIcN4yxAU3ogG1EPUM20qVowvcSxaQP4iIXGBXFcu2Ee2pe4ZBFchKYFaPsK1K71_1spWZdkjhZEOD9lw-WgI8nN9fk1LZXm_zIVoalAGrax-EHde0YsmLvKZLlTWIM=w613-h161-s-no-gm?authuser=0)

# Contribución
Si deseas contribuir a este proyecto, por favor sigue los siguientes pasos:

1. Crea un fork del repositorio.
2. Crea una rama para tu nueva funcionalidad: git checkout -b nueva-funcionalidad.
3. Haz tus cambios y realiza commit: git commit -m 'Añade nueva funcionalidad'.
4. Haz push a tu rama: git push origin nueva-funcionalidad.
5. Crea un pull request en GitHub.

# Licencia
Este proyecto está bajo la licencia de MIT. Consulta el archivo LICENSE para más detalles

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
