class Celle:
    # Konstruktør
    def __init__(self):
        self._status = "doed" #Når jeg lager cellen er den død
        self._naboer = []
        self._ant_levende_naboer = 0

    def sett_doed(self):
        self._status = "doed"

    def sett_levende(self):
        self._status = "levende"

    def legg_til_nabo(self, nabo): #Her legger nabo til
        self._naboer.append(nabo)

    def er_levende(self): #Returnerer True om den er levende
        return self._status == "levende"

    def hent_status(self): #DETTE GJORDE JEG, er egentlig bare pass her
        return self._status

    def hent_status_tegn(self):
        if self._status == "levende":
            return "O"
        if self._status == "doed":
            return "."

    def tell_levende_naboer(self):

        # for i in self._naboer:
        #     if i._status == "levende":
        #         self._ant_levende_naboer += 1

#Annen måte å gjøre det over på, den over funker ikke med oppdatert celle_test som er oppdatert
        levende_celler = []

        for celler in self._naboer:
            if celler.er_levende():
                levende_celler.append(celler)

        self._ant_levende_naboer = len(levende_celler)


#statusen til en celle basert på antall levende naboer
    def oppdater_status(self):
        if self.er_levende(): #kunne også ha skrevet self._status == "levende", men denne er kortere
            if self._ant_levende_naboer < 2:
                self.sett_doed()
            if self._ant_levende_naboer >= 2:
                self.sett_levende()
            if self._ant_levende_naboer > 3:
                self.sett_doed()

        if not self.er_levende(): #kunne også ha skrevet self._status == "doed", denne er kortere
            if self._ant_levende_naboer == 3:
                self.sett_levende()
