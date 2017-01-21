function [xmin ymin] = min(x,y)

tempx = x - 0.1*fx(x,y);
tempy = y - 0.1*fy(x,y);
tempf = f(tempx,tempy);

while f(x,y) - tempf > 0.001
  x = tempx;
  y = tempy;
  tempx = x - 0.1*fx(x,y);
  tempy = y - 0.1*fy(x,y);
  tempf = f(tempx,tempy);
end

xmin = tempx
ymin = tempy

endfunction
