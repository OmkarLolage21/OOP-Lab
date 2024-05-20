package FinalOOPLab;

import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println("Length of the String is " + s.length());
        System.out.println("Uppercase conversion of String is " + s.toUpperCase());
        System.out.println("Lowercase conversion of String is " + s.toLowerCase());
        System.out.println("Enter a string to concatenate: ");
        String so = sc.nextLine();
        s = s.concat(so);
        System.out.println("Concatenation of both Strings is " + s );
        System.out.println("Enter a substring: ");
        String sub = sc.nextLine();
        System.out.println(s.contains(sub));
        System.out.println("Enter a substring to be replaced: ");
        String replace = sc.nextLine();
        System.out.println(s.replace(replace,sub));

    }
}
