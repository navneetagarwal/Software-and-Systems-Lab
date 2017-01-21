set terminal png
set output 'plot.png'

splot "output.dat" using 1:2:3 with lines, \
	  "input.dat" using 1:2:3 with lines
	
