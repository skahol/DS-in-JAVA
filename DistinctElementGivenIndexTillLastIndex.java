import java.util.Scanner;
// WAP to generate query for number of distinct element from given index till last index in an array
public class DistinctElementGivenIndexTillLastIndex {
    public static void distinctElement(int[] arr,int[] query) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int q = 0;q<query.length;q++) {
            for (int i = query[q]-1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                if(arr[i] < min){
                    min = arr[i];
                }
            }
            int[] freqArr = new int[max + arr.length];
            int[] negFreqArr = new int[Math.abs(min)+ arr.length];
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
            for(int i=query[q]-1;i < arr.length;i++){
                if(arr[i]>=0)
                    freqArr[arr[i]] +=1;
                else
                    negFreqArr[Math.abs(arr[i])] +=1;
            }
            int count=0;
            for (int i = query[q]-1; i < arr.length; i++) {
                if(arr[i]>=0 && freqArr[arr[i]] == 1){
                    count++;
                }
                else if(arr[i]<0 && negFreqArr[Math.abs(arr[i])] == 1)
                    count++;
            }
            System.out.println("Distinct element from index "+(query[q]-1)+" :"+count);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int q =sc.nextInt();
        int[] query = new int[q];
        for(int i=0;i<q;i++){
            query[i] = sc.nextInt();
        }
        distinctElement(arr,query);
    }
}
