package com.tca;

public class innerTry {

    public static void main(String[] args) 
    {
        try   
        {
            int a = 10;
            int b = 0;

            try {
                int ans = a / b;   
                System.out.println("Answer: " + ans);
            }
            catch(ArithmeticException ae)
            {
                ae.printStackTrace();
            }

            try  
            {
                int[] arr = {11, 22, 33, 44};
                System.out.println(arr[5]); 
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                e.printStackTrace();
            }

        }
        catch(Exception ex) 
        {
            ex.printStackTrace();
        }
    }
}
