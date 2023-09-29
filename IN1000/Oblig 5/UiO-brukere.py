#2.1 Denne oppgaven spørr bruker om fornavn og etternavn og lager et brukernavn med de
def lagBrukernavn(navn): #En funksjon som tar inn fult navn
    splitta = navn.split() #Her splittes navnene så det blir en liste med to indekser

    while len(splitta) != 2: #Jeg har dette så den ikke klikker om bruker skriver bare fornavn
         print ("Nå klikka det, prøv på nytt:")
         navn = input ("Du må skrive inn fornavn og etternavn med mellomrom: ")
         splitta = navn.split()


    #print (splitta) #Hadde denne bare for å sjekke

    fornavn = splitta [0] #Her er indeks 0 fornavn
    etternavn = splitta [1] #Her er indeks 1 etternavn

    brukernavn = fornavn + etternavn[0:2] #Her legger den til hele fornavn og indeks 0-2 (de to første) i etternavn
    brukernavn = brukernavn.lower() #Her blir det satt i små bokstaver

    return brukernavn #Brukernavn er det som retuneres

navn = input ("Hva er ditt fulle navn? (Fornavn og etternavn) ")

print ("Ditt brukernavn er:", lagBrukernavn(navn)) #Her skrives ut funksjonen

#2.2 denne funksjonen vil ta inn et brukernavn og epost-suffix og lage en epostaddresse med den
def lagEpost(brukernavn,epost): #Denne funksjonen tar inn et brukernavn og en epost-suffix
    epostaddresse = brukernavn + "@" + epost #Her vil epostaddressen lages
    return epostaddresse

brukernavn = input ("Hva er ditt brukernavn?")
epost = input ("Hva er din epost?")

print ("Din epostaddresse er:", lagEpost(brukernavn,epost))

#2.3 her tar prosedyren inn en ordbok med navn og epost-suffix og lager epostaddresser
def skrivUtEposter(ordbok):
    for i in ordbok: #Her går den gjennom i som er nøkkelen i en ordbok
        print (lagEpost(i,ordbok[i])) # Det er sånn her i ordboka: i:ordbok[i]

ordbok = {"olan": "ifi.uio.no", "karin":"student.matnat.uio.no"}

skrivUtEposter(ordbok)

#2.4 her er det en prosedyre som har en while-løkke, while-løkken vil kjøre så lenge bruker vil, og den spørr bruker om å lage brukernavn, epostaddresse eller avslutte
def loop ():
    ordbok1 = {} #Her er en tom ordbok
    svar = input("Vil du redigere epostaddressene? ja/nei ") #Denne bestemmer om bruker kommer inn i løkken eller ikke
    svar = svar.lower()
    while svar == "ja":
        svar = input ("Skriv først inn i for å lage brukernavn \nSkriv p for å lage en epostaddresse \nOm du vil avslutte programmet trykk s \nSkriv her: ")

        if svar == "i": #Her lages brukernavn og bruker skriver suffix
            navn = input ("Skriv ditt fornavn og etternavn:  ")
            esuffix = input ("Skriv din favoritt e-post suffix: ")
            brukernavn = lagBrukernavn(navn)
            ordbok1[brukernavn] = esuffix #Her legges det inn i ordbok1
            print (ordbok1)
        if svar == "p":
            if ordbok1 == {}: #Her sjekkes om ordbok1 er tom, om den er tom vil loopen kjøres på nytt
                input ("Det går ikke, du må bruke i før p, gå tilbake med å taste ok \n")
                loop()
            skrivUtEposter(ordbok1) #Her vil epostaddresser skrives ut basert på det som er i ordbok1
        if svar == "s":
            exit () #Har denne så når det er s så avsluttes programmet
        svar = input ("Skriv ja om du vil fortsette ") #Denne blir spurt på slutten for at loopen fortsetter
loop ()
