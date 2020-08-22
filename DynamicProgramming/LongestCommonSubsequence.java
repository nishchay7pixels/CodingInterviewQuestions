//Recursive solution with memoisation
package DynamicProgramming;

public class LongestCommonSubsequence {
    static int [][]memo = new int[1000][1000];
    static void init(){
        for(int i=0;i<1000;i++){
            for(int j=0;j<1000;j++){
                memo[i][j]=-1;
            }
        }
    }
    static int findLongestSubsequence(char X[], char Y[], int N, int M){
        if(memo[N][M]!=-1){
            return memo[N][M];
        }
        else{
            if(N==0 || M==0){
                memo[N][M]=0;
                return memo[N][M];
            }
            else{
                if(X[N-1]==Y[M-1]){
                    memo[N][M] = 1 + findLongestSubsequence(X, Y, N-1, M-1);
                }
                else{
                    memo[N][M] = Math.max(findLongestSubsequence(X, Y, N-1, M), findLongestSubsequence(X, Y, N, M-1));
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
        init();
        System.out.println("Max Sequence Length: "+findLongestSubsequence(X, Y, X.length, Y.length));

    }
}