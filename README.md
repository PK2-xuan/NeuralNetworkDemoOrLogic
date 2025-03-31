# Neural Network Prediction API

Este proyecto utiliza Spring Boot y Deeplearning4j para crear una API REST que realiza predicciones utilizando una red neuronal entrenada. La API recibe datos de entrada en formato JSON y devuelve las predicciones en formato JSON.

## Tabla de Contenidos
1. [Descripción](#descripción)
2. [Tecnologías Utilizadas](#tecnologías-utilizadas)
3. [Instalación](#instalación)
4. [Uso](#uso)
5. [Ejemplo](#ejemplo)
6. [Contribuir](#contribuir)
7. [Licencia](#licencia)

## Descripción

Este proyecto es una API REST que permite realizar predicciones utilizando una red neuronal entrenada. Se utiliza Deeplearning4j para el modelo de red neuronal y Spring Boot para exponer la API. El modelo realiza una predicción en base a las entradas proporcionadas y devuelve un valor decimal, así como una predicción binaria (0 o 1) dependiendo de si el valor es mayor o menor que 0.5.

## Tecnologías Utilizadas

- **Java**
- **Spring Boot**
- **Deeplearning4j**
- **Postman** (para probar la API)

## Instalación

1. Clona el repositorio:

   ```bash
   git clone https://github.com/PK2-xuan/NeuralNetworkDemoOrLogic.git

   cd tu-repositorio
   
   mvn spring-boot:run

   http://localhost:8080

## Uso
2. Uso en Postman:

   ```bash
   Realiza una solicitud POST en Postman:
   POST http://localhost:8080/api/predict
   
   En el cuerpo de la solicitud (BODY): 
   {
     "inputs": [0.1, 1]
   }

   Respuesta esperada:
   {
     "Predicción (decimal)": "0.3926",
     "Predicción (0 o 1)": 0
   }

## Ejemplo:

3. Ejemplo de lo que se vería en Postman:
   
   <img src="https://github.com/PK2-xuan/NeuralNetworkDemoOrLogic/blob/master/image.png" alt="Imagen de Postman" height="400" width="800">

## Contribuir

¡Gracias por tu interés en contribuir a este proyecto! Si deseas contribuir, por favor sigue los siguientes pasos:

### Pasos para Contribuir

1. **Haz un Fork del Repositorio**  
   Haz un fork de este repositorio para poder hacer cambios de manera segura sin afectar el repositorio original.

2. **Crea una Rama Nueva**  
   Antes de comenzar a hacer tus cambios, crea una nueva rama:
   
   ```bash
   git checkout -b nombre-de-tu-rama

3. **Haz tus Cambios**
   Realiza tus modificaciones en el código según lo que necesites. Recuerda que este proyecto usa Java, Spring Boot y Deeplearning4j.

4. **Realiza un Commit**
   Después de hacer los cambios, realiza un commit con un mensaje descriptivo:
   
   ```bash
   git add .
   git commit -m "Descripción clara de lo que has hecho"

5. **Haz un Push a tu Fork**
   Empuja tus cambios a tu repositorio en GitHub:
   ```bash
   git push origin nombre-de-tu-rama

6. **Abre un Pull Request**
Ve a la página del repositorio original en GitHub y abre un Pull Request (PR) para que tus cambios sean revisados y, si son adecuados, sean fusionados con el proyecto principal.

## Reglas para Contribuir
- Asegúrate de que tu código esté bien documentado.

- Añade pruebas si es posible para validar tu código.

- Si estás corrigiendo un bug, intenta reproducir el error antes de solucionarlo.

- Sigue el estilo de codificación del proyecto.

¡Espero tu contribución!

Si tienes alguna duda o pregunta, no dudes en abrir un issue en el repositorio.

   ```bash
   Este texto cubre lo básico de cómo puedes contribuir al proyecto. Te proporciona instrucciones claras y accesibles para los desarrolladores
   que deseen aportar al código, además de crear una estructura amigable y abierta para contribuciones.
   
   Si tienes alguna otra pregunta o necesitas ajustar algo más, ¡avísame! 😊
