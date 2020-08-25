package DynamicProgramming.Knapsack01;

//import java.util.Arrays;

//Recursive Code - Without Dynamic Programming
/*
public class knapsacProblem {

    static int solution(int[] wt, int[] val, int bag, int size){
        if(size == 0 || bag==0){
            return 0;
        }
        else if(wt[size-1]<=bag){
            return(Math.max(val[size-1]+solution(wt, val, bag-wt[size-1], size-1), solution(wt, val, bag, size-1)));
        }
        else{
            return(solution(wt, val, bag, size-1));
        }
    }
    public static void main(String[] args) {
        int [] wht = {10,20,30};
        int [] val = {60,100,120};
        int bag = 50;
        System.out.println("Max:"+solution(wht, val, bag, wht.length));
    }
}
*/

//Recursive code - With dynamic Programming using memoization
/*
public class knapsacProblem {

    static int memo[][] = new int[1001][1001];

    static void init(){
        for(int i=0;i<1001;i++){
            for(int j=0;j<1001;j++){
                memo[i][j]=-1;
            }
        }
    }
    static int solution(int[] wt, int[] val, int bag, int size){
        if(memo[bag][size]!=-1){
            return memo[bag][size];
        }
        if(size == 0 || bag==0){
            return 0;
        }
        else if(wt[size-1]<=bag){
            return memo[bag][size]=(Math.max(val[size-1]+solution(wt, val, bag-wt[size-1], size-1), solution(wt, val, bag, size-1)));
        }
        else{
            return memo[bag][size] = (solution(wt, val, bag, size-1));
        }
    }
    public static void main(String[] args) {
        int [] wht = {10,20,30};
        int [] val = {60,100,120};
        int bag = 50;
        init();
        System.out.println("Max:"+solution(wht, val, bag, wht.length));
    }
}

*/

//Recursive code - With dynamic Programming using top-down
public class knapsacProblem {

    static int memo[][] = new int[1001][1001];

    static void init(){
        for(int i=0;i<1001;i++){
            for(int j=0;j<1001;j++){
                memo[i][j]=-1;
            }
        }
    }
    static int solution(int[] wt, int[] val, int bag, int size){
        for(int i=0;i<=size;i++){
            for(int j=0;j<=bag;j++){
                if(i==0 || j==0){
                    memo[i][j]=0;
                }
                else if(wt[i-1]<bag){
                    memo[i][j] = Math.max(val[i-1]+memo[i-1][bag-j] , memo[i-1][j]);
                }
                else{
                    memo[i][j] = memo[i-1][j];
                }        
            }
        }
        return memo[size][bag];
    }
    public static void main(String[] args) {
        int [] wht = {10,20,30};
        int [] val = {60,100,120};
        int bag = 50;
        init();
        System.out.println("Max:"+solution(wht, val, bag, wht.length));
    }
}