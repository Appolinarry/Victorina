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
    // возвращает значение Number
    public int getNumber() {
        return Number;
    }
    // возвращает значение Nicname
    public String getNic() {
        return Nicname;
    }
    // возвращает значение Title
    public String getTitle() {
        return Title;
    }
    // возвращает значение NameGame
    public String getNameGame() {
        return NameGame;
    }
    // возвращает значение GameCount
    public int getTotalCount() {
        return GameCount;
    }
    // возвращает значение FactNumber
    public int getFactNumber() {
        return FactNumber;
    }
}
