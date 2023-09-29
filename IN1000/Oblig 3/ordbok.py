#2.1 her har jeg en ordbok med pris og varer, som jeg printer ut:
prisvarer = {"melk":14.90, "brød":24.90, "yoghurt":12.90, "pizza":39.90} #Ordbok med varer og pris

print (prisvarer) #Her skrives ut innholdet

#2.2, her spør jeg bruker om å legge inn to varer og pris inn i ordboka:
def ny (): #Lager prosedyre så jeg ikke trenger å skrive det flere ganger
    bruker = input ("Hva liker du å kjøpe på butikken? \n")
    pris = int(input ("Hva koster det? \n"))
    prisvarer [bruker] = pris #Her legges det inn i ordboka
ny()
ny()

print (prisvarer)
