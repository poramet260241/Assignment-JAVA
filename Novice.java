import java.util.Scanner;
public class Novice {

    private Scanner scanner = new Scanner(System.in);
    //create object Bag
    private  Bag bag = new Bag();

    private String characterName;
    private String occupation;
    private int characterHp;
    private int characterMaxhp;
    private int characterExp;
    private int characterMoney;
    private int characterLevel;

    public Novice(){
        occupation = "Novice";
        characterHp = 100;
        characterExp = 0;
        characterMoney = 0;
        characterLevel = 1;
        characterMaxhp = 100;
    }



    public String getCharacterName() {
        return characterName;
    }

    public int getCharacterHp() {
        return characterHp;
    }

    public int getCharacterMaxhp() {
        return characterMaxhp;
    }

    public int getCharecterExp() {
        return characterExp;
    }

    public int getCharacterLevel() {
        return characterLevel;
    }

    public int getCharacterMoney() {
        return characterMoney;
    }

    public String getOccupation() {
        return  occupation;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public void setCharacterHp(int characterHp) {
        this.characterHp = this.characterHp + characterHp;
    }

    public void setCharecterExp(int charecterExp) {
        this.characterExp = this.characterExp + charecterExp;
    }

    public void setCharacterMaxhp(int characterMaxhp){
        this.characterMaxhp = this.characterMaxhp + characterMaxhp;
    }

    public void setCharacterLevel(int characterLevel) {
        this.characterLevel = this.characterLevel + characterLevel;
    }

    public void setCharacterMoney(int characterMoney) {
        this.characterMoney = this.characterMoney + characterMoney;
    }

    public void setOccupation(String occupation){
        this.occupation = occupation;
    }

    //for create first character
    public void createCharacter() {
        System.out.println("####CREATE YOUR CHARACTER####");
        System.out.print("Enter character name : ");
        setCharacterName(scanner.nextLine());
    }

    public void getStatus(){
        System.out.println("####YOUR STATUS####");
        System.out.println("Character name : " + getCharacterName());
        System.out.println("Occupation : "+ getOccupation());
        System.out.println("Level : " + getCharacterLevel());
        System.out.println("EXP : " + getCharecterExp());
        System.out.println("HP : " + getCharacterHp() + "/" + getCharacterMaxhp());
        System.out.println("Money : " + getCharacterMoney());
    }

    public boolean playGame(){
        System.out.println("------------------------------------");
        System.out.println("Press num 0-5 to select action");
        System.out.println("[1] Show character Status");
        System.out.println("[2] Attack Monster LV.1");
        System.out.println("[3] Attack Monster LV.2");
        System.out.println("[4] Attack Monster LV.3");
        System.out.println("[5] Open my bag");
        System.out.println("[0] EXIT");
        switch (scanner.nextInt()){
            case 1:
                getStatus();
                break;

            case 2:
                setStatus(10-characterLevel,10,0, 0 );
                System.out.println("Attack Success!");
                break;

            case 3:
                if(characterLevel - 4 <= 0){
                    setStatus(0,0,characterLevel-10,0);
                    System.out.println("Attack Fail!");
                }
                else {
                    setStatus(10-characterLevel,10,0, 0 );
                    System.out.println("Attack Success!");
                }
                break;

            case 4:
                if(characterLevel - 8 <= 0){
                    setStatus(0,0,characterLevel-15, 0);
                    System.out.println("Attack Fail!");
                }
                else {
                    setStatus(20-characterLevel,20,0, 0);
                    System.out.println("Attack Success!");

                }
                break;

            case 5:
                showListitem();
                break;

            case 0:
                return false;
        }
        return true;
    }

    public boolean setStatus(int exp, int money, int hp, int maxhp){
        setCharacterHp(hp);
        setCharacterMoney(money);
        setCharecterExp(exp);
        setCharacterMaxhp(maxhp);
        if(characterExp/100 == 1){
            System.out.println("###LEVEL UP###");
            setCharecterExp(-100);
            setCharacterLevel(+1);
            setCharacterHp(+10);
        }
        if(characterHp <= 0){
            System.out.println("###YOU ARE DEAD###");
            System.out.println("###GAME OVER!###");
            return true;
        }
        if(characterHp > characterMaxhp){
            characterHp = characterMaxhp;
        }
        return false;
    }

    public void useSmallpotion(){
        setCharacterHp(bag.getPotionHeal(1));
        System.out.println("Change HP");
    }

    public  void useMidpotion(){
        setCharacterHp(bag.getPotionHeal(2));
    }

    public void useBigpotion(){
        setCharacterHp(bag.getPotionHeal(3));
    }

    public void showListitem(){
        int select;
        System.out.println("####LIST ITEMS####");
        System.out.println("Small Potion    :"+bag.getSmallpotion());
        System.out.println("Mid Potion      :"+bag.getMidpotion());
        System.out.println("Big Potion      :"+bag.getBigpotion());
        System.out.println("Press [1] to use your item.");
        select = scanner.nextInt();
        if (select == 1){
            useItem();
        }
    }

    public void useItem(){

        int select;
        System.out.println("####USE ITEMS####");
        System.out.println("[1] Use Small Potion    HP+10");
        System.out.println("[2] Use Mid Potion      HP+50");
        System.out.println("[3] Use Big Potion      HP+100");
        System.out.println("Select Items to use");
        select = scanner.nextInt();
        if (select == 1 && bag.getSmallpotion() >= 1){
            bag.setSmallporion(-1);
            useSmallpotion();
            System.out.println("Use Small Potion");
            return;
        }
        if (select == 2 && bag.getMidpotion() >= 1){
            bag.setMidpotion(-1);
            useMidpotion();
            System.out.println("Use Mid Potion");
            return;
        }
        if (select == 3 && bag.getBigpotion() >= 1){
            bag.setBigpotion(-1);
            useBigpotion();
            System.out.println("Use Big Potion");
            return;
        }
        else {
            System.out.println("You don't have item");
        }
    }

    public boolean selectOccupation(){
        int select;
        System.out.println("***********You are Level 10 Please select your new Class***********");
        System.out.println("[1] Archer add max HP +200");
        System.out.println("[2] Warier add max HP +300");

        do{
            select = scanner.nextInt();
        }
        while (select != 1 && select != 2);

        if (select == 1){
            setOccupation("Archer");
            setStatus(0, 0, 200, 200);
        }
        if (select == 2){
            setOccupation("Warier");
            setStatus(0,0,300,300);
        }
        System.out.println("Now your Occupation is " + getOccupation());
        return  true;
    }

}
