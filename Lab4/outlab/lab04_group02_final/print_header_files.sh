#!/bin/bash
file="$1"
if [ -f "$file" ]

then :
else
	exit 1	
fi
g=0
while IFS='' read -r line || [[ -n "$line" ]]; do
	g=0
    qe=`echo $line | sed -e 's/  *//g' -e 's/^ *\(.*\) *$/\1/'`
	qe=${qe%% }
	qe=${qe## }
    if [[ $qe == *"#include<"*">"* ]] 
	then :
		g=0
		if [[ $qe == *"//#"* ]]; then
			g=1
		else
			g=0
		fi
	else
		if [[ $qe == "#include\""*"\"" ]]; then :
			#statements
			if [[ $qe == *"//#"* ]]; then
			 	g=1
			 else
			 	g=0
			 fi 
			else
				g=1
		fi
	fi
	if [[ $g == 0 ]] 
		then
		if [[ $qe == *"//"* ]]; then
			n1=`expr index "$qe" '/'`	
			else 
			n1=${#qe}
			let "n1=$n1+1"	
		fi
		n3=`expr index "$line" '<'`
		n4=`expr index "$line" '>'`
		#echo "$n1 $n4"
		let "n4=$n4-$n3-1"	
		echo ${line:$n3:$n4}
	fi
done < "$1"