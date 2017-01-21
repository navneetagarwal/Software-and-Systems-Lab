import sys
import csv


with open("tenth.txt", "rt") as in_txt:
	array1 = []
	found = True
	lines = in_txt.readlines()
	i = 0
	while i < len(lines) :
		line = lines[i]
		temp = line.split(' ')
		temp = [x for x in temp if x != '']
		if temp[0].isdigit():
			while not temp[2].isdigit():
				temp[1:3] = ['_'.join(temp[1:3])]
				pass
			if temp[17]=='EIOP':
				temp.insert(18,'NA')
			temp.pop()
			line1 = lines[i+1]
			line_2 = line1.split(' ')
			line_2 = [x for x in line_2 if x != '']
			temp = temp + line_2
			i+=1
			# print(temp)
			array1.append(temp)
		elif temp[0] == 'ROLL':
			cell =[]
			if found:
				found = False
				temp[0:2] = ['_'.join(temp[0:2])]
				temp[1:3] = ['_'.join(temp[1:3])]
				item_dot = temp[1].split('.')
				temp[1] = item_dot[0]
				
				line = lines[i+1]
				line_2 = line.split(' ')
				line_2 = [x for x in line_2 if x != '']
				line_2.pop()
				# print(line_2)
				i =0
				while i < len(line_2):
					if line_2[i] =='Part':
						line_2[i:i+2] = ['_'.join(line_2[i:i+2])]
					i+=1

				i =0
				while i < len(line_2):
					# print(len(line_2))
					if line_2[i] !=' ':
						# print(line_2[i])
						item_dot = line_2[i].split('.')
						line_2[i] = item_dot[0]
						j =0
						while j < len(item_dot)-1:
							if item_dot[j]==' ':
								if item_dot[j+1]!=' ':
									if item_dot[j+1]!='':
										item_dot.insert(j+1,'Part')
										# print(item_dot)
										cell = ['_'.join(item_dot[j+1:len(item_dot)])]
										# print(cell)
										line_2.insert(i+1,cell[0])
										line_2.insert(i+2,' ')
										item_dot[i+1:len(item_dot)]=[]
										pass
							elif item_dot[j]=='':
								if item_dot[j+1]!=' ':
									if item_dot[j+1]!='':
										item_dot.insert(j+1,'Part')
										# print(item_dot)
										cell = ['_'.join(item_dot[j+1:len(item_dot)])]
										# print(cell)
										line_2.insert(i+1,cell[0])
										line_2.insert(i+2,' ')
										item_dot[i+1:len(item_dot)]=[]
										pass
								pass
							j +=1
							pass
						val = item_dot.count('')
						if val != 0:
							val = int(val/3) + 1
							k = 0
							while k < val:
								# print(val)
								line_2.insert(i+1,' ')
								k +=1
								pass
							pass
						pass
					i+=1
					pass
				line_2.pop()
				# print(line_2)
				temp = temp + line_2
				array1.append(temp)
				i += 1
		i +=1

with open("cbseProcessed.csv", "w") as f:
    writer = csv.writer(f)
    writer.writerows(array1)
