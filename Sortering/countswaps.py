class CountSwaps(list):
    swaps = 0

    def swap(self, i, j):
        self.swaps += 1
        self[i], self[j] = self[j], self[i]

    # Har ikke med swap inni her
    def mergeSwap(self):
        self.swaps += 1

    # Her merger jeg swapsa fra de indre swapsene
    def mergemerge(self, x):
        self.swaps += x

    def get(self):
        return self.swaps
