#!/bin/bash
while read name;
do
	echo "$name"| tr ' ' '\n' | sort | uniq -c |awk '{print $1 $2}'
done

 # (tr ' ' '\n' | sort | uniq -c | awk '{print $2"@"$1}')

