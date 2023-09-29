# Merk: Her er ikke algoritmene som skrevet i oppgaveteksten implementert direkte
# da python gjoer grovarbeidet for oss.

list = []


def push_back(x):
    list.append(x)


def push_front(x):
    list.insert(0, x)


def push_middle(x):
    index = (len(list)+1) // 2
    list.insert(index, x)


def get(i):
    print(list[i])


n = int(input())

for i in range(n):
    inp, x = input().split()
    x = int(x)
    if inp == "push_back":
        push_back(x)
    elif inp == "push_front":
        push_front(x)
    elif inp == "push_middle":
        push_middle(x)
    elif inp == "get":
        get(x)
