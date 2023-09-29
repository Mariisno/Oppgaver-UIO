"""
Dette programmet inneholder en prosedyre som spørr bruker om alder.
Basert på alder vil billettprisen variere.
Prosedyren kalles 3 ganger
"""

def billett (): #Her lages en prosedyre
    alder = int(input ("Hvor gammel er du? \n")) #Her lages en variabel
    print ("Du er", alder, "gammel")

    billettpris = 0 #Denne variabelen vil forandre seg i if/elif -setningene basert på variabelet alder

    if alder <=17:
        billetpris = 30
        print ("Du er barn", billetpris, ("kr"))
    elif alder > 17 and alder < 63: #I oppgaven står det egentlig at alle over 17 er voksen, så om jeg skal følge oppgaven må jeg ikke ha med "and alder < 63"
        billetpris = 50
        print ("Du er voksen", billetpris, ("kr"))
    elif alder >= 63:
        billetpris = 35
        print("Du er gammel", billetpris, ("kr"))

#Her kalles prosedyren 3 ganger:
billett ()
billett ()
billett ()

#Se linje 10 for hva som posentielt kunne vært feil, men jeg valgte å fikse det
