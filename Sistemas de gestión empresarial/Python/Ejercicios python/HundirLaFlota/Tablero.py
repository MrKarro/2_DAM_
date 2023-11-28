import random
def crear_tablero():
    tablero = []
    for i in range(10):
        tablero.append(['-','-','-','-','-','-','-','-','-','-']) 
    return tablero

def mostrarTablero(tablero):
    for fila in tablero:
        print('|', end='')
        for columna in fila:
            print(columna, '|', end='')
        print()
def colocaBarco(tablero, barco):
    while(True):
        # seleccionamos un punto del tablero
        fila = random.randint(0,9)
        columna = random.randint(0,9)
        posicionesPosibles = []
        # comprobamos las direcciones disponibles
        if fila + len(barco) <= 9:
            if all('-' == tablero[fila + i][columna] for i in range(len(barco))):
                posicionesPosibles.append('S')
        if fila - len(barco) >= 0:
            if all('-' == tablero[fila - i][columna] for i in range(len(barco))):
                posicionesPosibles.append('N')
        if columna + len(barco) <= 9:
            if all('-' == tablero[fila][columna + i] for i in range(len(barco))):
                posicionesPosibles.append('E')
        if columna - len(barco) >= 0:
            if all('-' == tablero[fila][columna - i] for i in range(len(barco))):
                posicionesPosibles.append('O')
        if len(posicionesPosibles) != 0:
            break
    # aleatoriamente elegimos el sentido del barco 
    posicion = random.choice(posicionesPosibles)
    if posicion == 'S':
        for i in range(len(barco)):
            tablero[fila + i][columna] = barco[i]
        
    elif posicion == 'N':
        for i in range(len(barco)):
            tablero[fila - i][columna] = barco[i]
        
    elif posicion == 'E':
        for i in range(len(barco)):
            tablero[fila][columna + i] = barco[i]
        
    elif posicion == 'O':
        for i in range(len(barco)):
            tablero[fila][columna - i] = barco[i]
    cambiarCasillas(tablero)

def cambiarCasillas(tablero):
    filas = len(tablero)
    columnas = len(tablero[0])
    # Recoremos las filas y las casillas una a una comprobando
    for i in range(filas):
        for j in range(columnas):
            if tablero[i][j] not in ['-', '*']:
                # Si la casilla no es '-' ni '*', comprobamos las casillas circundantes
                for x in range(i-1, i+2):
                    for y in range(j-1, j+2):
                        if 0 <= x < filas and 0 <= y < columnas and tablero[x][y] == '-':
                            tablero[x][y] = '*'