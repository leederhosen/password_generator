package matt.orlinski.projects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {

    public static void main(String[] args)
    {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";

        String allChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers + "";

        Scanner kbd = new Scanner(System.in);
       System.out.println("Generate password? X = Yes O = No");

        String s = kbd.next();
        System.out.println("Enter a length greater than 11: ");
        int len = kbd.nextInt();

        while(len < 12)
        {
            System.out.println("Please enter a length greater than 11: ");
            len = kbd.nextInt();
        }
        String userPass = "";

        if (s.equals("X"))
        {
           userPass = generatePassword(allChars, len);
            System.out.println("Password Stored");
            System.out.println("Show password? X = Yes O = No");
            s = kbd.next();

            if(s.equals("X"))
            {
                System.out.println(userPass);

            }
            else {
                for(int i = 0; i < userPass.length(); i++)
                {
                    System.out.print("*");
                }

            }
        }
        else
        {
            userPass = kbd.next();
            System.out.println("Password Stored");
            System.out.println("Show password? X = Yes O = No");
            s = kbd.next();

            if(s.equals("X"))
            {
                System.out.println(userPass);

            }
            else {
                for(int i = 0; i < userPass.length(); i++)
                {
                    System.out.print("*");
                }

            }
        }

    }
    public static String generatePassword(String s, int y)
    {
        String password = "";
        int max = s.length();
        int min = 1;



        for(int i = 0; i < y; i++)
        {
            double n = (Math.random()*(max - min) + min);
            int x = (int) n;
            password = password + s.charAt(x) + "";
        }


        Pattern patternSpecChars = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcherSpecChars = patternSpecChars.matcher(password);

        boolean b = matcherSpecChars.find();

        if(b == false)
        {
            String specialCharacters = "!@#$";
            max = specialCharacters.length();
            double n = (Math.random()*(max - min) + min);
            int x = (int) n;
            password = password + specialCharacters.charAt(x);

        }



        return password;
    }
}
