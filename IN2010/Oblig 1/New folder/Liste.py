liste = []


def push_back(x):
    liste.append(x)


def push_front(x):
    liste.insert(0, x)


def push_middle(x):
    liste.insert(len(liste)+1//2, x)


def get(i):
    print(liste[i])


løkke = int(input())

teller = 0

while teller < løkke:
    inp = input()
    deler = inp.strip().split()
    if (deler[0] == "push_back"):
        liste.push_back(int(deler[1]))
    if (deler[0]) == "get":
        print(liste.get(int(deler[1])))
    if (deler[0]) == "push_front":
        liste.push_front(int(deler[1]))
    if (deler[0]) == "push_middle":
        liste.push_middle(int(deler[1]))

    teller += 1
