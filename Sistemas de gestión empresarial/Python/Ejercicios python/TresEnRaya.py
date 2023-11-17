def mostrarTablero(tablero):
    for fila in tablero:
        print('|', end='')
        for columna in fila:
            print(columna, '|', end='')
        print()

def comprobarGanador(tablero, jugador_actual):
    if (tablero[0][0] == tablero[1][1] == tablero[2][2] == jugador_actual or
        tablero[0][2] == tablero[1][1] == tablero[2][0] == jugador_actual or
        any(all(casilla == jugador_actual for casilla in fila) for fila in tablero) or
        any(all(fila[i] == jugador_actual for fila in tablero) for i in range(3))):
        return 1
    else:
        return 0

tablero = [['-','-','-'],['-','-','-'],['-','-','-']]

mostrarTablero(tablero)

# Jugadores 'X' y 'O'
jugador_actual = 'X'


for turno in range(9): 
    
    fila = int(input(f'Jugador {jugador_actual}, elige fila (0, 1, 2): '))
    columna = int(input(f'Jugador {jugador_actual}, elige columna (0, 1, 2): '))

    # Verificar si la casilla está vacía y llenarla en caso de que lo esté
    if tablero[fila][columna] == '-':
        tablero[fila][columna] = jugador_actual
        
        mostrarTablero(tablero)
        
        # Verificar si hay un ganador
        if turno > 4:
            if (comprobarGanador(tablero, jugador_actual) == 1):
                print(f'¡Jugador {jugador_actual} ha ganado!')
                break
        
        # Cambiar de jugador
        if jugador_actual == 'X':
            jugador_actual = 'O'  
        else: 
            jugador_actual = 'X'
    else:
        print('¡Esa casilla ya está ocupada! Inténtalo de nuevo.')
else:
    print('¡Empate!')