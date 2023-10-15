import graphviz

dot = graphviz.Digraph()
dot.node('A', 'Node A')
dot.node('B', 'Node B')
dot.edge('A', 'B', 'Edge 1')
dot.edge('B', 'A', 'Edge 2')

dot.render("graph", view=True)
