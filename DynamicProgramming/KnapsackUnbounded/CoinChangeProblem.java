package DynamicProgramming.KnapsackUnbounded;

public class CoinChangeProblem{

    static int memo[][] = new int[5][3]; //[coins+1][total+1]

    static void init(){
        for(int i=0;i<5;i++){
            for(int j=0;j<3;j++){
                memo[i][j] = -1;
            }
        }
    }
    static int findChangeWaysDP(int[] coins,int index, int total){
        
        for(int i=0;i<5;i++){
            for(int j=0;j<3;j++){
                if(j==0){
                    memo[i][j]=1;
                }
                else if(i==0 && j!=0){
                    memo[i][j]=0;
                }
                else{
                    if(coins[i-1]<=j){
                        memo[i][j] = memo[i][j-coins[i-1]]+ memo[i-1][j];
                    }
                    else{
                        memo[i][j] = memo[i-1][j];
                    }
                }
            }
        }
        return memo[4][2];
        
    }

    static int findChangeWaysRecursive(int coins[], int index, int total){
        if(index==0){
            return 0;
        }
        else if(total==0){
            return 1;
        }
        else{
            if(coins[index-1]<=total){
                return (findChangeWaysRecursive(coins, index, total - coins[index-1])+findChangeWaysRecursive(coins, index-1, total));
            }
            else{
                return findChangeWaysRecursive(coins, index-1, total);
            }
        }
    }
/*
    Total
I[100000]
N[100000]
D[100000]
E[100000]
X[100000]
*/
    
    public static void main(String args[]){
        int [] coins = {1,2,3, 5};
        int total = 2;
        System.out.println(findChangeWaysDP(coins,coins.length, total));
        System.out.println(findChangeWaysRecursive(coins,coins.length, total));
    }
    
}