import java.util.List;

public class Main {
    public static void main(String[] args) {

        Person per1 = new Person("Алексей", "Алексеев", Person.Sex.MALE, null);
        Person per2 = new Person("Иван", "Алексеев", Person.Sex.MALE, per1);
        Person per3 = new Person("Анжелика", "Алексеева", Person.Sex.FEMALE, per2);
        Person per4 = new Person("Антон", "Богданов", Person.Sex.MALE, per3);
        Person per5 = new Person("Елена", "Богданова", Person.Sex.FEMALE, per3);
        Person per6 = new Person("Антонина", "Богданова", Person.Sex.FEMALE, per5);

        System.out.println("Родители: ");
        for (Person person : per2.getParents()) {
            System.out.println(person.getNameData());
        }

        System.out.println("Дети: ");
        for (Person person : per3.getChildren()) {
            System.out.println(person.getNameData());
        }

        System.out.println("Родители родителей: ");
        for (Person person : per3.getSubParents()) {
            System.out.println(person.getNameData());
        }

        System.out.println("Внуки: ");
        for (Person person : per3.getSubChildren()) {
            System.out.println(person.getNameData());
        }
    }
}