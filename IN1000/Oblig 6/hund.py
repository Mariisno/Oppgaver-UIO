"""
Dette programmet inneholder klassen Hund
Den har en konstruktør og fire metoder som har forskjellige funksjoner
Hunden vil gå opp i vekt om den spiser og ned om den springer
"""

class Hund: #Her er klassen

    def __init__(self, alder, vekt): #Her er konstruktøren med to parameter i tillegg til self
        self._alder = alder #Dette er instantvariabel på alder
        self._vekt = vekt #instantvariabel
        self._metthet = 10 #instantvariabel som er satt til 10

    def spring (self): #Her er en metod
        self._metthet -= 1 #Her er det -1 på metthet når spring kjøres
        if self._metthet < 5: #Her sjekkes det om metthet er mindre enn 5
            self._vekt -= 1 #Om if kjøres så vil vekt bli -1

    def spis (self, mengde): #Her er en metode med et ekstra parameter som må skrives inn av bruker/fra test programmet
        self._metthet += mengde #Her plusses mengde på metthet
        if self._metthet > 7: #Sjekket om metthet er større enn 7
            self._vekt += 1

    def hent_alder(self):
        return print(f"Hunden din er {self._alder} år") #Her retuneres en formatering av instantvariablet alder og en setning som en print

    def hent_vekt(self):
        return print(f"Nå veier hunden {self._vekt} kg")
