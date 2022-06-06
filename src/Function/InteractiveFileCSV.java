package Function;

import Student_management.Student;
import Student_management.Subject;
import Student_management.Transcript;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class InteractiveFileCSV {
    public void writeStudentList(ArrayList<Student> list)  {
        File csvFile = new File("src\\Student List.csv");
        PrintWriter out = null;
        try {
            out = new PrintWriter(csvFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        out.println("Student Id, FirstName, LastName, Gender, Date of Birth, Email, Phone Number");
        for(Student obj:list) {
            out.println(obj.getId()+","+obj.getFirstName()+","+obj.getLastName()+","+obj.getGender()+","+
                    obj.getDateOfBirth()+","+obj.getEmail()+","+obj.getPhoneNumber());
        }
        out.close();
    }
    public void writeSubjectList(ArrayList<Subject> list)  {
        File csvFile = new File("src\\Subject List.csv");
        PrintWriter out = null;
        try {
            out = new PrintWriter(csvFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        out.println("Subject Id, Name, Credit");
        for(Subject obj:list) {
            out.println(obj.getId()+","+obj.getName()+","+obj.getCredit());
        }
        out.close();
    }
    public void writeTranscriptList(ArrayList<Transcript> list) {
        File csvFile = new File("src\\Transcript List.csv");
        PrintWriter out = null;
        try {
            out = new PrintWriter(csvFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        out.println("Subject Id, Student Id, Labs, ProgressTests. FinalTest, Average");
        for(Transcript obj:list) {
            out.println(obj.getSubjectId()+","+obj.getStudentId()+","+obj.getLabs()+","+obj.getProgressTests()+
                    ","+obj.getFinalTest()+","+obj.getAverage());
        }
        out.close();
    }
    public void readStudentList(ArrayList<Student>list) {
        String file = "src\\Student List.csv";
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            line= reader.readLine();
            while((line= reader.readLine())!=null) {
                String[] row = line.split(",");
                Student student = new Student(row[0],row[1],row[2],row[3],row[4],row[5],row[6]);
                list.add(student);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void readSubjectList(ArrayList<Subject>list) {
        String file = "src\\Subject List.csv";
        BufferedReader reader;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            line= reader.readLine();
            while((line= reader.readLine())!=null) {
                String[] row = line.split(",");
                Subject subject = new Subject(row[0],row[1],parseInt(row[2]));
                list.add(subject);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void readTranscriptList(ArrayList<Transcript>list) {
        String file = "src\\Transcript List.csv";
        BufferedReader reader;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            line= reader.readLine();
            while((line= reader.readLine())!=null) {
                String[] row = line.split(",");
                Transcript transcript = new Transcript(row[0],row[1],parseDouble(row[2]),parseDouble(row[3]),
                                        parseDouble(row[4]),parseDouble(row[5]));
                list.add(transcript);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
