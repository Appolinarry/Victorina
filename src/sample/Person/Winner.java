package sample.Person;

public class Winner extends Gamer{
    private int FactNumber;

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

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getNic() {
        return Nicname;
    }

    public void setNic(String nic) {
        Nicname = nic;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getNameGame() {
        return NameGame;
    }

    public void setNameGame(String nameGame) {
        NameGame = nameGame;
    }

    public int getTotalCount() {
        return GameCount;
    }

    public void setTotalCount(int totalCount) {
        GameCount = totalCount;
    }

    public int getFactNumber() {
        return FactNumber;
    }

    public void setFactNumber(int factNumber) {
        FactNumber = factNumber;
    }
}
