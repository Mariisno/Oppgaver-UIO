from rutenett import Rutenett

class Verden:
    def __init__(self, rader, kolonner):
        self._rader = rader
        self._kolonner = kolonner
        self._rutenett = Rutenett(self._rader, self._kolonner)
        self._generasjonsnummer = 0
        self._rutenett.fyll_med_tilfeldige_celler()
        self._rutenett.koble_celler()

    def tegn(self):
        self._rutenett.tegn_rutenett()
        print (f"Generasjonsnummer: {self._generasjonsnummer}")

    def oppdatering(self):
        print (f"Antall levende er: {self._rutenett.antall_levende()}") #går gjennom alle levende i rutenettet og teller levende naboer for hver celle

        #alle_celler = self._rutenett.hent_alle_celler()
        #går gjennom alle celler i rutenettet på nytt, og oppfaterer status på hver celle

        rutenett_liste = self._rutenett._rutenett #Her blir alle cellene i rutenettet til en liste

        for rad in rutenett_liste: #Går gjennom alle cellene i rutenettet
            for kol in rad:
                kol.tell_levende_naboer() #sjekker hvor mange som er levende

        for rad in rutenett_liste: #Går gjennom alle cellene
            for kol in rad:
                kol.oppdater_status() #Oppdaterer hver status på alle cellene

        self._generasjonsnummer += 1 #oppdatere telleren for antall generasjoner
