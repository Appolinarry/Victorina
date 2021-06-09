package sample.Person;

public class Winner extends Gamer{
    private int FactNumber;//номер выйгранного факта
    //конструктор класса
    public Winner(int number, String nic, String title, String nameGame, int totalCount, int factNumber) {
        this.Number = number;
        this.Nicname = nic;
        this.Title = title;
        this.NameGame = nameGame;
        this.GameCount = totalCount;
        this.FactNumber = factNumber;
    }
    @Override //перезапись метода toString для вывода в таблицу
    public String  toString(){
        return Integer.toString(Number)+" "+Nicname+" "+ Title+  " " +NameGame+" "+Integer.toString(GameCount)
                +  " " + FactNumber;
    }
    // возвращает значение Title
    public String getTitle() {
        return Title;
    }
    //устанавливает значение Title
    public void setTitle(String title) {
        Title = title;
    }
}
