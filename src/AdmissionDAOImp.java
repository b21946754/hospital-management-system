import java.util.ArrayList;

public class AdmissionDAOImp implements AdmissionDAO {
    ArrayList<Admission> admissions;

    AdmissionDAOImp(){
        admissions = new ArrayList<Admission>();
    }

    @Override
    public void createAdmission(int admissionID, int patientID) {
        admissions.add(new Admission(admissionID, patientID));
    }

    @Override
    public void deleteByID(int patientID) {
        admissions.removeIf(admission -> admission.patientID == patientID);
    }

    @Override
    public void addExamination(int admissionID, Examination examination) {
        for(Admission admission : admissions){
            if(admission.id == admissionID){
                admission.examinations.add(examination);
            }
        }
    }

    @Override
    public ArrayList<String> totalCost(int admissionID) {
        ArrayList<String> log = new ArrayList<>();
        for(Admission admission : admissions){
            if(admission.id == admissionID){
                int total = 0;
                log.add("TotalCost for admission " + admission.id);
                for(Examination e : admission.examinations){
                        log.add("\t" + e.description() + " " + e.cost() + "$");
                total += e.cost();
        }
                log.add("\tTotal: " + total + "$");
            }
        }
        return log;
    }
}
