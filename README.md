# Conversor de Monedas

Este es un proyecto en Java que implementa un conversor de monedas utilizando una API de tasas de cambio en tiempo real. Los usuarios pueden seleccionar diferentes opciones para convertir entre monedas específicas y obtener el resultado de la conversión basado en tasas actualizadas.

## Descripción del Proyecto

Este conversor de monedas se conecta a la API de Exchange Rate para obtener las tasas de cambio actuales. Luego, permite al usuario elegir entre varias opciones de conversión de divisas, incluyendo Dólar (USD), Peso Chileno (CLP), Real Brasileño (BRL) y Peso Colombiano (COP).

## Funcionalidades

- Conexión a la API de Exchange Rate para obtener las tasas de cambio en tiempo real.
- Menú interactivo en la consola que permite al usuario seleccionar la conversión deseada.
- Opciones de conversión incluidas:
  - Dólar a Peso chileno y viceversa.
  - Dólar a Real brasileño y viceversa.
  - Dólar a Peso colombiano y viceversa.
- Muestra el resultado de la conversión en tiempo real.

## Requisitos

- Java 11 o superior.
- Conexión a Internet (para obtener los datos de la API).
- Librería **Gson** para manejar la deserialización de JSON. Si no la tienes, puedes descargarla [aquí](https://github.com/google/gson) o incluirla en tu proyecto como una dependencia de Maven o Gradle.

