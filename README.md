# Neural Network Prediction API

Este proyecto utiliza Spring Boot y Deeplearning4j para crear una API REST que realiza predicciones utilizando una red neuronal entrenada. La API recibe datos de entrada en formato JSON y devuelve las[...]

## Tabla de Contenidos
1. [Descripción](#descripción)
2. [Tecnologías Utilizadas](#tecnologías-utilizadas)
3. [Instalación](#instalación)
4. [Uso](#uso)
5. [Ejemplo](#ejemplo)
6. [Contribuir](#contribuir)
7. [Licencia](#licencia)

## Descripción

Este proyecto es una API REST que permite realizar predicciones utilizando una red neuronal entrenada. Se utiliza Deeplearning4j para el modelo de red neuronal y Spring Boot para exponer la API. El mo[...]

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

3. Ejemplo:

Ejemplo de lo que se vería en Postman:
   
<img src="https://github.com/PK2-xuan/NeuralNetworkDemoOrLogic/blob/master/image.png" alt="Imagen de Postman">
