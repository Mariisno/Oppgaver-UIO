#1.1: Her er det en funksjon som adderer to tall
def addisjon (tall1, tall2): #To tall blir settet inn
    sum = tall1 + tall2 #Her adderes de og lagres som sum
    return sum #Sum blir retunert

print (addisjon(1,2))

#1.2: Her har jeg to funksjoner, en som substraherer og en som dividerer to tall
def substraksjon (tall1, tall2):
    sub = tall1 - tall2
    return sub #retunerer svaret

#Her sjekker jeg om det er "true" det som kommer inn i funksjonen:
assert substraksjon(2,1) == 1
assert substraksjon (10,2) == 8
assert substraksjon (7,4) == 3

def divisjon (tall1, tall2): #Her dividerer den
    div = tall1 / tall2
    return div
assert divisjon (2,2) == 1
assert divisjon (4,8) == 0.5
assert divisjon (10,2) == 5

#1.3: Dette er en funksjon som gjør om tommer til cm
def tommerTilCm (antallTommer):
    assert antallTommer > 0 #Om antallTommer er mindre enn 0 blir det feilmelding
    cm =  antallTommer * 2.54
    return cm

print (tommerTilCm(2))

#1.4:
def skrivBeregninger ():
    print ("\nUtregninger:")
    tall1 = float(input("Skriv inn tall 1: ")) #Her er tall1 fra bruker
    tall2 = float (input ("Skriv inn tall 2: ")) #Her er tall2 fra bruker
    print ("\nResultat av summering:", addisjon(tall1,tall2))
    print ("Resultat av substraksjon:", substraksjon(tall1,tall2))
    print (f"Resultat av divisjon: {divisjon(tall1,tall2)} \n ")
    print ("Konvertering fra tommer til cm:")
    konv = float (input ("Skriv inn et tall: ")) #Her er tallet som skal bli til tommer
    print ("Resultat:", tommerTilCm(konv))

#1.5: Her tester jeg prosedyren:
skrivBeregninger()
