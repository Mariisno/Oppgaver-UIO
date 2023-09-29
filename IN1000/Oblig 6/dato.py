"""
Skriv en klasse Dato som representerer en dato. Konstruktøren til klassen skal ha
parametere ny_dag, ny_maaned og nytt_aar og bruke disse til å initialisere
tilsvarende instansvariabler i det nye objektet (dag, maaned og aar) representert som
heltall.
"""

class Dato: #Her er klassen

    def __init__ (self, ny_dag, ny_maaned, nytt_aar): #Her er konstruktør
        self.ny_dag = ny_dag
        self.ny_maaned = ny_maaned
        self.nytt_aar = nytt_aar


    def hent_aar (self):
        return self.nytt_aar

    def hent_dato (self):
        return print(f"{self.ny_dag}.{self.ny_maaned}.{self.nytt_aar}")

    def bestemt_dato (self):
        bestemt_dato1 = 15
        bestemt_dato2 = 1
        if bestemt_dato1 == self.ny_dag: #Her sjekkes det om bestemt_dato1 er samme som den datoen som objektet har
            return print("Loenningsdag!") #Om det er samme så skrives dette ut
        elif bestemt_dato2 == self.ny_dag:
            return print("Ny maaned, nye muligheter")

    def sant_usant (self):
        riktig = 10
        return print(riktig == self.ny_dag) #Her skal "True" eller "False" skrives ut
