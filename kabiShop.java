import java.io.*;
import java.util.*;

public class kabiShop 
{
    public static void main(String args[])
    {
        boolean open = false;
        int aKirby = 0 ;
        int bKirby = 0 ;
        int cKirby = 0 ;
        int money = 0 ;
        int inputOptions ;
        System.out.println("//////////Welcome to NCKU-PD1-Kirby-Shop\\\\\\\\\\\\\\\\\\\\");
        Scanner scanner = new Scanner(System.in);
        do
        {
            System.out.println("Options: (1)Openning (2)List (3)Adding (4)Exit");
            inputOptions = scanner.nextInt();
            switch (inputOptions) 
            {
                case 1:
                    if(open)
                    {
                        System.out.println("Your Kirby shop has already opened :(");
                    }
                    else
                    {
                        open = true ;
                        System.out.println("Your shop is openning!");
                    }
                    break;
                case 2:
                    if(open)
                    {
                        System.out.println("===================================");
                        System.out.println("Kirby-A: "+aKirby);
                        System.out.println("Kirby-B: "+bKirby);
                        System.out.println("Kirby-C: "+cKirby);
                        int totalkirby = totalKirby(aKirby,bKirby,cKirby);                       
                        System.out.println("Kirby: "+totalkirby+", Money: "+money);
                        System.out.println("===================================");
                    }
                    else
                    {
                        System.out.println("Your shop is openning!");
                    }
                    break;
                case 3:
                    if(open)
                    {
                        System.out.print("Please enter three numbers: ");
                        int a = 0, b = 0, c = 0;
                        boolean validInput = false;
                        boolean enterError = false;
                        while (!validInput) 
                        {
                            try
                            {
                                a = scanner.nextInt();
                                b = scanner.nextInt();
                                c = scanner.nextInt();
                                if(a > 0 && b > 0 && c > 0)
                                {
                                    validInput = true; 
                                }
                                else if(enterError && a == -1 && b == -1 && c ==-1)
                                {
                                    
                                    break;
                                }
                                else
                                {
                                    System.out.print("Error: Please try again or enter '-1 -1 -1' to make a new options: ");
                                    scanner.nextLine();
                                    enterError = true ;
                                }
                            }
                            catch (InputMismatchException e) 
                            {
                                System.out.print("Error: Please try again or enter '-1 -1 -1' to make a new options: ");
                                scanner.nextLine(); 
                                enterError = true ;
                            }
                        }
                        if(validInput)
                        {
                            int maxBox = max(a, b, c);
                            int aInOneBox = a/maxBox ;
                            int bInOneBox = b/maxBox ;
                            int cInOneBox = c/maxBox ;
                            int price = money(a, b, c, maxBox);
                            System.out.println("Divide these Kirbys into "+maxBox+" boxes, with the number of Kirby in each box being "+aInOneBox+", "+bInOneBox+", and "+cInOneBox);
                            System.out.println("Price: "+price);
                            aKirby += a;
                            bKirby += b;
                            cKirby += c;
                            money += price;
                        }
                        
                    }
                    else
                    {
                        System.out.println("Your Kirby shop has not opened");
                    }

                    break;

                case 4:

                    break;
                
                default:
                    System.out.println("Error: Please try again!");
                    break;
            }
        }
        while(inputOptions!=4);
    }

    public static int totalKirby(int aKirby , int bKirby ,int cKirby)
    {
        int total = aKirby+bKirby+cKirby;
        return total;
    }

    public static int money(int aKirby , int bKirby ,int cKirby , int maxBox)
    {
        if(aKirby>0 || bKirby >0 || cKirby>0)
        {
            int total = (aKirby+bKirby+cKirby)-2*maxBox;
            return total;
        }
        else
        {
            return 0 ;
        }
        
    }

    public static int max(int aKirby , int bKirby ,int cKirby)
    {
        int minNumber=Math.min(aKirby, Math.min(bKirby, cKirby));
        int maxBox = 0 ;
        for(int i = 1 ; i <= minNumber ; i++)
        {
            if(aKirby % i == 0 && bKirby % i == 0 && cKirby % i == 0)
            {
                maxBox = i ;
            }
        }
        return maxBox;
    }
    
}

