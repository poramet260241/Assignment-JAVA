public class Item {
    private int smallpotionheal;
    private int midpotionheal;
    private int bigpotionheal;

    public Item(){
        smallpotionheal = 10;
        midpotionheal = 50;
        bigpotionheal = 100;
    }

    public int getSmallpotionheal() {
        return smallpotionheal;
    }

    public int getMidpotionheal(){
        return midpotionheal;
    }

    public int getBigpotionheal() {
        return bigpotionheal;
    }
}
