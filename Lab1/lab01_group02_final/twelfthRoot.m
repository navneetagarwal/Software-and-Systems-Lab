# Input prompts for user input
prompt0 = "Enter the value of x_0 ";

# Prompting the user for input
x_0 = input(prompt0);
A = 2;
n = 12;

# Initialising the variables 
x_prev = x_0;
count = 1;
x = 1/n*((n-1)*x_prev + A/(x_prev)^(n-1));
matrix = [0 x_prev;1 x];			# Matrix for easier access of value of x_k for a particular k

# Iterating through the recurrence relation to get the value of x such that the accuracy  is<= 10^ -11
while abs(x - x_prev) >= 10^-11
  count++;
  x_prev = x;
  x = 1/n*((n-1)*x_prev + A/(x_prev)^(n-1));
  new_row = [count x];				# Adding a new row to the matrix
  matrix = [matrix; new_row];
end

# Code for Graph 
figure;						# Initialising the plot
plot(matrix(:,1),matrix(:,2),".");	
title('Plot of x_k v/s k','Fontsize',24,'FontWeight','bold','Color','k')	# Title
legend('y = x_k')								# Legend
xlabel('k','Fontsize',16,'FontWeight','bold','Color','r')			# Labels
ylabel('x_k','Fontsize',16,'FontWeight','bold','Color','r')

# Printing output
printf("Value %dth root of %f = %.10f\n",n,A,x)					
