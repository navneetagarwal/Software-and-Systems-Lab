import numpy as np
from pylab import *
import sys
import matplotlib.patches as mpatches
import matplotlib.pyplot as plt
data = np.genfromtxt('data.csv',delimiter=',', dtype = float)

a = [row[0] for row in data]
b = [row[2] for row in data]

fig = plt.figure()
ax = fig.add_subplot(111, axisbg = 'w')
ax.plot(a,b,'g',lw=1.3,label = 'time')
ax.set_title("Time v/s n plot")    
ax.set_xlabel('n')
ax.set_ylabel('Time')
legend = ax.legend(loc='upper center')
plt.show()