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
    


listaBarcos = [['C','C','C','C'], ['T','T','T'], ['T','T','T'], ['D', 'D'], ['D', 'D'], ['D', 'D'], ['U'], ['U'], ['U'], ['U']]
tablero = crear_tablero()
for i in listaBarcos:
    colocaBarco(tablero, i)
mostrarTablero(tablero)
