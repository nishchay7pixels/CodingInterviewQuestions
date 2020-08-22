package Other;
public class MinimumTimeRotOrange {
    
    //Traverse matrix and find 1s[i,j] for which we will check matrix[i-1,j][i+1,j][i,j-1][i,j+1] 
    //be 2 if yes increment repeat till flag = false ie no 1 found
    
    static void printStatus(int[][] matrix, int clock, int M, int N){
        System.out.println("Clock: "+clock);
        for(int i=0;i<M;i++){
            System.out.println("");
            for(int j=0;j<N;j++){
                System.out.print(matrix[i][j]);
            }
        }
    }
    static boolean willRot(int i, int j, int[][] matrix){
        if(matrix[i-1][j]==2)
            return true;
        if(matrix[i+1][j]==2)
            return true;
        if(matrix[i][j-1]==2)
            return true;
        if(matrix[i][j+1]==2)
            return true;
        return false;   
    }
    static int findMinTimeRot(int[][] matrix, int M, int N){
        boolean remainingFlag=true;
        int clock = 0;
        //int orangeRemain =0 ;
        while(remainingFlag){
            int i = 0;
            int j = 0;
            printStatus(matrix, clock, M, N);
            remainingFlag=false;
            for(;i<M;i++){
                for(;j<N;j++){
                    if(matrix[i][j]==1 && willRot(i,j,matrix)){
                        matrix[i][j]=2;
                        remainingFlag = true;
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int [][]matrix = {{2,1,0,2,1},{1,0,1,2,1},{1,0,0,2,1}};
        System.out.println(findMinTimeRot(matrix, 5, 3));
        
    }
}