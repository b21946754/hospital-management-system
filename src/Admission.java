import java.util.ArrayList;

public class Admission implements Comparable<Admission>{
    int id;
    int patientID;
    ArrayList<Examination> examinations;

    @Override
    public int compareTo(Admission o) {
        return this.id - o.id;
    }

    public Admission(int admissionID, int patientID) {
        this.id = admissionID;
        this.patientID = patientID;
        examinations = new ArrayList<Examination>();
    }
}
