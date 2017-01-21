import sys

var = False
var2 = False
text_file = open("Output.txt", "w")

if len(sys.argv) == 2:
	with open(sys.argv[1], 'r') as cinput:
		for line in cinput.readlines():
			var = False
			array= list(line)
			for i in range(1,len(array)):
				if not var:
					if array[i-1] == '/':
						if array[i]=='/':
							var = True
				else:
					array1 = array[i:len(array)]
					array1 = ''.join(array1)
					text_file.write("%s" % array1)
					break
				if not var2:
					if array[i-1] == '/':
						if array[i]=='*':
							var2 = True
				else:
					if array[i-1] == '*':
						if array[i]=='/':

							var2 = False
					if var2:
						array1 = array[i]
						if array[i] == '*':
							array1 = '\n'
						text_file.write("%s" % array1)


else:
	print("Incorrect number of arguments. Give only 1 argument")
