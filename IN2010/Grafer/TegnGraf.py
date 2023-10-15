import graphviz
from collections import defaultdict

import os
os.environ["PATH"] += os.pathsep + "C:/Program Files/Graphviz/bin/"


# lines = "A B 13\nA C 6\nB C 7\nB D 1\nC D 14\nC E 8\nC H 20\nD E 9\nD F 3\nE F 2\nE J 18\nG H 15\nG I 5\nG J 19\nG K 10\nH J 17\nI K 11\nJ K 16\nJ L 4\nK L 12"


def buildgraph(lines):
    V = set()
    E = defaultdict(set)
    w = dict()

    for line in lines.splitlines():
        u, v, weight = line.strip().split()

        V.add(u)
        V.add(v)

        E[u].add(v)
        E[v].add(u)

        w[(u, v)] = int(weight)
        w[(v, u)] = int(weight)

    return V, E, w


def drawgraph(G):
    V, E, w = G
    dot = graphviz.Graph()
    seen_edges = set()

    for u in V:
        dot.node(u)

        for v in E[u]:
            if (v, u) in seen_edges:
                continue
            seen_edges.add((u, v))
            dot.edge(u, v, label=str(w[(u, v)]))

    dot.render('graph', view=True)


# G = buildgraph(lines)
# drawgraph(G)
