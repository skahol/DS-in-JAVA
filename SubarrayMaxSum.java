import java.util.Scanner;

public class SubarrayMaxSum {
    public static int[] subarrayMaxSum(int[] arr, int x){
        int[] subArr = new int[x];
        int sum;
        int max = Integer.MIN_VALUE;        // MAX CAN'T BE INTIALISE ZERO FOR NEG ARRAY
        for(int i=0;i<=arr.length - x;i++){
            sum=0;
            for(int j=i;j<i+x;j++){
                sum += arr[j];
            }
            if(sum>max){
                max = sum;
                int k=0;
                for(int j=i;j<i+x;j++){
                    subArr[k++] = arr[j];
                }
            }
        }
        return subArr;
    }
    public static void print(int[] subarr){
        for(int i=0;i<subarr.length;i++){
            System.out.print(subarr[i] +" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        int[] subArr = subarrayMaxSum(arr,x);
        print(subArr);
    }
}
