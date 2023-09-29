"""
Lag deretter en meny som spørr om allergier og forteller hva menyen blir.
"""


def valgmat ():
    mat= {"ingenting":"Sushi", "glutenfri":"kyllingsalat", "vegansk":"tomatsuppe", "laktosefri":"currysuppe"}

    spm = input ("Hvilke allergier/matpreferanser har du?? \n")
    spm = spm.lower()
    if spm in mat:
        print ("Da blir maten din:", mat[spm])
    else:
        print ("Hei, du valgte noe vi ikke skjønte, velg mellom ingenting, glutenfri, vegansk eller laktosefri")
        input ("Trykk ok for å skrive på nytt \n")
        valgmat ()

valgmat ()



"""
Lag til slutt en ordbok som har oversikt over deltagere og deres matpreferanse, hvor bruker skriver inn dette:
"""
oversikt = {} #Her er ordboka tom, men det fylles opp etterhvert
def matoversikt ():
    navn = input ("Hei, hva heter du? \n")
    matvalg = input ("Hei, hva har du lyst til å spise? \n")
    oversikt[navn] = matvalg
matoversikt ()
matoversikt ()
matoversikt ()

sjekk = input("Nå deler vi ut mat, hva heter du? \n")
if sjekk in oversikt:
    print ("Okay, da skal du få:", oversikt[sjekk])
else:
    print ("Hei, du er desverre ikke påmeldt")
