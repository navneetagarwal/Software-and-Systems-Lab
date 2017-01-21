#!bin/bash

file="data.csv"
if [ -f "$file" ]
then
	rm data.csv	
fi
for (( i = 1; i < 47; i++ )); do
	./a.out $i >> data.csv
done