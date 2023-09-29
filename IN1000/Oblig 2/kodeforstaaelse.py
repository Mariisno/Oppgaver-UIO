"""
1.  Starten av programet, altså "a = input ("Tast inn et helt tall!")" vil kjøre.
    Deretter når bruker skriver inn et tall vil man få Error - TypeError

2.  Problemet med programmet er på "print (b + "Hei!")"
    Her prøver man å plusse b, som er en int(heltall) med "Hei", hvor "Hei" er en str (streng)
    noe som ikke er mulig å gjøre i python. Altså man kan ikke addere to ulike typer datatyper i python.
"""

a = input("Tast inn et heltall! ")
b = int(a)
if b < 10:
    print (b + "Hei!")
