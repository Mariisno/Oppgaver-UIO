class AVL:

    class Node:
        def __init__(self, element):
            self.element = element
            self.left = None
            self.right = None
            self.height = 0  # For AVL-trær

    def __init__(self):
        self.s = 0
        self.root = None

    #Contains OK

    def contains(self, x):
        return self._contains(self.root, x)

    def _contains(self, node, x):
        if node is None:
            return False
        if x == node.element:
            return True
        elif x < node.element:
            return self._contains(node.left, x)
        else:
            return self._contains(node.right, x)

    #INSERT OK        

    def insert(self, x):
        #Her fikses det "nye" treet etter insetting:
        self.root  = self._insert(self.root, x)

    #Her fikser vi piler osv:
    def _insert (self, node, x): #sette x inn i mengden (uten duplikater)
        if node is None: #Om treet er tomt
            self.s += 1
            node = self.Node(x)
        elif x < node.element:
            node.left = self._insert(node.left,x)
        elif x > node.element:
            node.right = self._insert(node.right,x)
        #Kode for at det blir AVL tre:
        node.height = 1 + max(self.Height(node.left), self.Height(node.right))
        return self.Balance(node) #Retunerer balansert node og ikke bare node
        #return node

    def FindMin(self, node):
        while node.left is not None:
            node = node.left
        return node
    
    def remove (self, x):
        self.root = self._remove(self.root, x)

    def _remove (self, node, x): #fjerner x fra mengden
        #Dette skjer om elementet som skal fjernes ikke er i mengden
        if node is None:
            return None
        
        #Sjekker om elementet skal fjernes er mindre enn elementet i gjeldende node
        #Rekursivt beveger vi oss nedover til venstre i treet
        if x < node.element:
            node.left = self._remove(node.left, x)

        #Sjekker om elementene som skal fjernes er større enn elementet i gjeldende node
        #Rekursivt beveger vi oss nedover til høyre i treet
        elif x > node.element:
            node.right = self._remove(node.right, x)
        
        #Når vi har funnet elementet som skal fjernes:
        else:
            #Hvis gjeldende node ikke har noen barn
            #Så erstattes den med sitt høyre barn 
            if node.left is None:
                self.s -= 1
                return node.right
            
            #Hvis gjeldende node ikke har noen barn
            #Så erstattes den med sitt venstre barn
            elif node.right is None:
                self.s -= 1
                return node.left
            
            #Hvis gjeldende node har to barn
            else:
                #Finner det minste elementet i høyre subtre
                u = self.FindMin(node.right)

                #Erstatter gjeldende node med det minste elementet i høyre subtre
                node.element = u.element
                
                #Rekusivt fjern etterfølgeren fra høyre subtre
                node.right = self._remove(node.right, u.element)

        #AVL-greier:
        #oppdaterer høyden til noden
        node.height = 1+max(self.Height(node.left), self.Height(node.right))
        #balanserer treet for å opprettholde egenskapene til et AVL-tre
        return self.Balance(node) #Må balansere den først

    def size(self):  # Gir antall elementer i mengden
        return self.s

    # Hverken rekkefølge eller antall forekomster spiller noen rolle i mengde.
    # Ved fjerning av et element som ikke er i mengden skal mengden forbli uforandret

    # Metoder for AVL-trær:
    def Height(self, node):
        if node is None:
            return -1
        return node.height

    def SetHeight(self, node):
        if node is None:
            return
        else:
            node.height = 1+max(self.Height(node.left), self.Height(node.right))
    
    #Roteringer:
    def LeftRotate(self, node):
        nyRot = node.right
        blad = nyRot.left
        
        nyRot.left = node
        node.right = blad

        self.SetHeight(node)
        self.SetHeight(nyRot)
        return nyRot

    def RightRotate(self, node):
        nyRot = node.left
        blad = nyRot.right

        nyRot.right = node
        node.left = blad

        self.SetHeight(node)
        self.SetHeight(nyRot)
        return nyRot
    
    #Balansefaktor, må ha det for å sjekke hvor venstre- eller høyretungt v er
    #0 betyr at v er balansert
    #Positiv tall betyr at treet er venstretungt
    #Et negativt tall betyr at treet er høyretungt
    #v er en node
    def BalanceFactor(self, node):
        if node is None:
            return 0 #DEN ER BALANSERT
        return self.Height(node.left) - self.Height(node.right)
    
    #Balansering:
    def Balance(self, node):
        if self.BalanceFactor(node) < -1:
            if self.BalanceFactor(node.right) > 0:
                node.right = self.RightRotate(node.right)
            return self.LeftRotate(node)
        elif self.BalanceFactor(node) > 1:
            if self.BalanceFactor(node.left) < 0:
                node.left = self.LeftRotate(node.left)
            return self.RightRotate(node)
        return node

# Input:

set_bst = AVL()
n = int(input())
for _ in range(n):
    operation = input().split()
    if operation[0] == "contains":
        value = int(operation[1])
        result = set_bst.contains(value)
        print(result)
    elif operation[0] == "insert":
        value = int(operation[1])
        set_bst.insert(value)
    elif operation[0] == "remove":
        value = int(operation[1])
        set_bst.remove(value)
    elif operation[0] == "size":
        size = set_bst.size()
        print(size)
