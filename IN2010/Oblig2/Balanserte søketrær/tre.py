def tre(liste):
    if liste:  # Sjekker om den er tom
        midten = len(liste)//2
        if len(liste[midten:]) < 2:
            print(liste.pop(1))
            print(liste.pop(0))
            return
        else:
            print(liste.pop(midten))

        tre(liste[midten:])
        tre(liste[:midten])


liste = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

tre(liste)
