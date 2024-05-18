# PracticaFinal_P2
enlace al repositorio: https://github.com/KravAD/PracticaFinal_P2.git

Esta es la segunda parte del proyecto de crear una aplicación en java para el cultivo de bactereas.
El proyecto se ha separado en dos partes:
- En la primera me he enfocado en la parte de la creación de un experimento dónde se agregan poblaciones.
  
  · En el package Logica están las clases PoblacionBacterias, que se encarga de almacenar la información de una población con los datos del enunciado del proyecto, Experimento, que se encarga de representar un experimento que contiene a varias poblaciones, GestorExperimento, que se encarga de manejar el experimento (abrir existente, guardar, guardar como, crear), y una interfaz EstrategiasComida con tres estrategias de comida diferentes que implementan otras tres clases que se encargan de hacer el cálculo de la dosis de la comida.
  
  · Por parte de la interfaz de usuario he usado cuatro clases del package IU. La primera es Interfaz que se encarga de la ventana principal y esta cuenta con los botones para gestionar un experimento como abrir uno, guardar cambios, guardar como o crear otro nuevo. Al crear un experimento nuevo aparece la ventana de la clase ExperimentoFrame que se encarga de preguntar la información de la población como el nombre, fechas de inicio y fin, cantidad, temperatura y entre otros que pide el proyecto. Lo mas interesante es que abajo sale una caja de seleciión que preguntará por la estrategia de comida que se desea usar y de dicha eleccion depende el cálculo de las dosis. Arriba de la ventana hay tres botones: agregar población, eliminar población o ver la información de una población seleccionada. Al darle a agregar aparece la ventana ExperimentoLista que se encarga de enseñar las poblaciones agregadas. En esta ventana aparece un caja de filtro por nombre, antiguedad o por mayor cantidad de bacterias de la población que ordenará las poblaciones agregadas. Seleccionando una población de la lista se puede eliminar con el boton eliminar o visualizar con el boton detalles. Al darle al botón de detalles aparece la ventana de la clase DetallesPoblacionFrame que muestra todos los datos que se ha atribuido a la población más la dosis de comida que se seleccionado en la caja de opciones de estrategias de comida.

  · En el package Datos hay una única clase que es ArchivoExperimento. Esta solo tiene la función de archivador, que guarda un experimento en un archivo y lo carga.

- En la segunda parte me he dedicado a la simulación de Montecarlo.

  · En el package Montecarlo hay cuatro clases. La clase Bacteria representa una sola bacteria con capacidad de moverse, comer y reproducirse (en función de lo que come). La clase Celda representa una celda de un plato de cultivo de 20 x 20 celdas, donde cada una tiene una cantidad de comida y una cantidad de bacterias que se pueden mover de manera aleatoria. La clase Plato representa el plato de cultivo que está hecho de una matriz de celdas de orden 20 x 20. Y la clase Simulacro hace la simulación de Montecarlo que al final muestra la cantidad de bacterias que hay en cada celda del plato.

  · En el package IU está la clase InterfazMontecarlo que es externa a la ventana de Interfaz, con lo que no se relacionan. Esta clase genera una ventana con dos botones, simular y reiniciar la simulación. Al empezar la simulación, en el centro aparece una lista con todas las celdas y muestra la cantidad de bacterias en cada una de ellas y abajo está la visualización del plato con varios colores. Cada color representa un intervalo de cantidad de bacterias que están situadas en dichas celdas.

- Por parte del main, se hace una instancia de la clase Interfaz para invocar la ventana del experimento de poblaciones y se hace una instancia de la clase simulación que luego se pasa a la instancia de la clase InterfazMontecarlo para invocar la ventana de la simulación de Montecarlo.


Complicaciones:
Durante el proyecto tuve algunas complicaciones con el código, sobre todo en la primera parte cuando intentaba poner las fechas de inicio y fin del experimento. Más tarde con las estrategias de comida ya que fallaba el cálculo de las dosis.
  
