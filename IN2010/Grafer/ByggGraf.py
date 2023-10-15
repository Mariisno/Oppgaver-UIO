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


# lines = "A B 13\nA C 6\nB C 7\nB D 1\nC D 14\nC E 8\nC H 20\nD E 9\nD F 3\nE F 2\nE J 18\nG H 15\nG I 5\nG J 19\nG K 10\nH J 17\nI K 11\nJ K 16\nJ L 4\nK L 12"
# G = buildgraph(lines)
# print(G)
