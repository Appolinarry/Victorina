package sample.Databases;

public class Story {
    private int NumberAction;
    private String WhatHappen;
    private String Action1;
    private String Action2;
    private String Action3;
    private int WhatDo1;
    private int WhatDo2;
    private int WhatDo3;
    private  int count1;
    private  int count2;
    private  int count3;

    public Story(int numberAction, String whatHappen, String action1, String action2, String action3, int whatDo1,
                 int whatDo2, int whatDo3, int count1, int count2, int count3) {
        this.NumberAction = numberAction;
        this.WhatHappen = whatHappen;
        this.Action1 = action1;
        this.Action2 = action2;
        this.Action3 = action3;
        this.WhatDo1 = whatDo1;
        this.WhatDo2 = whatDo2;
        this.WhatDo3 = whatDo3;
        this.count1 = count1;
        this.count2 = count2;
        this.count3 = count3;
    }

    @Override
    public String  toString(){
        return "\t"+WhatHappen+"\n"+"1)"+Action1+"\n"+"2)"+Action2+"\n"+"3)"+Action3;
    }
}
