package sample.Person;

public class Person {
    private int NumberPerson;//Индивидуальный номер записи игры
    private String Nicname;//Никнейм игрока
    private String NameGame;//Название игрового режима
    private int GameCount;//Очки за игру
    private String Title;//Титул за игру основанный на количстве вопросов и выбранной сложности
    private String Comment;//Комментрий от игрока
    private int LifeCount;//Количество возможностей ошибится
    private int OurCount;//Количество ошибок

    //Конструктор класса
    public Person(int numberPerson, String nicname, String nameGame, int gameCount, String title, String comment,
                  int lifeCount, int ourCount) {
        NumberPerson = numberPerson;
        Nicname = nicname;
        NameGame = nameGame;
        GameCount = gameCount;
        Title = title;
        Comment = comment;
        LifeCount = lifeCount;
        OurCount = ourCount;
    }

    @Override //перезапись метода toString для вывода в таблицу
    public String  toString(){
        return Integer.toString(NumberPerson)+" "+Nicname+" "+ NameGame+" "+Integer.toString(GameCount)+" "+
                Title+  " " + Integer.toString(LifeCount) + " " + Integer.toString(OurCount) +" "+ Comment;
    }
    // гетеры и сетеры для полей класса
    public int getNumberPerson() {
        return NumberPerson;
    }

    public void setNumberPerson(int numberPerson) {
        NumberPerson = numberPerson;
    }

    public String getNicname() {
        return Nicname;
    }

    public void setNicname(String nicname) {
        Nicname = nicname;
    }

    public String getNameGame() {
        return NameGame;
    }

    public void setNameGame(String nameGame) {
        NameGame = nameGame;
    }

    public int getGameCount() {
        return GameCount;
    }

    public void setGameCount(int gameCount) {
        GameCount = gameCount;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public int getLifeCount() {
        return LifeCount;
    }

    public void setLifeCount(int lifeCount) {
        LifeCount = lifeCount;
    }

    public int getOurCount() {
        return OurCount;
    }

    public void setOurCount(int ourCount) {
        OurCount = ourCount;
    }
}
