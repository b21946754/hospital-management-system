public class OutpatientExamination extends Examination{
    @Override
    public String description() {
        return "Outpatient";
    }

    public int cost(){
        return 15;
    }
}
