#Her ber jeg med input bruker om å svare på spørsmålet
brus = input ("Vil du ha burs, ja eller nei? \n")


#Basert på svaret til brukeren vil det komme opp forskjellige alternativer i programmet.
#Om bruker skriver ja vil det første "if-setningen" bli tatt i bruk.
#Om bruker skriver nei vil den andre "elif-setningen" gjennomføres.
#Om brukeren svarer noe annet enn ja eller nei vil "else-setningen" gjennomføres

if brus.lower() == "ja" :
    print ("Her har du en brus!")

elif brus.lower() == "nei" :
    print ("Den er grei.")

#Grunnen til at det er skrevet "lower" over er fordi at det ikke skal være noen
#forskjell om bruker skriver med store eller små bokstaver.


else :
    print ("Det forstod jeg ikke helt.")
