public class Main{
    public static void main(String[] args){
        Chicken chicken1 = new Chicken("bird", 0.3, 3, 1500, "female", false);

        System.out.println(chicken1);
        System.out.println("Egg Price: " + chicken1.spawnEgg());
        chicken1.setEggPrice(25);
        System.out.println(chicken1);
    }
}