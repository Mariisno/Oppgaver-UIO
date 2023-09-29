#Først så starter programmet med å si "Hei student!",
#var litt usikker på om jeg skulle ta vekk dette siden det stod endre,
#så lot det bare stå:

print ("Hei Student!")

#Her vil jeg at bruker skal fortelle hva navnet deres er,
#det brukeren skriver inn vil bli til variabelet "navn".
#\n er tatt med så det skriftes linje inne i programmet og blir mer oversiktig,
#kommer til å bruke denne mer i oppgavene av samme grunn:
navn = input ("Hva er navnet ditt? \n")

#Her sier programmet "Hei" og navnet til brukeren:
print ("Hei:", navn)

#Her lages to variabler, en for hvor mange gutter det er, som er 15 og en for hvor mange jenter det er, altså 10
#så vil jeg at programmet skal printe ut teksten "Gutter" og hvor mange variabelet gutter er
#deretter at det gjør det samme med "Jenter" og det variabelet:

gutter = 15
jenter = 10
print ("Gutter:", gutter)
print ("Jenter:", jenter)

#Her lages en ny variabel som viser differansen mellom gutter-jenter, altså 15-10:
kjønnsforskjell = gutter-jenter

#Her vil variabelen kjønnsforskjell vises i programmet:
print ("Kjønnsforskjell:", kjønnsforskjell)


#Her vil bruker få beskjed om å skrive inn et nytt navn, hvor det vil bli laget en ny variabel "nytt" med det de skriver inn:
nytt = input("Vil du ha et nytt navn? \n")

#Her vil en ny variabel lages, altså "sammen",som er sammensatt av variablet "navn", en streng med tekst og variabelet "nytt":
sammen = navn + (" og ") + nytt

#Her vil variabelen "sammen" vise i programmet:
print (sammen)
