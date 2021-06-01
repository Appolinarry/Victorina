package sample.Person;

public class TitleCreator {
    private int NumberTitle;//номер титула
    private String NameGame;//название темы игры
    private String Title;//титул
    private String WinOrNot;//индикатор победы в игре
    //конструктор класса
    public TitleCreator(int numberTitle, String nameGame, String title, String winOrNot) {
        NumberTitle = numberTitle;
        NameGame = nameGame;
        Title = title;
        WinOrNot = winOrNot;
    }
    //перезапись toString
    @Override
    public String  toString(){
        return Integer.toString(NumberTitle) + " " + NameGame + " " + Title + " " + " " + WinOrNot;
    }
    //возвращает значение NumberTitle
    public int getNumberTitle() {
        return NumberTitle;
    }
    //устанавливает значение NumberTitle
    public void setNumberTitle(int numberTitle) {
        NumberTitle = numberTitle;
    }
    //возвращает значение NumberTitle
    public String getNameGame() {
        return NameGame;
    }
    //устанавливает значение NumberTitle
    public void setNameGame(String nameGame) {
        NameGame = nameGame;
    }
    //возвращает значение Title
    public String getTitle() {
        return Title;
    }
    //устанавливает значение Title
    public void setTitle(String title) {
        Title = title;
    }
    //возвращает значение WinOrNot
    public String getWinOrNot() {
        return WinOrNot;
    }
    //устанавливает значение WinOrNot
    public void setWinOrNot(String winOrNot) {
        WinOrNot = winOrNot;
    }
}
