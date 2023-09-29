#2.1 her vil programmet lese inn tall helt til bruker skriver 0:

teller = 1 #Denne teller hvor mange ganger loopen går, den kan ikke starte på 0 for da går ikke loop-en
#2.2, her lagres det hver gang loop går
liste = [] #En tom liste

while teller != 0: #Mens teller ikke er lik 0 kjører loopen, altså når bruker skriver 0 så stopper det
    teller = int(input ("Skriv inn et tall, når du skriver inn 0 vil programmet slutte \n")) #Husk å skrive int for det funker ikke hvis det er en streng

    liste += [teller] #Her lagres hver teller, altså hver gang bruker skriver noe annet

print (liste)

for i in liste: #Her skrives ut hver enkel indeks
    print (i)

minSum = 0 #Her vil alle summene av tallene lagres

for i in liste:
    minSum += i #Her vil det være summering av alle indeksene i liste, eks: 2+3+4+2 ...osv = minSum

print (minSum)

#2.5:
min= liste[0]
max= liste [0]

for i in liste:
    if i < min: #Her vil den gå igjennom alle indeksene og sammenligne hvilken som er minst
        min = i #Hver gang den finner en som er minst vil det bli lagra på min, om det kommer en ny en vil den bli erstatta

print (min)

for i in liste:
    if i > max: #Her sjekker den om indeksen er større enn max
        max = i #Max forandres hver gang den ser en i som er større enn max

print (max)
