package DynamicProgramming.Knapsack01;

import java.util.ArrayList;

//using recursion
public class SubsetDifference {

    static int sum(ArrayList<Integer> ar){
        int result=0;
        for(int i=0;i<ar.size();i++){
            result = result+ar.get(i);
        }
        return result;
    }

    static int minimumSum(int[] arr,int currentIndex, ArrayList<Integer> s1, ArrayList<Integer> s2){
        if(currentIndex==arr.length){
            return Math.abs((sum(s1)-sum(s2)));
        }
        else{
            s1.add(arr[currentIndex]);
            return Math.min(minimumSum(arr, currentIndex+1, s1, s2),minimumSum(arr, currentIndex+1, s2, s1));
        }
    }
    public static void main(String[] args) {
        int arr[] = {2,11,10,5};
        System.out.println(minimumSum(arr, 0, new ArrayList<Integer>(), new ArrayList<Integer>()));
    }   
}