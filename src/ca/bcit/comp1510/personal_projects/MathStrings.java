/**
 * 
 */
package ca.bcit.comp1510.personal_projects;

import java.util.Scanner;

/**
 * @author AL
 *
 */
public class MathStrings {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter math expression: ");
        String input = scan.nextLine();
        input = input.trim();
        
        int x = 0;
        int y = 0;
        int add = input.indexOf("+");
        int subtract = input.indexOf("-");
        int multiply = input.indexOf("*");
        int divide = input.indexOf("/");
        int openBracket = input.indexOf("(");
        int closeBracket = input.indexOf(")");
        
        if (add > 0) {
            x = Integer.parseInt(input.substring(0, add));
            y = Integer.parseInt(input.substring(add + 1, add +2));
            System.out.println(x+y);
        }
        if (subtract > 0) {
            x = Integer.parseInt(input.substring(0, subtract));
            y = Integer.parseInt(input.substring(subtract + 1, subtract +2));
            System.out.println(x-y);
        }
        if (multiply > 0) {
            x = Integer.parseInt(input.substring(0, multiply));
            y = Integer.parseInt(input.substring(multiply + 1, multiply +2));
            System.out.println(x*y);
        }
        if (divide > 0) {
            x = Integer.parseInt(input.substring(0, divide));
            y = Integer.parseInt(input.substring(divide + 1, divide +2));
            System.out.println(x/y);
        }
        
        System.out.println("...Done.");
       
        scan.close();
    }

}
