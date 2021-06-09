package sample.Person;

public class TitleCreator {
    //номер титула
    private int NumberTitle;
    //название темы игры
    private String NameGame;
    //титул
    private String Title;
    //индикатор победы в игре
    private String WinOrNot;
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
    //возвращает значение Title
    public String getTitle() {
        return Title;
    }
    //устанавливает значение Title
    public void setTitle(String title) {
        Title = title;
    }
}
