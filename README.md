<h1 align="center">Conversor de Monedas - Challenge Alura</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange" alt="Java 17" />
  <img src="https://img.shields.io/badge/Status-En%20Desarrollo-green" alt="Status" />
  <img src="https://img.shields.io/badge/Maven-Project-blue" alt="Maven" />
</p>

## 📝 Descripción

Bienvenido al **Conversor de Monedas**, un desafío backend desarrollado como parte de la formación de Java de Alura.
Esta herramienta permite a los usuarios convertir montos entre diferentes divisas internacionales en tiempo real, utilizando tasas de cambio actualizadas directamente desde una API externa.

El objetivo principal es poner en práctica conocimientos sobre consumo de APIs, manejo de datos JSON y lógica de programación en Java.

## 🔨 Funcionalidades

- **Conversión en tiempo real:** Obtiene las tasas de cambio actuales desde ExchangeRate-API.
- **Múltiples monedas:** Soporte para Dólar (USD), Peso Argentino (ARS), Real Brasileño (BRL), y Peso Colombiano (COP).
- **Interfaz de consola:** Menú interactivo y fácil de usar.
- **Historial de conversión:** (Opcional: Si planeas agregarlo después).

## 🛠️ Tecnologías Utilizadas

Este proyecto fue construido con las siguientes herramientas:

* **[Java 17](https://www.oracle.com/java/)**: Lenguaje principal del proyecto.
* **[Maven](https://maven.apache.org/)**: Gestor de dependencias y construcción.
* **[Gson](https://github.com/google/gson)**: Librería de Google para parsear JSON a objetos Java.
* **[Java-Dotenv](https://github.com/cdimascio/java-dotenv)**: Para la gestión segura de variables de entorno (API Keys).
* **[ExchangeRate-API](https://www.exchangerate-api.com/)**: Proveedor de datos de divisas.

## 🚀 Cómo ejecutar el proyecto

### Prerrequisitos
1. Tener instalado **Java 17** o superior.
2. Tener una API Key gratuita de [ExchangeRate-API](https://www.exchangerate-api.com/).

### Pasos
1. Clona el repositorio:
   ```bash
   git clone [https://github.com/LunaFernando791/conversorMonedas.git](https://github.com/LunaFernando791/conversorMonedas.git)
