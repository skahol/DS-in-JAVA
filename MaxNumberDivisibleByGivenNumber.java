import java.util.Scanner;

public class MaxNumberDivisibleByGivenNumber {
    public static int divisibleByDiv(int[] arr,int div){
        int divisibleCount=0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max)
                max = arr[i];
            if(arr[i]<min)
                min = arr[i];
        }
        int[] freqArr = new int[max + arr.length];
        int[] negFreqArr = new int[Math.abs(min) + arr.length];
        int p=0,r=0;
        while(true){           // reduce two for loops
            if(p<freqArr.length) {
                freqArr[p] = 0;
                p++;
            }
            if(r<negFreqArr.length){
                negFreqArr[r] = 0;
                r++;
            }
            if(p==freqArr.length && r==negFreqArr.length)
                break;
        }
        // filling freqArr
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=0)
                freqArr[arr[i]] += 1;
            else
                negFreqArr[Math.abs(arr[i])] +=1;
        }
        for(int i=0;i<freqArr.length;i++){
            if(freqArr[i]>0 && i%div==0 ){
                divisibleCount++;
            }
        }
        for(int i=0;i<negFreqArr.length;i++){
            if(negFreqArr[i]>0 && i%div==0){
                divisibleCount++;
            }
        }
        return divisibleCount;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int div = sc.nextInt();
        System.out.println(divisibleByDiv(arr,div));
    }
}
