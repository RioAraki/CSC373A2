import heapq
import math
import numpy as np
import matplotlib.pyplot as plt

def randomGraph(nV,d=3):
    E = np.around(np.random.rand(nV, nV), decimals=d)
    E = E - np.diag(E.diagonal())
    E = (E + E.T) / 2      
    return E


def krustal_algorithm(nV, E):
    pass
def prim_algorithm(nV, E):
    cost=[math.inf]*nV
    cost[0]=0
    prev=[None]*nV
    pq=[(cost[i],i) for i in range(nV)]
    heapq.heapify(pq)
    count=nV-1
    while count!=0:
        v=heapq.heappop(pq)
        for node in range(nV):
            if cost[node]>E[node,v[1]] and v[1]!=node:
                cost[node]=E[node,v[1]]
                prev[node]=v[1]
        count-=1
        pq=[(cost[j],j) for j in range(nV) if prev[j]==None]
        heapq.heapify(pq)
    return sum(cost)
    
if __name__=="__main__":
    nV=10
    E=randomGraph(nV,d=3)
    print(prim_algorithm(nV, E))