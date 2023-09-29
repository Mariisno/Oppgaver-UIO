"""
Dette er et program med en klasse Motorsykkel
Den har en konstruktør og tre instantmetoder i dette programmet.
"""

class Motorsykkel: #Her er klassenavnet

    def __init__(self, merke, registreringsnummer): #Her er konstruktør som har to parameter i tillegg til self
        self._merke = merke #Her er instansvariabelene
        self._registreringsnummer = registreringsnummer #instansvariabel
        self._km = 0 #Instansvariabel

    def kjor (self, km): #Her er metoden kjor, den har parameteret self, som alle metodene må ha for å referere til objektet og et parameter km, altså må bruker skrive inn et argument på km
        self._km += km #Her økes kilometerstand med det som ble skrevet inn i km

    def hent_kilometerstand(self): #Her er en metode som retunerer motorsykkelens totale kilometerstand
        return self._km #Her vises hva som retuneres, den vil ikke automatisk bli printet ut, så det må skje i test programmet

    def skriv_ut(self): #Her er en metode som skriver ut instansvariabelene nedenfor
        print (self._merke, self._registreringsnummer, self._km)
