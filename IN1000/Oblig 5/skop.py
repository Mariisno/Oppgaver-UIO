def minFunksjon():
    for x in range(2):
        c = 2
        print(c) #Denne vil bli printa ut som 2
        c += 1
        b = 10
        b += a #a finnes ikke her og b vil derfor ikke funke
        print(b)
    return(b)
def hovedprogram():
    a = 42
    b = 0
    print(b) #Denne vil bli printa ut som 0
    b = a
    a = minFunksjon() #a vil ikke finnes for minFunksjon retunerer b som ikke finnes
    print (b)
    print (a)

hovedprogram()

"""
Først defineres funksjonen minFunksjon, den tar ikke imot noen parametere. Deretter
defineres prosedyren hovedprogram, som heller ikke har noe parameter. Så kalles hovedprogram.
Innni hovedprogram er det to variabler a og b. Først er a=42 og b=0. Deretter blir b=a, altså b=0
Så blir a til a=minFunksjon(). Problemmet her er at inni minFunksjon så står det b += a og a finnes ikke inni minFunksjon.
Da vil altså b ikke være noe for a er ikke definert, og det vil ikke gå an å retunere b.
Altså vil a i hovedprogram ikke finnes for minFunksjon vil ikke kunne retunere b.

"""
