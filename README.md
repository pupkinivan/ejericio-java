# ejericio-java

El ejercicio se centra en un sistema ficticio de validación de operaciones de pago con tarjeta de crédito. Se debe cotejar, por un lado, que la tarjeta sea válida en base a su fecha de expiración y, por otro, que la operación que se realiza sea de un monto menor a $1000. Además, las tres empresas ficticias que fabrican tarjetas ("SQUA", "SCO" y "PERE") cobran comisiones distintas, las que se debe poder calcular.

Las consignas específicas son:

Una tarjeta se identifica según su marca, dueño, número y fecha de expiración y, para simplicidad del ejercicio, es válida solamente si la fecha de expiración es posterior a la actual.

Una operación es válida solamente si su monto es menor a los $1000.

Las tasas de comisión por operación de cada empresa se calculan de la siguiente forma:
* SQUA: año / mes
* SCO: día del mes x 0.5
* PERE: mes x 0.1

Las consignas específicas a cumplir son:
1. Crear una clase ejecutable que instancie tres objetos e:
    1. invoque un método que entregue los detalles de una tarjeta
    1. informe si una operación es válida
    1. informe si una tarjeta es válida para operar
    1. identifique si una tarjeta es igual a otra o no
    1. obtener por medio de un método la comisión de operación en función de marca de tarjeta y monto de la transacción
1. El proceso de cobro consiste en cuatro acciones:
    1. ```imprimirFactura()```: imprimir la factura
    1. ```enviarInfoTC()```: enviar la información de la tarjeta de crédito
    1. ```informarPago()```: informar el pago a comercial
    1. ```actualizarSaldo(cliente)```: actualizar el saldo del cliente
    
    Se debe adaptar los métodos para contemplar los siguientes casos de error:
    1. la impresora no imprime
    1. el host de la tarjeta de crédito está caído
    1. el sistema contable no responde y/o no atiende los pedidos
    1. la base de datos no permite escribir el nuevo saldo del cliente
1. Servicio REST
    1. implementar un servicio REST en formato JSON de consulta de comisión de una operación informando marca y monto
    1. compartir el código en git (holis)
    1. hostear la API REST en un servicio de nube gratuito e indicar la URL

El servicio alojado de consulta se puede encontrar en https://ejercicio-java.herokuapp.com/getComision?marcaTarjeta=SQUA&monto=555 . Modificando la porción siguiente a ```marcaTarjeta``` se puede (sorpresa) elegir otra de las fabricantes de tarjetas y alterando ```monto```, lo propio. Dado que los servidores gratuitos de Heroku se apagan luego de determinado tiempo, si se quiere probar, escríbaseme.

