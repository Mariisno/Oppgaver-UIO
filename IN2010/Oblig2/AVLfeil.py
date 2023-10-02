class AVL:

    class Node:
        def __init__(self, element):
            self.element = element
            self.left = None
            self.right = None
            self.height = None  # For AVL-trær

    def __init__(self):
        self.s = 0
        self.root = None

    def contains(self, x):  # Er x med i mengden?
        if self.root == None:
            return False
        if self.root.element == x:
            return True
        if x < self.root.element:
            return self.contains(x)
        if x > self.root.element:
            return self.contains(x)

    def insert(self, x):
        # Her fikses det "nye" treet etter insetting:
        self.root = self._insert(self.root, x)
        self.s += 1

    # Her fikser vi piler osv:
    def _insert(self, node, x):  # sette x inn i mengden (uten duplikater)
        if node is None:
            return self.Node(x)
        elif x < node.element:
            node.left = self._insert(node.left, x)
        elif x > node.element:
            node.right = self._insert(node.right, x)
        #Kode for at det blir AVL tre:
        self.SetHeight(node)
        return self.Balance(node) #Retunerer balansert node og ikke bare node
        #return node

    def FindMin(self):
        while self.root is not None:
            self.root = self.root.left
        return

    def remove(self, x):  # fjerner x fra mengden
        if self.root is None:
            return None
        if x < self.root.element:
            self.root.left = self.remove(x)
        if x > self.root.element:
            self.root.right = self.remove(x)
        if self.root.left == None:
            return self.root.right
        if self.root.right == None:
            return self.root.left
        u = self.FindMin(self.root.right)
        self.root.element = u.element
        self.root.right = self.remove(u.element)

        #AVL-greier:
        self.SetHeight(self.root)
        return self.Balance(self.root) #Må balansere den først

    def size(self):  # Gir antall elementer i mengden
        return self.s

    # Hverken rekkefølge eller antall forekomster spiller noen rolle i mengde.
    # Ved fjerning av et element som ikke er i mengden skal mengden forbli uforandret

    # Metoder for AVL-trær:
    def Height(self, node):
        if node is None:
            return -1
        else:
            node.height

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

    def RightRotate(self, node):
        nyRot = node.left
        blad = nyRot.right

        nyRot.right = node
        node.left = blad

        self.SetHeight(node)
        self.SetHeight(nyRot)
    
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
            if self.BalanceFactor(node) > 0:
                node.right = self.RightRotate(node.right)
            return self.LeftRotate(node)
        if self.BalanceFactor(node) < 1:
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
