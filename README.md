# Currency Converter App

## Descripción

**Currency Converter App** es una aplicación escrita en **Java** que permite a los usuarios convertir entre ocho monedas diferentes utilizando tasas de cambio en tiempo real, obtenidas de una API pública. La aplicación también ofrece un historial de las últimas cinco conversiones realizadas.

La aplicación está organizada en dos clases principales:
- **CurrencyApi**: Maneja las consultas a la API y la obtención de tasas de cambio.
- **CurrencyConverterApp**: Contiene la lógica principal del programa, incluyendo la interacción con el usuario, las conversiones y la gestión del historial.

## Características

1. **Conversión de monedas en tiempo real**: 
   - Permite convertir entre ocho monedas: USD, EUR, GBP, JPY, CAD, AUD, CHF, MXN.
   - Las tasas de cambio se obtienen en tiempo real desde la API pública de [Dinero.Today](https://dinero.today/pages/api).

2. **Historial de conversiones**: 
   - Guarda las últimas cinco conversiones realizadas.
   - Muestra el historial con las tasas de cambio utilizadas y la hora en que se realizó la conversión.

3. **Interfaz interactiva**: 
   - El usuario puede seleccionar monedas de origen y destino, así como la cantidad a convertir.
   - Menú intuitivo con opciones para realizar nuevas conversiones, ver el historial o salir del programa.

4. **Organización modular**:
   - El código está dividido en dos clases: `CurrencyApi` y `CurrencyConverterApp`, lo que facilita su mantenimiento y reutilización.

## Estructura del Proyecto

El proyecto está dividido en las siguientes clases:

### 1. `CurrencyApi`

Esta clase contiene la lógica para interactuar con la API pública para obtener las tasas de cambio. 
- **Métodos principales**:
  - `getExchangeRates()`: Realiza la solicitud HTTP a la API y devuelve las tasas de cambio en formato JSON.
  
### 2. `CurrencyConverterApp`

Esta clase contiene la lógica principal de la aplicación, incluyendo la interacción con el usuario, las conversiones y la gestión del historial.
- **Métodos principales**:
  - `performCurrencyConversion()`: Realiza la conversión entre las monedas seleccionadas por el usuario y muestra el resultado.
  - `showHistory()`: Muestra el historial de las últimas cinco conversiones.
  - `addToHistory()`: Añade una conversión al historial, eliminando la más antigua si el historial ya tiene cinco entradas.

## Ventajas de la estructura modular

- **Separación de responsabilidades**: 
   - La clase `CurrencyApi` se encarga exclusivamente de la lógica de la API, mientras que la clase `CurrencyConverterApp` se enfoca en la lógica de la aplicación, lo que facilita su modificación independiente.
   
- **Mantenimiento sencillo**: 
   - Si necesitas actualizar la API o cambiar el servicio de tasas de cambio, puedes hacerlo directamente en la clase `CurrencyApi` sin afectar el resto del código.
   
- **Reutilización**: 
   - La clase `CurrencyApi` puede ser reutilizada en otros proyectos que necesiten realizar conversiones de moneda o consultar tasas de cambio sin necesidad de modificar el resto del código.
   
- **Escalabilidad**: 
   - Si en el futuro decides añadir más monedas o mejorar la interacción del programa, la estructura modular facilita la ampliación del código sin afectar a su funcionalidad actual.

## Ejecución del proyecto

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/tu-usuario/currency-converter-app.git

2. **Compilar y ejecutar**
   - Puedes compilar el proyecto en tu entorno de desarrollo favorito (como Eclipse o IntelliJ) o usar la terminal de comandos con:
  
    ```bash
    javac CurrencyApi.java CurrencyConverterApp.java
    java CurrencyConverterApp

3. **Instrucciones de uso**
   - Selecciona la moneda de origen y destino.
   - Ingresa el monto que deseas convertir.
   - Consulta el historial de conversiones recientes.
  
## API Utilizada
   - Esta aplicación utiliza la API pública de [Dinero.Today](https://dinero.today/pages/api). para obtener las tasas de cambio más recientes.

## Requisitos del sistema
  - **Java 8** o superior.
  - Conexión a Internet para obtener las tasas de cambio en tiempo real.

## Contribuciones
-Las contribuciones son bienvenidas. Si deseas mejorar este proyecto, puedes hacerlo de la siguiente manera:

1. Haz un fork de este repositorio.
2. Crea una nueva rama `(git checkout -b mejora-nueva-funcionalidad)`.
3. Realiza tus cambios.
4. Haz un commit de tus cambios `(git commit -m 'Añadir nueva funcionalidad')`.
5. Haz push de tu rama `(git push origin mejora-nueva-funcionalidad)`.
6. Abre un Pull Request.

## Autor

Este proyecto fue desarrollado por **Rodrigo Rivas**. Si tienes alguna pregunta, sugerencia o te gustaría colaborar en este proyecto, no dudes en ponerte en contacto conmigo a través de mi perfil de [LinkedIn](www.linkedin.com/in/rodrigo-rivas-3123392b5)
