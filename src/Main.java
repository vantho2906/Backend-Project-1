import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = "SE123";
        do {
            try {
                System.out.print("input the id:");
                String in = sc.nextLine();
                in = in.replaceAll("\\D","");
                System.out.println(Integer.parseInt(in));
//                System.out.println(in);
            }catch (Exception e) {
                System.out.println("Integer required");
            }

        }while(true);

//        do {
//            try {
//                System.out.print("input the number:");
//                int number = parseInt(sc.nextLine());
//                System.out.println(number);
//            } catch(Exception e) {
//                System.out.println("Integer required ");
//            }
//        }while(true);
//
    }
}