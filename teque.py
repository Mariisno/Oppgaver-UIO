class teque:

    def __init__(self):
        self.A = []

    def push_back(self, x):
        self.A[len(self.A)+1] = x
        return self.A

    def push_front(self, x):
        for i in range(0, len(self.A)):
            self.A[i + 1] = self.A[i]
        self.A[0] = x
        return self.A

    def push_middle(self, x):
        m = (len(self.A) + 1) % 2
        for i in (range(m, len(self.A))):
            self.A[i+1] = self.A[i]
        self.A[m] = x
        return self.A

    def get(self, i):
        return self.A[i]


liste = teque()

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
