%Prompts for geting input
prompt1 = 'Initial x- Coordinate ';
prompt2 = 'Initial y- Coordinate ';
prompt3 = 'Final x- Coordinate ';
prompt4 = 'Final y- Coordinate ';
prompt5 = 'Velocity ';

%Initialization of required variables
prev_angle = 0;
prev_angle_1 = 0;
g = 10;
k = 0.05;
set_precision = 0.005;
x_original = input(prompt1);
y_original = input(prompt2);
x_final = input(prompt3);
y_final = input(prompt4);
velocity = input(prompt5);
x_final = x_final - x_original;
y_final = y_final - y_original;

% Code for all cases for position of bulls eye wrt shooter
if x_final > 0

% Code for Case I
  disp("Case I")
% Loop going from (-90,90) because t = 1/0 for +-90
  for angle = -89.99:0.01 : 89.99
%   t from first equation assuming value of angle
    t = x_final/(velocity*cosd(angle));
%   Checking if the value of t and angle reach the bull's eye
    if abs(y_final + 0.5*g*(t^2) - velocity*t*sind(angle)) <= 0.03
%     To find the smallest angle
      if prev_angle == 0
        prev_angle = 1;
        angle1 = angle;
      end
    else
%     To find the largest angle 
      if prev_angle == 1
        prev_angle = 0;
        angle2 = angle - 0.01;
%       Printing Output        
        if angle2 == angle1
          printf ("Dart can hit for the angle {%.2f}\n",angle1)
        else
          printf ("Dart can hit for the angles between [ %.2f, %.2f]\n",angle1,angle2)  
        end
      end
    end  
  end
  
% Code for Case II
  disp("Case II")
% Loop going from (-90,90) as t = 1/0 for +-90
  for angle = -89.99:0.01 : 89.99
%   t from first equation assuming value of angle
    t = -1/k*log(1- (x_final*k/(velocity*cosd(angle))));
%   Checking if the value of t and angle reach the bull's eye
    if abs(y_final - (g/k^2*(1-k*t-exp(-k*t))) - velocity*sind(angle)/k*(1 - exp(-k*t))) <= 0.03
%     To find the smallest angle
      if prev_angle == 0
        prev_angle = 1;
        angle1 = angle;
      end
    else
%     To find the largest angle 
      if prev_angle == 1
        prev_angle = 0;
        angle2 = angle - 0.01;
%       Printing Output        
        if angle2 == angle1
          printf ("Dart can hit for the angle {%.2f}\n",angle1)
        else
          printf ("Dart can hit for the angles between [ %.2f, %.2f]\n",angle1,angle2)  
        end
      end
    end  
  end
  
% Code for Case III
  disp("Case III")
% Loop going from (-90,90) as t = 1/0 for +-90
  for angle = -89.99:set_precision : 89.99
%   t from first equation assuming value of angle
    t = (exp(x_final*k) - 1)/(k*velocity*cosd(angle));
%   Checking if the value of t and angle reach the bull's eye
    if abs(y_final - 1/k*(log((cos(sqrt(g*k)*t - atan(sqrt(k/g)*velocity*sind(angle)))/cos(atan(sqrt(k/g)*velocity*sind(angle))))))) <= 0.03
%     To find the smallest angle
      if prev_angle == 0
        prev_angle = 1;
        angle1 = angle;
      end
    else
%     To find the largest angle 
      if prev_angle == 1
        prev_angle = 0;
        angle2 = angle - set_precision;
%       Printing Output        
        if angle2 == angle1
          printf ("Dart can hit for the angle {%.2f}\n",angle1)
        else
          printf ("Dart can hit for the angles between [ %.2f, %.2f]\n",angle1,angle2)  
        end
      end
    end  
  end

else
  if x_final < 0
    
%   Code for Case I
    disp("Case I")

%   Loop going from (-90,90) because t = 1/0 for +-90
    for angle = 90.01:0.01: 269.99
%     t from first equation assuming value of angle
      t = x_final/(velocity*cosd(angle));
%     Checking if the value of t and angle reach the bull's eye
      if abs(y_final + 0.5*g*(t^2) - velocity*t*sind(angle)) <= 0.03
%       To find the smallest angle
        if prev_angle == 0
          prev_angle = 1;
          angle1 = angle;
        end
      else
%       To find the largest angle 
        if prev_angle == 1
          prev_angle = 0;
          angle2 = angle - 0.01;
%         Printing Output                  
          if angle2 == angle1
            printf ("Dart can hit for the angle {%.2f}\n",angle1)
          else
            printf ("Dart can hit for the angles between [ %.2f, %.2f]\n",angle1,angle2)  
          end
        end
      end  
    end
    
%   Code for Case II
    disp("Case II")
    
%   Loop going from (-90,90) as t = 1/0 for +-90
    for angle = 90.01:0.01: 269.99
%     t from first equation assuming value of angle
      t = -1/k*log(1- (x_final*k/(velocity*cosd(angle))));
%     Checking if the value of t and angle reach the bull's eye
      if abs(y_final - (g/k^2*(1-k*t-exp(-k*t))) - velocity*sind(angle)/k*(1 - exp(-k*t))) <= 0.03
%       To find the smallest angle
        if prev_angle == 0
          prev_angle = 1;
          angle1 = angle;
        end
      else
%       To find the largest angle 
        if prev_angle == 1
          prev_angle = 0;
          angle2 = angle - 0.01;
%         Printing Output
          if angle2 == angle1
            printf ("Dart can hit for the angle {%.2f}\n",angle1)
          else
            printf ("Dart can hit for the angles between [ %.2f, %.2f]\n",angle1,angle2)  
          end
        end
      end  
    end
    
%   Code for Case III
    disp("Case III")
    
%   Loop going from (-90,90) as t = 1/0 for +-90
    for angle = 90.01:set_precision: 269.99
%     t from first equation assuming value of angle
      t = (exp(x_final*k) - 1)/(k*velocity*cosd(angle));
%     Checking if the value of t and angle reach the bull's eye
      if abs(y_final - 1/k*(log((cos(sqrt(g*k)*t - atan(sqrt(k/g)*velocity*sind(angle)))/cos(atan(sqrt(k/g)*velocity*sind(angle))))))) <= 0.03
%       To find the smallest angle
        if prev_angle == 0
          prev_angle = 1;
          angle1 = angle;
        end
      else
%       To find the largest angle 
        if prev_angle == 1
          prev_angle = 0;
          angle2 = angle - set_precision;
%         Printing Output
          if angle2 == angle1
            printf ("Dart can hit for the angle {%.2f}\n",angle1,angle2)
          else
            printf ("Dart can hit for the angles between [ %.2f, %.2f]\n",angle1,angle2)  
          end
        end
      end  
    end 
  else

%     Case for x_final = 0 , y_final = 0. It will occur for all angles and all velocities
      if y_final == 0
        disp("Infinite solutions")
      
    else
%   Code for Case I and II only
      if y_final < 0
        disp("Case I")
        printf ("Dart can hit for the angles {-90,90} only\n")
        disp("Case II")
        printf ("Dart can hit for the angles {-90,90} only\n")
      else
      
%       Case for y_final > 0 
        disp("Case I")
        if y_final <= (velocity)^2/(2*g) + 0.03
          printf ("Dart can hit for the angles {90} only\n")
        end
        
%       Code for Case II
        disp("Case II")
        t = 1/k * log((k*velocity+g)/g);
        if y_final <= ((velocity/k*(1 - exp(-k*t))) + (g/k^2*(1 - k*t - exp(-k*t))))
           printf("Dart can hit for the angles {90} only\n")
        end
      end
%     Code for Case III 
      disp("Case III")
%     Value of t should be real as well as more than 0
      t = acos(exp(k* y_final)*cos(atan(sqrt(k/g)*velocity))) + atan(sqrt(k/g)*velocity); # Case III: For angle = 90
      if  t > 0
%       Case III: For angle  = -90
        if(t - 2* atan(sqrt(k/g)*velocity)> 0)
            printf("Dart can hit for the angles {-90,90}\n")    # Printing the case that both values are possible
        else
          printf("Dart can hit for the angles {90} only\n")     # Printing the case that only angle = 90 is possible
        end
      end
    end
  end
end