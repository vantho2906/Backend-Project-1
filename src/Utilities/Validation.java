package Utilities;

import Student_management.Student;
import Student_management.Subject;

import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    private static Scanner scanner = new Scanner(System.in);
    public int InputInteger(int maxnum) {
        while(true) {
            try {
                int number = parseInt(scanner.nextLine());
                if(number<0 || number >maxnum) {
                    System.out.println("Number available from 1 to "+maxnum);
                    System.out.println("Choose an option again:");
                }
                else {
                    return number;
                }
            } catch(Exception e) {
                System.out.println("Integer required");
                System.out.println("Choose an option again:");
            }
        }
    }

    public static int inputInteger(String message) {
        int number = 0;
        do {
            try {
                System.out.print(message);
                number = parseInt(scanner.nextLine());
                return number;
            } catch (Exception e) {
                System.out.println("Required Integer!");
            }
        } while (true);
    }

    public static int inputCredit(String message) {
        int number = 0;
        do {
            try {
                System.out.print(message);
                number = parseInt(scanner.nextLine());
                if(number<=0) {
                    throw new Exception("credit is a positive number");
                }
                return number;
            } catch (Exception e) {
                System.out.println("Required Integer!");
            }
        } while (true);
    }

    public static double inputGrade(String message) {
        double grade = 0;
        do {
            try {
                System.out.print(message);
                grade = parseDouble(scanner.nextLine());
                if(grade>10 || grade<0) {
                    throw new Exception("grade must be between 0 and 10");
                }
                return parseDouble(String.format("%.1f",grade));
            } catch (Exception e) {
                System.out.println("Required Double!");
            }
        } while (true);
    }

    public static float inputFloat(String message) {
        float number = 0;
        do {
            try {
                System.out.print(message);
                number = parseFloat(scanner.nextLine());
                return number;
            } catch (Exception e) {
                System.out.println("Required Float!");
            }
        } while (true);
    }

    public static double inputDouble(String message) {
        double number = 0;
        do {
            try {
                System.out.print(message);
                number = parseDouble(scanner.nextLine());
                return number;
            } catch (Exception e) {
                System.out.println("Required Double!");
            }
        } while (true);
    }



    public static String inputIdSubject(String message, ArrayList<Subject> list) {
        String input = null;
        do {
            try {
                System.out.print(message);
                input = scanner.nextLine();
                if (input.isEmpty()) {
                    throw new Exception("Required a string");
                }
                for(Subject i :list) {
                    if(i.getId().equals(input))
                        throw new Exception("Id existed");
                }

                return input;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
    public static String inputPhoneNumber(String message, String pattern) {
        String input = null;
        do {
            try {
                System.out.print(message);
                input = scanner.nextLine();
                if (!input.matches(pattern) && !pattern.equals("")) {
                    throw new Exception("10 numbers only and no alphabet character");
                }
                if (input.isEmpty()) {
                    throw new Exception("Required a string");
                }
                return input;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static String inputIdStudent(String message, String pattern, ArrayList<Student> list) {
        String input = null;
        do {
            try {
                System.out.print(message);
                input = scanner.nextLine();
                if (!input.matches(pattern) && !pattern.equals("")) {
                    throw new Exception("Id must be SExxx(3 numbers)");
                }
                if (input.isEmpty()) {
                    throw new Exception("Required a string");
                }
                for(Student i :list) {
                    if(i.getId().equals(input))
                        throw new Exception("Id existed");
                }

                return input;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }


    public static String inputChar(String message, String pattern) {
        String gender;
        do {
            System.out.print(message);
            gender = scanner.nextLine();
            if(!gender.matches(pattern)) {
                System.out.println("Invalid String");
            }
            else {
                if(gender.charAt(0) == 'm' || gender.charAt(0) == 'M' ) return "male";
                else if(gender.charAt(0) == 'F' || gender.charAt(0) == 'f' ) return "female";
                return "other";
            }
                
        }while(true);
    }

    public static String inputString(String message, String pattern, String name) {
        String input = null;
        do {
            try {
                System.out.print(message);
                input = scanner.nextLine();
                if (!input.matches(pattern) && !pattern.equals("")) {
                    throw new Exception("Invalid "+name);
                }
                if (input.isEmpty()) {
                    throw new Exception("Required a string");
                }
                return input;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static Date inputDate(String message) {
        SimpleDateFormat formatter = new SimpleDateFormat(Pattern.DATE_PATTERN);
        Date date = new Date();
        do {
            try {
                System.out.println(message);
                String input = scanner.nextLine();
                date = formatter.parse(input);
                return date;
            } catch (Exception e) {
                System.out.println("invalid date");
            }
        } while (true);
    }

    public static String convertDateFormat(Date date, String pattern) {
        String dateResult = null;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        try {
            if (date == null) {
                return "null";
            }
            dateResult = formatter.format(date);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dateResult;
    }

}

class Pattern {

    public static final String DATE_PATTERN = "dd/MM/yyyy";
}