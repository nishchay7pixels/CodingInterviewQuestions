//Exponential Time
package Other;
public class PainterProblem {

    private static int sumPartition(int start, int end , int[]arr){
        int sum=0;
        for(int i = start ; i<=end ; i++){
            sum+=arr[i];        
        }
        return sum;
    }
    
    static int painterScheduler(int arr[],int start, int end, int k){
        
        if(k==1){
            return sumPartition(start, end, arr);
        }
        if(end==start){
            return arr[start];
        }
        int best = Integer.MAX_VALUE;
        for(int index=1;index<end;index++){
            best = Math.min(best,Math.max(painterScheduler(arr, start, end-index, k-1), sumPartition(end-index+1, end,arr)));
        }
        
        return best;
          
    }
                    
    //10 20 30 40 k=3
    // Case 1 : 10 / 20 30 40 --- max(k1 , k2) = max(10 , 20/30+40) = 90
    // Case 2 : 10 20 / 30 40 --- max(k1 , k2) = max(10+20 , 30+40) = 70
    // Case 3 : 10 20 30 / 40 --- max(k1 , k2) = max(10+20+30 , 40) = 60
    // min(Case 1 , Case 2 , Case 3) = Case 3 = 60
    public static void main(String[] args) {
        int arr[] = {10 , 20,30,40};
        System.out.print(painterScheduler(arr, 0, arr.length-1, 2));
    }
}
/*
k = 3 SOL[10, 20, 30, 40]
k = 2 min(max(SOL[10, 20, 30] sum[40]) || max(SOL[10 , 20] sum[30 , 40]) || max(SOL[10] sum[20, 30, 40]))
k = 1 min(max(sum[10, 20] sum[30] sum[40])    max(sum[10] sum[20] sum[30, 40])      max(sum[10] sum[20, 30] sum[40])

*/