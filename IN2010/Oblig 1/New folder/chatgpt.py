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
            self.midten = nyNode if self.storrelse % 2 == 1 else self.midten
        self.storrelse += 1

 

    def push_front(self, x):
        if self.forste is None:
            self.forste = self.Node(x)
            self.siste = self.forste
            self.midten = self.forste
        else:
            nyNode = self.Node(x)
            nyNode.neste = self.forste
            self.forste.forrige = nyNode
            self.forste = nyNode
            self.midten = nyNode if self.storrelse % 2 == 0 else self.midten
        self.storrelse += 1

 

    def push_middle(self, x):
        nyNode = self.Node(x)
        nyNode.forrige = self.midten
        nyNode.neste = self.midten.neste

 

        if self.midten.neste is not None:
            self.midten.neste.forrige = nyNode

 

        self.midten.neste = nyNode
        self.midten = nyNode

 

        self.storrelse += 1

 

    def get(self, i):
        if i < 0 or i >= self.storrelse:
            raise IndexError("Indeks utenfor gyldig rekkevidde")

 

        teller = 0
        temp = self.forste

 

        while teller < i:
            temp = temp.neste
            teller += 1

 

        return temp.element

 

liste = linkedlist()
liste.push_back(9)
liste.push_front(3)
liste.push_middle(5)
print(liste.get(0))
print(liste.get(1))
print(liste.get(2))
liste.push_middle(1)
print(liste.get(1))
print(liste.get(2))
print(liste.get(3))