formatSpec = '%0.3f %0.3f %0.3f\n';
fileID1 = fopen('input.txt','r');
fileID2 = fopen('input.dat','w');
spec = '%s';
x = -5.000;
y = -5.000;
str = fscanf(fileID1,spec);
f1 = inline(str,'x','y');
z = feval(f1,x,y);

for i=-5:0.5:5
  for j=-5:0.5:5
    z = feval(f1,i,j);
    c=[i j z];
    fprintf(fileID2,formatSpec,c);
  end
end
fclose(fileID2);
a = [x y z];
fileID = fopen('output.dat','w');
fprintf(fileID,formatSpec,a);


function z = f(x,y,f1)
  z = feval(f1,x,y);
endfunction

function z1 = fx(x,y,f1)
  z1 = (f(x+0.01,y,f1) - f(x,y,f1))/0.01;
endfunction

function k = fy(x,y,f1)
 k = (f(x,y+0.01,f1) - f(x,y,f1))/0.01;
endfunction

function [xmin ymin] = min(x,y,a,fileID,formatSpec,f1)

tempx = x - 0.01*fx(x,y,f1);
tempy = y - 0.01*fy(x,y,f1);
tempf = f(tempx,tempy,f1);
b = [tempx tempy tempf];
%a = [a; b];
disp(x);
if abs(f(x,y,f1) - tempf) > 1000000
	x = x + 3;
	y = y + 3;
  if x > 50
    disp('Not possible for this code');
    break  
  else
	   min(x,y,a,fileID,formatSpec,f1);
  end
else
  while abs(f(x,y,f1) - tempf) > 0.001
    x = tempx;
    y = tempy;
    tempx = x - 0.01*fx(x,y,f1);
    tempy = y - 0.01*fy(x,y,f1);
    tempf = f(tempx,tempy,f1);
    b = [tempx tempy tempf];
    %a = [a; b];
    fprintf(fileID,formatSpec,b);
  end
end
b
endfunction

min(x,y,a,fileID,formatSpec,f1);
fclose(fileID);
fclose(fileID1);
