package sample.Questons;

import java.util.Random;

public class SomeUntipicalQueston extends Victorin{
    protected String AnswerD;
    Random random = new Random();
    public SomeUntipicalQueston(String queston, String answera, String answerb, String answerc, String answerd, String rightanswer, int number, int count) {
        this.Queston = queston;
        this.AnswerA = answera;
        this.AnswerB = answerb;
        this.AnswerC = answerc;
        this.AnswerD = answerd;
        this.RightAnswer = rightanswer;
        this.NumberQueston = number;
        this.CountQueston = count;
    }
    @Override
    public String  toString(){
        int choise = random.nextInt(24);
        switch (choise){
            case 0:
                return Queston+"\n " +AnswerA+"\n "+ AnswerB+"\n "+ AnswerC+"\n "+ AnswerD;
            case 1:
                return Queston+"\n " +AnswerA+"\n "+ AnswerC+"\n "+ AnswerD+"\n "+ AnswerB;
            case 2:
                return Queston+"\n " +AnswerB+"\n "+ AnswerD+"\n "+ AnswerA+"\n "+ AnswerC;
            case 3:
                return Queston+"\n "+ AnswerD+"\n " +AnswerB+"\n "+ AnswerC+"\n "+ AnswerA;
            case 4:
                return Queston+"\n " +AnswerC+"\n "+ AnswerB+"\n "+ AnswerA+"\n "+ AnswerD;
            case 5:
                return Queston+"\n " +AnswerC+"\n "+ AnswerA+"\n "+ AnswerD+"\n "+ AnswerB;
            case 6:
                return Queston+"\n " +AnswerA+"\n "+ AnswerD+"\n "+ AnswerB+"\n "+ AnswerC;
            case 7:
                return Queston+"\n "+ AnswerD+"\n " +AnswerA+"\n "+ AnswerC+"\n "+ AnswerB;
            case 8:
                return Queston+"\n " +AnswerB+"\n "+ AnswerA+"\n "+ AnswerC+"\n "+ AnswerD;
            case 9:
                return Queston+"\n " +AnswerB+"\n "+ AnswerC+"\n "+ AnswerD+"\n "+ AnswerA;
            case 10:
                return Queston+"\n " +AnswerC+"\n "+ AnswerD+"\n "+ AnswerB+"\n "+ AnswerA;
            case 11:
                return Queston+"\n "+ AnswerD+"\n " +AnswerC+"\n "+ AnswerA+"\n "+ AnswerB;
            case 12:
                return Queston+"\n " +AnswerA+"\n "+ AnswerB+"\n "+ AnswerC+"\n "+ AnswerD;
            case 13:
                return Queston+"\n " +AnswerA+"\n "+ AnswerC+"\n "+ AnswerD+"\n "+ AnswerB;
            case 14:
                return Queston+"\n " +AnswerB+"\n "+ AnswerD+"\n "+ AnswerA+"\n "+ AnswerC;
            case 15:
                return Queston+"\n "+ AnswerD+"\n " +AnswerB+"\n "+ AnswerC+"\n "+ AnswerA;
            case 16:
                return Queston+"\n " +AnswerC+"\n "+ AnswerB+"\n "+ AnswerA+"\n "+ AnswerD;
            case 17:
                return Queston+"\n " +AnswerC+"\n "+ AnswerA+"\n "+ AnswerD+"\n "+ AnswerB;
            case 18:
                return Queston+"\n " +AnswerA+"\n "+ AnswerD+"\n "+ AnswerB+"\n "+ AnswerC;
            case 19:
                return Queston+"\n "+ AnswerD +"\n " +AnswerA+"\n "+ AnswerC+"\n "+ AnswerB;
            case 20:
                return Queston+"\n " +AnswerB+"\n "+ AnswerA+"\n "+ AnswerC+"\n "+ AnswerD;
            case 21:
                return Queston+"\n " +AnswerB+"\n "+ AnswerC+"\n "+ AnswerD+"\n "+ AnswerA;
            case 22:
                return Queston+"\n " +AnswerC+"\n "+ AnswerD+"\n "+ AnswerB+"\n "+ AnswerA;
            case 23:
                return Queston+"\n "+ AnswerD+"\n " +AnswerC+"\n "+ AnswerA+"\n "+ AnswerB;
        }
        return Queston+"\n " +AnswerA+"\n "+ AnswerB+"\n "+ AnswerC+"\n "+ AnswerD;
    }
}
