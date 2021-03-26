public class MeasurementsDecorator extends ExaminationDecorator{
    public MeasurementsDecorator(Examination examination){
        this.examination = examination;
    }

    @Override
    public String description() {
        return this.examination.description() + " measurements";
    }

    public int cost (){
        return this.examination.cost() + 5;
    }
}
