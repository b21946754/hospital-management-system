import java.util.ArrayList;

public class PatientDAOImp implements PatientDAO {
    ArrayList<Patient> patients;

    public PatientDAOImp(){
        patients = new ArrayList<Patient>();
    }

    @Override
    public Patient getByID(int id) {
        for(Patient element : patients) {
            if(element.id == id) {
                return element;
            }
        }
        return null;
    }

    @Override
    public void deleteByID(int id) {
        patients.removeIf(element -> element.id == id);
    }

    @Override
    public void add(Patient patient) {
        patients.add(patient);
    }

    @Override
    public ArrayList<Patient> getAll() {
        return patients;
    }
}
