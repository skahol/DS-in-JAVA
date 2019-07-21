import java.util.Scanner;

public class MinDeletionModify {
    public static int minDeletionModify(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int[] freqArr = new int[max+arr.length];
        for(int i=0;i<max+1;i++){
            freqArr[i]=0;
        }
        for(int i=0;i<arr.length;i++){
            freqArr[arr[i]] +=1;
        }
        int dummy = freqArr[min];
        int del=0;
        for(int i=0;i<freqArr.length;i++){
            if(freqArr[i]>0){
                if(freqArr[i] >dummy){
                    del += freqArr[i]-dummy;
                }
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
        int res = minDeletionModify(arr);
        System.out.println("Min delete :"+res);
    }
}
