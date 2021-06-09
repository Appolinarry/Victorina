package sample.Questons;

public class Victorin {
    //Вопрос
    private String Queston;
    //Вариант ответа №1
    private String AnswerA;
    //Вариант ответа №2
    private String AnswerB;
    //Вариант ответа №3
    private String AnswerC;
    //Правильный вариант ответа
    private int RightAnswer;
    //Номер вопроса в таблице
    private int NumberQueston;
    //очки за вопрос
    private int CountQueston;
    //название темы
    private String NameTopic;
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
    //перезапись toString
    @Override
    public String  toString(){//на основе случайного числа подбирает запись вопроса
        return Queston+"\n 1)" +AnswerA+"\n 2)"+ AnswerB+"\n 3)"+ AnswerC;
    }

    //возвращает  значения  RightAnswer
    public int getRightAnswer() {
        return RightAnswer;
    }
    //возвращает  значения  CountQueston
    public int getCountQueston() {
        return CountQueston;
    }
    //возвращает  значения  NameTopic
    public String getNameTopic() {
        return NameTopic;
    }

}
