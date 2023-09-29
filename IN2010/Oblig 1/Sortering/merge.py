from countswaps import CountSwaps


def sort(A):
    # Do merge sort here. Use the Sorter's comparison- and swap
    # methods for automatically counting the swaps and comparisons.
    # Use A.swap(i, j) to swap the values at two indices i and j. The swap is
    # counted, when using this method. Comparisons are counted automatically.

    def Merge(A1, A2, A):
        i = 0
        j = 0

        while i < len(A1) and j < len(A2):
            # Inni her er mergeswap
            if A1[i] <= A2[j]:
                A[i + j] = A1[i]
                i = i + 1

            else:
                A[i + j] = A2[j]
                j = j + 1
            A.mergeSwap()

        while i < len(A1):
            A[i + j] = A1[i]
            i = i + 1
        while j < len(A2):
            A[i + j] = A2[j]
            j = j + 1
        # Her setter jeg sammen swapsa i mergeSwaps som skjer over, altså A1 og A2
        A.mergemerge(A1.swaps)
        A.mergemerge(A2.swaps)
        return A

    def MergeSort(A):
        if len(A) <= 1:
            return A
        i = len(A) // 2
        # Gjør om listene under til Swaps
        # Dette gjøres for A og insertion-sort i sort_runner, men må også gjøres for A1 og A2
        A1 = MergeSort(CountSwaps(A[0:i]))
        A2 = MergeSort(CountSwaps(A[i:]))
        return Merge(A1, A2, A)

    return MergeSort(A)