#4.1 denne funksjonen tar inn en fil og organiserer den inn i en ordbok
def getRekords (string): #Den tar inn en streng som er filnanv
    fil = open (string, "r")
    ordbok = {} #tom ordbok
    for linje in fil: #Her får jeg ut en og en linje
        bit = linje.strip("\n").split(",") #Her sletter jeg \n og splitter på ","
        mnd =bit[0] #Kolonne 1
        temp = float(bit[1]) #Kolonne 2
        ordbok[mnd]=temp #Her legges måned og temp inn, hvor måned er nøkkel og temperatur er verdi

    return ordbok

# 2
def getTemps (rekorder, string): #Her tar funksjonen inn to argumenter, en ordbok som er de varmeste temperaturene (funksjonen over) og et filnavn for en fil som inneholder daglige temperaturer
    fil = open (string, "r") #Her leses av de daglige temperaturene
    for linje in fil: #Her får jeg ut en og en linje
        bit = linje.strip("\n").split(",")
        mnd = bit[0]
        temp = float(bit[2])
        if temp > rekorder[mnd]: #Her sjekkes det om temperaturen for en dag er høyere enn temperaturen som finnes i ordboken(rekorder)
            print (f"ny varmerekort i {mnd}: {temp} Celsius (gammel varmerekort var {rekorder[mnd]} Celsius)") #Må bruke ordbok for å finne GammelTem
            rekorder[mnd] = temp #Oppgave 3

    return rekorder #Oppgave 3


def main (): #Her har jeg lagt inn alle kjøringene av funksjonene i en prosedyre for at ingenting er globalt
    # 1
    rekords = getRekords ("max_temperatures_per_month.csv")
    print("Oppgave 1")
    print(rekords)
    # 2
    temps = getTemps(rekords, "max_daily_temperature_2018.csv")
    # 3
    print(temps)

main () #Her kjøres alt inni main
