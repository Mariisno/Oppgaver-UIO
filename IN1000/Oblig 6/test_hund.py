"""
Dette programmet skal teste hund.py programmet
"""

from hund import Hund #Her henter jeg klassen

def hovedprogram(): #Hovedprogram
    hund1 = Hund(5, 9) #Her blir argumentene satt som instantvariabler inni klassen

#Her kjører jeg en del metoder for å sjekke hva de gjør når hunden springer
    hund1.spring()
    hund1.hent_vekt()

    hund1.spring()
    hund1.hent_vekt()

    hund1.spring()
    hund1.hent_vekt()

    hund1.spring()
    hund1.hent_vekt()

    hund1.spring()
    hund1.hent_vekt()

    hund1.spring()
    hund1.hent_vekt()

    hund1.spring()
    hund1.hent_vekt()

    hund1.spring()
    hund1.hent_vekt()

#Her spiser hunden og går opp i vekt:
    hund1.spis(20)
    hund1.hent_vekt()


hovedprogram ()
