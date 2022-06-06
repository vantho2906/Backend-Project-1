
import Function.EnterGrade;
import Function.InteractiveFileCSV;
import Function.UpdateStudent;
import Function.UpdateSubject;
import Student_management.*;
import Utilities.*;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Mainv1 extends Validation {

    ArrayList<Student>studentList = new ArrayList<>();
    ArrayList<Subject>subjectList = new ArrayList<>();
    ArrayList<Transcript>transcriptList = new ArrayList<>();
    UpdateStudent updateStu = new UpdateStudent();
    UpdateSubject updateSub = new UpdateSubject();
    EnterGrade enterGrade = new EnterGrade();
    InteractiveFileCSV file = new InteractiveFileCSV();
    Scanner sc = new Scanner(System.in);

    void menu() {

        System.out.println("---------------STUDENT MANAGEMENT---------------");
        System.out.println("1. Add new Student");
        System.out.println("2. Add new Subject");
        System.out.println("3. Update Student");
        System.out.println("4. Update Subject");
        System.out.println("5. Enter grade");
        System.out.println("6. Student grade report");
        System.out.println("7. Subject grade report");
        System.out.println("8. Exit");
        System.out.println("Choose an option:");
        int number = InputInteger(8);
        switch (number) {
            case 1:
                AddNewStudent();
                break;
            case 2:
                AddNewSubject();
                break;
            case 3:
                BigUpdateStudent();
                break;
            case 4:
                BigUpdateSubject();
                break;
            case 5:
                EnterGrade();
                break;
            case 6:
                StudentGradeReport();
                break;
            case 7:
                SubjectGradeReport();
                break;
            case 8:
                System.out.println("Good bye. Have a nice day!!!");
                return;
            default:

        }
    }


    public static void main(String[] args) {

        Mainv1 main = new Mainv1();
        main.readAll();
        main.menu();
    }
    public void AddNewStudent() {
        System.out.println("-----------------ADD NEW STUDENT-----------------");
        String id = inputIdStudent("input id:","SE[0-9]{3}",studentList);
        System.out.println("input firstName:");
        String firstName = sc.nextLine();
        System.out.println("input lastName:");
        String lastName = sc.nextLine();
        String gender = inputChar("input gender(type one char male m female f other o):","^[o0MmFf][ ]*");
        Date date = inputDate("input date of birth:");
        String dateOfBirth = convertDateFormat(date, "dd/MM/yyyy");
        String email = inputString("input email:","^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$","email");
        String phoneNumber =inputPhoneNumber("input phone number:","[0-9]{10}" );
        Student student = new Student(id,firstName,lastName,gender,dateOfBirth,email,phoneNumber);
        studentList.add(student);
        file.writeStudentList(studentList);
        System.out.println("Add successfully");
        if(askBackMainMenu()=='1')AddNewStudent();
        else menu();
    }
    public void AddNewSubject() {
        System.out.println("-----------------ADD NEW SUBJECT-----------------");
        String id = inputIdSubject("input id:",subjectList);
        System.out.println("input subject's name:");
        String name = sc.nextLine();
        int credit = inputCredit("input credit:");
        Subject subject = new Subject(id,name,credit);
        subjectList.add(subject);
        file.writeSubjectList(subjectList);
        System.out.println("Add successfully");
        if(askBackMainMenu()=='1')AddNewSubject();
        else menu();
    }
    public void BigUpdateStudent() {
        System.out.println("---------------BIG UPDATE STUDENT---------------\n");
        System.out.println("1. Update student\n");
        System.out.println("2. Delete student\n");
        System.out.println("3. Show student list\n");
        int number = InputInteger(3);
        switch(number) {
            case 1:
                UpdateStudent();
                break;
            case 2:
                DeleteStudent();
                break;
            case 3:
                ShowStudentList();
                break;

        }
    }
    private void UpdateStudent() {
        System.out.println("-----------------UPDATE STUDENT-----------------");
        String firstName, lastName, gender, dateOfBirth, email, phoneNumber;
        int indexOfObjectContainId = updateStu.inputId("input id:",studentList);
        int i = indexOfObjectContainId;
        System.out.println("Hello "+studentList.get(i).getLastName()+ " "+studentList.get(i).getFirstName() );
        if(updateStu.change("firstname","[yYnN][ ]*")=='y') {
            System.out.println("change firstname:");
            firstName = sc.nextLine();
            studentList.get(i).setFirstName(firstName);
        }
        if(updateStu.change("lastname","[yYnN][ ]*")=='y') {
            System.out.println("change lastname:");
            lastName = sc.nextLine();
            studentList.get(i).setLastName(lastName);
        }
        if(updateStu.change("gender","[yYnN][ ]*")=='y') {
            gender = inputChar("change gender(type one char male m female f other o):","^[o0MmFf][ ]*");
            studentList.get(i).setGender(gender);
        }
        if(updateStu.change("date of birth","[yYnN][ ]*")=='y') {
            Date date = inputDate("change date of birth:");
            dateOfBirth = convertDateFormat(date, "dd/MM/yyyy");
            studentList.get(i).setDateOfBirth(dateOfBirth);
        }
        if(updateStu.change("email","[yYnN][ ]*")=='y') {
            email = inputString("change email:","^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$","email");
            studentList.get(i).setEmail(email);
        }
        if(updateStu.change("phone number","[yYnN][ ]*")=='y') {
            phoneNumber =inputString("change phone number:","[0-9]{10}","phone number" );
            studentList.get(i).setPhoneNumber(phoneNumber);
        }
        file.writeStudentList(studentList);
        System.out.println("Update successfully");
        if(askBackMainMenu()=='1')UpdateStudent();
        else menu();

    }
    private void ShowStudentList() {
        System.out.println("-----------------STUDENT LIST-----------------");
        System.out.println("|++NO++|++++++ID++++++|++++++++++NAME++++++++++|+++++GENDER+++++" +
                "|++DATE OF BIRTH++|   +++++++++EMAIL+++++++++   |+++++PHONE+++++|");
        for(int i=0;i<studentList.size();i++) {
            System.out.printf("%5s %11s %26s %14s %18s %30s %15s\n",String.format("%02d",i+1),studentList.get(i).getId(),
                    studentList.get(i).getLastName()+" "+studentList.get(i).getFirstName(),studentList.get(i).getGender(),
                    studentList.get(i).getDateOfBirth(),studentList.get(i).getEmail(),studentList.get(i).getPhoneNumber());
        }
        if(askBackMainMenu()=='1')ShowStudentList();
        else menu();
    }
    private void DeleteStudent() {
        System.out.println("-----------------DELETE STUDENT-----------------");
        int indexOfObjectContainId = updateStu.inputId("input id:",studentList);
        int i= indexOfObjectContainId;
        String studentId = studentList.get(i).getId();
        boolean existInTranscript =false;
        for(Transcript j: transcriptList ) {
            if(j.getStudentId().equals(studentId)) {
                existInTranscript = true; break;
            }
        }
        if(existInTranscript) {
            System.out.println("Can not delete student who is graded");
        }
        else {
           if(askDeleteStudent(studentId,i)=='y') {
               System.out.println("Deleted successfully student id "+studentList.get(i).getId());
               studentList.remove(studentList.get(i));
               file.writeStudentList(studentList);
           }
           else {
               System.out.println("Cancel successfully");

           }
        }
        if(askBackMainMenu()=='1')DeleteStudent();
        else menu();
    }
    void BigUpdateSubject() {
        System.out.println("---------------UPDATE SUBJECT---------------\n");
        System.out.println("1. Update subject\n");
        System.out.println("2. Delete subject\n");
        System.out.println("3. Show subject list\n");
        int number = InputInteger(3);
        switch(number) {
            case 1:
                UpdateSubject();
                break;
            case 2:
                DeleteSubject();
                break;
            case 3:
                ShowSubjectList();
                break;

        }
    }
    private void UpdateSubject() {
        System.out.println("-----------------UPDATE SUBJECT-----------------");
        String name;
        int credit;
        int indexOfObjectContainId = updateSub.inputId("input id:",subjectList);
        int i = indexOfObjectContainId;
        System.out.println("id:"+subjectList.get(i).getId());
        if(updateSub.change("name","[yYnN][ ]*")=='y') {
            System.out.println("change name:");
            name = sc.nextLine();
            subjectList.get(i).setName(name);
        }
        if(updateSub.change("credit","[yYnN][ ]*")=='y') {
            credit = inputCredit("change credit:");
            subjectList.get(i).setCredit(credit);
        }
        file.writeSubjectList(subjectList);
        System.out.println("Update successfully");
        if(askBackMainMenu()=='1')UpdateSubject();
        else menu();
    }

    private void ShowSubjectList() {
        System.out.println("-----------------SUBJECT LIST-----------------");
        System.out.println("|++No++|  ++++ID++++ |       ++++++++++++Name++++++++++++       |");
        for(int i=0;i<subjectList.size();i++) {
            System.out.printf("%5s %10s %45s\n",String.format("%02d",i+1),subjectList.get(i).getId(),
                    subjectList.get(i).getName());
        }
        if(askBackMainMenu()=='1')ShowSubjectList();
        else menu();
    }

    private void DeleteSubject() {
        System.out.println("-----------------DELETE SUBJECT-----------------");
        int indexOfObjectContainId = updateSub.inputId("input id:",subjectList);
        int i= indexOfObjectContainId;
        String subjectId = subjectList.get(i).getId();
        boolean existInTranscript =false;
        for(Transcript j: transcriptList ) {
            if(j.getSubjectId().equals(subjectId)) {
                existInTranscript = true; break;
            }
        }
        if(existInTranscript) {
            System.out.println("Can not delete subject which is graded");
        }
        else {
            if(askDeleteSubject(subjectId,i)=='y') {
                System.out.println("Deleted successfully subject id "+studentList.get(i).getId());
                subjectList.remove(subjectList.get(i));
                file.writeSubjectList(subjectList);
            }
            else {
                System.out.println("Cancel successfully");

            }
        }
        if(askBackMainMenu()=='1')DeleteSubject();
        else menu();
    }
    private void EnterGrade() {
        System.out.println("-----------------ENTER GRADE-----------------");
        int indexOfStudentContainId = updateStu.inputId("input Student id:",studentList);
        int indexOfSubjectContainId = updateSub.inputId("input Subject id:",subjectList);
        int i1 = indexOfStudentContainId;
        int i2 = indexOfSubjectContainId;
        String studentId = studentList.get(i1).getId();
        String subjectId = subjectList.get(i2).getId();
        boolean existInTranscript =false;
        int indexOfTranscriptContainId=0;
        for(int i=0;i<transcriptList.size();i++) {
            if(transcriptList.get(i).getSubjectId().equals(subjectId) && transcriptList.get(i).getStudentId().equals(studentId)) {
                existInTranscript = true;
                indexOfTranscriptContainId = i;
                break;
            }
        }
        int i = indexOfStudentContainId;
        if(existInTranscript) {
            System.out.print("Student is graded in this subject\n Do you want to overwrite it?(y/n):");
            if(updateStu.change("[YyNn][ ]*")== 'y') {
                    enterGrade.askAndOverwriteGrade(transcriptList,i);
                    System.out.println("Enter grade successfully");
                }
            else {
                System.out.println("Cancel successfully");
            }
        }
        else {
            double labs = inputGrade("input labs grade:");
            double progressTests = inputGrade("input progressTests grade:");
            double finalTest = inputGrade("input finalTest grade:");
            double average =(labs+progressTests+finalTest)/3;
            average = parseDouble(String.format("%.1f",average));
            Transcript transcript = new Transcript(subjectId,studentId,
                    labs,progressTests,finalTest,average);
            transcriptList.add(transcript);
            System.out.println("Enter grade successfully");
        }
        file.writeTranscriptList(transcriptList);
        if(askBackMainMenu()=='1')EnterGrade();
        else menu();
    }
    private void SubjectGradeReport() {
        ArrayList<String> studentIdList = new ArrayList<>();
        ArrayList<Double> studentAverageGradeList = new ArrayList<>();
        ArrayList<String> studentNameList = new ArrayList<>();
        String subjectName = null;
        String subjectId = findSubjectIdInTranscript(studentIdList,studentAverageGradeList);
        System.out.println("-----------------GRADE SUBJECT REPORT-----------------");
        if(subjectId!="no data") {
            for(Subject obj:subjectList) {
                if(subjectId.equals(obj.getId()) ) {
                    subjectName = obj.getName();
                    break;
                }
            }
            System.out.println("Subject ID: "+subjectId);
            System.out.println("Name: "+subjectName);
            System.out.printf("%10s %30s %15s %15s \n", "|++ No ++|","|++++++++++ name +++++++++++",
                    "|++ Average mark ++","|++ Status ++|");
            for(int i=0;i<studentIdList.size();i++) {
                for(int j=0;j<studentList.size();j++) {
                    if(studentList.get(j).getId().equals(studentIdList.get(i))) {
                        studentNameList.add(studentList.get(j).getLastName()+" "+studentList.get(j).getFirstName());
                        j=studentList.size();
                    }
                }
            }
            for(int i=0;i<studentIdList.size();i++) {
                String status;
                if(studentAverageGradeList.get(i)<5)status ="Failed";
                else status ="Pass";
                System.out.printf("%6s %34s %13s %16s \n",String.format("%02d",i+1),studentNameList.get(i),
                                    String.format("%.1f",studentAverageGradeList.get(i)),status);
            }
        }
        else {
            System.out.println("No data");
        }
        if(askBackMainMenu()=='1')SubjectGradeReport();
        else menu();

    }

    private void StudentGradeReport() {
        ArrayList<String> subjectIdList = new ArrayList<>();
        ArrayList<Double> subjectAverageGradeList = new ArrayList<>();
        ArrayList<String> subjectNameList = new ArrayList<>();
        String studentName = null;
        String studentId = findStudentIdInTranscript(subjectIdList,subjectAverageGradeList);
        System.out.println("-----------------GRADE STUDENT REPORT-----------------");
        if(studentId!="no data") {
            for(Student obj:studentList) {
                if(studentId.equals(obj.getId())) {
                    studentName = obj.getLastName()+" "+obj.getFirstName();
                    break;
                }
            }
            System.out.println("Student ID: "+studentId);
            System.out.println("Fullname: "+studentName);
            System.out.printf("%10s %40s %14s %15s \n", "|++ NO ++|","|+++++++++++++++ NAME +++++++++++++++",
                    "|++ AVERAGE MARK ++","|++ STATUS ++|");
            for(int i=0;i<subjectIdList.size();i++) {
                for(int j=0;j<subjectList.size();j++) {
                    if(subjectList.get(j).getId().equals(subjectIdList.get(i)) ) {
                        subjectNameList.add(subjectList.get(j).getName());
                    }
                }
            }
            for(int i=0;i<subjectIdList.size();i++) {
                String status;
                if(subjectAverageGradeList.get(i)<5)status ="Failed";
                else status ="Pass";
                System.out.printf("%6s %45s %12s %16s \n",String.format("%02d",i+1),subjectNameList.get(i),
                        String.format("%.1f",subjectAverageGradeList.get(i)),status);
            }
        }
        else {
            System.out.println("No data");
        }
        System.out.println(subjectIdList.size());
        if(askBackMainMenu()=='1')StudentGradeReport();
        else menu();
    }
    private String findSubjectIdInTranscript(ArrayList<String>studentIdList,ArrayList<Double>studentAverageGradeList) {
        String input= null;
        do {
            System.out.println("input subject id:");
            input = sc.nextLine();
            boolean check = false;
            for(int i=0;i<transcriptList.size();i++) {
                if(transcriptList.get(i).getSubjectId().equals(input)) {
                    check = true;
                    studentIdList.add(transcriptList.get(i).getStudentId());
                    studentAverageGradeList.add(transcriptList.get(i).getAverage());
                }
            }
            if(check==true)return input;
            for(int i=0;i<subjectList.size();i++) {
                if (subjectList.get(i).getId().equals(input))
                    return "no data";
            }
            System.out.println("Id doesn't exist");

        } while(true);
    }
    private String findStudentIdInTranscript(ArrayList<String>subjectIdList,ArrayList<Double>subjectAverageGradeList) {
        String input= null;
        do {
            System.out.println("input student id:");
            input = sc.nextLine();
            boolean check = false;
            for(int i=0;i<transcriptList.size();i++) {
                if(transcriptList.get(i).getStudentId().equals(input)) {
                    check = true;
                    subjectIdList.add(transcriptList.get(i).getSubjectId());
                    subjectAverageGradeList.add(transcriptList.get(i).getAverage());
                }
            }
            if(check==true)return input;
            for(int i=0;i<studentList.size();i++) {
                if (studentList.get(i).getId().equals(input))
                    return "no data";
            }
            System.out.println("Id doesn't exist");

        } while(true);
    }
    char askDeleteStudent(String studentId,int i) {
        do {
            System.out.println("Are you sure you want to delete student id "+studentId+"(y/n)");
            String input = sc.nextLine();
            if(input.matches("[Yy][ ]*")) {
                return 'y';
            }
            if(input.matches("[Nn][ ]*")) {
                return 'n';
            }
                System.out.println("Invalid Input");
        }while(true);
    }
    char askDeleteSubject(String subjectId,int i) {
        do {
            System.out.println("Are you sure you want to delete subject id "+subjectId+"(y/n)");
            String input = sc.nextLine();
            if(input.matches("[Yy][ ]*")) {
                return 'y';
            }
            if(input.matches("[Nn][ ]*")) {
                return 'n';
            }
            System.out.println("Invalid Input");
        }while(true);
    }

    char askBackMainMenu() {
        do {
            System.out.println("You want to continue(1)or back to main menu(2) (number 1 or 2):");
            String input = sc.nextLine();
            if(input.matches("[1][ ]*")) {
                return '1';
            }
            if(input.matches("[2][ ]*")) {
                return '2';
            }
            System.out.println("Invalid Input");
        }while(true);
    }
    public void readAll() {
        file.readStudentList(studentList);
        file.readSubjectList(subjectList);
        file.readTranscriptList(transcriptList);
    }
}


