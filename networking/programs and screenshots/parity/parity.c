#include<stdio.h>

void main()
  {
   int i,n,a[10],b[10],c=0,d=0;
   
   printf("enter the no.of bits in data\n");
   scanf("%d",&n);
   printf("enter sender side data\n");
   for(i=0;i<n;i++)
    {
      scanf("%d",&a[i]);
    }
   for(i=0;i<n;i++)
    {
      if(a[i]==1)
        {
          c++;
        }
     }
    if(c%2==0)
     {
        a[n]=0;
     }
    else
     {
       a[n]=1;
     } 
    printf("data sent from sender \n");
    
     for(i=0;i<=n;i++)
    {
      printf("%d",a[i]);
    }
    int k;
    k=n+1;
    printf("\nenter recieved data: \n");
     for(i=0;i<k;i++)
     {
      scanf("%d",&b[i]);
     }
    
     for(i=0;i<k;i++)
    {
      printf("  %d",b[i]);
      
    }
     for(i=0;i<k;i++)
    {
      if(b[i]==1)
        {
          d++;
        }
   
    }
     
     if(d%2==0)
      {
        printf("\nno error detected \n");
      }  
      else if(d%2==1)
       {
         printf("error detected \n");
       }
  }
    
    
    
    
    
    
    
    
    
    
    
