package ca.bcit.comp1510.personal_projects;

import java.util.Scanner;

/**
 * TestStrings.
 *
 * @author Andy Loi, Set B
 * @version 1.0
 */
public class TestStrings {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String test = "4+5+4";
        char plus = '+';
        char replaced = 'A';
        test = test.replace(plus, replaced);
        System.out.println(test);
        Scanner scan = new Scanner(test);
        scan.useDelimiter("A|B|C|D");
        System.out.println(scan.nextInt());
    }

}
