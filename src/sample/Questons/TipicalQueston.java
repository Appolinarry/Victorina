package sample.Questons;

import java.util.Random;

public class TipicalQueston extends  Victorin{

    Random random = new Random();
    public TipicalQueston(String queston, String answera,String answerb,String answerc, String rightanswer, int number, int count) {
        this.Queston = queston;
        this.AnswerA = answera;
        this.AnswerB = answerb;
        this.AnswerC = answerc;
        this.RightAnswer = rightanswer;
        this.NumberQueston = number;
        this.CountQueston = count;
    }
    @Override
    public String  toString(){
        int choise = random.nextInt(6);
        switch (choise){
            case 0 :
                return Queston+"\n " +AnswerA+"\n "+ AnswerB+"\n "+ AnswerC;
            case 1:
                return Queston+"\n " +AnswerA+"\n "+ AnswerC+"\n "+ AnswerB;
            case 2 :
                return Queston+"\n " +AnswerB+"\n "+ AnswerA+"\n "+ AnswerC;
            case 3:
                return Queston+"\n " +AnswerB+"\n "+ AnswerC+"\n "+ AnswerA;
            case 4 :
                return Queston+"\n " +AnswerC+"\n "+ AnswerB+"\n "+ AnswerA;
            case 5:
                return Queston+"\n " +AnswerC+"\n "+ AnswerA+"\n "+ AnswerB;
        }
        return Queston+"\n " +AnswerA+"\n "+ AnswerB+"\n "+ AnswerC;
    }
}
