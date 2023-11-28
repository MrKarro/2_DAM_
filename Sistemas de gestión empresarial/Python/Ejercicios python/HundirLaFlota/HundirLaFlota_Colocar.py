import Tablero as tab

#Creamos la lista de barcos con los que vamos a jugar.
listaBarcos = [['C','C','C','C'], ['T','T','T'], ['T','T','T'], ['D', 'D'], ['D', 'D'], ['D', 'D'], ['U'], ['U'], ['U'], ['U']]

# Comenzamos con el jugador 1.

#Creamos el tablero para el jugador 1
tableroJug1 = tab.crear_tablero()
#Recorremos la lista de barcos y uno a uno vamos asignandolo aleatorimente al tablero
for i in listaBarcos:
    tab.colocaBarco(tableroJug1, i)
    
print("\n\n--------------------")
print("TABLERO DE JUGADOR 1")
tab.mostrarTablero(tableroJug1)
print("\n\n--------------------")

# Creamos el juego para el jugador 2

tableroJug2 = tab.crear_tablero()
#Recorremos la lista de barcos y uno a uno vamos asignandolo aleatorimente al tablero
for i in listaBarcos:
    tab.colocaBarco(tableroJug2, i)
    
print("\n\n--------------------")
print("TABLERO DE JUGADOR 2")
tab.mostrarTablero(tableroJug2)
print("\n\n--------------------")
