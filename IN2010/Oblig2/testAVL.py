class AVL:

    class Node:
        def __init__(self, element):
            self.element = element
            self.left = None
            self.right = None
            self.height = 1  # For AVL-trees, initially set to 1

    def __init__(self):
        self.s = 0
        self.root = None

    def contains(self, x):  # Is x in the set?
        return self._contains(self.root, x)

    def _contains(self, node, x):
        if node is None:
            return False
        if x == node.element:
            return True
        if x < node.element:
            return self._contains(node.left, x)
        if x > node.element:
            return self._contains(node.right, x)

    def insert(self, x):
        # Here we fix the "new" tree after insertion:
        self.root = self._insert(self.root, x)
        self.s += 1

    def _insert(self, node, x):
        if node is None:
            return self.Node(x)
        elif x < node.element:
            node.left = self._insert(node.left, x)
        elif x > node.element:
            node.right = self._insert(node.right, x)

        # Update height
        node.height = 1 + max(self._get_height(node.left), self._get_height(node.right))

        # Check and balance
        balance = self._get_balance(node)

        # Left-Left Case
        if balance > 1 and x < node.left.element:
            return self._rotate_right(node)

        # Right-Right Case
        if balance < -1 and x > node.right.element:
            return self._rotate_left(node)

        # Left-Right Case
        if balance > 1 and x > node.left.element:
            node.left = self._rotate_left(node.left)
            return self._rotate_right(node)

        # Right-Left Case
        if balance < -1 and x < node.right.element:
            node.right = self._rotate_right(node.right)
            return self._rotate_left(node)

        return node

    def remove(self, x):
        self.root = self._remove(self.root, x)
        self.s -= 1

    def _remove(self, node, x):
        if node is None:
            return node

        if x < node.element:
            node.left = self._remove(node.left, x)
        elif x > node.element:
            node.right = self._remove(node.right, x)
        else:
            if node.left is None:
                return node.right
            if node.right is None:
                return node.left

            min_node = self._get_min_node(node.right)
            node.element = min_node.element
            node.right = self._remove(node.right, min_node.element)

        # Update height
        node.height = 1 + max(self._get_height(node.left), self._get_height(node.right))

        # Check and balance
        balance = self._get_balance(node)

        # Left-Left Case
        if balance > 1 and self._get_balance(node.left) >= 0:
            return self._rotate_right(node)

        # Right-Right Case
        if balance < -1 and self._get_balance(node.right) <= 0:
            return self._rotate_left(node)

        # Left-Right Case
        if balance > 1 and self._get_balance(node.left) < 0:
            node.left = self._rotate_left(node.left)
            return self._rotate_right(node)

        # Right-Left Case
        if balance < -1 and self._get_balance(node.right) > 0:
            node.right = self._rotate_right(node.right)
            return self._rotate_left(node)

        return node

    def size(self):
        return self.s

    def _get_height(self, node):
        if node is None:
            return 0
        return node.height

    def _get_balance(self, node):
        if node is None:
            return 0
        return self._get_height(node.left) - self._get_height(node.right)

    def _rotate_left(self, z):
        y = z.right
        T2 = y.left

        y.left = z
        z.right = T2

        z.height = 1 + max(self._get_height(z.left), self._get_height(z.right))
        y.height = 1 + max(self._get_height(y.left), self._get_height(y.right))

        return y

    def _rotate_right(self, y):
        x = y.left
        T2 = x.right

        x.right = y
        y.left = T2

        y.height = 1 + max(self._get_height(y.left), self._get_height(y.right))
        x.height = 1 + max(self._get_height(x.left), self._get_height(x.right))

        return x

    def _get_min_node(self, node):
        while node.left is not None:
            node = node.left
        return node
