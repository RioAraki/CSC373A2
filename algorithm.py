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
def prim(E):
    nV = np.shape(E)[0]
    cost=[math.inf]*nV
    cost[0]=0
    visited=[False]*nV
    pq=[(cost[i],i) for i in range(nV)]
    heapq.heapify(pq)
    count=nV
    while count!=0:
        v=heapq.heappop(pq)
        visited[v[1]]=True
        
        
        for node in range(nV):
            if cost[node]>E[node,v[1]] and v[1]!=node and not visited[node]:
                cost[node]=E[node,v[1]]
                
        count-=1
        pq=[(cost[j],j) for j in range(nV) if not visited[j]]
        heapq.heapify(pq)
    return sum(cost)

    
if __name__=="__main__":
    nV=1000
    E=randomGraph(nV,d=3)
    print(prim_algorithm(nV, E))