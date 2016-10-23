import heapq
import math


def krustal_algorithm(nV, E):
    pass
def prim_algorithm(nV, E):
    cost=[math.inf]*nV
    cost[0]=[0]
    prev=[None]*nV
    pq=[cost[i] for i in range(nV)]
    heapq.heapify(pq)
    count=nV-1
    while count!=0:
        v=heapq.heappop(pq)
        for node in range(nV):
            if cost[node]>E[node,v[1]] and v[1]!=node:
                cost[node]=E[node,v[1]]
                prev(node)=v[1]
        count-=1
        pq=[cost[j] for j in range(nV) if prev[j]==None]
        heapq.heapify(pq)