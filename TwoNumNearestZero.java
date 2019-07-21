import java.util.Arrays;
import java.util.Scanner;

public class TwoNumNearestZero {
    public static void nearestToZero(int[] arr){
        // sorting array
        // initialise l=0, r=n-1;
        // sum = arr[l]+arr[r];
        // if sum is +ve r--;
        // if sum is -ve l++;
        // while loop till l<r
        Arrays.sort(arr);
        int n = arr.length;
        int sum ;
        int l=0, r = n-1;
        while(l < r){
            sum = arr[l]+arr[r];
            if(sum<0)
                l++;
            else if(sum>0)
                r--;
            else
                break;
        }
        System.out.println(arr[l]+" "+arr[r]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        nearestToZero(arr);
    }
}
