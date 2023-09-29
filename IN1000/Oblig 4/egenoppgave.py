"""
Dette programmet spørr bruker om å legge til eller fjerne venner og dere bursdagsmåned i en liste.
Hver gang en venn og måned er lagt til vil lista vises.
"""
bursdagsoversikt = [] #Her er den tomme lista som vil bli fylt opp


def start ():
    svar = input ("Vil du redigere bursdagslista? ja/nei? \n") #Dette er starten
    svar = svar.lower()
    loop (svar) #Her kommer svaret som er overst og da starter "loop"


def add (venn):
    bursdag = input ("Når har vennen din bursdag? (måned) \n") #Skriver måned for å gjøre det klart at det er måned og ikke dato
    bursdag = bursdag.lower () #Her er lower for at det skal bli lettere å fjerne
    bursdagsoversikt.append (venn + " Bursdag: " + bursdag) #Her vil elementene bli lagt til
    print ("Her kan du se oversikten over vennene dine sine bursdager: ", bursdagsoversikt) #Når alt over i "loop" er ferdig vil bursdagsoversikt printes
    return bursdagsoversikt

def remove (venn): #Her er fjerne funksjonen
    bursdag = input ("Når har vennen din bursdag? (måned) \n")
    bursdag = bursdag.lower ()
    if (venn + " Bursdag: " + bursdag) not in bursdagsoversikt:
        print ("Nå skrev du noe som ikke var i lista eller noe feil \n Husk å skrive riktig navn og måned uten noen mellomrom")
    else:
        bursdagsoversikt.remove (venn + " Bursdag: " + bursdag) #Den vil her fjerne "venn" + "Bursdag" + bursdag
    print ("Her kan du se oversikten over vennene dine sine bursdager: ", bursdagsoversikt) #Når alt over i "loop" er ferdig vil bursdagsoversikt printes
    return bursdagsoversikt

def loop (svar):
    while (svar != "nei") and (svar =="ja"): #Hvis svaret er ja vil dette skje:
        alternativer = input ("Hva vil du gjøre? legge til eller fjerne en venn i lista? (legge til/fjerne)\n>") #:Her kan bruker legge til eller fjerne
        alternativer = alternativer.lower ()
        if alternativer == "legge til": #Hvis bruker vil legge til skjer dette:
            navn = input ("Hvem vil du legge til i bursdagslista? ")
            navn = navn.lower () #For at det skal være lett å legge til og fra har jeg lower
            add (navn) #Da vil den gå til "add"-funksjonen som legger til elementer i lista
        if alternativer == "fjerne": #Dette er der programmet kommer om bruker vil fjerne
            if bursdagsoversikt == []: #Her sjekker programmet om lista er tom, om den er tom så går det ikke å fjerne noe fra lista.
                print ("Lista di er tom, du må legge til noen for å fjerne \n")
                input ("Trykk ok for å gå tilbake \n")
                loop (svar)
            else:
                navn = input ("Hvem vil du fjerne i bursdagslista? \n")
                navn = navn.lower()
                remove(navn) #Her er fjerne funksjonen
        else:
            print ("Nå skrev du noe rart")
        svar = input("Vil du fortsette å redigere bursdagslista? (ja/nei) ") #Her er det spørsmål om noe mer skjer

    if (svar != "nei") and (svar != "ja"): #Om svar ikke er nei eller ja, så vil dette skje
        sikker = input ("Nå skrev du noe rart, vil du tilbake til programmet? ja/nei? \n") #Da vil bruker få mulighet til å gå tilbake til programmet
        sikker = sikker.lower ()
        if sikker == "ja":
            start ()
        if sikker == "nei":
            print ("OK")

start ()
