"""
Dette programmet importerer programmet Motorsykkel
Det tester ut om klassen motorsykkel funker som det skal
"""

from motorsykkel import Motorsykkel #Her importerer jeg filen motorsykkel inn i denne filen

def hovedprogram():#Her er en prosedyre
    motor1 = Motorsykkel("Honda", "PIZZA", 21) #Her er første objektet motor1, og argumenter som blir lagres inn som instantvariabler
    motor2 = Motorsykkel("Yamaha", "LAKS", 2000)
    motor3 = Motorsykkel("BMW", "TACO", 2894)
    motor1.skriv_ut() #Her kalles metoden .skriv_ut() som er laget inni klassen
    motor2.skriv_ut()
    motor3.skriv_ut()

    motor3.kjor(10) #Her kjøres enda en ny metode
    print(motor3.hent_kilometerstand()) #Her printer jeg ut en metode

hovedprogram () #Her kjøres prosedyren hovedprogrammet
