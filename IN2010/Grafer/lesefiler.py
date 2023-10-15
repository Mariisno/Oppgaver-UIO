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

# Funker til hit!

# AB er en kant og er to skuespillere som spiller i samme film

# Gå gjennom alle skuespillerne og sjekk om de spiller i samme film,
# hvis de gjør det så kobles de sammen


def sammeFil(movies, actors):
    kanter = []
    for i in range(len(actors)):
        for ttB in actors[i].hentTT:
            for ttA in actors[i+1].hentTT:
                if ttB == ttA:
                    kanter.append(actors[i].navn)
                    kanter.append(actors[i+1].navn)
                    # Legge til vekten
                    # Da lages en kant
                    for movie in movies:
                        if movie.ttID == ttA:
                            kanter.append(movie.Rating)
    return kanter


def lines(kanter):
    for i in range(len(kanter)):
        lines += kanter[i] + " " + kanter[i+1] + " " + kanter[i+2] + "\n"


G = TegnGraf.buildgraph(lines(sammeFil(Movies, Actors)))

TegnGraf.drawgraph(G)
