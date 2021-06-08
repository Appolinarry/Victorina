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
    //возвращает  значения  Queston
    public String getQueston() {
        return Queston;
    }
    // устанавливает значение Queston
    public void setQueston(String queston) {
        Queston = queston;
    }
    //возвращает  значения  AnswerA
    public String getAnswerA() {
        return AnswerA;
    }
    // устанавливает значение AnswerA
    public void setAnswerA(String answerA) {
        AnswerA = answerA;
    }
    //возвращает  значения  AnswerB
    public String getAnswerB() {
        return AnswerB;
    }
    // устанавливает значение AnswerB
    public void setAnswerB(String answerB) {
        AnswerB = answerB;
    }
    //возвращает  значения  AnswerC
    public String getAnswerC() {
        return AnswerC;
    }
    // устанавливает значение AnswerC
    public void setAnswerC(String answerC) {
        AnswerC = answerC;
    }
    //возвращает  значения  RightAnswer
    public int getRightAnswer() {
        return RightAnswer;
    }
    // устанавливает значение RightAnswer
    public void setRightAnswer(int rightAnswer) {
        RightAnswer = rightAnswer;
    }
    //возвращает  значения  NumberQueston
    public int getNumberQueston() {
        return NumberQueston;
    }
    // устанавливает значение NumberQueston
    public void setNumberQueston(int numberQueston) {
        NumberQueston = numberQueston;
    }
    //возвращает  значения  CountQueston
    public int getCountQueston() {
        return CountQueston;
    }
    // устанавливает значение CountQueston
    public void setCountQueston(int countQueston) {
        CountQueston = countQueston;
    }
    //возвращает  значения  NameTopic
    public String getNameTopic() {
        return NameTopic;
    }
    // устанавливает значение NameTopic
    public void setNameTopic(String nameTopic) {
        NameTopic = nameTopic;
    }

}
