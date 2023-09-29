"""
Skriv en klasse Person med en konstruktør som tar imot navn og alder og oppretter
og initialiserer instansvariabler med disse. I tillegg skal konstruktøren opprette en
instansvariabel hobbyer som en tom liste . Skriv en metode leggTilHobby som tar
imot en tekststreng og legger den til i hobbyer-listen. Skriv også en metode
skrivHobbyer. Denne metoden skal skrive alle hobbyene etter hverandre på en linje.
Gi deretter Person-klassen en metode skrivUt som i tillegg til å skrive ut navn og
alder kaller på metoden skrivHobbyer.
"""

class Person: #klassen

    def __init__(self, navn, alder): #Her er det to parametere og en self som er objektet
        self._navn = navn
        self._alder = alder
        self._hobbyer = [] #En tom liste

    def leggTilHobbyer (self, streng): #Denne metoden legger til en streng inn i den tomme listen, altså til hobbyer
        self._hobbyer.append(streng)
        self._hobbyer.append(" ") #Har med denne fordi da blir det et mellomrom på slutten når jeg vil skrive ut hobbyene i en streng

    def skrivHobbyer (self): #Denne metoden skriver ut listen som en streng og ikke som en liste
        str = "" #En tomt streng
        for i in self._hobbyer:
            str += i #Her legges i (indeks) inn i str(streng)
        return str #Strengen retuneres

    def skrivUt (self): #Her kommer det som blir skrivet ut, ikke noe over har print
        if self._hobbyer == []: #Denne sjekker om _hobbyer er tom
            return print (f"Hei, {self._navn}, på {self._alder}, du har ikke fortalt om noen hobbyer")
        if len(self._hobbyer) == 1: #Denne sjekker om bruker bare har en hobby
            return print(f"{self._navn} er {self._alder} år og har denne hobbyen: {self.skrivHobbyer()}")
        else: #Denne går om bruker har flere enn 1 hobby
            return print(f"{self._navn} er {self._alder} år og har disse hobbyene: {self.skrivHobbyer()}")
