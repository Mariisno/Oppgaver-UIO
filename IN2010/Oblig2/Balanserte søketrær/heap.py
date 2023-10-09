from heapq import heappush, heappop


def balance(heap):
    balancedHeap = []
    if heap:  # Sjekker om den er tom
        midten = len(heap)//2

        if len(heap[midten:]) < 2:
            heappush(balancedHeap, heappop(heap))
            heappush(balancedHeap, heappop(heap))
            return heap
        else:
            heappush(balancedHeap, heappop(heap))

        heappush(balancedHeap, balance(heap[midten:]))
        heappush(balancedHeap, balance(heap[:midten]))


heap = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]


print(balance(heap))
