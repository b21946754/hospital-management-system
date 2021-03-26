import java.util.Comparator;

public class AdmissionComparator implements Comparator<Admission>{
    @Override
    public int compare(Admission o1, Admission o2) {
        return o1.compareTo(o2);
    }
}
