# Práctica: Simulación del Problema de Parada (Halting Problem)

## 1. Introducción

El Problema de Parada (Halting Problem) fue formulado por **Alan Turing en 1936** y plantea la siguiente pregunta:  
> ¿Existe un algoritmo que, dado cualquier programa y cualquier entrada, pueda determinar si dicho programa se detendrá o continuará ejecutándose para siempre?

Turing demostró que este problema es **indecidible**, es decir, que **no existe ningún algoritmo general** que pueda resolverlo en todos los casos posibles.  
Esta práctica tiene como objetivo simular este concepto en Java, comprendiendo tanto su funcionamiento como sus implicaciones teóricas.


---

## 2. Estructura del proyecto

## `Main`
**Rol:**  
- Es el **punto de entrada** de la aplicación.  
- Suele contener el método `public static void main(String[] args)`.
- Aquí se inicializa la interfaz gráfica (`MainUI`) y se pueden realizar pruebas de consola (ejecutar los programas, llamar a `Reverser`, etc.).

---

## Paquete `programs`
Este paquete contiene **los programas de ejemplo** que ilustran el Problema de Parada.

- **`Program.java`**  
  - Es la **interfaz base** para todos los programas que se van a simular.  
  - Define métodos como `run()` (para ejecutar el programa) y `getName()` (para identificarlo).

- **`CountDown.java`**  
  - Implementa la interfaz `Program`.  
  - **Se detiene** al contar hacia abajo desde un número hasta 0.  
  - Sirve como ejemplo de un programa que termina con seguridad.

- **`CountUp.java`**  
  - Implementa la interfaz `Program`.  
  - **No se detiene** nunca: cuenta hacia arriba indefinidamente.  
  - Es el ejemplo de un programa que entra en un bucle infinito.

---

## Paquete `checker`
Aquí vive el **HaltChecker**, que simula el verificador hipotético.

- **`HaltChecker.java`**  
  - **Función principal:** Determina (de forma simulada) si un programa se detiene o no con cierta entrada.  
  - **Importante:** En la práctica, no existe un verificador universal. Pero aquí, `HaltChecker` está diseñado para "conocer" solo casos concretos (`CountDown`, `CountUp`...), devolviendo respuestas predefinidas (por ejemplo, "sí se detiene" para `CountDown`, "no se detiene" para `CountUp`).

---

## Paquete `logic`
Aquí se incluye la lógica que genera la **paradoja** de Turing.

- **`Reverser.java`**  
  - Representa el programa que se comporta de forma **contradictoria** con respecto a `HaltChecker`.  
  - **Funcionamiento:**  
    - Si `HaltChecker` dice "este programa se detiene", `Reverser` entra en un bucle infinito.  
    - Si `HaltChecker` dice "este programa no se detiene", `Reverser` se detiene inmediatamente.  
  - El caso extremo es cuando `Reverser` se evalúa a sí mismo, generando la **contradicción** que demuestra la indecidibilidad del problema de parar.

---

## Paquete `ui`
Contiene la **interfaz gráfica** en Swing.

- **`MainUI.java`**  
  - Proporciona una ventana básica con botones para **ejecutar** cada programa:  
    - Un botón para `CountDown` (se detiene).  
    - Un botón para `CountUp` (no se detiene, ¡cuidado!).  
    - Un botón para `Reverser` (muestra la paradoja).  
  - Útil para demostrar la práctica de forma interactiva en lugar de hacerlo solo por consola.

---

## ¿Cómo se relacionan los componentes?

- **Main** invoca la interfaz gráfica `MainUI` o realiza pruebas en consola.  
- **MainUI** ofrece botones que, al pulsarlos, crean instancias de los programas (`CountDown`, `CountUp`) y llaman a su método `run()`.  
- **HaltChecker** se usa internamente por `Reverser` para decidir si "se detiene" o "no se detiene".  
- **Reverser** aplica la lógica opuesta a la predicción de `HaltChecker`.  
- Al combinar `Reverser` con `HaltChecker` y sus propios métodos, se ilustra la **paradoja** descrita por Turing.

---

## Resumen de la estructura del proyecto

- **`programs`**: Programas simples que se detienen o no.  
- **`checker`**: Verificador hipotético que “decide” (solo para ejemplos conocidos).  
- **`logic`**: Contiene `Reverser`, que genera la contradicción.  
- **`ui`**: Interfaz Swing para demostrar la ejecución.  
- **`Main`**: Punto de entrada.

## 2. Programas de ejemplo

Se han implementado dos programas sencillos que permiten visualizar el problema:

- **`programStops`**: cuenta hacia abajo desde un número dado hasta 0. Este programa **siempre se detiene**.
- **`programLoops`**: cuenta hacia arriba indefinidamente sin condición de parada. Este programa **nunca se detiene**.

Estos ejemplos sirven como base para que nuestro sistema simulado (`HaltChecker`) pueda analizarlos y emitir predicciones controladas.

---

## 3. Simulación de `HaltChecker`

`HaltChecker` representa una **simulación conceptual** de un programa que intenta decidir si otro programa se detiene o no, basándose en su nombre o estructura.  
Por supuesto, como sabemos que el problema real es indecidible, este `HaltChecker` no es un verificador universal, sino un modelo que **devuelve respuestas controladas** para los casos conocidos (`programStops`, `programLoops`, etc.).

Esto permite simular cómo **se comportaría un verificador si existiera**, y así reproducir la lógica del razonamiento de Turing.

---

## 4. El programa `Reverser`

`Reverser` es un programa diseñado para crear una **contradicción lógica**. Su comportamiento depende del resultado que le da `HaltChecker`:

- Si `HaltChecker` indica que el programa se detendrá, entonces `Reverser` **entra en un bucle infinito**.
- Si `HaltChecker` indica que no se detendrá, entonces `Reverser` **termina inmediatamente**.

Es decir, hace exactamente lo **opuesto** a lo que predice el verificador.

---

## 5. Paradoja de `Reverser(Reverser)`

Aquí se encuentra el núcleo de la paradoja. Ejecutamos `Reverser` pasando **su propio código como entrada**:
```java
Reverser.execute("Reverser");
```

Esto lleva a dos posibilidades, ambas contradictorias:

Si HaltChecker dice que Reverser se detiene con su propia entrada -> entonces Reverser entra en bucle -> no se detiene.
Si HaltChecker dice que Reverser no se detiene con su propia entrada -> entonces Reverser termina -> sí se detiene.
Por tanto, no importa qué responda HaltChecker, siempre se equivoca. Esta paradoja demuestra de forma práctica la indecidibilidad del problema.

## 6. Conclusión
Esta simulación permite visualizar una de las ideas más importantes de la teoría de la computación:

Existen límites fundamentales a lo que los algoritmos pueden resolver.

El Problema de Parada es indecidible, lo que significa que no hay ninguna forma general y segura de determinar si un programa se detendrá con una entrada dada.
Esta conclusión no solo tiene valor teórico, sino que también impacta el diseño de compiladores, verificadores de código y sistemas automáticos de prueba.

Gracias a esta práctica, se comprende no solo el razonamiento lógico detrás del problema, sino también su impacto real en el pensamiento algorítmico y los límites de la computación.
