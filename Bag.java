import java.util.Scanner;

public class Bag {
    private int smallpotion;
    private int midpotion;
    private int bigpotion;

    public Bag(){
        smallpotion = 5;
        midpotion = 5;
        bigpotion = 2;
    }

    private Item item = new Item();

    public int getSmallpotion() {
        return smallpotion;
    }

    public int getMidpotion() {
        return midpotion;
    }

    public int getBigpotion() {
        return bigpotion;
    }

    public void setSmallporion(int smallporion) {
        this.smallpotion = this.smallpotion + smallporion;
    }

    public void setMidpotion(int midpotion) {
        this.midpotion = this.midpotion + midpotion;
    }

    public void setBigpotion(int bigpotion) {
        this.bigpotion = this.bigpotion + bigpotion;
    }

    public int getPotionHeal(int select){
        if(select == 1){
            return item.getSmallpotionheal();
        }
        else if(select == 2){
            return item.getMidpotionheal();
        }
        else if(select == 3){
            return item.getBigpotionheal();
        }
        else return 0;
    }

}
