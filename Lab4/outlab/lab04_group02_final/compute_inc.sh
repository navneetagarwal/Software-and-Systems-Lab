#!/bin/bash
IFS=","
g=1
b=1
c=1
file="population_inc.csv"
if [ -f "$file" ]
then
	rm population_inc.csv	
fi
while read f1 f2
do
	if [ "$g" -eq "$b" ]; then
		echo "$f1,$f2">>population\_inc.csv
		let "c=$f2"
		let "g=$g+$b"
	else
		let "c=$f2-$c"
		echo "$f1,$c">>population\_inc.csv
		let "c=$f2"
	fi
done<population.csv