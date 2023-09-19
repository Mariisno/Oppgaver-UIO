def insertionSort(A):
    for i in (range(1, len(A))):
        j = i
        while j > 0 and A[j-1] > A[j]:
            A[j-1], A[j] = A[j], A[j-1]

            j = j-1
    return A


def Merge(A1, A2, A):
    i = 0
    j = 0
    while i < len(A1) and j < len(A2):
        if A1[i] <= A2[j]:
            A[i + j] = A1[i]
            i = i + 1
        else:
            A[i + j] = A2[j]
            j = j + 1
    while i < len(A1):
        A[i + j] = A1[i]
        i = i + 1
    while j < len(A2):
        A[i + j] = A2[j]
        j = j + 1
    return A


def MergeSort(A):
    if len(A) <= 1:
        return A
    i = len(A) // 2
    A1 = MergeSort(A[0:i])
    A2 = MergeSort(A[i:])
    return Merge(A1, A2, A)


liste = [4, 1, 2, 3]
print(MergeSort(liste))
