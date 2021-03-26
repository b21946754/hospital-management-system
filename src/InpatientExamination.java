public class InpatientExamination extends Examination{
    @Override
    public String description() {
        return "Inpatient";
    }

    public int cost(){
        return 10;
    }
}
