class linkedlist:

    class Node:
        def __init__(self, x):
            self.element = x
            self.neste = None
            self.forrige = None

    def __init__(self):
        self.forste = None
        self.midten = None
        self.siste = None
        self.storrelse = 0

    # Endre midt hver gang jeg endrer push_back eller push_front

    # Sett element x inn bakerst i køen
    # Midten er den neste
    def push_back(self, x):
        if self.forste is None:
            self.forste = self.Node(x)
            self.siste = self.forste
            self.midten = self.forste
        else:
            nyNode = self.Node(x)
            self.siste.neste = nyNode
            nyNode.forrige = self.siste
            self.siste = nyNode
            if (self.storrelse % 2 == 1):  # Hvis den er 1 så er det oddetall
                self.midten = self.midten.neste
        self.storrelse += 1

    # Midten er den forrige
    def push_front(self, x):
        if self.forste is None:
            self.forste = self.Node(x)
            self.siste = self.forste
            self.midten = self.forste
        else:
            nyNode = self.Node(x)
            self.forste.forrige = nyNode
            nyNode.neste = self.forste
            self.forste = nyNode

            if (self.storrelse % 2 == 0):  # Hvis den er 0 så er det partall
                self.midten = self.midten.forrige
        self.storrelse += 1

    def push_middle(self, x):

        nyNode = self.Node(x)

        if self.forste is None:
            self.forste = nyNode
            self.siste = self.forste
            self.midten = self.forste

        else:

            if (self.storrelse % 2 == 0):  # Hvis den er 0 så er det partall

                nyNode.forrige = self.midten.forrige
                nyNode.neste = self.midten

                self.midten.forrige.neste = nyNode
                self.midten.forrige = nyNode
                self.midten = nyNode

            elif (self.storrelse % 2 == 1):  # Hvis den er 1 så er det oddetall
                nyNode.forrige = self.midten

                if (self.midten.neste is not None):
                    nyNode.neste = self.midten.neste
                    self.midten.neste.forrige = nyNode
                else:
                    self.siste = nyNode
                self.midten.neste = nyNode
                self.midten = nyNode

        self.storrelse += 1

    def get(self, i):
        if i < 0 or i >= self.storrelse:
            raise IndexError("Indeks utenfor gyldig rekkevidde")

        teller = 0
        temp = self.forste

        while (teller < i):
            temp = temp.neste
            teller += 1

        return temp.element


liste = linkedlist()

teller = 0

with open(0) as f:
    cnt = 0
    for inp in f:
        if cnt == 0:
            cnt += 1
            continue
        deler = inp.strip().split()
        if (deler[0] == "push_back"):
            liste.push_back(int(deler[1]))
        elif (deler[0]) == "get":
            print(liste.get(int(deler[1])))
        elif (deler[0]) == "push_front":
            liste.push_front(int(deler[1]))
        elif (deler[0]) == "push_middle":
            liste.push_middle(int(deler[1]))
        else:
            print("EH ?")
