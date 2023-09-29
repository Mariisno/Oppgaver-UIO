"""
Dette programmet konverterer fahrenheit til celsius.

"""

"""
#Dette er første del, før programmet modifiseres:
fahrenheit = 100
print ("fahrenheit: ", 100)

celsius = ((100)-32)*5/9
print ("celsius: ", celsius)
"""

#Skriver float istedenfor int, for da kan bruker skrive inn desimaltall:
F = float(input("Skriv inn hvor varmt det er i Fahrenheit: \n")) #Her bes brukes om å skrive inn tremperaturen i tall


C = ((F)-32)*5/9 #Dette er formelen for å regne fra fahrenheit til celsius
print ("Celsius:", C) #Her vil tremperaturen som bruker skrev over i fahrenheit vises i celsius
