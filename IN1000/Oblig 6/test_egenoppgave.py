"""
Lag deretter et testprogram for klassen Person der du lar brukeren skrive inn navn og
alder, og oppretter et Person-objekt med informasjonen du får. Deretter skal brukeren
ved hjelp av en løkke få legge til så mange hobbyer de vil. Når brukeren ikke lenger
ønsker å oppgi hobbyer skal informasjon om brukeren skrives ut.
"""


from egenoppgave import Person

def hovedprogram():

    p1 = Person("Mari", 23)

    svar = input ("Vil du fortelle hva dine hobbyer er? ja/nei: ") #Her må brukeren bestemme om den vil inn i løkka eller ikke
    while svar == "ja":
        hobby = input ("Fortell en hobby du har: ") #Dette blir lagt inn i lista

        p1.leggTilHobbyer(hobby) #Her legges det inn

        svar = input ("Har du flere hobbyer? ") #Her kan bruker gå ut av løkka

    p1.skrivUt()

hovedprogram()
