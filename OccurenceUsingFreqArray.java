import java.util.Scanner;

public class OccurenceUsingFreqArray {
    public static int[] occurenceOfNumber(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        int[] freqArr = new int[max+1];
        for(int i=0;i<max+1;i++){
            freqArr[i]=0;
        }
        for(int i=0;i<arr.length;i++){
            freqArr[arr[i]] += 1;
        }
        return freqArr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int[] freqArr = occurenceOfNumber(arr);
        for(int i=0;i<freqArr.length;i++){
            System.out.println(i+"--->"+freqArr[i]);
        }
    }
}