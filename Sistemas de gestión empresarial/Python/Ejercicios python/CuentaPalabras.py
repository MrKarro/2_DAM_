def cuentaPalabras(frase):
    #separamos la frase por espacios y devolvemos la cantidad
    partida = frase.split()
    return len(partida)

def cuentaLetras(frase):
    return len(frase)

def cuentaVocales(frase):
    suma = 0
    # comprobamos todas las vocales y aumentamos la suma
    for i in ("a","e","i","o","u"):
        suma += frase.count(i)
    return suma

def cuentaPuntuacion(frase):
    suma = 0
    # comprobamos los signos de puntuacion y aumentamos la suma
    for i in (",", "."):
        suma += frase.count(i)
    return suma

def letraCapital(frase):
    partida = frase.split()
    suma = 0
    # comprobamos si la primera letra es mayuscula y la segunda minuscula
    for i in partida:
        if i[0].isupper() and i[1].islower():
            suma += 1
    return suma

def finPlural(frase):
    partida = frase.split()
    suma = 0
    # comprobamos si la ultima letra es una s, si antes tiene una vocal y si tiene mas de dos letras
    for i in partida:
        if i[-1] == "s" and i[-2] in ("a","e","i","o","u") and len(i) > 2:
            suma += 1
    return suma





frase = "Yo creo que la gente, cuando es inteligente y completamente normal, no debe pretender el ser rara y extraña, porque llega al absurdo inventado."
print(frase)
print("La frase tiene ", cuentaPalabras(frase), " palabras")
print("La frase tiene ", cuentaLetras(frase), " letras")
print("La frase tiene ", cuentaVocales(frase), " vocales")
print("La frase tiene ", cuentaPuntuacion(frase), " signos de puntuacion")
print("La frase tiene ", letraCapital(frase), " palabras que comienzan por mayúscula")
print("La frase tiene ", finPlural(frase), " palabras que terminan en plural")

