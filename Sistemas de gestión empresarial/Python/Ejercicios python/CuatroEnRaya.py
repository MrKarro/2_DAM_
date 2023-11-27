
def crear_tablero():
    tablero = [[0,1,2,3,4,5,6]]
    for i in range(7):
        tablero.append(['-','-','-','-','-','-','-']) 
    return tablero

def mostrarTablero(tablero):
    for fila in tablero:
        print('|', end='')
        for columna in fila:
            print(columna, '|', end='')
        print()

def jugada(jugador, tablero):
    colum = int(input(f"\n{jugador}, elige la columna:\t"))
    if colum < 0 or colum > 6:
        print("Esa columna no existe")
    else:    
        for i in range(7,0,-1):
            if tablero[i][colum] == '-':
                tablero[i][colum] = jugador
                break
# creamos las diferentes opciones para ganar que tiene el juego
def diag_dere(x, y, tablero, jugador_actual):
    if (jugador_actual == tablero[x+i][y+i] for i in range(0, 4)):
        return True
    return False
def diag_izq(x, y, tablero, jugador_actual):
    if (jugador_actual == tablero[x-i][y-i] for i in range(0, 4)):
        return True
    return False
def hori_dere(x, y, tablero, jugador_actual):
    if (jugador_actual == tablero[x+i][y] for i in range(0, 4)):
        return True
    return False
def hori_izq(x, y, tablero, jugador_actual):
    if (jugador_actual == tablero[x-i][y] for i in range(0, -4, -1)):
        return True
    return False
def verti(x, y, tablero, jugador_actual):
    if y + 3 >= len(tablero[0]):
        return False
    if (jugador_actual == tablero[x][y+i] for i in range(0, 4)):
        return True
    return False

# creamos la funcion para que nos confirme si el jugador gana o se sigue jugando
def ganar(tablero):
    for i in range(6, 0, -1):
        for j in range(7):
            if j < 4 and (verti(j, i, tablero, jugador_actual) or hori_dere(j, i, tablero, jugador_actual) or diag_dere(j, i, tablero, jugador_actual)):
                return True
            elif j >= 3 and (verti(j, i, tablero, jugador_actual) or hori_izq(j, i, tablero, jugador_actual) or diag_izq(j, i, tablero, jugador_actual)):
                return True
    return False
    


#creamos el tablero y lo muestra por pantalla
tablero = crear_tablero()
mostrarTablero(tablero)

# Jugadores 'X' y 'O'
jugador_actual = 'X'

for turno in range(49):
    jugada(jugador_actual, tablero)
    mostrarTablero(tablero)
    #verificar si hay un ganador o si se completo el tablero
    if turno >= 6:
        if ganar(tablero):
            print("Jugador", jugador_actual, " ganó enhorabuena")    
            break
    # Cambiar de jugador
    if jugador_actual == 'X':
        jugador_actual = 'O'  
    else: 
        jugador_actual = 'X'
else:
    print("Empate!")


