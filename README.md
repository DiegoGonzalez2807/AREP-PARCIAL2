# AREP-PARCIAL2
AREP Segundo Corte Parcial


Diseñe un prototipo de sistema de microservicios que tenga un servicio (En la figura se representa con el nombre Math Services) para detectar si una cadena es un palíndromo o no.  El servicio de palíndromos debe estar desplegado en almenos dos instancias virtuales de EC2. Adicionalmente, debe implementar un service proxy que reciba las solicitudes de llamdo desde los clientes  y se las delega a las dos instancias del servicio de palíndromo usando un algoritmo de round-robin. El proxy deberá estar desplegado en otra máquina EC2. Asegúrese que se pueden configurar las direcciones y puertos de las instancias del servicio en el proxy usando variables de entorno del sistema operativo.  Finalmente, construya un cliente Web mínimo con un formulario que reciba la cadena y de manera asíncrona invoke el servicio único en el PROXY. El cliente debe ser escrito en HTML y JS.


## Backend
Para el backend del palindromo se crea mediante Spark un Listener en el cual reciba los endpoints "/espalindromo?value={}". La respuesta de este listener es en formato JSON para que el frontend lo pueda entender e imprimir
![Image text](https://github.com/DiegoGonzalez2807/AREP-PARCIAL2/blob/master/images/PRIMERA.png)

De igual manera se revisa el query que se hace y así retornar el valor mediante la función "GetValue", la cual se presenta en la misma clase.

### Funcionamiento Palindrome
Palíndromo Es una cadena que se lee igual si se lee de izquierda a derecha, que si se lee de derecha a izquierda.

Por ejemplo, "adbaeea" no es un palíndromo, pero en cambio, "aadbaeeabdaa" si es una palíndormo.
Otro ejemplo, "12785" no es una palíndromo, pero "127858721" si es una palíndromo.


Para esto lo que se piensa es convertir a ua lista de Strings la cadena dada por el usuario y así ir comparando desde la primera hasta la última posición
![Image text](https://github.com/DiegoGonzalez2807/AREP-PARCIAL2/blob/master/images/SEGUNDA.png)


### FUNCIONAMIENTO BACKEND AWS

Para este caso se hacen dos dependencias para que el RoundRobin pueda escoger entre dos distintos servicios. Se muestran imagenes del funcionamiento de estas en la maquina

![Image text](https://github.com/DiegoGonzalez2807/AREP-PARCIAL2/blob/master/images/INSTANCIAS.png)


![Image text](https://github.com/DiegoGonzalez2807/AREP-PARCIAL2/blob/master/images/PRIMERA%20MAQUINA.png)


![Image text](https://github.com/DiegoGonzalez2807/AREP-PARCIAL2/blob/master/images/SEGUNDA%20MAQUINA.png)

##FRONTEND PALINDROME
En este caso se genera un listener spark donde este escucha peticiones para redirigir al html y para escuchar a los dos servicios de back 
Se hace algoritmo de RoundRobin 


