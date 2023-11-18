def nuevoAlumno(asignaturas):
    
    # Leemos los datos del alumno
    nombre = input("Ingrese el nombre del alumno: ")
    apellidos = input("Ingrese los apellidos del alumno: ")
    edad = int(input("Ingrese la edad del alumno: "))
    movil = input("Ingrese el número de móvil del alumno: ")

    # creamos un alumno
    alumno = {'Nombre': nombre, 'Apellidos': apellidos, 'Edad': edad, 'Móvil': movil}

    # pedimos la asignatura
    asignaturaRecibida = input("Ingrese la asignatura del alumno (SGE o PROGRAMACIÓN): ")

    # si la asignatura esta en la lista se añade
    if asignaturaRecibida in asignaturas:
        asignaturas[asignaturaRecibida].append(alumno)
    else:
        print("asignaturas no válida. No se ha agregado el alumno.")
    
    limpiaPantalla()


def muestraMenu():
    
    # mostramos el menu principal de la aplicación
    print("\n\tMenu principal")
    print("============================================")
    print("============================================")
    print("\n\t1. Agregar 3 alumnos")
    print("\n\t2. Mostrar todos los alumnos por asignatura")
    print("\n\t3. Salir")
    print("============================================")
    print("============================================")
    elec = int(input("Ingrese la opción que desea:"))
    limpiaPantalla()
    return elec

def limpiaPantalla():
    for i in range(20):
        print("\n")

def muestraAsignaturas(asignaturas):
    # mostramos los alumnos por asignatura
    for clave, valor in asignaturas.items():
        if len(valor)>=1:
            print('\n\t\tAsignatura: ',clave)
            for item in valor:
                print('\t\t---------------------')
                print('\t\tNombre:',item['Nombre'])
                print('\t\tApellidos:',item['Apellidos'])
                print('\t\tEdad:',item['Edad'])
                print('\t\tMóvil:',item['Móvil'],'\n')




elec = 0
# creamos dos asignaturas
asignaturas = {'SGE': [], 'PROGRAMACIÓN': []}



while (elec !=3):
    elec = muestraMenu()

    if elec == 1:
        # creamos los 3 alumnos
        for i in range(3):
            nuevoAlumno(asignaturas)
    elif elec == 2:
        muestraAsignaturas(asignaturas)
    elif elec==3:
        break
else:
    print("Fin de la aplicación")








