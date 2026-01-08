//Addition code
public class Operator
{
    public static void main(String[] args)
    {
        int a=15;
        int b=4;

        System.out.println("Addition :"+(a+b));
        System.out.println("Difference:"+(a-b));
        System.out.println("Mult :"+(a*b));
        System.out.println("Remindar :"+(a%b));
        System.out.println("Question :"+(a/b));


        int age=16;
        boolean hasLearnerPermit=true;
        boolean passWritenTest=true;

        if(age>=18 && hasLearnerPermit && passWritenTest)
        {
            System.out.println("Eligible to get driving license");
        }
        else
        {
            System.out.println("Not eligible to get driving license");
        }   

        //used ternery
        String eligibility = (age>=18 && hasLearnerPermit && passWritenTest) ? "Eligible to get driving license" : "Not eligible to get driving license";
        System.out.println(eligibility);

        //Also check if can get leaners permit age>=16 or has special permission
        boolean hasSpecialPermission = false;

        String learnerEligibility = (age >= 16 || hasSpecialPermission) ? "Eligible to get learner's permit" : "Not eligible to get learner's permit";
        System.out.println(learnerEligibility);



    }
}