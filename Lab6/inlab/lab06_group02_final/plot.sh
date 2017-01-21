#!/bin/bash

gnuplot<<- EOF
set terminal pngcairo  transparent enhanced font "arial,10" fontscale 1.0 size 500,    350 
set output 'boxWhisker.png'
set boxwidth 0.2 absolute
set title "Box-and-whisker plot with median bar, whiskerbars, and variable box width" 
set xrange[0:5]
set yrange[-5:500]

# Data columns: X Min 1stQuartile Median 3rdQuartile Max BoxWidth Titles

# set bars 4.0
set style fill empty
plot 'data.dat' using 1:3:2:6:5:7:xticlabels(8) with candlesticks title 'Quartiles' whiskerbars, \
  ''         using 1:4:4:4:4:7 with candlesticks lt -1 notitle
EOF