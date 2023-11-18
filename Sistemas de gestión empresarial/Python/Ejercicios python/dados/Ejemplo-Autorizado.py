autenticado = True

def requiere_autenticación(f):
    def funcion_decorada(*args, **kwargs):
        if not autenticado:
            print("Error. El usuario no se ha autenticado")
        else:
            return f(*args, **kwargs)
    return funcion_decorada

@requiere_autenticación
def di_Tu_nombre():
    print("Usuario")
    
di_Tu_nombre()