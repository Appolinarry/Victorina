package sample.Person;

public class Person extends Gamer{

    protected String Comment;//Комментрий от игрока
    protected int LifeCount;//Количество возможностей ошибиться
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

    //возвращает значение Number
    public int getNumberPerson() {
        return Number;
    }
    //возвращает значение Nicname
    public String getNicname() {
        return Nicname;
    }
    //возвращает значение  NameGame
    public String getNameGame() {
        return NameGame;
    }
    //возвращает значение GameCount
    public int getGameCount() {
        return GameCount;
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
    //возвращает значение LifeCount
    public int getLifeCount() {
        return LifeCount;
    }
    //возвращает значение OurCount
    public int getOurCount() {return OurCount;}
}
