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

## 🚀 Contacto
Hola, y mi nombre es Alexander! 👋 I'm a full stack developer...
Si necesitas ayuda adicional, no dudes en contactarme alexanderfuentes199912@gmail.com.

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

# Pantallazos

![App](https://lh3.googleusercontent.com/fife/AK0iWDzYf6s7OCls6jJkk5w7hPYW6vz6JKJpUVeYPgyOv-Z_r_s2RfFKspEe5ZADbDLce7h5uzKkiFhOvT18JV8FMHWfQK6DD9Ipus_hm7LagcLEn5XzMcJA3aWA6jwlr4hLJAYgidojXfDN6oepfdK1oksqSY483ap-lHRPoHa-QAZWtrUIotc1Xs5Xh0Ir4v8h3mzVU8Sy0gvKlgAqxp6uXcIcm-ilMtLszEQQgCH08cFH_M0fu7YQa1JiA1ssWr7aIeUQ4wz-oIJYTIVYoS2CYuv53XL_IqQSKdGTIOHcd5aG9B79JexRDvOiSsaOwrP02SgwDEbEmHfKvjXR_5dQNeQZDo59ynqYyvMYqzsIQx6e815xVc_Jpv-7ab860E3uxtjeCeaT_eRql_vdTvTRdEClKbMry_mj9wCzsmxNI7iCVBUbOOE3JRSSr_gJ00JnqQCiCaIEBG8khGGuD0f0nJoSjVgM-r6qEjFFq0tgPmW2F-tpfIpjvdPHjCSv2lGbladavezYeQ9TwELc0KMEaAvNE4NB81DfR__3eiPR4asJIDBjYPJHPWD4yxKkoExBScAAVZtrgp12udeRLGC9SAAivXV9FctO0ptK0qh7DZlzJexkpu_jOBAsyYKQj8yCpZy7F-94CRgVu2zn2LTltWhiFYyrQd22q-gx7OyeEDBGXgVKs7et53R3Ga6cUHByK3yX3LOPSOFlyRmesnmsZAkSIvL-H-5_IVqxjqeaxj5W-weNEI_vtgiq5bUutMat0tM8_azkYNmDh99H6sh8easvicArICtsfOt_VOjjnIsdpInFwUnLio2aFniv_eGMrNK-lbwOMjFIRTBkMN5LQGOfJUHvvxzvKpAc8sdpEurnCJsS3kHzcVZPU-wBx4VtVEbBsttTD47KE7mTVRPHdpdGOuFWJ8oF09cuVPnmzY9-9Uvt7MUild5CBmbeEC2XU3GU18TVzsbsHjn-_73Np9SgXv78kgtDRZEPhJCMSX8EZnM-aE91Izcq5OjovE2JHWD-_GHhRr_bLPMSnYHIRIJ8ewotPMoBDY5eWRjDSuVFwAIALORT9sJxxT0QrLM4dES35N8yXd32-LjHjMsmLjV-dSkE8SFmB6R8tRGVCGNvYPdqXA5j3UKDxbUkF-yTF8X9Ayh5RgCY59tB7LjycHVn_pScCn4kNaW5svw8qLKjyzU8J6UOd6mzhLj8vZ-y_pLQ0ExoWI8q3ry0qZXMDgq-8lLJiHPGloTW55P-NfTJ05A0kF8zTD-T2TvDDkaiK4v6gJ3y6ePivWShTfWWDGT8Tiq63_xX9-Mqau8cMjjGS_VS7ErbK5gANXc6yBJAEJJBWsyhtZtk3-5grlZVt1lHbWKKddzPTfMQHyyuZ8Cn8RdU-wGTTBCPl0yZKFg9DboAzMuypP5thNueffGeSCNB5AIi3qOuVfOb1013q4fDbzw3oUJbew2OjLeamKD5kQvMHMmR-43AuXqenURAUPX7rTcO8InSvzkxcicJsqTlCqYGuIxSpAC3mHdXeY-nlu-lTSiE0NWqLAyKWOcXT-39xSjWQVC3EYDycf21iUBvnpU_c9Yt3458xYPOJoJfS5h-D5ZItedny4vaEq2F5I_TM1NuPEusqyi_KUDD1p4kgXQjhFMieroOAwXfY8pLMNHPVPRinBguyhz0UsXtiMa0AL4=s1130-w1130-h202-s-no-gm?authuser=0)
![Home Controller](https://lh3.googleusercontent.com/pw/ADCreHfEzCmeOLScLskNcYVkbVTgPRJKsjVD0WCLF4DN4Pu7sbjzel8uvvbduulRMl9ZgW5q_rZOz_9d5YzP_VxKMiTMA03pFEfq7StPuY05tI-nppyx52F-wjTsqM4OfZUsxorIKVuKpXDX71KPCJ2exjnZMQDbim1XEyqMFD5qOz_OxzKWHWN_5miOzB8n4YN4uHBAPjhw5u1wd8hDIL-kUt9vIB15SUxcZ40Oh1_AEh0ErJFZ4bBrTbgmC89u2Bp7gFOk8aje91NSNER6feBagrlMc6voFTuP3TGyd1F_uTdgc1ghhLTcUv97uVDeEw9Mp--YyxXNFmJ7vtyw_1D6NWJ6xhghDZDRvEN8NVGbXH5dpf4DgelimmewoCRoF--nMCv9CmxaSqPYrRj7ywNRjuJ4yOWiCZhOr9ko0WQSh5ka-16CkJmJAIOpvE8DlgkpZoA4763RQ-1Y5auJf4kfu5SM0kJdwMHuYfS-NnzvAgl9epVcT6K2ZtMx_oMlmU_nkr4cDDiQuQqUge8NfQp39EXfoDprdwQ8nHVahj2eXhVD9M-zMMrUwtwk6k6Jvby8yr2FYm9ReIhuxl6i595nQntrzHSJlvnRaWn-n9u9LVPpThwBslkCjUQYHoxTraw8NCcpkmNduMhUHSLTXqbpt4rJWhZ8FiRWHL35RAIPaEPmrEhaMH1rvRRpe3OOZMH5KXOQ9vXDRSVjiavJOaI8E1rNjTzoPUZkbekTunLml_hiHirNxJUWiSL4-fw-FssxI9X1aCVlvIVeEQqpQePMEDw_kLcsjTkmH7hV7MDHbrJb90q9DGfWcw4FYHt1sISq7ACWRrVRVlH7rsrqgQQp2s5TtLxdCo8XoepNhZ4XPNzCJvioL9BjSyqWRXyagTZhWcFW9F4vr-vJEPpiVvfH9i4=w1100-h225-s-no-gm?authuser=0)
![Navegador](https://lh3.googleusercontent.com/fife/AK0iWDwmQMnCFlLDlCuClBDNTkMW0Y_ZBTOVjCoEqwIBy8TeXorspAbaZPiGHl_q4touC673jURcMosX2rt3i3fktCYwkMFgWbD99Qg2IRBWflAJT3iqRNSmzyuSRR46KMxrvQTmflrGu16J1ZEFSQ7t_7EyZUf9vY7r2v_mB9EdvHVhBpmzTr1lOQYdq5b2UHgxSrwKErgidobcjjP1n9_juBPCcm-XDlIzjX7glDRgEh5LCdXRuLbWMgPZO8-ltDC7vpSX0X_hCTurL39eyF2EWzEjw8jZ3pCxF36uE6Xp824B93op77ISHNp4bcpgeJIvuA4VIzrrMS7TtvLWdNlPsJm2cLTRnddiJmXN62x8QPlB_n3CmvWmAT5psYMHwtFil5C7k2Hd9J-t811IinzQ9lNcxfdwd7SEYhUqTMfVDWNwVjXGrajKOdOcN1RAQFF5D2onaYV_9bSGqpkgA5YIhw9FPUuGZV9kSkd-oQrV5tyaPy7WZRgXLm3cGxtZR16kwgvIiel-JYNbd4wJtLr8PtFxgchcdmAj07xz3fb8-FaMyb9s7Z11DTxVCLe2kCJQ4yR42kMOYa8-EfQHB2je_tMIaUd-SWM8mNbwk90bZ70xvfqHJsTN7m3PIel1qemIKymQiA2jWeWYmJj-eu0JZCsiX8XD_gpmdfWnuSudAhwvjH9k7KIiPaLSdavAxprc0bNRaLH_YkiuTvYDjys03ZDqowTJJKNFjYxuzOq6wPct9ugncwFSEIdHQQkzPoSbPBKIMoZmBwNlMsi184JJpN6FtK9reZeNZu9iFwdcIQGpTRbEPeW66Gj2GtmUoYUTdw8lxr3AvLu2uPlBSc6sB-NB4JqWlSsT9lwbnFOM-Kts3Fy2mADciccGZZBqAJsqiJdi97ah9avVBUOTmaJBQRc3-PrNdHL6V9Xlb-U-LQY-0M2DhE0-bqRBUWxjdVBRPG53tL-vQublooxGsbIc6JbDVLhrPazpDFvWkNQxcf4aMIcW3F7EsesPqT3cpYXL5NCjkL8fxRo1Y75wOPWbmKJFsSLEvQtPK2UlubNsAzGobJpwE0c7EJbpNSZwjAI0JGYWLt2Fwbcg7yey3ZewnBgkfg-kNhTuQFIrzbTmJyXS4ZAhEhSEKTdEE1P7Adl8VHQaeEJXt3tYuLJtZf5XM3v6BjX_1E3m56G3R8U7r2JVuw3lIwA6podnqn2Hf1r0D6ZuqymkE1Qak-VwWOLIqlJWRijijbGVa1DRad2mnKSlhp7v-uEg4eD0ZN8dZKL34Nj3TXXYaPcSu_uhE7z7HTL1dGHeYu_wc6fkML9XShhmv76Ldy9t9xxCmY6vhLx2upzkLpFfP0F6DKMh89-KrT3P7WfbUl-t7j6rQJS3MNvHoqsi32sO3Lpne_YZqOrTyRXZ2vLgghYBtjyvg9XG9AsOAT7-0k5m4xodhYn1GTm7ffCGYm9jkFIXlg4IBr0ziNNjQwrz7M8jvKtfCA9m1LYRKTSac9orpF_vQaTlLVwNYxuGzutgKc2oSGohxoZx2__Is0ogpCruCvJ_XtapgsaMKkFfz3cyeosDxjkiJFcysvMNFcovyDbRwkGmdwRURlxTMc_mejDSFem6QjUb3lYJs2jhGkMhPxVG4qLBAljGEpVN9MZrHmnmlN2VZosrrBAF_b8vy3M_ynYGDE-peaZ3NA8=s613-w613-h161-s-no-gm?authuser=0)
