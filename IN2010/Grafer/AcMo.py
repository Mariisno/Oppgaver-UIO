class Actor:

    # ttId er en liste
    # Actor er nodene
    def __init__(self, nmID, Navn, ttId):
        self.nmID = nmID
        self.Navn = Navn
        self.ttId = ttId  # liste

    def __str__(self):
        return self.Navn


class Movies:

    # Ignorer antStemmer
    # Rating er vekten til grafen
    # Movies er kant
    def __init__(self, ttID, Tittel, Rating):
        self.ttID = ttID
        self.Tittel = Tittel
        self.Rating = Rating

    def __str__(self):
        return self.Tittel
