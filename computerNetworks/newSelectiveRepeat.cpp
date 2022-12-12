#include<iostream>
#include<string>
#include<conio.h>
using namespace std;

int main()
{
	cout<<"Enter the Message to be Sent :";
	string packet,sub;
	getline(cin,packet);
    char c= ' ';
    int len=packet.size();
    int found;
    int sizef=0;
     for(int i=0;i<=len;i++)
     
     {
     	if (packet[i]==' '|| packet[i]=='\0')
     	        ++sizef;	
	 }
 string frame[sizef];
    for(int i=0;i<sizef;i++)
    {
        if(i!=sizef)
        {
        found=packet.find(c);
		sub=packet.substr(0,found);
		frame[i]=sub;
		packet=packet.substr(found+1,len);                   
	    }
	   else
	   {
	  	sub=packet.substr(found,len);
	  	frame[i]=sub;
	   }	 
}

int ws,a=0;
cout<<("Enter the size of Window :");
cin>>ws;
int random,timer=0,ack=ws,seq=0;
int ch=4,flag=0,check=0,c2=0,point=0,ld,loop,f2,f3=0,count=0,nack;
if(sizef%ws==0)
loop=sizef/ws;
else
{
f2=sizef%ws;
loop=sizef/ws+1;
}

int sr =(ws*2)-1;
    for (int i=0;i<loop;i++)
    {
    	 if(a==0)
		  a=3; 
    	  getch();
    	  switch(ch)
    	  {
    	  	case 0:                                                          // Receiver
    	  		{
    	  		cout<<"\n\t\t\t\t\t\t------Receiver------";
    	  		if(check==3 && c2!=0)
    	  		{
    	  		for(int i=point;i<ld+point-1;i++)
    	  		cout<<"\n\t\t\t\t\t\tMessage received : "<<frame[i];
    	  		if(c2==1)
    	  		cout<<"\n\t\t\t\t\t\tFrame "<<ld+point<<" Lost ";	
				else if(c2==2)
				cout<<"\n\t\t\t\t\t\tFrame "<<ld+point<<" damaged ";
				
				for(int i=ld+point;i<ws+point;i++)
    	  		cout<<"\n\t\t\t\t\t\tMessage received : "<<frame[i];
    	  		nack=((ld+point)%(sr+1))-1;
    	  		if(nack==-1)
    	  		nack=sr;
    	  		cout<<"\n\n\t\t\t\t\t\tSending Nack :"<<nack;
				c2=0;
    	  		--i;
    	  		ch=4;
    	  		check=0;
    	  		break;
				}
				
				if(seq==sr+1)
				seq=ack=0;
				else
    	        ack=seq;
    	        
    	        
    	        if(check==1)
    	  		{
    	  		for(int i=point;i<ld+point-1;i++)
    	  		cout<<"\n\t\t\t\t\t\tMessage discarded : "<<frame[i];
    	  			ack=seq;
    	  			
    	  			cout<<"\n\n\t\t\t\t\t\tAgain Sending Ack :"<<ack;
    	  			check=0;
    	  			ch=4;
    	  			
    	  			break;
				}
    	  		if(ld!=0)
    	  		{
    	  		
    	  		cout<<"\n\t\t\t\t\t\tMessage received : "<<frame[ld+point-1];
    	  		nack=0;
    	  		ld=0;
				}
				else
				{
				
    	  		for(int i=point;i<ws+point;i++)
    	  		cout<<"\n\t\t\t\t\t\tMessage received : "<<frame[i];
    	  	    }
    	  		if (check==2)
    	  		{
    	  			
    	  		
    	  		cout<<"\n\n\t\t\t\t\t\tSending Ack "<<ack;
    	  		cout<<"\n---------------------\nAck lost\n---------------------";
    	  		check=1;
    	  		ch=4;
    	  		--i;
    	  		ack=!seq;
    	  		
    	  		break;
				}
				
    	  		
    	  		
		
    	  		cout<<"\n\n\t\t\t\t\t\tSending Ack :"<<ack;
    	  		
    	  		ch=4;
    	  		break;
				}
    	  	case 1:                                                        //Frame Lost
			  {  
    	  		  cout<<"\n---------------------\n--Frame lost-- \n---------------------";
    	  		  
    	  	      timer=1;
    	  	      ld=rand()%ws+1;
    	  	      nack=ld;
    	  	      check=3;
    	  	      c2=1;
    	  	      
    	  	      ch=0;
    	  	     --i;
				 break;
			  }
			  case 2:                                                       //Frame Damage
			  	{      
			  		cout<<"\n---------------------\n--sizef damaged--\n---------------------";
			  		timer=1;
			  		ld=rand()%ws+1;
			  		nack=ld;
			  		c2=2;
    	  	        ch=0;
    	  	        
			  		--i;
			  		break;
				 }	  
			  case 3:                                                      //Ack Lost
			  	{
    	  		ch=0;
    	  		--i;
    	  		
    	  		check=2;
    	  		break;
				  }
    	  	case 4:                                                        //Sender
    	  		{
    	  		
    	  		
    	  			ch=a--; 
    	  			rand();
    	  			cout<<"\n-------Sender---------";
    	  			if(timer==1)
    	  			{
    	  				timer=0;
    	  				int s=nack;
    	  				
    	  				cout<<"\nNack Received :"<<nack;
    	  				cout<<"\nSending Frame"<<ld+point<< " Again";
    	  				cout<<"\nSending Message |"<<frame[ld+point-1]<<"| with Sequence No. "<<s;
    	  			    check=3;
    	  			    
    	  			    --i;
    	  			    ch=0;
    	  	            break;
					}
					else 
					{
						
				 	    if (ack==seq)
					  {
					  	point=point+ws;
					  if(point==sizef)
					{
						i=loop;
						f3=1;
						break;
					}
						cout<<"\nReceived Ack : "<<ack;
						count=seq;
						
					
				      }
				     	
				       	else 
				       	
				       	
					   if(flag==1 )
					   {
					   
					cout<<"\nTimer Out!!!\nAck not received \nSending sizef again ";
					--i;
					if(ack!=seq)
				    seq=count;
					for(int j=point;j<point+ws;j++,seq++)
				    {
				    
				    if(seq>sr) 
					{
					seq=0;
					}
    	  			cout<<"\nFrame "<<j+1;
    	  			cout<<"\nSending Message |"<<frame[j]<<"| with Sequence No. "<<seq;       //seq
    	  		    }
    	  				ld=ws+1;
						ch=0;
						check=1;
						--i;
						break;
						
					}
					flag=1;
				}	
				    
					if(point+ws>sizef)
				    {
				    	ws=f2;
				    	ack=f2;
					}
				    for(int j=point;j<point+ws;j++,seq++)
				    {
					if(timer==1)
					{
					timer=0;
					seq=count;
					}
					if(seq>sr) 
					{
					seq=0;
					}
    	  			cout<<"\nFrame "<<j+1;
    	  			cout<<"\nSending Message |"<<frame[j]<<"| with Sequence No. "<<seq;       //seq
    	  		    }
    	  		                                    //ch=  0 ,1 ,2 ,3
    	  		   
    	  		    --i;
						break;
		     	}
		     	
		  }
	}
	if(f3!=1)
	cout<<"\n-------Sender---------";
	cout<<"\nAck received : "<<ack;
}