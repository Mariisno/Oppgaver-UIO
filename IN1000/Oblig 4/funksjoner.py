#1.1
def add (tall1, tall2): #Her er det to helltall som parameter (tall1 og tall2)
    return tall1 + tall2  #Man må ha en return for at dette skal være en funksjon, den tar inn argumentene (?)
#Her kalles funksjonene på med forskjellige tall som parameter:
print (add (2, 3))
print (add (1, 8))


"""
#1.2, versjon 1, vil bare ha den her så jeg kan se

likbokstav = 0 #Her telles det hvor mange like bokstaver det er i et ord
ord = input("Skriv noe her: \n")
bokstav = input ("Skriv din favorittbokstav: \n")
for antall in ord: #Antall går igjennom hele variabelen ord som en samling
    if antall == bokstav:
        likbokstav += 1
print ("Det er", likbokstav, "bokstaver av favorittbokstaven din i", ord )
"""


#1.3:
minTekst = input ("Skriv en tekst? \n")
minBokstav = input ("Skriv en bokstav du liker: \n")

def tellForekomst (minTekst, minBokstav): #Her er det to variabler som parametere
    teller = 0 #Denne teller hvor mange ganger loopen under går
    for antall in minTekst: #Antall går igjennom hele variabelen ord som en samling, sjekker indeksen til "samlingen"
        if antall == minBokstav:
            teller += 1
    return teller

print ("Det er", tellForekomst(minTekst, minBokstav), "av bokstaven du valgte i", minBokstav)
