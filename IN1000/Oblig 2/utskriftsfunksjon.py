"""
Først vil en bruker bli spurt om å skrive inn navn, så bosted.
Så vil programmet skrive ut "Hei, (Det bruker skrev inn på navn)! Du er fra (Det bruker skrev på bosted)"
Dette vil kjøres tre ganger.
"""

def hilsen (): #Her lages en funksjon
    navn = input ("Hva er ditt navn? \n") #Her skal brukes skrive inn navn
    sted = input ("Hvor bor du? \n") #Her skal brukes skrive inn en addresse/bosted

    print ("Hei, " + navn + "! " + "Du er fra " + sted) #Dette printes ut

#Her vil funksjonen som ble laget over kjøres tre ganger:
hilsen ()
hilsen ()
hilsen ()
