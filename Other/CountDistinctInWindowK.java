package Other;
import java.util.HashMap;


class CountDistinctInWindowK{

    static void debug(int [] arr, int i, int j, HashMap<Integer,Integer> hm){
        while(i<=j){
            System.out.print(arr[i]);
            i++;
        }
        System.out.print("x");
        System.out.println(hm.values());
    }
    static int[] countDistinctWindow(int arr[], int k){
        HashMap <Integer, Integer> hm = new HashMap<Integer,Integer>();        
        
        int solution[] = new int[arr.length-k+1];
        int i=0;
        int j=k-1;
        int l =0;
        while(j<arr.length){
            if(hm.containsKey(arr[i]) && i<=j){
                int cnt = hm.get(arr[i]);
                hm.remove(arr[i]);
                hm.put(arr[i], cnt+1);
                i++;    
            }else{
                hm.put(arr[i], 1);  
                i++; 
            }
            if(i>j){
                
                solution[l] = hm.size();
                i=j-k+1;
                debug(arr, i, j,hm);
                int cnt = hm.get(arr[i]);
                hm.remove(arr[i]);
                if(cnt>1){
                    hm.put(arr[i], cnt-1);
                }
                j+=1;
                i=j;
                l++;
            }
        }
        return solution;
    }
// [1[254]78]
    public static void main(String[] args) {
        int arr[] = {1,2,1,3,4,2,3};
        int k = 4;
        int [] sol = countDistinctWindow(arr, k);
        for(int i=0;i<sol.length;i++){
        System.out.println(sol[i]);
        }
    }
}