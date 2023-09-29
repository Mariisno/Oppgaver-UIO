"""
Dette programmet tester om dato.py funker som det skal
Jeg har testa med litt forskjellige variabler og bruk av metoder
"""

from dato import Dato


def hovedprogram ():

    dato1 = Dato(10, 5, 2000)

    dato1.hent_dato()

    dato2 = Dato(15, 5, 2022)

    dato2.bestemt_dato() #Dette er lønningsdag

    dato1.sant_usant()

hovedprogram ()
