from sang import Sang

class Spilleliste:
    def __init__(self, listenavn):
        self._sanger = []
        self._navn = listenavn

# Skriv metoden les_fil med parametere self og filnavn. Metoden åpner den oppgitte filen, og
# leser inn data om sanger – en linje per sang, på formatet
# tittel;artist
# Siden både tittel og artist kan inneholde blanke tegn, brukes semikolon som skilletegn. Merk
# også at det er lurt å fjerne tegn for linjeskift på slutten av hver linje

    def les_fil (self, filnavn):
        fil = open(filnavn, "r")
        for linje in fil:
            bit = linje.strip().split(";")
            sang1 = Sang(bit[1], bit[0]) #Her gjør jeg om sang til et sang-objekt, hvor bit[1] er tittel og bit[0] er artist
            self._sanger.append(sang1) #Blir lagra med addressen, da kan jeg bruke sang-metodene senere på det



# legg_til_sang med parametere self og ny_sang,
# der ny_sang er objektet som skal
# legges til spillelisten.
    def legg_til_sang (self, ny_sang):
        self._sanger.append(ny_sang)

# fjern_sang med parametere self og sang.
# Metoden tar inn et Sang-objekt som skal
# fjernes fra listen med sanger
    def fjern_sang (self, sang):
        self._sanger.remove(sang)

# spill_sang med parametere self og sang. Metoden skal kalle på metoden spill() til
# Sang-objektet som sendes med som parameter.

    def spill_sang (self, sang):
        return sang.spill() #Her må sang være addressen til objektet som skal spilles

# spill_alle med parameter self, som spiller hver enkelt sang i listen. Pass på å sjekke
# at rekkefølgen på tittel;artist i les_fra_fil har blir lest inn riktig ved å se hva som
# printes i terminalen når metoden blir kalt på.

    def spill_alle (self):
        for i in self._sanger: #Her vil alle printes
            self.spill_sang(i)


# finn_sang med parametere self og tittel, som leter gjennom listen av sanger etter en
# med oppgitt tittel og returnerer den første den finner. Finnes ikke tittelen i spillelisten
# returneres None

    def finn_sang (self, tittel):
        for i in self._sanger: #Går gjennom lista
            if i.sjekk_tittel(tittel): #Her bruker jeg en metode fra klassen Sang som sjekker om tittel som er skrevet inn er det samme som i
                return i

# hent_artist_utvalg med parametere self og artistnavn,
#som går gjennom alle sanger i spillelisten og returnerer en liste med sanger der artisten har et eller flere
# navn fra parameteren artistnavn.


    def hent_artist_utvalg (self, artistnavn):
        liste_sanger = []
        for i in self._sanger:
            if i.sjekk_artist(artistnavn):
                liste_sanger.append(i)
        return liste_sanger
