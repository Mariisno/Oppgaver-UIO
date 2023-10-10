from collections import defaultdict


def buildgraph(lines):
    V = set()
    E = defaultdict(set)
    W = dict()

    for line in lines.splitlines():
        u, v, weight = line.strip().split()

        V.add(u)
        V.add(v)

        E[u].add(v)
        E[v].add(u)

        W[(u, v)] = int(weight)
        W[(u, v)] = int(weight)
    return V, E, W


G = buildgraph(open("Graf.txt"))
