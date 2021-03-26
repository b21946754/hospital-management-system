public class TestsDecorator extends ExaminationDecorator{
    public  TestsDecorator(Examination examination){
        this.examination = examination;
    }

    @Override
    public String description() {
        return this.examination.description() + " tests";
    }

    public int cost (){
        return this.examination.cost() + 7;
    }
}
