#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<string.h>

   int main()
 {
      int data;
       printf("enter the data\n");
            // scanf("%d",&data);

  //covert data into binary data
  
    //  char *sendbuffer=(char *)malloc(sizeof(char)*32);      
        char sendbuffer[32];          
       // itoa(data,&sendbuffer,2);   // here 2 means binary
     scanf("%s",sendbuffer);
 printf("Binary value = %s\n", sendbuffer);
        //send  a window data to the destination
         
       printf("enter window size\n");
        int winSize;
       scanf("%d",&winSize);
       int dataLen=strlen(sendbuffer);
       
int i=0;          
          //receiving window
              char *recieveBuffer=      (char *)malloc(sizeof(char)*dataLen);  
              
 int j=0;
         while(i<dataLen)
         {
                
                //send data
             j=0;
                  while(j<winSize)
                        {
                                printf("\npacket %d sent data : %c\n", i,sendbuffer[i]);
                                recieveBuffer[i]=sendbuffer[i];
                                //   printf("enter not recieved packet at network\n");
                                   //scanf("%d",&j); 
                                      //if(j=i)
                                          // {
                                          printf("packet ack %d sent\n",i);
                                               printf("packet ack %d recieved\n",i);
                                       //}
                                   //j=j-1;
                                   

                                            j++; 
                                        i=i+j;          
                             
                            }

                         printf("next window\n");

              }
           //  recieveBuffer[i]=0;
           printf("\nthe recieved data : %s",recieveBuffer);






return 0;
     }
