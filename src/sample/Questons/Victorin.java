package sample.Questons;

import java.util.Random;

public class Victorin {
    private String Queston;//Вопрос
    private String AnswerA;//Вариант ответа №1
    private String AnswerB;//Вариант ответа №2
    private String AnswerC;//Вариант ответа №3
    private int RightAnswer;//Правильный вариант ответа
    private int NumberQueston;//Номер вопроса в таблице
    private int CountQueston;//очки за вопрос
    private String NameTopic; //название темы
    //конструктор класса
    public Victorin(int number,String queston, String answera,String answerb,String answerc, int rightanswer,
                    int count, String nametopic) {
        this.Queston = queston;
        this.AnswerA = answera;
        this.AnswerB = answerb;
        this.AnswerC = answerc;
        this.RightAnswer = rightanswer;
        this.NumberQueston = number;
        this.CountQueston = count;
        this.NameTopic = nametopic;
    }
    @Override
    public String  toString(){//на основе случайного числа подбирает запись вопроса
        return Queston+"\n 1)" +AnswerA+"\n 2)"+ AnswerB+"\n 3)"+ AnswerC;
    }
    public String getQueston() {
        return Queston;
    }

    public void setQueston(String queston) {
        Queston = queston;
    }

    public String getAnswerA() {
        return AnswerA;
    }

    public void setAnswerA(String answerA) {
        AnswerA = answerA;
    }

    public String getAnswerB() {
        return AnswerB;
    }

    public void setAnswerB(String answerB) {
        AnswerB = answerB;
    }

    public String getAnswerC() {
        return AnswerC;
    }

    public void setAnswerC(String answerC) {
        AnswerC = answerC;
    }

    public int getRightAnswer() {
        return RightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        RightAnswer = rightAnswer;
    }

    public int getNumberQueston() {
        return NumberQueston;
    }

    public void setNumberQueston(int numberQueston) {
        NumberQueston = numberQueston;
    }

    public int getCountQueston() {
        return CountQueston;
    }

    public void setCountQueston(int countQueston) {
        CountQueston = countQueston;
    }

    public String getNameTopic() {
        return NameTopic;
    }

    public void setNameTopic(String nameTopic) {
        NameTopic = nameTopic;
    }

}
