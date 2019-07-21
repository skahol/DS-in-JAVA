import java.util.Scanner;
public class DRAWoptimise {
    public static void  rearrange(int[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1)
                    count++;
            }
        }
        int[] hrow = new int[count];
        int[] hcol = new int[count];
        int k=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 1){
                    hrow[k] = i;
                    hcol[k++] = j;
                }
            }
        }
        for(int i=0;i<hrow.length;i++){
            for(int j=0;j<arr.length;j++){
                arr[j][hcol[i]] = 1;
            }
            for(int l=0;l<arr[0].length;l++) {
                arr[hrow[i]][l] = 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] arr = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        rearrange(arr);
    }
}