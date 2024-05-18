package FinalOOPLab;

import java.util.Arrays;
import java.util.Scanner;

public class BasicArrays {
    public static void main(String[] args) {
        int n;
        int max = -999999999;
        int min = 999999999;
        System.out.println("Enter the size of the array : ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] omkar = new int[n];
        for (int i=0;i<n;i++){
            omkar[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            int sum = omkar[i];
            if(omkar[i] > max ){
                max = omkar[i];
            }
            if(omkar[i] < min ){
                min = omkar[i];
            }
        }
        Arrays.sort(omkar);
        System.out.println(Arrays.toString(omkar));
        int[] revOmkar = new int[n];
        for(int i = n-1 ;i >= 0 ;i--){
            revOmkar[n - i - 1] = omkar[i];
        }
        System.out.println(Arrays.toString(revOmkar));
    }
}
