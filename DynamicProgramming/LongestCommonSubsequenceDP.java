package DynamicProgramming;
//Dynamic Programming Top Down 

public class LongestCommonSubsequenceDP {
    static int findLongestSubsequence(char X[], char Y[], int N, int M, int[][] memo){
        
        for(int i=0;i<=N;i++){
            for(int j=0;j<=M;j++){
                if(i==0 || j==0){
                    memo[i][j]=0;
                }
                else{
                    if(X[i-1]==Y[j-1]){
                        memo[i][j]=1+memo[i-1][j-1];
                    }
                    else{
                        memo[i][j]= Math.max(memo[i-1][j], memo[i][j-1]);
                    }
                }
            }
        }
        return memo[N][M];
    }
    public static void main(String[] args) {
        String s1 = "abcdghr";
        String s2 = "abedfhre";
        char X[] = s1.toCharArray();
        char Y[] = s2.toCharArray();
        int [][] memo = new int[s1.length()+1][s2.length()+1];
        System.out.println("Max Sequence Length: "+findLongestSubsequence(X, Y, X.length, Y.length, memo));

    }
}