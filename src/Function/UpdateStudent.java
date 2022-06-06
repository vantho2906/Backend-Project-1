package Function;

import Student_management.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UpdateStudent {
    private static final Scanner sc = new Scanner(System.in);
    public static int inputId(String message, ArrayList<Student> list) {
        String input;
        do {
            System.out.println(message);
            input = sc.nextLine();
            for(int i=0;i<list.size();i++) {
                if(input.equals(list.get(i).getId())) {
                    return i;
                }
            }
            System.out.println("Id doesn't exist");

        } while(true);
    }
    public static char change(String name,String pattern) {
        System.out.println("You want to change your " + name + "?(y/n)");
        do {
            String input = sc.nextLine();
            if (input.matches(pattern)) {
                if (input.charAt(0) == 'n') return 'n';
                else if(input.charAt(0) == 'y')return 'y';
            }
            System.out.println("Wrong input");
        } while (true);
    }
    public static char change(String pattern) {
        do {
            String input = sc.nextLine();
            if (input.matches(pattern)) {
                if (input.charAt(0) == 'n') return 'n';
                else if(input.charAt(0) == 'y')return 'y';
            }
                System.out.println("Wrong input");
        } while (true);
    }


}
