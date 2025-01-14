import java.util.Arrays;
class Wallet{
    private int bill1;
    private int bill5;
    private int bill10;
    private int bill20;
    private int bill50;
    private int bill100;

    public Wallet(){}

    public int getTotalMoney(){
        return (1*bill1) + (5*bill5) + (10*bill10) + (20*bill20) + (50*bill50) + (100*bill100);
    }

    public int insertBill(int bill, int amount){
        switch(bill){
            case(1):
                bill1 += amount;
                break;
            case(5):
                bill5 += amount;
                break;
            case(10):
                bill10 += amount;
                break;
            case(20):
                bill20 += amount;
                break;
            case(50):
                bill50 += amount;
                break;
            case(100):
                bill100 += amount;
                break;
            default:
                return 0;
        }

        return bill*amount;
    }

    public int removeBill(int bill, int amount){
                switch(bill){
            case(1):
                bill1 -= amount;
                break;
            case(5):
                bill5 -= amount;
                break;
            case(10):
                bill10 -= amount;
                break;
            case(20):
                bill20 -= amount;
                break;
            case(50):
                bill50 -= amount;
                break;
            case(100):
                bill100 -= amount;
                break;
            default:
                return 0;
        }

        return bill*amount;
    }
}

class Person{
    private String firstName;
    private String lastName;
    private int age;
    private double heightM;
    private double weightKg;
    private Wallet wallet;
    private String denomination = "highestFirst";


    public Person(String firstName, String lastName, int age, double heightM, double weightKg){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.heightM = heightM;
        this.weightKg = weightKg;
        this.wallet = new Wallet();
    }
    //Personクラスのオーバーロード　initialMoney
    public Person(String firstName, String lastName, int age, double heightM, double weightKg, int initialMoney){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.heightM = heightM;
        this.weightKg = weightKg;
        this.wallet = new Wallet();
        this.getPaid(initialMoney);
        
    }

    public int getCash(){
        if(this.wallet == null) return 0;
        return this.wallet.getTotalMoney();
    }

    public void printState(){
        System.out.println("firstname - " + this.firstName);
        System.out.println("lastname - " + this.lastName);
        System.out.println("age - " + this.age);
        System.out.println("height - " + this.heightM);
        System.out.println("weight - " + this.weightKg);
        System.out.println("Current Money - " + this.getCash());
        System.out.println();
    }
    //highestの時のお札のリストを返す
    private int[] highestFirstList(int money){
        int[] billsList = new int[6];
        //お札ごとの金額のリスト
        int[] billsAmount = new int[] {1, 5, 10, 20, 50, 100};
        //各お札に割られたときのあまり
        int remainderMoney = money;

        for(int i = billsList.length - 1;i >= 0;i--){
            //各お札ごとに枚数を決める
            billsList[i] = remainderMoney / billsAmount[i];
            remainderMoney = remainderMoney % billsAmount[i];
        }

        return billsList;
        
    }
    //twentiesの時のお札のリストを返す
    private int[] twentiesList(int money){
        //[0]=1$ [1]=5$ [2]=10$ [3]=20$ 
        int[] billsList = new int[6];
        //お札ごとの金額のリスト
        int[] billsAmount = new int[] {1, 5, 10, 20};
        //各お札に割られたときのあまり
        int remainderMoney = money;

        for(int i = billsAmount.length - 1;i >= 0;i--){
            //各お札ごとに枚数を決める
            switch(billsAmount[i]){
                case(20):
                    billsList[3] = remainderMoney / 20;
                    remainderMoney = remainderMoney % 20;
                    break;
            
                case(10):
                    billsList[2] = remainderMoney / 10;
                    remainderMoney = remainderMoney % 10;
                    break;
                
                case(5):
                    billsList[1] = remainderMoney / 5;
                    remainderMoney = remainderMoney % 5;
                    break;
                
                case(1):
                    billsList[0] = remainderMoney / 1;
                    break;
            
                default : break;
            }
        }

        return billsList;
    }

    public int[] getPaid(int money){
        //財布がない場合はnullを返す
        if(this.wallet == null)return null;
        //空のお札リスト
        int[] billsList = new int[6];
        //お札の種類のリスト
        int[] billsAmount = new int[] {1, 5, 10, 20, 50, 100};

        //denominationによって処理を変更
        switch (this.denomination) {
            case "highestFirst":
                for(int i = 0;i < billsList.length;i++){
                    billsList = this.highestFirstList(money);
                    this.wallet.insertBill(billsAmount[i],billsList[i]);
                }   break;
            case "twenties":
                for(int i = 0;i < billsList.length;i++){
                    billsList = this.twentiesList(money);
                    this.wallet.insertBill(billsAmount[i],billsList[i]);
                }   break;
            case "dollars":
                this.wallet.insertBill(1,money);
                billsList[0] = money;
                break;
            default:
                break;
        }


        return billsList;
    }

    public int[] spendMoney(int money){
        if(this.wallet ==  null)return null;

        //お金を記憶しておく
        int remainderMoney = money;
        //空のお金リスト
        int[] billsList = new int[6];
        //お金の種類
        int[] billsAmount = new int[] {1, 5, 10, 20, 50, 100};

        //denominationによって処理を変更
        switch (this.denomination) {
            case "highestFirst":
                for(int i = 0;i < billsList.length;i++){
                    billsList = this.highestFirstList(money);
                    this.wallet.removeBill(billsAmount[i],billsList[i]);
                }   break;
            case "twenties":
                for(int i = 0;i < billsList.length;i++){
                    billsList = this.twentiesList(money);
                    this.wallet.removeBill(billsAmount[i],billsList[i]);
                }   break;
            case "dollars":
                billsList[0] = money;
                this.wallet.removeBill(1,money);
                break;
            default:
                break;
        }

        return billsList;

    }

    public void setDenominationPreference(String denomination) {
        //対応してなかったら警告して何もしない
        if(!(denomination.equals("highestFirst")) && !(denomination.equals("twenties")) && !(denomination.equals("dollars"))){
            System.out.println("This denomination is not available.");
        }
        else {
            this.denomination = denomination;
        }
    }

    public Wallet dropWallet(){
        if(this.wallet == null)return null;

        Wallet output = this.wallet;
        this.wallet = null;
        return output;
    }

    public void addWallet(){
        //すでに所有していたら警告
        if(this.wallet != null){
            System.out.println("You have a wallet already.");
        }else{
            this.wallet = new Wallet();
        }
    }
}

public class App {
    public static void main(String[] args){
        Person p = new Person("Ryu","Poolhopper", 40, 1.8, 140);
        p.printState();

        // p.wallet.insertBill(5,3);
        // p.wallet.insertBill(100,2);

        p.printState();
        p.addWallet();


        Person p2 = new Person("Ryu","Poolhopper", 24, 1.8, 60, 389);
        p2.printState();

        System.out.println(Arrays.toString(p2.getPaid(389)));
    
        p2.setDenominationPreference("test");//取り扱いタイプにないので警告
        
        p2.setDenominationPreference("twenties");
        System.out.println(Arrays.toString(p2.getPaid(389)));
        p2.setDenominationPreference("dollars");
        System.out.println(Arrays.toString(p2.spendMoney(389)));

        p2.printState();

        p2.addWallet();
        System.out.println(p2.dropWallet().getTotalMoney());

        p2.printState();
    }
}
