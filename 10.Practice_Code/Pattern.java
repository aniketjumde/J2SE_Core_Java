public class Pattern
{
    public static void main(String[] args)
    {
        
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<i+1;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();


        for(int i=5;i>0;i--)
        {
            for(int j=0;j<i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

                    System.out.println();


        for(int i=0;i<5;i++)
        {
            for(int j=0;j<i+1;j++)
            {
                System.out.print(i+1);
            }
            System.out.println();
        }
        
        System.out.println();

         for(int i=5;i>0;i--)
        {
            for(int j=0;j<i;j++)
            {
                System.out.print(i);
            }
            System.out.println();
        }



        int n = 5;
            
            // Upper half of diamond
            for(int i=1;i<=n;i++)
            {
                for(int sp=1;sp<=n-i;sp++)
                {
                System.out.print(" ");
                }
                for(int j=1;j<=2*i-1;j++)
                {
                System.out.print("*");
                }
                System.out.println();
            }
            
            // Lower half of diamond
            for(int i=n-1;i>=1;i--)
            {
                for(int sp=1;sp<=n-i;sp++)
                {
                System.out.print(" ");
                }
                for(int j=1;j<=2*i-1;j++)
                {
                System.out.print("*");
                }
                System.out.println();
            }
            
            System.out.println();
    }

    


  
}