public class ImagingDecorator extends ExaminationDecorator{
    public ImagingDecorator(Examination examination){
        this.examination = examination;
    }

    @Override
    public String description() {
        return this.examination.description() + " imaging";
    }

    public int cost (){
        return this.examination.cost() + 10;
    }
}
