package Student_management;

public class Transcript {
    public Transcript(String subjectId, String studentId,
                      double labs, double progressTests,
                      double finalTest, double average) {
        setSubjectId(subjectId);
        setStudentId(studentId);
        setLabs(labs);
        setProgressTests(progressTests);
        setFinalTest(finalTest);
        setAverage(average);
    }
    private String subjectId;
    private String studentId;
    private double labs;
    private double progressTests;
    private double finalTest;
    private double average;

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getLabs() {
        return labs;
    }

    public void setLabs(double labs) {
        this.labs = labs;
    }

    public double getProgressTests() {
        return progressTests;
    }

    public void setProgressTests(double progressTests) {
        this.progressTests = progressTests;
    }

    public double getFinalTest() {
        return finalTest;
    }

    public void setFinalTest(double finalTest) {
        this.finalTest = finalTest;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
