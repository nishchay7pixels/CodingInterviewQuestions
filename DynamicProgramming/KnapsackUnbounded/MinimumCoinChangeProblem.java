package DynamicProgramming.KnapsackUnbounded;

public class MinimumCoinChangeProblem {
    static int memo[][] = new int[4][6];//index+1 , sum+1
    static void init(int coins[]){
        for(int i=0;i<4;i++){
            for(int j=0;j<6;j++){
                if(i==0){
                    memo[i][j] = Integer.MAX_VALUE; // if coins bag is empty to make any sum we need infinite coins
                }else if(j==0 && i!=0){
                    memo[i][j] = 0;
                }
                else if(j%coins[i]==0 && i==1){
                    memo[i][j] = 1;
                }
                else{
                    memo[i][j] = -1;
                }
            }
        }
    }

    static int minCoinNeededDynamic(int[] coins, int sum){
        
        for(int i=0;i<4;i++){
            for(int j=0;j<6;j++){
                if(i==0){
                    memo[i][j] = Integer.MAX_VALUE; // if coins bag is empty to make any sum we need infinite coins
                }else if(j==0 && i!=0){
                    memo[i][j] = 0;
                }
                else if(j%coins[i-1]==0 && i==1 && j!=0){
                    memo[i][j] = j/coins[i-1];
                }
                else if(j%coins[i-1]!=0 && i==1 && j!=0){
                    memo[i][j] = Integer.MAX_VALUE;
                }
                else{
                    if(coins[i-1]<=j){
                        memo[i][j] = Math.min(1+memo[i][j-coins[i-1]], 
                        memo[i-1][j]);
                    }
                    else{
                        memo[i][j] = memo[i-1][j];
                    }
                }
            }
        }
        return memo[3][5];
    }

    static int minCoinNeededRecursive(int[] coins, int index, int sum){
        if(index==0){
            return Integer.MAX_VALUE-1;
        }
        else if(sum==0){
            return 0;
        }
        else{
            if(coins[index-1]<=sum){
                return Math.min(1+minCoinNeededRecursive(coins, index, sum-coins[index-1]),
                        minCoinNeededRecursive(coins, index-1, sum));
            }else{
                return minCoinNeededRecursive(coins, index-1, sum);
            }
        }
    }
    public static void main(String args[]){
        int coins[] = {1,2,3};
        int sum = 5;
        //init(coins);
        System.out.println(minCoinNeededRecursive(coins, coins.length, sum));
        System.out.println(minCoinNeededDynamic(coins, sum));
    }
}