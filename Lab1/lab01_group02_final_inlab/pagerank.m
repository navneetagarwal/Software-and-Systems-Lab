format free
fp=fopen("small.txt","r");

const=input("Give the value of constant \n")

% Check if file exists.
if fp>0

% Initialisation of the Connectivity matrix, page id.
  C=zeros(1000,1000);
  #Declaration for line 1
  id=1;

% Iterating till the end of file.
  while !feof(fp)

%   Getting the next line from the file and storing it in outLink.
    outLink=fgetl(fp); 
    no_of_outlinks=0;

%   Scaning through the links and storing them individually in linkId. Also counting no. of links.
    [linkId,count]=sscanf(outLink,"%d");
%   Ensuring no dangling node
    if count>0
%     Registering the values in the C matrix
      for i=1:1:count
%       Ensuring no self links or duplicate links
        if C(linkId(i),id)==0&&linkId(i)!=id
           C(linkId(i),id)=1;
          no_of_outlinks++;
        end
      end
    
%     Updating the values in the connectivity matrix as per the formula.
      C(:,id)=1/no_of_outlinks*C(:,id);
      id++;
    end
  end

% Associating the constant factor with the eigenvalue.
  C=C+const/1000*ones(1000,1000);
  [egVector, egValue] = eig (C);
  lambda=diag(egValue);
  
% Confirming that the value falls in the appropriate range.
  for i=1:1000
    if abs(lambda(i,1)-(1+const))<0.005
      break;
    end
  end

% Sorting the obtained page ranks in the desending order.
  [b,k]=sort(egVector(:,i),"descend");
% Printing the Output
  printf("\n");
  printf("Sr. No\tPg No.\tPg Rank\n")
  for j=1:20
    printf("%d\t%d\t%f\n",j,k(j,1),b(j,1))              % Printing the first 20 page ranks in the descending order.
  end
end
fclose(fp);


