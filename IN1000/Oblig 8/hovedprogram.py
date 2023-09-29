from verden import Verden

def hovedprogram():
    rad = input ("Skriv antall rader: ")
    kol = input ("Skriv antall kolonner: ")

    Verden1 = Verden(int(rad), int(kol))

    spm = True #Da starter det uten at bruker må gjøre noe

    while spm != "q":
        Verden1.tegn() #Tegner rutenett

        Verden1.oppdatering() #Oppdaterer rutenettet

        spm = input ("trykk q for å avslutte") #Her kan programme avluttes


# starte hovedprogrammet
hovedprogram()
