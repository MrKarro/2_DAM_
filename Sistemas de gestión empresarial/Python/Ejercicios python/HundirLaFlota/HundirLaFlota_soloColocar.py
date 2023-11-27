import Tablero as tab

listaBarcos = [['C','C','C','C'], ['T','T','T'], ['T','T','T'], ['D', 'D'], ['D', 'D'], ['D', 'D'], ['U'], ['U'], ['U'], ['U']]
tablero = tab.crear_tablero()
for i in listaBarcos:
    tab.colocaBarco(tablero, i)
tab.mostrarTablero(tablero)
