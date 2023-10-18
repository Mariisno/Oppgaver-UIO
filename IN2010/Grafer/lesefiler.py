import AcMo
import ByggGrafOblig

# En skuespiller kan ha en tt-id som ikke forekommer i movies.tsv -> disse skal ignoreres

Actors = []
Movies = []


def lesFil(fil):
    with open(fil, 'r') as f:
        for inp in f:
            deler = inp.strip().split("\t")

            # Hvis det er actor
            if deler[0][0] == "n":
                nyActor = AcMo.Actor(str(deler[0]), str(deler[1]), (deler[2:]))
                Actors.append(nyActor)
            else:
                nyMovie = AcMo.Movies(
                    str(deler[0]), str(deler[1]), float(deler[2]))
                Movies.append(nyMovie)


lesFil('marvel_actors.tsv')
lesFil('marvel_movies.tsv')

# Funker til hit!

# AB er en kant og er to skuespillere som spiller i samme film

# Gå gjennom alle skuespillerne og sjekk om de spiller i samme film,
# hvis de gjør det så kobles de sammen


def sammeFil(movies, actors):
    kanter = []

    for i in range(len(actors)):
        teller = 0
        # Må sammenligne den første osv. med alle de andre
        while teller < len(actors):
            # Må sjekke om hentTT er liste ller ikke
            if type(actors[i].ttId) == list:
                # Sjekke om de spiller i samme film
                for tt in actors[i].ttId:
                    if tt in actors[teller].ttId and teller != i:
                        kanter.append(actors[i].Navn)
                        kanter.append(actors[teller].Navn)
                        # Legge til vekten
                        # Da lages en kant
                        for movie in movies:
                            if movie.ttID == tt:
                                kanter.append(movie.Rating)
            teller += 1
    return kanter


def lines(kanter):
    for i in range(len(kanter)):
        lines += kanter[i] + " " + kanter[i+1] + " " + kanter[i+2] + "\n"


print(sammeFil(Movies, Actors))

# G = ByggGraf.buildgraph(lines(sammeFil(Movies, Actors)))

# TegnGraf.drawgraph(G)
