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

    public int getNumberPerson() {
        return Number;
    }
    //устанавливает значение Number
    public void setNumberPerson(int numberPerson) {
        Number = numberPerson;
    }
    //возвращает значение Number
    public String getNicname() {
        return Nicname;
    }
    //устанавливает значение Nicname
    public void setNicname(String nicname) {
        Nicname = nicname;
    }
    //возвращает значение Nicname
    public String getNameGame() {
        return NameGame;
    }
    //устанавливает значение Number
    public void setNameGame(String nameGame) {
        NameGame = nameGame;
    }
    //возвращает значение NameGame
    public int getGameCount() {
        return GameCount;
    }
    //устанавливает значение NameGame
    public void setGameCount(int gameCount) {
        GameCount = gameCount;
    }
    //возвращает значение Title
    public String getTitle() {
        return Title;
    }
    //устанавливает значение Title
    public void setTitle(String title) {
        Title = title;
    }
    //возвращает значение Comment
    public String getComment() { return Comment;  }
    //устанавливает значение Comment
    public void setComment(String comment) {
        Comment = comment;
    }
    //возвращает значение LifeCount
    public int getLifeCount() {
        return LifeCount;
    }
    //устанавливает значение LifeCount
    public void setLifeCount(int lifeCount) {
        LifeCount = lifeCount;
    }
    //возвращает значение OurCount
    public int getOurCount() {return OurCount;}
    //устанавливает значение OurCount
    public void setOurCount(int ourCount) {
        OurCount = ourCount;
    }
}
