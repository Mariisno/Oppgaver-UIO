"""
Denne oppgaven beregner skreddermål fra tommer til CM
"""

def ordbok (filnavn): #I denne funksjonen tas filen inn og gjøres om til en ordbok
    fil = open (filnavn, "r")

    ordbok = {}

    detIfil = ""

    for linje in fil:
        detIfil += linje
        bit = linje.split( ) #Her splittes det for å lage ordbok
        navn = bit [0]
        malTom = bit [1]
        ordbok[navn]=malTom

    print ("\nHer er det jeg vil konvortere til cm:\n\n",detIfil)

    return ordbok

def tommerTilCm (antallTommer):#Denne funksjonen regner fra tommer til cm
    cm =  antallTommer * 2.54
    return cm

def mal (ordbok):
    listeCm = [] #Liste med målet i Cm
    listeTom = [] #Liste med målet i Tom

    for i in ordbok: #Her gås det gjennom hvert mål
        Tom = ordbok[i]
        Tom = float(Tom)
        listeTom.append(Tom)
        Tom = tommerTilCm(Tom)
        Tom = listeCm.append(Tom)

    TomOgCm = f"Målene i tommer: {listeTom} er {listeCm} i cm. " #Dette er det som retuneres, så er det en liste med tommer og en med cm
    return TomOgCm


def main (): #Har det i main så ikke noe er lokalt
    print (mal(ordbok("egenoppgave.txt")),"\n")

main()
