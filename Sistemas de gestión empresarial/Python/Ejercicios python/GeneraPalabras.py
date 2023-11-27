import random

def generaPalabra(abecedario):
    palabra = ''
    for i in range(5):
        palabra = random.sample(abecedario, 5)    
    return palabra




abecedario = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']

palabras = []

for i in range(30):
    palabras.append(generaPalabra(abecedario))

for i in range(10):
    elegida = random.choice(palabras)
    print ( (i+1), " ", "".join(elegida))