package Domain;

public class Administrator implements Human {

    int salary = 4000;
    String name = "Mark Zuckernerg";
    int age = 40;

    private Administrator() {
    }

    private static class SingletonHolder {
        private static final Administrator INSTANCE = new Administrator();
    }

    public static Administrator getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }
}
