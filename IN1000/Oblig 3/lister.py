
#1.1, her er det en liste med 3 tall:
tall = [1, 2, 3,]
tall.append (4) #Her legger jeg til et tall i litsa tall

#Her sjekker jeg hva som printes ut på 0 og 2:
print (tall [0])
print (tall [2])

#1.4:
sum = tall[0] + tall [1] + tall[2] + tall[3] #Her beregnes sum av lista
print (sum)
produktet = tall[0] * tall [1] * tall[2] * tall[3] #Her multipliseres lista
print (produktet)
ny = [sum, produktet] #Her lages en ny liste
print (ny)
alt = tall + ny #Her slår jeg sammen listene
print (alt)

#Her er det et alternativ til å ta vekk de bak, men pop er bedre å bruke om man ikke vet hvor mange variabler man har
"""
alt.remove (alt[5])
print(alt)
alt.remove (alt[4])
Brukte dette først, men pop er bedre
"""
alt.pop ()
alt.pop ()
print (alt)

#1.2, dette programmet spørr om navn og legger det inn i en liste, også sjekker den om mitt navn er med:

navn = [] #Her er en ny tom liste
def navne (): #Lager prosedyre så koden blir kortere
    navn.append (input ("Skriv inn et navn \n"))
#Her ber jeg bruker 4 ganger om å skrive inn navn:
navne ()
navne ()
navne ()
navne ()


if "Mari" in navn: #Denne sjekker om "Mari" er i lista
    print ("Du huska meg")

else:
    print ("Du glemte meg")
