# 🎓 Proyecto Final: Java Intermedio (UTN - Argentina Programa)

Este repositorio contiene el proyecto final desarrollado para el curso de **Java Intermedio**, enfocado en la aplicación práctica de los principios de la Programación Orientada a Objetos (POO), manejo de colecciones avanzadas, y persistencia de datos básica.

El proyecto es una demostración de la capacidad para estructurar código modular y escalable utilizando estándares de diseño modernos en Java.

## 🛠️ Stack Tecnológico

| Tecnología | Propósito |
| :--- | :--- |
| **Java** | Lenguaje principal (POO y Lógica de Negocio). |
| **Maven** | Gestión de dependencias y estandarización de la compilación. |
| **Collections Framework** | Uso de `ArrayList`, `HashMap` o `HashSet` para gestión eficiente de datos en memoria. |

## 💡 Conceptos POO Aplicados

El diseño de la aplicación se centró en demostrar la correcta implementación de los pilares de la Programación Orientada a Objetos:

* **Abstracción:** Modelado de entidades del mundo real (ej., `Cliente`, `Producto`, `Venta`).
* **Encapsulamiento:** Protección de datos mediante *Getters* y *Setters*.
* **Herencia:** Creación de jerarquías de clases para evitar la duplicación de código (ej., una clase base para diferentes tipos de usuarios o productos).
* **Polimorfismo:** Implementación de métodos que actúan de diferente manera según el tipo de objeto, logrando un código flexible.
* **Interfaces:** Definición de contratos claros para las funcionalidades principales de la aplicación.

## 📂 Estructura del Proyecto y Funcionalidades

El proyecto sigue una estructura modular para separar la lógica de negocio de la interfaz de usuario:

1.  **Modelo (`modelo/`):** Contiene todas las clases de la entidad (ej., `Venta`, `Cliente`).
2.  **Servicio/Lógica (`servicio/` o `logica/`):** Clases que contienen las reglas de negocio, cálculos y manejo de colecciones.
3.  **Utilidades (`util/`):** Clases para el manejo de archivos (lectura/escritura) o utilidades de conversión.

### Funcionalidades Demostradas

* **Gestión de Colecciones:** Almacenamiento y manipulación de listas de objetos en memoria (`List<Object>`, `Map<Key, Value>`).
* **Manejo de Archivos:** Implementación de lectura y escritura para persistir datos en archivos de texto o binarios (serialización).
* **Lógica de Negocio:** Desarrollo de funciones específicas (ej., cálculo de totales de venta, búsqueda de elementos por criterio, gestión de *stock*).

## ⚙️ Cómo Ejecutar el Proyecto

1.  **Clonar el Repositorio:**
    ```bash
    git clone [https://docs.github.com/es/repositories/creating-and-managing-repositories/quickstart-for-repositories](https://docs.github.com/es/repositories/creating-and-managing-repositories/quickstart-for-repositories)
    ```
2.  **Abrir en IDE:** Importar el proyecto como un proyecto **Maven** en IntelliJ IDEA, Eclipse o VS Code.
3.  **Ejecutar la Clase Principal:** Correr la aplicación desde la clase que contiene el método `main()` (generalmente ubicada en el paquete raíz o `main/`). La aplicación se ejecutará por consola.

---
