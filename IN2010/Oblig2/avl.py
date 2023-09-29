#AVL-trær er like som BST, men i tillegg må de:
#For hver node i et avl-tre, så må høydeforskjellen på venstre og høyre subtre være mindre eller lik 1
#Skjer ved innsetting og sletting

class BST:

    class Node:
        def __init__ (self, element):
            self.element = element
            self.left = None
            self.right = None

    def __init__(self):
        self.s = 0
        self.root = None
    
    def contains (self, x): #Er x med i mengden?
        if self.root == None:
            return False
        if self.root.element == x:
            return True
        if x < self.root.element:
            return self.contains(x)
        if x > self.root.element:
            return self.contains(x)
        
    def insert(self, x):
        #Her fikses det "nye" treet etter insetting:
        self.root  = self._insert(self.root, x)
        self.s += 1


    #Her fikser vi piler osv:
    def _insert (self, node, x): #sette x inn i mengden (uten duplikater)
        if node is None:
            return self.Node(x)
        elif x < node.element:
            node.left = self._insert(node.left,x)
        elif x > node.element:
            node.right = self._insert(node.right,x)
        return node

    def FindMin(self):
        while self.root is not None:
            self.root = self.root.left
        return

    def remove (self, x): #fjerner x fra mengden
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
        return self.root

    def size (self): #Gir antall elementer i mengden
        return self.s

    #Hverken rekkefølge eller antall forekomster spiller noen rolle i mengde.
    #Ved fjerning av et element som ikke er i mengden skal mengden forbli uforandret

    #Input:
    

set_bst = BST()
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