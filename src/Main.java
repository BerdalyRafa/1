import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Person> personList = new MyArrayList<>();
        MyLinkedList<Person> personLinkedList = new MyLinkedList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of persons for MyArrayList:");
        int numPersons = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numPersons; i++) {
            System.out.println("Enter person's name:");
            String name = scanner.nextLine();

            System.out.println("Enter person's age:");
            int age = scanner.nextInt();
            scanner.nextLine();

            Person person = new Person(name, age);
            personList.add(person);
        }

        System.out.println("Enter the number of persons for MyLinkedList:");
        numPersons = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numPersons; i++) {
            System.out.println("Enter person's name:");
            String name = scanner.nextLine();

            System.out.println("Enter person's age:");
            int age = scanner.nextInt();
            scanner.nextLine();

            Person person = new Person(name, age);
            personLinkedList.add(person);
        }

        System.out.println("Contents of MyArrayList before addAll:");
        displayPersonList(personList);

        System.out.println("\nContents of MyLinkedList before addAll:");
        displayPersonList(personLinkedList);


        MyArrayList<Person> additionalPersonsArrayList = new MyArrayList<>();
        additionalPersonsArrayList.add(new Person("John", 28));
        additionalPersonsArrayList.add(new Person("Jane", 32));


        MyLinkedList<Person> additionalPersonsLinkedList = new MyLinkedList<>();
        additionalPersonsLinkedList.add(new Person("Ella", 25));
        additionalPersonsLinkedList.add(new Person("Mike", 40));


        personList.addAll(additionalPersonsArrayList);
        personLinkedList.addAll(additionalPersonsLinkedList);


        System.out.println("\nContents of MyArrayList after addAll:");
        displayPersonList(personList);

        System.out.println("\nContents of MyLinkedList after addAll:");
        displayPersonList(personLinkedList);
    }

    private static void displayPersonList(MyArrayList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            Person person = list.get(i);
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        }
    }

    private static void displayPersonList(MyLinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            Person person = list.get(i);
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        }
    }
}
