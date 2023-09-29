"""
Dette programmet lager en reiseplan for brukeren,
hvor brukeren kan se tilbake på planen etter den er skrevet
"""
#Her er det tomme lister som fylles ut etterhver i programmet
steder = []
klesplagg = []
avreisedatoer = []

for i in range(5): #Her vil loopen gå 5 ganger 0-4
    i = input ("Hvor vil du reise? \n")
    steder.append(i) #Her vil i som er steder[i] bli fylt opp hver gang loopen går

for i in range(5):
    i = input ("Hva skal du ha på?")
    klesplagg.append(i)


for i in range(5):
    i = input ("Når skal du reise? \n")
    avreisedatoer.append(i)


reiseplan = [steder] + [klesplagg] + [avreisedatoer]
#Her kobles de tre listene sammen, altså vil det være tre lister inni en liste

#Her vil programmet spørre brukeren om hvilken reiseplan som bruker vil se:
liste_indeks1 = int(input ("Vil du se reiseplan 0(Hvor), 1(Klær) eller 2(Dato)? \n")) #Her er det 0-2 og det sjekkes hvilke av de tre listene inni lista brukeren vil åpne
liste_indeks2 = int (input ("Vil du se reiseplan 0, 1, 2, 3 eller 4? \n")) #Her sjekkes 0-4, her sjekker det hvilken indeks inni den første indeksen(første lista) som brukeren vil se

#Her sjekkes det om det er gyldig det bruker skriver:
if (liste_indeks1 <=2 or liste_indeks1 >= 0) and (liste_indeks2<= 0 or liste_indeks2 <= 4): #Paranteser for å gruppere riktig
    print (reiseplan[liste_indeks1][liste_indeks2])
else:
    print ("Ugyldig input!")
