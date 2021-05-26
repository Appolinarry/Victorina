package sample.Person;

public class Person extends Gamer{

    protected String Comment;//Комментрий от игрока
    protected int LifeCount;//Количество возможностей ошибится
    protected int OurCount;//Количество ошибок
    //Конструктор класса
    public Person(int numberPerson, String nicname, String nameGame, int gameCount, String title,
                  int lifeCount, int ourCount,String comment) {
        this.Number = numberPerson;
        this.Nicname = nicname;
        this.NameGame = nameGame;
        this.GameCount = gameCount;
        this.Title = title;
        this.Comment = comment;
        this.LifeCount = lifeCount;
        this.OurCount = ourCount;
    }

    @Override //перезапись метода toString для вывода в таблицу
    public String  toString(){
        return Integer.toString(Number)+" "+Nicname+" "+ NameGame+" "+Integer.toString(GameCount)+" "+
                Title+  " " + Integer.toString(LifeCount) + " " + Integer.toString(OurCount) +" "+ Comment;
    }
    // гетеры и сетеры для полей класса
    public int getNumberPerson() {
        return Number;
    }

    public void setNumberPerson(int numberPerson) {
        Number = numberPerson;
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

    public String getComment() { return Comment;  }

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
