/*##############################
############mohanteja###############
##hamming code parity correction######
###############7-7-2017############
####315126510194######*/

#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>



int findparno(int len)
{
	int i = 0;
	while (pow(2,i*1.0)<len)
	{
		i++;
	}
	return i+1;
}


int main()
{
	printf("\n------------------------------------transmitter side----------------------------------------\n");

	//scan data
	long long int data;
	printf("enter data to be sent:");
	scanf_s("%d", &data);
	
	//call dec to int
 

	char *binary = (char*)malloc(sizeof(char) * 32);
	_itoa_s(data,binary,32,2);
	//data len
	printf("binary code of data :%s\n", binary);
	int slen = strlen(binary);
	printf("%d\n", slen);

	//converge parity spaces and data

	//cal no of parity bits required
	int nopars = findparno(slen);
	printf("%d\n", nopars);

	//cal total length  paritybits + data bits

	//duplicate final data

       	char *s_data_c = (char *)calloc((slen + nopars),sizeof(char));


	//merge them
	int i,j = 0, k = 65, l = 0;
	/*s_data_c[0] = 10;*/

	for (i = 0; i<(slen + nopars);i++)
	{

		//printf("-------------\n");
		if (i==(int)pow(2,j*1.0)-1)          //substitute parities at 2^j values
		{
			s_data_c[i] = k;
			//printf("%c---------1\n", s_data_c[i]);
			//printf("%d---------1\n", i);
			k++;
			j++;
		}
		else
		{
			s_data_c[i] = binary[l];
			//printf("%c-----------2\n", s_data_c[i]);
			l++;
		}
		//printf("------------------%d\n", i);
	
	}
	s_data_c[slen + nopars] = 0;
	printf("\nbinary data in packet :%s\n", s_data_c);

	




	//create parity arrays
	int **p = (int**)calloc(nopars, sizeof(int));
	for (int e = 0; e < nopars;e++)
	   p[e]=(int*)calloc((slen/2)+1,sizeof(int));

      int *parcount = (int*)calloc(nopars,sizeof(int));
	  int *parity = (int*)calloc(nopars, sizeof(int));
	  
	  //bucket sort corresponding parities
	  
	  for (i = 0,j=0; i < slen + nopars; i++)
	{
		if (i +1 == (int)pow(2, j*1.0))
		{
			
			j++;
			continue;
		}
		k = i + 1;
		//printf("i----------------------------------------------------%d\n",k);

			for (int w = 1; w <= nopars; w++)
			{
				
			
				if (k % 2==1)
				{
				//	printf("k---------------%d\n", k);
					/*printf("i----------%d\n", i);
					printf("parcount[w]----------%d\n", parcount[w]);
					printf("w----------%d\n", w);*/

					p[w-1][parcount[w-1]++] = i+1;
					//printf("%d---%d--%d\n", w - 1, parcount[w - 1],i+1);

					if (s_data_c[i] == '1') parity[w - 1]++;


				}
				//printf("---------kbrfore--%d\n", k);

				k = (i+1) >> w;
				//printf("k-w----%d---%d\n", k,w);
			}

        
	}

	//for (int k = 0; k <5; k++)
	//	printf("%d\t", parity[k]%2);

	//printf("-----------------\n");

	/*for (int i = 0; i < 4; i++)
	{
		printf("\n");
		for (int k = 0; k < 5; k++)
			printf("%d\t", p[i][k]);
	}*/

	



	//calculate parities
	for (int k = 0; k <nopars; k++)
		printf("%d\t", parity[k] % 2);

	//insert parities
	for (i = 0,j=0; i<(slen + nopars); i++)
	{

		//printf("-------------\n");
		if (i == (int)pow(2, j*1.0) - 1)          //substitute parities at 2^j values
		{
			s_data_c[i] = '0' + (parity[j] % 2);
			j++;
		}
		
	}
	printf("\nfinal data packet at transmitter : %s\n", s_data_c);
//medium ---------------------------------------------------------------------------------------------------------
	printf("\n------------------------------------medium----------------------------------------\n");

	//insert error into data
	printf("enter error into the data select a bit position to change except 2 power i values \n");
	scanf_s("%d", &i);
	
	//i = 5;
	s_data_c[i-1] = (s_data_c[i - 1] == 48) ? 49 : 48;
	printf("\nerror data in transmission medium : %s\n", s_data_c);

//reciever	side ----------------------------------------------------------------------------------------------------
	printf("\n------------------------------------reciever side----------------------------------------\n");

	printf("\nerror data recieved : %s\n", s_data_c);
	//error detection
	int   *parity_rec = (int*)calloc(nopars, sizeof(int));
	        //calculate parity again

	for (i = 0; i < nopars; i++)
	{
		for (k = 0; k < (slen+nopars)/2; k++)
		{
			if (p[i][k] > 0)
			{
				//printf("%d\n", p[i][k]);

				if (s_data_c[p[i][k] - 1]=='1')
					parity_rec[i] += 1;
			
			}
		}
	}
	//printf("\n----------------------------------------------------------------------------\n");
	for (int k = 0; k < nopars; k++){
		//printf("%d\t", parity_rec[k]);
		
		parity_rec[k] %= 2;
		
	 // printf("%d\t", parity_rec[k]);
		
	}
	//detection of error
//	printf("\n----------------------------------------------------------------------------\n");
	int count=0;
	for (j = 0; j < nopars; j++)
	{
		if (!(s_data_c[(int)pow(2, j*1.0)-1]== 48 + parity_rec[j]))
		{

			/*printf("str------%c\n", s_data_c[(int)pow(2, j*1.0) - 1]);
			printf("parity---%d\n", parity_rec[j]);*/
			count = count + (int)pow(2, j*1.0);
			/*printf("%d\n", count);*/
		}

	}
	printf("detected error at bit:%d\n", count);
	//detection of error data bit


	//correction
	s_data_c[count - 1] = (s_data_c[count - 1] == 48) ? 49 : 48;
	printf("\n corrected data  : %s\n", s_data_c);
	return 0;
}
//dont modify
