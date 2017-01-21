import sys
import csv

#print(len(sys.argv))
Hub = []
selHub = []
found = 0
total = 0
if len(sys.argv) == 2:
    print ("Part 2a ")
    with open(sys.argv[1], 'r') as marks:
        for line in marks.readlines():
            array = line.split(',')
            try:
                val = int(array[0])
                total = total + 1
            except ValueError:
                total = total
    print(total)
    print("Part 2b")
    with open(sys.argv[1], 'r') as marks:
        for line in marks.readlines():
            array = line.split(',')
            try:
                val = int(array[0])
                Hub.append(array)
            except ValueError:
                i = 1
    print(len(Hub))
    Hub=[]
    print("Part 2c")
    with open(sys.argv[1], 'r') as marks:
        for line in marks.readlines():
            array = line.split(',')
            try:
                val = int(array[0])
                Hub.append(array)
            except ValueError:
                i = 1
    #selHub.append([row for row in Hub if row[0]==0])
    selHub = list(filter((lambda x: x[6]=='1\n'), Hub))

    print(len(selHub))
    Hub=[]
    selHub=[]
    print("Part 2d")
    with open(sys.argv[1], 'r') as marks:
        for line in marks.readlines():
            array = line.split(',')
            Hub.append(array)
                
    selHub = list(filter((lambda x: x[0]=='"Sno"'), Hub))
    dict = {}
    for i in range(len(selHub[0])):
        dict[selHub[0][i]] = i+1
    for k,v in dict.items():
        print(k,v)
    Hub=[]
    selHub=[]
    with open(sys.argv[1], 'r') as marks:
        for line in marks.readlines():
            array = line.split(',')
            if found == 0:
                Hub.append(array)
            else:
                total = 0
                for i in range(1, len(array)-1):
                    if array[i]=='"NA"':
                        array[i] = "NA"
                        total = total
                    else:
                        total = total + float(array[i])
                array.append(total)
                if array[len(array)-2] == '0\n':
                    array[len(array)-2] = '0'
                else:
                    array[len(array)-2] = '1'
                selHub.append(array)
            if array[0] == '"Sno"':
                found = 1

    col = len(selHub[0]) - 1;
    selHub.sort(key = lambda x: x[col])
    for i in range(len(selHub)):
        selHub[i][col] = str(selHub[i][col])
    #print(selHub)

    with open('marks_sorted.csv','w') as myFile:
        wr = csv.writer(myFile)
        wr.writerows(selHub)
    
                 
else:
    print("Incorrect number of arguments. Give only 1 argument")
    
