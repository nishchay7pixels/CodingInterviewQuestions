package DynamicProgramming.KnapsackUnbounded;

public class CoinChangeProblem{
    static int findChangeWays(int[] coins,int index, int total){
        if(index == 0){
            return 0;
        }
        else if(total==0){
            return 1;
        }
        else{
            if(coins[index-1]<=total){
                return (findChangeWays(coins, index, total-coins[index-1])+ 
                findChangeWays(coins, index-1, total));
            }
            else{
                return findChangeWays(coins,index-1, total);
            }
        }
    }

    
    public static void main(String args[]){
        int [] coins = {1,2,3, 5};
        int total = 5;
        System.out.println(findChangeWays(coins,coins.length, total));
    }
    
}