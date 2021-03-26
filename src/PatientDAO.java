import java.util.ArrayList;
public interface PatientDAO {
    Patient getByID(int id);
    void deleteByID(int id);
    void add(Patient patient);
    ArrayList<Patient> getAll();
}
