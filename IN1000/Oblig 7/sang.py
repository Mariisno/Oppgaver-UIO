class Sang():

    def __init__ (self, artist, tittel):
        self._artist = artist #En streng som består av en eller flere bokstavsekvenser atskilt av blanke tegn
        self._tittel = tittel


# """
# Metode spill
# "Spiller av" musikk i sangen den kalles for -
# Den skriver meldingen "Spiller <info om tittel og artist>" ut på terminalen"
# """
    def spill (self):
        return print (f"Spiller {self._tittel} av {self._artist}") #Dette skal printes ut hver gang en sang spilles

# """
# sjekk_artist med parameter navn (en streng) på samme form som instansvariabelen
# _artist. Metoden returnerer True dersom ett eller flere av navnene i strengen navn
# finnes i _artist, ellers False
# """

    def sjekk_artist (self, navn):
        for i in navn.split(): #Sjekker om både fornavn og etternavn/flere navn er med
            return i in self._artist.split() #Denne vil retunere True/False

# """
# sjekk_tittel med parameter tittel (en streng). Metoden sjekker om oppgitt tittel er den
# samme som i instansvariabelen og returnerer True ved likhet, ellers False. Titlene
# skal defineres som like uavhengig av små/ store bokstaver.
# """

    def sjekk_tittel (self, tittel):
        return (tittel.lower() == self._tittel.lower()) or (tittel == self._tittel)

# """
# sjekk_artist_og_tittel med parametere artist og tittel. Metoden returnerer True
# dersom både tittelen og artisten (samme regler som i sjekk-metodene) stemmer med
# sangens instansvariabler, ellers False.
# """
    def sjekk_artist_og_tittel (self, artist, tittel):
        return self.sjekk_tittel (tittel) and self.sjekk_artist (artist)
