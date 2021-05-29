package sample.Questons;

public class Facts {
    private int Number;//номер факта
    private String FactContent;//содержание факта
    private String FotoFact;//картинка к нему

    public Facts(int number, String factContent, String fotoFact) {
        Number = number;
        FactContent = factContent;
        FotoFact = fotoFact;
    }
    @Override
    public String  toString(){
        return FactContent;
    }
    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getFactContent() {
        return FactContent;
    }

    public void setFactContent(String factContent) {
        FactContent = factContent;
    }

    public String getFotoFact() {
        return FotoFact;
    }

    public void setFotoFact(String fotoFact) {
        FotoFact = fotoFact;
    }
}
