# rm -f $(find / -name core) &> /dev/null
file="bad.txt"
if [ -f "$file" ]
then
	rm bad.txt	
fi
file="good.txt"
if [ -f "$file" ]
then
	rm good.txt	
fi
for m in *.c
do

if (gcc $m -lm) 2>/dev/null; then 
echo $m>>good.txt
else 
echo $m>>bad.txt
fi
done

