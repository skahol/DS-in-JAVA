import java.util.Scanner;
// find min deletion/decrement required in array such that a number x will occur exactly x no. of times

public class MinDeletion {
    public static int minDeletion(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int[] freqArr = new int[max+arr.length];
        for(int i=0;i<freqArr.length;i++){
            freqArr[i] = 0;
        }

        for(int i=0;i<arr.length;i++){
            freqArr[arr[i]] +=1;
        }
        int del=0;
        for(int i=0;i<freqArr.length;i++){
            if(freqArr[i] >i){
                del += freqArr[i]-i;
            }
        }
        return del;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int res = minDeletion(arr);
        System.out.println("Min delete :"+res);
    }
}
