import java.util.Comparator;

public class PatientNameComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient o1, Patient o2) {
        return o1.name.compareTo(o2.name);
    }
}
