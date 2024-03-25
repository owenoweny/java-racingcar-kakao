public class Car implements Comparable<Car> {

    private final String owner;

    private int offset;

    public Car(String owner, int offset) {
        this.owner = owner;
        this.offset = offset;
    }

    public static Car of(String name) {
        return new Car(name, 0);
    }

    public void move() {
        this.offset++;
    }

    public int status() {
        return offset;
    }

    public String owner() {
        return this.owner;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.offset, o.offset);
    }
    
}
