package models;

public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person other) {

        if (this.age < other.age) return -1;
        if (this.age > other.age) return 1;

        int cmpName = this.name.compareToIgnoreCase(other.name);
        if (cmpName != 0) return cmpName;

        return Integer.compare(
                this.toString().hashCode(),
                other.toString().hashCode()
        );
    }

    @Override
    public String toString() {
        return "Person(" + name + ", " + age + ")";
    }
}