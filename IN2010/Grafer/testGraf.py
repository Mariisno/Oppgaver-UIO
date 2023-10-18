import graphviz
from collections import defaultdict
from collections import deque

import os
os.environ["PATH"] += os.pathsep + "C:/Program Files/Graphviz/bin/"


lines = "A B 13\nA C 6\nB C 7\nB D 1\nC D 14\nC E 8\nC H 20\nD E 9\nD F 3\nE F 2\nE J 18\nG H 15\nG I 5\nG J 19\nG K 10\nH J 17\nI K 11\nJ K 16\nJ L 4\nK L 12"


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


G = buildgraph(lines)
drawgraph(G)


# G er graf, s er startnode, result er alle nodene
def dfs_rec(G, s, visited, result):
    _, E, _ = G
    result.append(s)
    visited.add(s)
    for v in E[s]:  # E[s] viser alle naboene til s
        if v not in visited:
            dfs_rec(G, v, visited, result)
    return result


dfs_rec(G, 'A', set(), [])

# eksplisitt stack -> ikke rekursiv


def dfs(G, s):
    _, E, _ = G
    visited = set()  # De som er besøkt
    stack = [s]  # Stack for naboer
    result = []  # Alle nodene som er gått igjennom
    while stack:  # Mens stacken ikke er tom:
        u = stack.pop()  # Tar vekk det øverste elementet, u = det som blir popa
        if u not in visited:  # Sjekker om u er i visited
            result.append(u)  # Legger til u i resultat
            visited.add(u)  # Legges til i visited
            for v in E[u]:  # Sjekker alle naboene til u
                stack.append(v)  # Legger til naboene, v, i stack
    return result


dfs(G, "A")


def bfs(G, s):
    _, E, _ = G
    result = []
    queue = deque([s])  # Her legges inn naboene
    visited = set([s])  # Visited er set og legger til s

    while queue:  # Mens queue ikke er tom
        u = queue.popleft()  # u blir det første elementet på queue, og dette fjernes
        result.append(u)
        for v in E[u]:  # Går gjennom alle naboene til v
            if v not in visited:
                visited.add(v)
                queue.append(v)  # Legger den til kø-en
    return result


print(bfs(G, "A"))
