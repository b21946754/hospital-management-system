import java.util.ArrayList;

public interface AdmissionDAO {
    void createAdmission(int admissionID, int patientID);
    void addExamination(int admissionID, Examination examination);
    ArrayList<String> totalCost(int admissionID);
    void deleteByID(int patientID);
}
