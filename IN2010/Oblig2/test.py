#Feil på size

class BST:
    class Node:
        def __init__(self, element):
            self.element = element
            self.left = None
            self.right = None

    def __init__(self):
        self.s = 0
        self.root = None

    def contains(self, x):
        current = self.root
        while current is not None:
            if x == current.element:
                return True
            elif x < current.element:
                current = current.left
            else:
                current = current.right
        return False

    def insert(self, x):
        if self.root is None:
            self.root = self.Node(x)
            self.s += 1
        else:
            self._insert(self.root, x)

    def _insert(self, node, x):
        if x < node.element:
            if node.left is None:
                node.left = self.Node(x)
                self.s += 1
            else:
                self._insert(node.left, x)
        elif x > node.element:
            if node.right is None:
                node.right = self.Node(x)
                self.s += 1
            else:
                self._insert(node.right, x)

    def find_min(self, node):
        while node.left is not None:
            node = node.left
        return node

    def remove(self, x):
        self.root = self._remove(self.root, x)

    def _remove(self, node, x):
        if node is None:
            return node

        if x < node.element:
            node.left = self._remove(node.left, x)
        elif x > node.element:
            node.right = self._remove(node.right, x)
        else:
            if node.left is None:
                self.s -= 1
                return node.right
            elif node.right is None:
                self.s -= 1
                return node.left

            min_node = self.find_min(node.right)
            node.element = min_node.element
            node.right = self._remove(node.right, min_node.element)
        return node

    def size(self):
        return self.s

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
