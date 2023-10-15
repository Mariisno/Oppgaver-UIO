import AcMo
import TegnGraf

# En skuespiller kan ha en tt-id som ikke forekommer i movies.tsv -> disse skal ignoreres

Actors = {}
Movies = {}


def lesFil(fil):
    with open(fil, 'r') as f:
        for inp in f:
            deler = inp.strip().split("\t")

            # Hvis det er actor
            if deler[0][0] == "n":
                nyActor = AcMo.Actor(str(deler[0]), str(deler[1]), (deler[2:]))
                Actors[deler[0]] = nyActor
            else:
                nyMovie = AcMo.Movies(
                    str(deler[0]), str(deler[1]), float(deler[2]))
                Movies[deler[0]] = nyMovie


lesFil('marvel_actors.tsv')
lesFil('marvel_movies.tsv')

print(Movies)

#Funker til hit!

lines = f""

#AB er en kant og er to skuespillere som spiller i samme film

#Gå gjennom alle skuespillerne og sjekk om de spiller i samme film, 
#hvis de gjør det så kobles de sammen

def sammeFil(skuespillerA, skuespillerB):
    kanter = []
    for ttB in skuespillerA.hentTT:
        for ttA in skuespillerB.hentTT:
            if ttB == ttA:
                
                #Da lages en kant


            

#Skuespiller:
A = 
#Skuespiller
B = 
#Vekt -> rating
V = 

TegnGraf.buildgraph(lines)