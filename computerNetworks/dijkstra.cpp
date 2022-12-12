#include<iostream>
#include<climits>    
#include<string> 
#define iMAX 9999
#define Max_nodes 20

using namespace std;

int minDist(int dist[], bool Tset[],int num){
    int min=iMAX,index;
	  
    for(int i=0;i<num;i++) {
	    if(Tset[i]==false && dist[i]<=min){
		    min=dist[i];
		    index=i;
	    }
    }
    return index;
}

void dijAlg(int graph[Max_nodes][Max_nodes],char *ch,int src,int num){
    int dist[num];
    char predecessor[num];
    string shortestPath[num];                            
    bool Tset[num];

    //In the beginning, let dist for each node be infinity and permanent label false.
    for(int i = 0; i<num; i++){
	    dist[i] = iMAX;
	    Tset[i] = false;
        predecessor[i] = ch[i];
        shortestPath[i] = ch[src];	
    }
    //Set distance of source to 0
    dist[src] = 0;              
    
    for(int i = 0; i<num; i++){
	    int m=minDist(dist,Tset,num); 
	    Tset[m]=true;
    
	    for(int i = 0; i<num; i++){   

		    if(!Tset[i] && graph[m][i] && dist[m]!=iMAX && dist[m]+graph[m][i]<dist[i]) {
                predecessor[i] = ch[m];
			    dist[i]=dist[m]+graph[m][i];
            }
	    }
    }

    cout<<"Node   - Distance from source - Shortest Path"<<endl;
    //Calculate shortest path using predecessors

    for(int i = 0; i<num; i++){
        int j = i;
        while (predecessor[j] != ch[j] && predecessor[j] != ch[src] && j >= 0) {
            shortestPath[i] = shortestPath[i] + " -> " + predecessor[j]; 
            j--;
        }
        shortestPath[i] = shortestPath[i] + " -> " + ch[i];

        if(dist[i]!=iMAX)
            cout<<ch[i]<<"\t\t"<<dist[i]<<"\t\t"<<shortestPath[i]<<endl;
            //cout<<ch[i]<<"\t\t"<<dist[i]<<"\t\t"<<predecessor[i]<<endl;
        else
            cout<<ch[i]<<"\t\t"<<"infinity"<<endl;
    }
}

int main(){

    int vn;	    // number of vertices
    int ne;	    // number of edges

    cout << "No. of vertices : ";
    cin >> vn;

    char ch[vn];
    int graph[Max_nodes][Max_nodes];

    for (int i = 0; i < vn; i++){
        cout << "Vertex - " << i+1  << " : " ;
        cin >> ch[i];
    }

    int i,j,k,t;
 
    cout<<"\nEnter number of edges : ";
    cin>>ne;

    for (i=0;i<vn;i++){
	for(j=0;j<vn;j++){
	    graph[i][j] = 0;
	}
    } 
 
    /* Get input */
    for (i=0;i<ne;i++){
        char ch1,ch2;
        int r = 0 ;
        int c = 0;

	//Take vertex input for edge i+1
	cout << "Edge " << i+1 << " : " << endl;
        cout<<"\tFirst vertex" << " : ";
        cin >> ch1;
        cout<<"\tSecond vertex" << " : ";
        cin >> ch2;
        
        //Find corresponding vertex index to entered vertex names 
        for(int k=0; k<vn; k++){
            if ( ch[k] == ch1 )
		        r = k;
            if ( ch[k] == ch2 ) 
		        c = k;
        }

        cout << "\tWeight : ";
        cin>>t;

        graph[r][c]=graph[c][r]=t;
    }

    cout << "    ";
    for(i=0; i<vn; i++){
        cout << ch[i] << " ";
    }
    //Beautify
    cout << "\n   ";
    for(i=0; i<vn; i++){
        cout << "---";
    }
    cout << endl;
    //Print Weight Matrix
    for (i=0;i<vn;i++){
        cout << ch[i] << " |";
        for(j=0;j<vn;j++){
	    cout << " " << graph[i][j] ;
        }
        cout << endl;
    }  
	
    cout << endl;

    dijAlg(graph,ch,0,vn);
    return 0;	                        
}
 
