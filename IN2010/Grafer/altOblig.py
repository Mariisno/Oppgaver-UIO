import AcMo
from collections import defaultdict

def buildgraph(info):
    V = set()
    E = defaultdict(set)
    w = dict()

    for edge in info:
        u, v, weight = edge[0], edge[1], edge[2] 

        V.add(u)
        V.add(v)

        E[u].add(v)
        E[v].add(u)

        w[(u, v)] = float(weight)
        w[(v, u)] = float(weight)

    return V, E, w


# def drawgraph(G):
#     V, E, w = G
#     dot = graphviz.Graph()
#     seen_edges = set()

#     for u in V:
#         dot.node(u)

#         for v in E[u]:
#             if (v, u) in seen_edges:
#                 continue
#             seen_edges.add((u, v))
#             dot.edge(u, v, label=str(w[(u, v)]))

#     dot.render('graph', view=True)


# G = buildgraph(lines)
# drawgraph(G)


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
                    str(deler[0]), str(deler[1]), str(deler[2]))
                Movies.append(nyMovie)


lesFil('marvel_actors_liten.tsv')
lesFil('marvel_movies_liten.tsv')

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
            # Sjekke om de spiller i samme film
            for tt in actors[i].ttId:
                kant = []
                # Hvis den ikke er tom:
                if tt in actors[teller].ttId and teller != i:
                    kant.append(actors[i].Navn)
                    kant.append(actors[teller].Navn)
                    # Legge til vekten
                    # Da lages en kant
                    if kanter:
                        duplikat = False
                        sjekka = False
                        for k in kanter:
                            for movie in movies:
                                if movie.ttID == tt and not sjekka:
                                    kant.append(movie.Rating)
                                    sjekka = True
                            if len(kant) == 3:
                                if kant[0] in k and kant[1] in k and kant[2] in k:
                                    duplikat = True
                                    break
                        if not duplikat and len(kant) == 3:
                            kanter.append(kant)
                    if len(kanter) < 1:
                        for movie in movies:
                            if movie.ttID == tt:
                                kant.append(movie.Rating)
                                kanter.append(kant)
                                break
            teller += 1
    return kanter

kanter = sammeFil(Movies, Actors)

G = buildgraph(kanter)
