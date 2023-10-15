#Algoritme 1: Sortert fletting av to arrayer
#Input: To sorterte arrayer A og B, og et array C som skal inneholde alle elementene i A og B
#Output: Et sortert array C som inneholder alle elementene i A og B

def Merge(A, B, C):
    i = 0
    j = 0
    while i < len(A) and j < len(B):
        if A[i] <= B[j]:
            C[i + j] = A[i]
            i = i + 1
        else:
            C[i + j] = B[j]
            j = j + 1
    while i < len(A):
        C[i + j] = A[i]
        i = i + 1
    while j < len(B):
        C[i + j] = B[j]
        j = j + 1
    return C

#Algoritme 2: Sortert fletting av k arrayer
#Input: Et array med k sorterte arrayer
#Output: Et sortert array som inneholder alle elementene i de k arrayene 
def MergeK(A):
    if len(A) == 1:
        return A[0]
    else:
        #Her bruker jeg Merge fra algoritme 1
        return Merge(A[0], MergeK(A[1:]), [None] * (len(A[0]) + len(MergeK(A[1:]))))

test = [1, 3, 2, 5, 4, 7, 9]

print(MergeK(test))