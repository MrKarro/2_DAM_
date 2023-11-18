alumnos={}
asignaturas={}
""" 
for i in range(3):
  nombre=input('Dame un nombre')
  apellido=input('Dame un apellido')
  edad=input('Que edad tiene el alumno')
  movil=input('El número de telefono del alumno')
  alumno='Alumno'+str(i)
  dic={alumno:{'nombre':nombre,'apellido':apellido,'edad':edad,'movil':movil}}
  alumnos.update(dic)
print(alumnos)
asignaturas={'mates':alumnos,'lengua':alumnos}
print(asignaturas)
"""  
asignaturas={'mates': {'Alumno0': {'nombre': 'juan', 'apellido': 'hernandez', 'edad': '17', 'movil': '001122330'}, 'Alumno1': {'nombre': 'MARIA', 'apellido': 'GUTIERREZ', 'edad': '17', 'movil': '123456789'}, 'Alumno2': {'nombre': 'Elena', 'apellido': 'jimenezz', 'edad': '18', 'movil': '789456123'}}, 'lengua': {'Alumno0': {'nombre': 'juan', 'apellido': 'hernandez', 'edad': '17', 'movil': '001122330'}, 'Alumno1': {'nombre': 'MARIA', 'apellido': 'GUTIERREZ', 'edad': '17', 'movil': '123456789'}, 'Alumno2': {'nombre': 'Elena', 'apellido': 'jimenezz', 'edad': '18', 'movil': '789456123'}}}

for a  in asignaturas:
   print(a)
   for b   in  asignaturas[a]:
     print("\t "+b)
     for  n,v  in asignaturas[a][b].items():
        print("\t \t El "+n+" es : "+v)
    
      

print(asignaturas.items())
'''
for clave, valor  in asignaturas.iteritems():
     print(clave+"   "+valor)
'''    
