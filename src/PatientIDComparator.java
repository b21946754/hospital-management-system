import java.util.Comparator;

public class PatientIDComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient o1, Patient o2) {
        return o1.compareTo(o2);
    }

}
