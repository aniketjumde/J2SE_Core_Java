import java.util.*;

public class Demo
{

    public static int fab(int n){

        if(n==0){
            return 0;
        }
       
       int ans =n+fab(n-1);
       System.out.println(ans);
       return ans;
       
    }

    public static void main(String[] args){
Scanner sc = new Scanner(System.in);
System.out.println("Enter No");
int n=sc.nextInt();
    System.out.println(fab(n));
    }
}