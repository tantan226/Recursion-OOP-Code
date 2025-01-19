public class Bird extends Animal {
    private boolean canFly;

    public Bird(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex, boolean canFly) {
        super(species, heightM, weightKg, lifeSpanDays, biologicalSex);
        this.canFly = canFly;
    }
}
