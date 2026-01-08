// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;

class Main {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();   // consume leftover newline


        while (t-- > 0) {
            int n = scanner.nextInt();
            scanner.nextLine();   // consume leftover newline

            String s = scanner.next();


            // Your code goes here s
            char arr[]=s.toCharArray();
            for(int i=0;i<arr.length;i++)
            {
                System.out.println(arr[i]);
            }
        }
    }
}