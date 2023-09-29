"""
Skriv et program som spør bruker om den vil være med på en quiz eller ikke.
Bruk prosedyrer som inneholder if/else inne i programmet, hvor det finnes flere mulige løsninger for å komme til prosedyrene
Ha med forskjellige spørsmål til bruker.
Når bruker endelig kommer til quiz- spørsmålet skal det bare være et spørsmål.
Skriv kommentarer om du føler det er nødvendig. Om det er nye fokusjoner for deg er det fint om det er kommentarer
"""
"""
Dette programmet spørr bruker om å være med på quiz.
Det er flere mulige svar for bruker og finnes flere prosedyrer som er satt
inn så brukeren kan komme til samme utgangspunkt selvom svarene er forskjellig
"""
#Viktig at en def som skal brukes skrives før den brukes, altså den som brukes sist skrives først
def start(): #Dette er en prosedyre som kommer frem når den blir kalt på
    quizsvar = input ("Hva er best av pizza og sushi?\n>")
    if quizsvar.lower() == ("pizza"): #.lower() er med så det ikke har noe å si om svaret er med store eller små bokstaver
        input("WOW Hvordan visste du det?\n>") #Her ber jeg om input fra bruker, men inputet vil ikke ha noen påvirkning på programmet
        print("Okay da er quizen over, du vant!")
        print("Ring meg på 2222 5555 så får du en premie")
        exit(0) #Må ha exit(0) tror jeg, hvis ikke kjørte "else"-en som jeg skrev på slutten
    elif quizsvar.lower() == ("sushi"):
        input("hva slags sushi da?\n>")
        print("Okay spennende, da er quizen ferdig :) takk for idag.")
        exit(0)
    else:
        print("Nå svarte du noe rart")
        exit(0)

def quizspm(): #Enda en prosedyre
    print("NÅ STARTER DET!!!!")
    gira = input("Er du gira? ja/nei?\n>") #Jeg har med ja/nei så bruker vet at den må skrive ett av de
    if gira.lower() == ("ja") :
        print("Wohoo")
        start() #Her kalles prosedyren over på
    elif gira == "nei" :
        print("Dumt for deg, vi fortsetter uansett")
        start()
    else:
        print ("Jeg skjønte ikke")
        exit (0)

def quiz():
    print("Åhh så gøy at du er med!")
    klar = input("Er du klar ja/nei?\n>")
    if klar.lower() == ("ja"):
        quizspm() #Her kalles prosedyren over og den vil kjøre
    elif klar.lower() == ("nei"):
        vente = input("Skal vi vente på deg? ja/nei\n>")
        if vente.lower() == ("nei"):
            print ("Okay da starter vi uten deg.")
            quizspm()
        elif vente.lower() == ("ja"):
            ventetid = input("Ok da starter vi når du skriver klar!\n>") #Her må bruker skrive klar, som den får beskjed om, hvis ikke kommer else-en som er nederst
            if ventetid.lower() == ("klar"):
                quizspm()
    elif klar.lower() == ("absolutt ikke") :
        print("Okay da ses vi en annen gang")

#Det over er laget som prosedyrer og vil ikke kjøre før de blir "kallet på"
#Her starter python! Dette er hvor programmet starter!
spm1 = input("Hei, vil du spille quiz ja/nei?\n>")
if spm1.lower() == ("ja") :
    quiz() #Her blir prosedyren quiz() kallet på, så den vil kjøre her

if spm1.lower() == ("nei") :
    print("Åhh så trist")
    usikker = input("Er du sikker? ja/nei\n>")
    if usikker.lower() == ("nei") :
        quiz()
    elif usikker.lower() == ("ja"):
        input ("Vil du utdype hvorfor du ikke vil være med på quiz?\n>")
        print ("Den er grei, ha en fin dag videre! :) ")
else :
    print ("Jeg skjønner ikke hva du mener, kjør programmet på nytt")
