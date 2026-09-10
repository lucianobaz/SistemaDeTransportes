# Guion — Video Explicativo: Sistema de Transportes POO
**Duración estimada: ~4:15 min | Requisito: 3 a 5 min | Formato: Voz en off con código, diagramas y terminal en pantalla**

> **Consejo para la grabación:** Los tiempos son una guía para no pasarse de los 5 minutos. Hablen tranquilos y con tono natural, explicando el sistema con sus palabras como si se lo presentaran a un colega.

---

## [0:00 – 0:35] LUCIANO — Presentación e introducción del proyecto

**En pantalla:** Portada con el título del proyecto y los nombres de los 5 integrantes, o la carpeta del proyecto en el IDE.

> "Hola a todos. En este video les vamos a presentar el sistema de gestión de transportes y distribución de paquetes que desarrollamos en Java para la materia de Programación Avanzada.
>
> El objetivo del proyecto es informatizar una empresa logística acá en Uruguay: cómo se registran los envíos hacia diferentes departamentos, quiénes los transportan y cómo se calculan las tarifas finales en pesos uruguayos y en dólares.
>
> Para resolverlo aplicamos los pilares fundamentales de la Programación Orientada a Objetos: encapsulamiento, herencia, interfaces y, muy especialmente, polimorfismo. Para arrancar, Rodrigo les va a explicar el diseño de nuestro diagrama de clases UML."

---

## [0:35 – 1:15] RODRIGO — Diagrama UML, Interfaz Rastreable y Relaciones

**En pantalla:** Diagrama UML completo (`UML.png`), haciendo foco primero en la interfaz `Rastreable` y luego en las entidades y la clase asociativa `Conduccion`.

> "Acá pueden ver nuestro diagrama de clases UML. Por un lado tenemos las entidades del transporte: `Camionero`, `Camion` y `Departamento`. Y por otro lado, toda la jerarquía de paquetes.
>
> En la cima de la jerarquía definimos la interfaz `Rastreable`. La pensamos como un contrato obligatorio porque cualquier paquete, sin importar su tipo, tiene que permitir consultar el estado actual del envío mediante `consultarEstado()` y generar un código único con `generarCodigoRastreo()`.
>
> Además, representamos las relaciones del negocio: una asociación simple entre camionero y sus paquetes, y la clase asociativa `Conduccion`, que modela la relación muchos a muchos entre camioneros y camiones guardando la fecha del evento con `LocalDate`. Ahora Noelia les va a mostrar cómo implementamos la clase abstracta `Paquete`."

---

## [1:15 – 1:55] NOELIA — Clase abstracta Paquete, herencia y manejo de Strings

**En pantalla:** Código de `Paquete.java`, mostrando el constructor, `super()` en `PaqueteEstandar`/`PaqueteFragil`, y los métodos de `String`.

> "De la interfaz `Rastreable` deriva nuestra clase abstracta `Paquete`. Es abstracta porque en el modelo real no existen paquetes genéricos: siempre son de tipo Estándar o Frágil. Aquí encapsulamos los atributos comunes como código, descripción, destinatario, dirección y departamento.
>
> Las subclases `PaqueteEstandar` y `PaqueteFragil` heredan de `Paquete` y reutilizan el constructor del padre mediante `super()`, agregando únicamente sus datos propios: peso y costo base para el estándar, y nivel de cuidado y seguro para el frágil.
>
> También implementamos los requerimientos de formateo de texto con la clase `String`: en `setCodigo()` usamos `trim()` para limpiar espacios y `toUpperCase()` para mayúsculas. Y en `formatearDireccionEtiqueta()` usamos `replace()` para abreviar automáticamente 'Calle ' por 'C/ ' y 'Avenida ' por 'Avda.'. Ahora Catalina les va a explicar el polimorfismo y la demo del sistema."

---

## [1:55 – 2:40] CATALINA — Polimorfismo: cálculo de costos en pesos y dólares

**En pantalla:** Código de `calcularCostoEnvio()` en `Paquete.java` (abstracto), luego en `PaqueteEstandar` y `PaqueteFragil`, y el método `calcularCostoEnDolares()`.

> "El corazón del diseño es el polimorfismo. En la clase padre `Paquete`, el método `calcularCostoEnvio()` es abstracto. Cada subclase lo sobreescribe con su propia regla de negocio:
>
> El `PaqueteEstandar` suma su costo base más el peso multiplicado por 50 pesos el kilo. El `PaqueteFragil` parte de una base de 300 pesos, suma el seguro y aplica un recargo por manipulación de 500 pesos si el cuidado es Alto, o 250 si es Medio o Bajo. A ambos subtotales se les aplica automáticamente el 22% de IVA multiplicando por 1.22.
>
> Además, en la clase padre implementamos `calcularCostoEnDolares(tipoCambio)`, que reutiliza polimórficamente el resultado en pesos y lo divide por la cotización del día. Al recorrer una lista genérica `List<Paquete>`, Java invoca dinámicamente la fórmula correspondiente a cada objeto en tiempo de ejecución."

---

## [2:40 – 3:30] CATALINA — Demostración del programa en ejecución (`Main.java`)

**En pantalla:** Terminal ejecutando `java Main` y recorriendo la salida generada.

> "Ahora pasamos a la ejecución del programa en `Main.java`. Creamos departamentos uruguayos como Montevideo y Canelones, instanciamos a los camioneros —Juan Pérez y Taylor Swift—, asignamos los camiones y registramos eventos de conducción.
>
> Luego creamos 4 paquetes combinando estándar y frágiles, y los agregamos a una única lista polimórfica.
>
> Al ejecutar el `Main`, vemos cómo el bucle recorre la lista e imprime cada envío: el código limpio, la dirección abreviada con 'C/' o 'Avda.', el costo final en pesos con IVA, su equivalente en dólares al tipo de cambio de 40, el estado del paquete según su tipo y el chofer a cargo. Todo se procesa a través de la misma lista sin necesidad de preguntar el tipo de cada paquete."

---

## [3:30 – 4:05] TOMÁS — Control de Calidad (QA) y pruebas automatizadas

**En pantalla:** Código de `TestValidaciones.java` y su ejecución por terminal con todos los resultados en `[OK]`.

> "Desde el rol de Control de Calidad y Pruebas, armamos el módulo `TestValidaciones.java` para verificar de forma automática que las reglas de negocio y los casos borde no rompan el sistema.
>
> Probamos tres aspectos clave:
> Primero, que `limpiarCI()` elimine puntos y guiones mediante `replaceAll()`, incluso si la cédula viene con espacios o ya limpia.
> Segundo, que `esMatriculaValida()` acepte formatos correctos como 'SAB 1234' y rechace matrículas sin espacio o con menos de 7 caracteres.
> Y tercero, que el formateo de direcciones en los paquetes reemplace correctamente todas las variantes de 'Calle' y 'Avenida'.
>
> Al ejecutar la clase de pruebas, vemos en consola que todos los casos arrojan resultado 'OK'."

---

## [4:05 – 4:20] TODOS / CIERRE — Conclusión final

**En pantalla:** Pantalla final con el diagrama UML o el repositorio de código y los créditos del equipo.

> "En resumen, logramos que todo el sistema funcione de forma clara y ordenada: la interfaz asegura qué métodos no pueden faltar en ningún paquete, la clase abstracta evita que repitamos código innecesario, y gracias al polimorfismo el programa puede calcular los costos y mostrar los envíos sin importar si son estándar o frágiles.
>
> Muchas gracias por su atención y quedamos a las órdenes para cualquier consulta."

---

### ⏱️ Resumen de tiempos estimado:
* **Luciano:** ~35 segundos (Intro y contexto)
* **Rodrigo:** ~40 segundos (UML, Rastreable, Conducción)
* **Noelia:** ~40 segundos (Paquete, herencia, String)
* **Catalina:** ~85 segundos (Polimorfismo + Demostración de `Main`)
* **Tomás:** ~35 segundos (Pruebas de validación QA)
* **Cierre:** ~15 segundos
* **Total aproximado:** **~4:15 a 4:30 minutos** *(Rango perfecto para la pauta de 3 a 5 min)*.
