# EvidenciaFinal
Repositorio para la evidencia final de Computacion en Java
-----COMO CREAR EL ARCHIVO JAR Y EJECUTARLO PARA CORRER EL PROGRAMA ------

Crear un JAR ejecutable con el programa Dr.Manager:

1) Desde el repositorio https://github.com/Agamo77/EvidenciaFinal accede al branch "master" y descarga todos los archivos.java a tu computadora en un directorio nuevo. Deberan de ser 6: Citas.java, Doctores.java, Main.java, Pacientes.java, SistemaDeGestion.java y Usuario.java.

2) Abre una ventana CMD en el directorio donde residen los archivos .java del proyecto y ejecuta el siguiente comando:

javac -d bin *.java

Esto creara una carpeta bin en el directorio y agregara archivos .class. No cierres la ventana de CMD.

3) Al haber compilado el codigo, para crear el archivo JAR, en la misma ventana de CMD en la que compilaste el codigo, ejecuta el siguiente comando:

jar cvfe drmanager.jar Main -C bin .

Este comando creara el archivo JAR especificando que el archivo se llamara "drmanager.jar", que la clase principal se llama Main y que debe utilizar los archivos .class localizados en la carpeta bin del directorio.

4) Para ejecutar el programa, desde la misma ventana de CMD ejecuta el siguiente comando:

java -jar drmanager.jar

-------- FUNCIONAMIENTO DEL PROGRAMA ---------
El programa Dr Manager permite al usuario gestionar información de doctores, pacientes y citas. Este programa permite al usuario las siguientes operaciones:
1.	Agregar nuevos doctores en base de datos y mostrarlos
2.	Agregar nuevos pacientes en base de datos y mostrarlos
3.	Programar citas de pacientes con doctores en específico y mostrarlos
4.	Agregar usuarios a la base de datos para restringir el acceso a usuarios no deseados.
Dr Manager escribe y lee la información de pacientes, doctores, citas y usuarios en su respectivo archivo .csv que esta localizado en la carpeta db dentro del directorio donde se ejecuta el programa. Al iniciar, el programa valida la existencia de los archivos y carga la información que tengan, sin embargo, al no encontrar los archivos, el programa creara instancias nuevas de cada archivo que estarán en blanco.
Es importante aclarar que Dr Manager cuenta con una cuenta de usuario programada directamente en el código fuente. Este usuario es capaz de acceder al programa aun cuando no exista en el archivo usuarios.csv. Las credenciales son:

USUARIO: administrador
CONTRASENA: administrador

Estas son las funciones de cada operación disponible en Dr Manager:

1.	Agregar Doctor: Ingresa la opción 1. El sistema solicitara el nombre y especialidad del doctor a ingresar y lo grabara en el archivo \bin\doctores.csv. Al mismo tiempo generara un ID para ese doctor automáticamente.
2.	Agregar Paciente: Ingresa la opción 2. El sistema solicitara el nombre del paciente y lo grabara en el archivo \bin\pacientes.csv. Al mismo tiempo generara un ID para ese paciente automáticamente.
3.	Agregar Cita: Ingresa la opción 3. El sistema solicitara ingresar la fecha y hora de la cita a generar en el formato YYYY-MM-DDTHH:MM. Después de esto solicitara un motivo de la cita, el nombre del doctor y del paciente. Al finalizar le generará un ID a esta entrada y escribirá la información en el archivo \bin\citas.csv.
4.	Mostrar Doctores: Opción 4. El sistema leerá el archivo \bin\doctores.csv y presentará la lista de doctores disponible en él.
5.	Mostrar Pacientes: Opción 5. El sistema leerá el archivo \bin\pacientes.csv y presentará la lista de pacientes disponible en él.
6.	Mostrar Citas: Opción 6. El sistema leerá el archivo \bin\citas.csv y presentará la lista de citas disponibles en él.
7.	Agregar Nuevo Usuario: El sistema solicitara un nombre de usuario y contraseña para el nuevo usuario. Al finalizar lo agregara al archivo \bin\usuarios.csv.



-----CREDITOS------
ARNOLDO GARCIA UNIVERSIDAD TECMILENIO MODALIDAD CONNECT
