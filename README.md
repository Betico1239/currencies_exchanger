<h1 align="center"> Currencies Exchanger </h1>

<img src="https://github.com/Betico1239/currencies_exchanger/assets/132612578/d50e3294-742f-4474-9b01-7e19783d2ef1" width = 50>

<img src="https://github.com/Betico1239/currencies_exchanger/assets/132612578/93c11204-321b-4f59-aac2-25a4461403c7" width = 250>


![Badge en Desarollo](https://img.shields.io/badge/STATUS-EN%20DESAROLLO-purple)
![GitHub Org's stars](https://img.shields.io/github/stars/Betico1239?style=social)


## Descripción
Este proyecto es un desafío propuesto para un curso de Alura, en el cuál se nos pide construir un convertidor de monedas básico que permita al usuario ingresar las monedas a convertir y el valor a convertir. Todo esto desde el back-end.

## Instalación
1. Clonar el repositorio:
   ```sh
   git clone <URL_del_repositorio>
2. Abrir el proyecto en un IDE que soporte archivos .java (recomendado IntelliJ IDEA).
3. Ejecutar la clase Principal para iniciar el programa.

## :hammer:Funcionalidades del proyecto
- `Funcionalidad 1`: Desde la clase Principal podrás ejecutar el programa para interactuar con la interfáz. 
- `Funcionalidad 2`: El usuario deberá escoger alguna opción que desee utilizar para comprobar el cambio de diferentes monedas a nivel mundial (Los factores de conversión están actualizados y se pueden consultar en: "https://www.exchangerate-api.com/").
- `Funcionalidad 3`: Luego digitar el valor correspondiente a conertir.
- `Funcionalidad 4`: Internamente se hará la conversión, teniendo en cuenta si el usuario digitó correctamente lo solicitado, caso contrario, entrarán a jugar las excepciones utilizadas para el proyecto, donde unas son propias y otras de Java.
- `Funcionalidad 5`: El programa llevará un registro de las conversiones realizadas para que el usuario pueda acceder a ellas cuando guste.
- `Funcionalidad 6`: Finalmente el usuario podrá salir del programa especificando el número y se mostrará el historial correspondiente y el programa habrá finalizado.

## Autores
| <img src="https://github.com/Betico1239/currencies_exchanger/assets/132612578/1e475b43-8bf7-4579-9624-757f2080c86e" width=115><br><sub>Cristian Alberto Bravo Granados</sub>|
| :---: |


## Tecnologías
| Tecnologías usadas  | Descripción |
| ------------- | ------------- |
| Java | Utilizado para la lógica del programa |
|  IntelliJ IDEA IDE | Utilizado para el desarrollo  |
| API de Exchange Rate  | Para realizar las conversiones y obtener formatos JSON.  |
| GSON  | Para manejar y adaptar el formato JSON a la clase deseada.  |
| Java.time.LocalDateTime  |  Para acceder a la hora exacta en que se realizó la conversión. |
|  Excepciones personalizadas | Para manejar errores y proporcionar información útil al usuario.  |

## Licencia
Gratuita de uso libre.
