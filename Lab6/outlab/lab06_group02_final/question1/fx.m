function z = fx(x,y)
  z = (f(x+0.01,y) - f(x,y))/0.01;
endfunction