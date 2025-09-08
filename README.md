# THE FALL

El auténtico resultado de la decadencia. Ahora somos parte del problema.

---

## Descripción

`THE FALL` es un sistema de gestión de empleados y ventas con menús interactivos para administrador y empleados.  
Permite registrar, listar, actualizar y eliminar empleados, ingresar ventas, consultar totales y realizar pagos.  

Está construido en **Java**, usando **programación funcional** para validaciones y flujo seguro de entrada de datos.

---


## Requisitos

- **Java 15+** (para text blocks y características modernas).
- Sistema operativo compatible con Java (Linux, Mac, Windows).

---

## Ejecutar Proyecto

Sigue estos pasos para clonar y ejecutar el proyecto en tu máquina:

1. **Clonar el repositorio**

```bash
git clone https://github.com/ElCabris/the_fall.git
cd the_fall
```
2. **Compilar y Ejecutar**
```bash
javac -d out $(find src/main/java/com/the_fall -name "*.java") && java -cp out com.the_fall.App
```