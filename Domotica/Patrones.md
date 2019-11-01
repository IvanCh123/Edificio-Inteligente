# Patrones utilizados en el sistema de domotica

## Factory Method -> Tener un fatory de sensores y actuadores ya que muchos de sus metodos son iguales.

## Mediator -> Se encarga de añadir los comportamientos y comunicarse con todos los tipos de sensor/actuadores.

## 
Para el sistema de domotica tiene un mediator que se conecta con los sensores y mediadores


| Sensor | <-- Mediator --> | Actuador |


El sensor tiene que avisar de alguna manera que algo cambió y así ver la condición y hacer el actuador
Ej: temperatura = 31; 

Para esto se puede hacer mediante el Mediador:
El sensor cambia, mediador se da cuenta y le dice a los que estan asociados al sensor cambien automáticamente.


        *  *             
     *        *     ----> Actuador asociado
    *  Sensor  *    ----> Actuador asociado
    *          *    ----> Actuador asociado
     *        *        
        *  *              

El sensor sabe a cual Actuador cambiar por medio del Mediator. 


Posible test: 

new Mediator
new Sensores {}
new Actudaores {}



mediator.addB( temp > 30, apagaRadio())
sensores[temp] = 31

Assert(Radio.apagado = true)

