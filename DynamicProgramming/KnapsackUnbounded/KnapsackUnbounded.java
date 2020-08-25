package DynamicProgramming.KnapsackUnbounded;

//Recursive Solution
public class KnapsackUnbounded{
static int [] memo = new int [5];
/*
if(memo[index]!=-1){
    return memo[index-1];
}
if(index =0 || K=0)
return 0
else
if wt[index]<givenWt
take element - memo[index-1] = max(val[index-1]+getMaxVal(wt, val, index, K-wt[index-1]),getMaxVal(wt, val, index-1, K))
return memo[index-1]
else 
memo[index-1] = getMaxVal(wt, val, index-1, K)
return memo[index-1]
*/

    static int getMaxValMemoisation(int[] wt, int[] val, int index, int K){
        if(K==0||index==0){
            return 0;
        }
        if(memo[index-1]!=-1){
            return memo[index-1];
        }
        else{
            if(wt[index-1]<=K){
                memo[index-1] = Math.max(val[index-1]+getMaxValMemoisation(wt, val, index, K-wt[index-1]),
                                        getMaxValMemoisation(wt, val, index-1, K));
                return memo[index-1];
            }
            else{
                memo[index-1] = getMaxValMemoisation(wt, val, index-1, K);
                return memo[index-1];
            }
        }
    }
    static int getMaxValRecursive(int[] wt, int[] val, int index, int K){
        if(index == -1 || K==0){
            return 0;
        }
        else if(wt[index]<=K){
            return Math.max(val[index]+getMaxValRecursive(wt, val, index, K-wt[index]), getMaxValRecursive(wt, val, index-1, K));
        }
        return getMaxValRecursive(wt, val, index-1, K);
    }
    static void init(){
        for(int i=0;i<memo.length;i++){
            memo[i]=-1;
        }
    }
    public static void main(String args[]){
        int wt[] = {10,20,30,40};
        int val[] = {1,5,4,7};
        int K=30;
        init();
        System.out.println(getMaxValRecursive(wt,val, wt.length-1, K)); // pass wt.length-1 for recursive and wt.length for DP
        System.out.println(getMaxValMemoisation(wt,val, wt.length, K));
    }
}