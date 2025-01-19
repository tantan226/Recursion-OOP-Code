public class Chicken extends Bird{
    private int eggPrice = 20;
    private double weightKg;

    public Chicken(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex,boolean canFly){
        super(species, heightM, weightKg, lifeSpanDays, biologicalSex, canFly);
        this.weightKg = weightKg;
    }

    public int spawnEgg(){
        return this.eggPrice;
    }

    public void setEggPrice(int price){
        System.out.println("Change egg price from " + this.eggPrice + " to " + price);
        this.eggPrice = price;
    }

    @Override
    public String toString(){
        return super.toString() + "eggPrice:" + this.eggPrice;
    }      
}
