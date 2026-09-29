import java.util.Scanner;

class DivideByZeroException extends RuntimeException
{
    DivideByZeroException(String msg)
    {
    super(msg);
    }
}
public class Calculator 
{
    public static double calculate(double a,double b,char op)throws DivideByZeroException
    {
        switch(op)
        {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                if(b==0){
                    throw new DivideByZeroException("can not divde by zero");
                }
                return a/b;
            default: throw new IllegalArgumentException("Invalid operator!");
        }
    }

    

    public static void main(String[] args) {
    
    Scanner sc=new Scanner(System.in);
    boolean success=false;

    while(!success){
   
    try{
     System.out.println("enter a number1:");
    double n1=Double.parseDouble(sc.nextLine());

    System.out.println("enter a number2:");
    double n2=Double.parseDouble(sc.nextLine());

    System.out.println("enter a operator(+,-,*,/)");
    char o=sc.nextLine().charAt(0);

    double res=calculate(n1,n2,o);

    System.out.println("result is: "+res);
    success=true;
    }
    catch(NumberFormatException n){
        System.out.println("invaild number!!");
    }
    catch(DivideByZeroException d)
    {
        System.out.println("divide by zero exception");
    }
    catch(IllegalArgumentException i)
    {
        System.out.println("error"+i.getMessage());
    }
    finally{
        System.out.println("calculations complete");
    }
    }
    sc.close();
    System.out.println("thank you for using calculator");
}
}