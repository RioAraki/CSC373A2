import numpy as np
import matplotlib.pyplot as plt
import timeit
from timeit import Timer
from scipy.spatial import distance
import heapq
import math

def randomGraph(nV,d=3):
    E = np.random.rand(nV, nV)
    E = E - np.diag(E.diagonal())
    E = (E + E.T) / 2      
    return np.around(E, decimals=d)


def circleGraph(nV, d=3):
    
    r = np.around(np.sqrt(np.random.rand(nV)), d)   
    alpha = 2 * np.pi * np.around(np.random.uniform(0,1,nV), d)
    X = r * np.cos(alpha)
    Y = r * np.sin(alpha)
        
    E = np.zeros((nV,nV))    
    for i in range(nV):
        for j in range(i,nV):
            E[i,j] = np.sqrt((X[i]-X[j])**2 + (Y[i]-Y[j])**2)
    return E


def krustal(nV, E):
    pass

def prim(E):
    nV = np.shape(E)[0]
    cost=[math.inf]*nV
    cost[0]=0
    visited=[False]*nV
    pq=[(cost[i],i) for i in range(nV)]
    heapq.heapify(pq)
    count=nV
    totalcost = 0
    while count!=0:
        v=heapq.heappop(pq)
        visited[v[1]]=True
        
        # added:
        totalcost += v[0]
        
        print (v)
        
        for node in range(nV):
            if cost[node]>E[node,v[1]] and v[1]!=node:
                cost[node]=E[node,v[1]]
                
        count-=1
        pq=[(cost[j],j) for j in range(nV) if not visited[j]]
        heapq.heapify(pq)
    return sum(cost), visited, totalcost

e = randomGraph(4,2)
print (prim(e))

#nV = 10000
#t = Timer(lambda: circleGraph(nV))
#print (t.timeit(number=1))
    