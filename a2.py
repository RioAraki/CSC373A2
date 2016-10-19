import numpy as np
import matplotlib.pyplot as plt
import timeit
from timeit import Timer

def randomGraph(nV,d=3):
    E = np.around(np.random.rand(nV, nV), decimals=d)
    E = E - np.diag(E.diagonal())
    E = (E + E.T) / 2      
    return E


def circleGraph(nV, d=3):
    
    r = np.around(np.sqrt(np.random.rand(nV)), d)   
    alpha = 2 * np.pi * np.around(np.random.uniform(0,1,nV), d)
    X = r * np.cos(alpha)
    Y = r * np.sin(alpha)
    
    #if show:
        #plt.plot(X, Y, 'ro')
        #plt.axis([-1, 1, -1, 1])
        #plt.show()
        
    E = np.zeros((nV,nV))    
    for i in range(nV):
        for j in range(i,nV):
            if i != j:
                E[i,j] = E[j,i] = np.sqrt((X[i]-X[j])**2 + (Y[i]-Y[j])**2)
                
    return E

nV = 10000
t = Timer(lambda: circleGraph(nV))
print (t.timeit(number=1))
    
