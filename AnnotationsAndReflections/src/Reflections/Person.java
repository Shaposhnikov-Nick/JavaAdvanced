package Reflections;

@Author(name = "Nick", dateOfCreation = 2021)
public class Person {
    private int id;
    private String name;

    public Person() {
        this.id = -1;
        this.name = "Noname";
    }

    public void sayHello(){
        System.out.printf("Person with id %d with name %s says Hello\n",id, name);
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
