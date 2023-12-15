package by.yury;

public class Person  {

    public String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static   Person getInstance(){
        return new Person();
    }

    public void init() throws Exception
    {
        System.out.println("Я инит-метод " + this.getClass().getSimpleName());
    }

    public void destroy() throws Exception
    {
        System.out.println("Я дестрой-метод " + this.getClass().getSimpleName());
    }

}
