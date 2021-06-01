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
    //устанавливает значение Number
    public void setNumber(int number) {
        Number = number;
    }
    // возвращает значение Nicname
    public String getNic() {
        return Nicname;
    }
    //устанавливает значение Nicname
    public void setNic(String nic) {
        Nicname = nic;
    }
    // возвращает значение Title
    public String getTitle() {
        return Title;
    }
    //устанавливает значение Title
    public void setTitle(String title) {
        Title = title;
    }
    // возвращает значение NameGame
    public String getNameGame() {
        return NameGame;
    }
    //устанавливает значение NameGame
    public void setNameGame(String nameGame) {
        NameGame = nameGame;
    }
    // возвращает значение GameCount
    public int getTotalCount() {
        return GameCount;
    }
    //устанавливает значение GameCount
    public void setTotalCount(int totalCount) {
        GameCount = totalCount;
    }
    // возвращает значение FactNumber
    public int getFactNumber() {
        return FactNumber;
    }
    //устанавливает значение FactNumber
    public void setFactNumber(int factNumber) {
        FactNumber = factNumber;
    }
}
