# Tp1-Progra3/2020 (MVC-WindowBuilder)
## Intruduccion
El presente informe tiene como objetivo exponer, de forma breve, el desarrollo de la
aplicación “juegos aritméticos”, el cual consisten en rellenar una matriz con números de formar
que la sumas de estos, fila por fila y columna por columna, coincidan con valores asignados
previamente a esas filas y columnas.
## Guia
Al iniciar la app ,el usuario tendrá que ingresar el tamaño del tablero, el cual deberá
respetar los valores dentro de un intervalo acotando de números naturales comprendido entre
4 y 8, tanto para filas como columnas (4<=Filas<=8 /\ 4<=Columnas<=8 }. Luego de la
elección de la dimensión del tablero, se crearan una cantidad de botones que se corresponden
a la multiplicación de la cantidad de filas por columnas elegidos (Cantidad_de_Botones =
Filas*Columnas) y se iniciara un contador de segundo. Estos botones, cumplirán la función de
recibir los valores a ingresar en el tablero mediante el uso de un panel, con valores prefijados
del 1 al 9, que se abrirá al hacer click sobre el botón que ocupe lo posición en el que el usuario
quiera hacer su jugada. En caso de que las sumas de la columnas y filas de los valores
ingresados al tablero de coincidan con los valores prefijado en la inicialización del juego, la
interfaz mostrar un mensaje indicando al usuario que gano.
