#Counting no of files
variabl=$(ls -1a | wc -l) 
variable=$(ls -la| grep -c ^d)
let "variabl=$variabl-$variable"
# let "variable=$variable-2"
echo $variable
echo $variabl
exit 0;