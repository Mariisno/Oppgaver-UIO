"""
Dette programmet spørr bruker om å skrive inn et navn til en beboer.
Derretter vil matplanen til beboeren dukke opp
"""

#4.1
beboere = {"Arne":["Frokost=banan", "Lunsj=omellet", "Middag=pizza"], #Dette er en ordbok med navn på beboere og deres matplan
"Gerd":["Frokost=Eple","Lunsj=yoghurt", "Middag=Pølser"],
"Gunnhilde":["Frokost=Pølser", "Lunsj = Granola", "Middag = Suppe"]} #Matplanen til hver beboer er skrevet inn i en egen liste

#4.2
def navnbo (): #Her lages en prosedyre
    print ("Beboerene som bor her er: Arne, Gerd og Gunnhilde")
    navn=input ("Skriv en beboer du vil se matplanen til her: \n")
    if navn in beboere: #Denne if-setningen sjekker om det bruker skriver inn i navnet finnes i ordboken beboere, og hvis ja så utføres den
        print ("Her er", navn, "sin matplan:", beboere[navn])
    else:
        print (navn, "er ikke registert hos oss")

navnbo () #Her kalles prosedyren på

#4.3:
"""
a) Jeg ville brukt ordbok, da kunne jeg hatt "Brukernavn":"Navn", siden
alle brukernavn er unike, så kan man lett søke opp hvem som har hvilket brukernavn.

b) Jeg ville også brukt ordbok, da kan man ha "Brukernavn":Poeng
så kan man lett søke det opp.

c) Jeg ville brukt en enkel liste, siden vi bare skal ha navn trenger vi ikke noe mer
og det kan også være at flere heter det samme, derfor må vi ha liste og ikke mengde.

d) Jeg ville brukt mengde, for da vil vi ha en oversikt over alle de unike
allergiene som finnes, det kan f.eks være at flere er allergisk mot gluten,
og da er det fint at det bare kommer opp en gang.
"""
