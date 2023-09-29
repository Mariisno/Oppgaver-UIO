#4.1, dette programmet sjekket hvor mange bokstaver det er i et ord:
def o (ord): #Her er det en funksjon med parameter
    teller = 0 #En teller som skal telle alle bokstavene (basert på hvor mange loops)
    for i in ord: #Her er det en loop som sjekker hvor mange indekser det er i "ord"
        teller += 1 #For hver indeks som blir sjekka blir det +1
    return teller #funksjonen vil skrive ut teller

ord = input("Skriv ditt favorittord: \n")
print("Ditt favorittord har", o(ord), "bokstaver") #Her printes det ut


#4.2, dette programmet vil sjekke hvor mange unike ord det er i en setning
ordbok = {} #Her er det en tom ordbok som vil fylles opp

def s (setning): #Dette er en funksjon med parameter
    ordene=setning.split() #Denne funksjonen vil splitte alle ordene til en liste

    for elm in ordene: #Går gjennom hele liste, går gjennom indeks for indeks
        teller1 = 0 #Her resettes tellinga
        for ordet in ordene: #Her sammenligner den det første indeks fra lista
            if elm == ordet: #Her sjekkes det om indekset og ordet (neste indeks som sjekkes) er like
                teller1 += 1 #Om det er likt er det +1 hver gang loopen skjer
        ordbok[elm]=teller1 #Her lagres det første indekset fra lista, dette skjer hver gang loopen går

    return ordbok #Dette er det som kommer ut

setning = input ("Skriv en fin setning: \n") #Denne settes inn i parameteret i funksjonen

print (s(setning))


#4.3,
"""
her bruker jeg funksjonene og parameterene fra oppgavene over
for å finne ut hvor mange ord det er i alle ordene i setningen og
hvor mange ganger et unikt ord forekommer
"""
bruker = input ("Skriv en til fin setning: \n")

print ("Det er", o(bruker), "i setningen din") #Merk her at jeg setter inn variabelen "bruker", som i funksjonen vil bli gjort om til variabelen setning

for i in s(bruker): #Her vil det være en loop for hver i(indeks) i ordbok, for s(bruker)=ordbok (det som er return)
    print ("Ordet", i, "forekommer", ordbok[i], "ganger, og har", o(i), "bokstaver" ) #For hver loop vil i(indeks) som er et ord i ordboka vises og få en forklaring
    #Her er i = ordet eks "jeg":3 i = jeg, ordbok[i]= forekomst eks: "jeg":3 - her vil 3 skrives ut, o(i)=lengde på ordet (her brukes funksjonen o(i) og sjekker i som er et ord)
