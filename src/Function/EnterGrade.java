package Function;

import Student_management.Transcript;
import Utilities.Validation;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class EnterGrade extends Validation {
    double labs;
    double progressTests;
    double finalTest;
    double average;
     Scanner sc = new Scanner(System.in);

    public void askAndOverwriteGrade (ArrayList<Transcript> list,int i) {
        if(change("labs","[YyNn][ ]*")== 'y') {
            labs = inputGrade("change labs grade:");
            list.get(i).setLabs(labs);
        }

        if(change("progressTests","[YyNn][ ]*")=='y') {
            progressTests = inputGrade("change progressTests grade:");
            list.get(i).setProgressTests(progressTests);
        }

        if(change("finalTest","[YyNn][ ]*")=='y') {
            finalTest = inputGrade("change finalTest grade:");
            list.get(i).setFinalTest(finalTest);
        }
        average =(labs+progressTests+finalTest)/3;
        average = parseDouble(String.format("%.1f",average));
        list.get(i).setAverage(average);
    }
    public char change(String name,String pattern) {
        System.out.println("You want to change your " + name + " grade(y/n)");
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
