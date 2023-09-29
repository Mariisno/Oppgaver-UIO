#Her spør programmet bruker om å skrive den første datoen og deretter bruker om å skrive inn første måned
#Jeg skriver "Maned1" isteden for med å, i tilfelle programmet ikke skjønner å
#\n er med for å bytte linje så det blir mer oversiktig
Dato1 = input ("Skriv inn første dato: \n")
Maned1 = input ("Skriv inn første måned: \n")

#Her er det ganske likt som over, bare at datoen og måned spørr bruker om å skrive inn noe annet
Dato2 = input ("Skriv inn andre dato: \n")
Maned2 = input ("Skriv inn andre måned: \n")

#Her sjekker programmet om det brukeren skriver inn på "Maned1" er mindre enn det som er skrevet inn på "Maned2"
#Om "Maned1" er mindre enn "Maned2" vil programmet skrive ut "Riktig rekkefølge!", hvis den ikke er større vil programmet sjekke elif-setningen
if Maned1 < Maned2 :
    print ("Riktig rekkefølge!")

#Om "if-setningen" over ikke var "true" (riktig), vil elif-setningen sjekkes
#Her vil den først sjekke om "Maned1" er det samme som "Maned2"
#Deretter bil den sjekke om "Dato1" er mindre enn "Dato2", om dette er "true", vil "Riktig rekkefølge!" printes, hvis ikke vil den gå over på neste "elif-setning" under
#Hvis "elif-setningen" Dato1 > Dato2 er true vil det som står under med print skrives ut i programmet, hvis ikke vil den gå videre
#Hvis så "elif-setningen" Dato1 == (som betyr at Dato1 er det samme som) Dato2 vil det printes ut "Samme" i programmet
elif Maned1 == Maned2:
    if Dato1 < Dato2:
        print ("Riktig rekkefølge!")
    elif Dato1 > Dato2:
        print ("Feil rekkefølge!")
#Her ser vi at både måneden og datoen er det samme:
    elif Dato1 == Dato2:
        print ("Samme")

#Om ingen av utfallene over passer vil programmet gå til den siste elif-setningen:
#Her sjekker programmet om Maned1 er større enn Maned2, noe som er vil skrive ut "Feil rekkefølge!" i programmet
elif Maned1 > Maned2:
    print ("Feil rekkefølge!")
