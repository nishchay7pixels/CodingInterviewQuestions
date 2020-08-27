package DynamicProgramming.KnapsackUnbounded;

//Given - A rod of 8 Meter. Divide it into parts such that the profit made should be maximized
//Size of each length is sell at different price as below,
//LENGTH[1,2,3,4,5,6,7,8]
//PRICE [1,5,8,9,10,17,17,20]
public class RodCuttingProblem {
    static int memo[][] = new int [1001][1001];
    static int calls=0;
    static int rodCuttingProblemRecursive(int length[], int price[], int index, int rodSize){
        calls++;
        if(rodSize==0||index==-1)
            return 0;
        else{
            if(length[index]<=rodSize){
                return Math.max(price[index]+rodCuttingProblemRecursive(length, price, index, rodSize-length[index]),
                                rodCuttingProblemRecursive(length, price, index-1, rodSize));
            }
            else{
                return rodCuttingProblemRecursive(length, price, index-1, rodSize);
            }
        }
    }

    static int rodCuttingProblemMemoisation(int length[], int price[], int index, int rodSize){
        calls++;
        if(index==-1||rodSize==0){
            return 0;
        }
        else if(memo[index][rodSize]!=-1){
            return memo[index][rodSize];
        }
        else{
            if(length[index]<=rodSize){
                memo[index][rodSize] = Math.max(price[index]+rodCuttingProblemMemoisation(length, price, index, rodSize-length[index])
                    ,rodCuttingProblemMemoisation(length, price, index-1, rodSize));
                return memo[index][rodSize];
            }
            else{
                memo[index][rodSize] = rodCuttingProblemMemoisation(length, price, index-1, rodSize);
                return memo[index][rodSize];
            }
        }
    }
    static void initMemo(){
        for(int i=0;i<1001;i++){
            for(int j=0;j<1001;j++){
                memo[i][j]=-1;
            }
        }
    }
    public static void main(String args[]){
        int length[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int rodSize = 8;
        System.out.println(rodCuttingProblemRecursive(length, price, length.length-1, rodSize)+ " in "+calls+" calls");
        initMemo();
        calls=0;
        System.out.println(rodCuttingProblemMemoisation(length, price, length.length-1, rodSize)+ " in "+calls+" calls");
    }
}