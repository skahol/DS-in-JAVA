import java.util.Arrays;
import java.util.Scanner;
public class OccurenceIntNumber {
    public static void occurenceOfNumber(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        int count=1;
        int i;
        for( i=0;i<n;i++){
            if(arr[i] == arr[i+1] && i!=n-1){
                count++;
            }
            else{
                System.out.println("Occurence of "+ arr[i] +"="+count);
                count=1;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        occurenceOfNumber(arr);
    }
}
