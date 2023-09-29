from random import randint
from celle import Celle

class Rutenett:
    def __init__(self, rader, kolonner):
        self._ant_rader = rader
        self._ant_kolonner = kolonner
        self._rutenett = self._lag_tomt_rutenett()

    def _lag_tomt_rutenett(self):
        to_dimensjonal_liste = []
        for rad in range(self._ant_rader): #Her finner jeg hver rad
            to_dimensjonal_liste.append(self._lag_tom_rad()) #Legger til en liste inni lista (to_dimensjonal_listed/noestet liste), da lager jeg radene
        return to_dimensjonal_liste

    def _lag_tom_rad(self):
        liste = []
        for kol in range(self._ant_kolonner): #Her finner jeg hver kolonne
            liste.append(None) #Her lager jeg kolonnene i lista, legger de til
        return liste

    def fyll_med_tilfeldige_celler(self): #SE fyll_verdi
        for rad in range(len(self._rutenett)): #Her finner jeg raden, eks: Hvis den har 10 lister - vil den gå fra 0-9
            for kol in range(len(self._rutenett[rad])): #Her finner jeg kolonnen
                self.lag_celle(rad, kol)

    def lag_celle(self, rad, kol):
        if randint(0,2) == 0:
            celle = Celle()
            celle.sett_levende()
            self._rutenett[rad][kol] = celle #Her setter jeg levende inn cellen i rutenett

        else:
            celle = Celle()
            self._rutenett[rad][kol] = celle #Her setter jeg inn doed celle i rutenett


    def hent_celle(self, rad, kol):
        if (rad < 0) or (kol < 0) or (rad > len(self._rutenett)-1) or (kol > len(self._rutenett[rad])-1): #Sjekker at den ikke kan være mindre enn 0 eller større enn lengden til listen, Her må jeg ha -1, hvis ikke blir det feil i _sett_naboer
            return None
        else:
            return self._rutenett[rad][kol]

#Den over må ha -1 siden den har len, en den under trenger ikke det for den bruker ikke len, så den vil ikke være utenfor rutenettet
#Når det er len så vil det telle en for mye, derfor må ha -1

#Den under og over funker (måtte sjekke litt forskjellig for hadde en feil et sted da jeg kjørte hovedprogram)
#Lar den være for å kunne se to forskjellige løsninger på samme

        # if rad < 0 or rad >= self._ant_rader:
        #     return None
        # elif kol < 0 or kol >= self._ant_kolonner:
        #     return None
        # else:
        #     return self._rutenett[rad][kol]


    def tegn_rutenett(self):
        for rad in range(len(self._rutenett)): #Her finner jeg raden, eks: Hvis den har 10 lister - vil den gå fra 0-9
            for kol in range(len(self._rutenett[rad])): #Her finner jeg kolonnen
                print(self._rutenett[rad][kol].hent_status_tegn(), end= " ") #Her må jeg gå inn i rutenettet å hente cellen - se hent status tegn
            print("") #Dette er linjeskift


    def _sett_naboer(self, rad, kol): #Kaller på metoder som skal oppdatere listene, kall på legg_til_nabo, appende cellene rundt en delle til naboer, HENT CELLEN OG LEGG TIL NABO
        celle = self.hent_celle(rad,kol) #Her er cellen som skal sjekkes naboene til
        for rad_indeks in range (-1,2): #fra og med -1, til og med 1
            for kol_indeks in range (-1,2):
                if (rad + rad_indeks, kol + kol_indeks) != (rad, kol): #Her sjekker jeg om det er den samme cellen
                    if self.hent_celle(rad + rad_indeks, kol + kol_indeks) != None: #Her sjekker jeg om den er ute av rutenettet
                        nabo_celle = self.hent_celle(rad + rad_indeks, kol + kol_indeks)
                        celle.legg_til_nabo(nabo_celle)


    def koble_celler(self):

        for rad in range(self._ant_rader): #Radene - finner kordinatene/indeksen til hvor jeg skal legge den til
            for kol in range(self._ant_kolonner): #Kolonner
                self._sett_naboer(rad,kol) #Her legger jeg til cellen i sett_nabo i forhold til kordinatene/indeksene

    def hent_alle_celler(self):
        liste_med_alle_cellene = []
        for rad in self._rutenett: #Går gjennom hele rutenettet for å legge til alle cellene som er der
            for kol in rad: #Kolonner
                liste_med_alle_cellene.append(kol)
        return liste_med_alle_cellene

    def antall_levende(self):
        levende_celler = 0
        for rad in self._rutenett:
            for kol in rad:
                if kol.hent_status() == "levende":
                    levende_celler += 1
        return levende_celler
