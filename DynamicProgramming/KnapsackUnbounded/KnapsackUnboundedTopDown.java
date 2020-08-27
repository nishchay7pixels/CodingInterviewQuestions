package DynamicProgramming.KnapsackUnbounded;

//TOP Down solution ---- Need FIX
public class KnapsackUnboundedTopDown{
static int [][] memo = new int [5][31]; //[index][weight]
/*
memo x-axis hold index y-axis hold capacity
if capactity = 0 thus nomatter what is the index return 0;
if no element then no matter what capacity return 0 
*/

    static int getMaxValTopDown(int[] wt, int[] val, int index, int bag){
        
        for(int i=1;i<5;i++){
            for(int j=1;j<31;j++){
                if(wt[i-1]<=bag){
                    memo[i][j] = Math.max(val[i-1]+memo[i-1][bag-j] , memo[i-1][j]);
                }
                else{
                    memo[i][j] = memo[i-1][j];
                }   
            }      
        }
        return memo[4][30];
    }

    static void init(){
        for(int i=0;i<5;i++){
            for(int j=0;j<31;j++){
                if(i==0||j==0){
                    memo[i][j]=0;
                }
                else{
                    memo[i][j]=-1;
                }
            }
        }
    }
    public static void main(String args[]){
        int wt[] = {10,30,40,20};
        int val[] = {1,5,4,7};
        int K=30;
        init();
        System.out.println(getMaxValTopDown(wt,val, wt.length, K)); // pass wt.length-1 for recursive and wt.length for DP
        
    }
}