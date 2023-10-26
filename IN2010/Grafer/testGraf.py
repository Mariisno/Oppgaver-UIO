from heapq import heappush, heappop
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
# drawgraph(G)


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


bfs(G, "A")


def bfs_shortest_paths_from(G, s):
    _, E, _ = G
    parents = {s: None}  # s har ingen forelder
    queue = deque([s])
    while queue:
        u = queue.popleft()
        for v in E[u]:  # Sjekker naboene til v
            if v not in parents:  # Hvis v ikke har en forelder legges den til
                parents[v] = u  # Da blir v forelderen til u
                queue.append(v)
    return parents


def draw_parents(parents):
    dot = graphviz.Graph()
    for u in parents:
        v = parents[u]
        if v:
            dot.edge(v, u)
    dot.render('bfs_spanningtree', format='svg')


draw_parents(bfs_shortest_paths_from(G, 'A'))


def bfs_shortest_path_between(G, s, t):
    parents = bfs_shortest_paths_from(G, s)
    v = t
    path = []

    if t not in parents:
        return path

    while v:
        path.append(v)
        v = parents[v]

    return path[::-1]


bfs_shortest_path_between(G, 'A', 'G')


def bfs_all_shortest_paths(G, s):
    V, _, _ = G
    parents = bfs_shortest_paths_from(G, s)
    paths = []

    for v in V:
        path = []
        while v:
            path.append(v)
            v = parents[v]
        paths.append(path[::-1])
    return paths


sorted(bfs_all_shortest_paths(G, 'A'))


def dijkstra(G, s):
    V, E, w = G
    queue = [(0, s)]
    dist = defaultdict(lambda: float('inf'))
    dist[s] = 0

    while queue:
        cost, u = heappop(queue)
        if cost != dist[u]:
            continue
        for v in E[u]:
            c = cost + w[(u, v)]
            if c < dist[v]:
                dist[v] = c
                heappush(queue, (c, v))
    return dist


dist = dijkstra(G, 'A')
print(list(zip(*sorted(dist.items()))))


def shortest_paths_from(G, s):
    V, E, w = G
    queue = [(0, s)]
    dist = defaultdict(lambda: float('inf'))
    parents = {s: None}
    dist[s] = 0

    while queue:
        cost, u = heappop(queue)
        if cost != dist[u]:
            continue
        for v in E[u]:
            c = cost + w[(u, v)]
            if c < dist[v]:
                dist[v] = c
                heappush(queue, (c, v))
                parents[v] = u

    return parents


def draw_parents_weighted(G, parents, name):
    V, _, w = G
    dot = graphviz.Graph()
    for u in parents:
        v = parents[u]
        if v:
            dot.edge(u, v, label=str(w[(u, v)]))
    dot.render(name, format='svg')


draw_parents_weighted(G, shortest_paths_from(G, 'A'), 'dijkstra_spanningtree')
