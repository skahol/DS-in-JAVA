import java.util.Scanner;
// min increment in array to make every element distinct in array
public class DistinctELements {
    public static int[] distinctElement(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }
       // min = -min;     // for negative value freq array
        int[] freqArr = new int[arr.length+max];
        int[] negFreqArr = new int[arr.length+Math.abs(min)];

        for(int i=0;i<freqArr.length;i++){
            freqArr[i] = 0;
        }
        for(int i=0;i<negFreqArr.length;i++){
            negFreqArr[i] = 0;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=0){
                freqArr[arr[i]] +=1;
            }
            else {
                negFreqArr[Math.abs(arr[i])] += 1;
            }
        }
        int count = 0;      // min increment
        /********solution for whole number in array************
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] == arr[j]){
                    while(freqArr[arr[j]]>1){
                        freqArr[arr[j]] -= 1;
                        count++;
                        arr[j] +=1;
                        freqArr[arr[j]] += 1;
                    }
                }
            }
        }*****************************************************/
        //solution for integers + atleast one positive integer in array
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                while(arr[i] == arr[j]){
                    if(arr[j]<0 && negFreqArr[Math.abs(arr[j])]>1){
                        negFreqArr[Math.abs(arr[j])] -=1;
                        count++;
                        if(arr[j] == -1){
                            arr[j] +=1;
                            freqArr[0]+=1;
                            break;
                        }
                        arr[j] +=1;
                        negFreqArr[Math.abs(arr[j])] +=1;
                    }
                    if(arr[j]>=0 && freqArr[arr[j]]>1){
                        freqArr[arr[j]] -= 1;
                        count++;
                        arr[j] +=1;
                        freqArr[arr[j]] += 1;
                    }
                }
            }
        }
        System.out.println("count->"+count+"\n");
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int[] array= distinctElement(arr);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}
