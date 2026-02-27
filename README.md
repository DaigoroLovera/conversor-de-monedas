# Conversor de Monedas

**Challenge de programación en Java**  
Este proyecto es un **conversor de monedas por consola**, que permite convertir montos desde **USD** a varias monedas (ARS, BOB, BRL) usando tasas de cambio actualizadas en tiempo real desde la API de [ExchangeRate](https://www.exchangerate-api.com/).

---

## Objetivo

Desarrollar un conversor de monedas por consola utilizando Java, con interacción básica y manejo de errores.

---

## Características

- Conversión de USD a ARS, BOB y BRL.  
- Obtiene tasas de cambio en tiempo real desde la API.  
- Interfaz de consola simple e interactiva.  
- Manejo básico de errores y validación de opciones inválidas.  

---

## Configuración e instalación

1. Clonar o descargar el proyecto desde GitHub.  
2. Abrir el proyecto en IntelliJ IDEA (o cualquier IDE de Java).  
3. Agregar la librería [Gson](https://github.com/google/gson) al proyecto.  
4. Generar una **API Key** en [ExchangeRate-API](https://www.exchangerate-api.com/) y reemplazar el valor `"TU_API_KEY"` en el código.  
5. Ejecutar la clase `Main.java`.  

---

## Uso

Al ejecutar el programa, la consola mostrará un menú:

=== Conversor de Monedas ===

1.USD → ARS

2.USD → BOB

3.USD → BRL

4.Salir

Elija una opción:


- Seleccioná la opción deseada.  
- Ingresá el monto en USD que querés convertir.  
- El programa mostrará el resultado con la tasa actual.  

---

##Notas

Si la API no responde, el programa muestra un mensaje de error.

Se pueden agregar más monedas modificando el código y obteniendo nuevas tasas desde la API.
