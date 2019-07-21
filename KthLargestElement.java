import java.util.Scanner;

public class KthLargestElement {
    public static int kthLargestElement(int[] arr,int k){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }

        int[] freqArr = new int[max+arr.length];
        int[] freqNegArr = new int[arr.length+Math.abs(min)];
         for(int i=0;i<max+1;i++){
             freqArr[i]=0;
         }
         for(int i=0;i<freqNegArr.length;i++){
            freqNegArr[i] = 0;
         }

         for(int i=0;i<arr.length;i++){
             if(arr[i]>=0)
                freqArr[arr[i]] +=1;
             else
                 freqNegArr[Math.abs(arr[i])] +=1;
         }
         int l=0;
         int i;
         for( i=freqArr.length-1;i>=0;i--){
             if(freqArr[i]>0){
                 l++;
             }
             if(l == k){
                 return i;
             }
         }
         for( i =1;i<freqNegArr.length;i++){
             if(freqNegArr[i] >0)
                 l++;
             if(l == k)
                 break;
         }
         return -i;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k = sc.nextInt();
        int res = kthLargestElement(arr,k);
        System.out.println("Kth largest element :"+res);
    }
}