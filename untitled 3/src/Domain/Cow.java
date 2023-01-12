package Domain;

public class Cow implements Animal {
    private String colour;
    private String name;
    private double weight;
    private String className = "cow";
    private int ID;

    public Cow(int ID, String colour, String name, double weight) {
        this.ID = ID;
        this.colour = colour;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public void speak() {
        System.out.println("Mooooooo!");
    }

    @Override
    public String getColor() {
        return this.colour;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public void printAnimal() {
        String printingString = "The cow named " + this.name + " has colour " + this.colour + " and it weights " + this.weight + " kg\n";
        System.out.print(printingString);
    }
}
