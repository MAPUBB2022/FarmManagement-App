package Domain;

public class Chicken implements Animal {
    private String colour;
    private String name;
    private double weight;
    private String className = "chicken";
    public int ID;

    public Chicken(int ID, String colour, String name, double weight) {
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
        System.out.println("Cluck cluck!");
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
        String printingString = "The chicken named " + this.name + " has colour " + this.colour + " and it weights " + this.weight + " kg\n";
        System.out.print(printingString);
    }
}
