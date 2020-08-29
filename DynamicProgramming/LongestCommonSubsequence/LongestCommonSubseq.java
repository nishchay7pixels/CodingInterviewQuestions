package DynamicProgramming.LongestCommonSubsequence;

public class LongestCommonSubseq {

    static int memo[][] = new int [7][8]; //indexX+1, indexY+1
    static void initMemo(){
        for(int i=0;i<7;i++){
            for(int j=0;j<8;j++){
                if(i==0 || j ==0){
                    memo[i][j] = 0;
                }
                else{
                    memo[i][j] = -1;
                }
            }
        }
    }
    static int longestCommonSubsequenceDynamic(String X[], String Y[], int indexX, int indexY){
        if(X.length==0 || Y.length==0){
            return 0;
        }
        else{
            for(int i=1;i<7;i++){
                for(int j=1;j<8;j++){
                    if(X[i-1].equals(Y[j-1])){
                        memo[i][j] = memo[i-1][j-1]+1; 
                    }
                    else{
                        memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
                    }
                }
            }
        }
        return memo[6][7];
    }
    static int longestCommonSubsequenceRecursive(String X[], String Y[], int indexX, int indexY){
        if(indexX==0 || indexY==0){
            return 0;
        }else{
            if(X[indexX-1].equals(Y[indexY-1])){
                
                return (1 + longestCommonSubsequenceRecursive(X, Y, indexX-1, indexY-1));
            }else{
                
                return  Math.max(longestCommonSubsequenceRecursive(X, Y, indexX-1, indexY),
                longestCommonSubsequenceRecursive(X, Y, indexX, indexY-1));
            }
        }
    }
    public static void main(String args[]){
        String a = "abcagh";
        String b = "abedflm";
        String X[] = a.split("");
        String Y[] = b.split("");
        System.out.println(longestCommonSubsequenceRecursive(X, Y, X.length,Y.length));
        initMemo();
        System.out.println(longestCommonSubsequenceDynamic(X, Y, X.length,Y.length));
    }
}