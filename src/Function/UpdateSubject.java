package Function;

import Student_management.Student;
import Student_management.Subject;

import java.util.ArrayList;
import java.util.Scanner;

public class UpdateSubject {
    private static final Scanner sc = new Scanner(System.in);
    public static int inputId(String message, ArrayList<Subject> list) {
        String input= null;
        do {
            System.out.println(message);
            input = sc.nextLine();
            for(int i=0;i<list.size();i++) {
                if(list.get(i).getId().equals(input))
                    return i;
            }
            System.out.println("Id doesn't exist");

        } while(true);
    }

    public static char change(String name,String pattern) {
        System.out.println("You want to change your " + name + " ()y/n");
        do {
            String input = sc.nextLine();
            if (input.matches(pattern)) {
                if (input.charAt(0) == 'n') return 'n';
                return 'y';
            } else {
                System.out.println("Wrong input");
            }
        } while (true);
    }
}
