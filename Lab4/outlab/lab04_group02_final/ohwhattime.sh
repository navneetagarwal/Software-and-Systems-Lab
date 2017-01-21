#!/bin/bash
suffix1=_$(date +%m) 
suffix2=_$(date +%d)
suffix3=_$(date +%k)
suffix4=:$(date +%M)
#Traverse all matching files in directory.

# It's great for creating "unique and random" temp filenames,
#+ even better than usingda
for f in * ; do 
cp -a "$f" "$f$suffix1$suffix2$suffix3$suffix4"
done

#m: month number
#h: month code
#d: date 
#k: hour
#l: hour in pm
#p: AM or PM
#u : donno


