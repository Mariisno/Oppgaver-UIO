class BST:

    class Node:
        def __init__ (self, element):
            self.element = element
            self.left = None
            self.right = None

    def __init__(self):
        self.s = 0
        self.root = None
    
    #Contains OK

    def contains (self, x):
        return self._contains(self.root, x)
    
    def _contains (self, node, x): #Er x med i mengden?
        if node is None:
            return False
        if node.element == x:
            return True
        if x < node.element:
            return self._contains(node.left, x)
        if x > node.element:
            return self._contains(node.right, x)

    #INSERT OK        

    def insert(self, x):
        #Her fikses det "nye" treet etter insetting:
        self.root  = self._insert(self.root, x)

    #Her fikser vi piler osv:
    def _insert (self, node, x): #sette x inn i mengden (uten duplikater)
        if node is None: #Om treet er tomt
            self.s += 1
            return self.Node(x)
        elif x < node.element:
            node.left = self._insert(node.left,x)
        elif x > node.element:
            node.right = self._insert(node.right,x)
        return node
    


    def FindMin(self, node):
        while node.left is not None:
            node = node.left
        return node
    
    def remove (self, x):
        self.root = self._remove(self.root, x)

    def _remove (self, node, x): #fjerner x fra mengden
        if node is None:
            return None
        if x < node.element:
            node.left = self._remove(node.left, x)
        elif x > node.element:
            node.right = self._remove(node.right, x)
        else:
            if node.left is None:
                self.s -= 1
                return node.right
            if node.right is None:
                self.s -= 1
                return node.left
            u = self.FindMin(node.right)
            node.element = u.element
            node.right = self._remove(node.right, u.element)
        return node

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