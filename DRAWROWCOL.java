import java.util.*;
import java.lang.*;
// make copy of array then make changes in new array
public class DRAWROWCOL {
    public static void rearrange(int[][] arr){
        int r = arr.length;
        int c = arr[0].length;
        int[][] narr = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                narr[i][j] = arr[i][j];
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(narr[i][j] == 1){
                    for(int k=0;k<c;k++)
                        arr[i][k] = 1;
                    for(int l=0;l<r;l++)
                        arr[l][j] = 1;
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
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
