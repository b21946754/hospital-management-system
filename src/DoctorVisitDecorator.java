public class DoctorVisitDecorator extends ExaminationDecorator {
    public DoctorVisitDecorator(Examination examination){
        this.examination = examination;
    }

    @Override
    public String description() {
        return this.examination.description() + " doctorvisit";
    }

    public int cost (){
        return this.examination.cost() + 15;
    }
}
