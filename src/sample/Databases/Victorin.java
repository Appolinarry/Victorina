package sample.Databases;

public class Victorin {
    private String Queston;
    private String AnswerA;
    private String AnswerB;
    private String AnswerC;
    private int RightAnswer;
    private int NumberQueston;

    public Victorin(int numberQueston, String queston, String answerA, String answerB, String answerC, int rightAnswer) {
        this.Queston = queston;
        this.AnswerA = answerA;
        this.AnswerB = answerB;
        this.AnswerC = answerC;
        this.RightAnswer = rightAnswer;
        this.NumberQueston = numberQueston;
    }

    @Override
    public String  toString(){
        return "\t"+Queston+"\n"+"1)"+AnswerA+"\n"+"2)"+AnswerB+"\n"+"3)"+AnswerC;
    }

    public String getQueston() {
        return Queston;
    }

    public String getAnswerA() {
        return AnswerA;
    }

    public String getAnswerB() {
        return AnswerB;
    }

    public String getAnswerC() {
        return AnswerC;
    }

    public int getRightAnswer() {
        return RightAnswer;
    }

    public int getNumberQueston() {
        return NumberQueston;
    }

    public void setQueston(String queston) {
        Queston = queston;
    }

    public void setAnswerA(String answerA) {
        AnswerA = answerA;
    }

    public void setAnswerB(String answerB) {
        AnswerB = answerB;
    }

    public void setAnswerC(String answerC) {
        AnswerC = answerC;
    }

    public void setRightAnswer(int rightAnswer) {
        RightAnswer = rightAnswer;
    }

    public void setNumberQueston(int numberQueston) {
        NumberQueston = numberQueston;
    }

}
