package phoneProblem;

public class PhoneBookApp {
    public static void main(String[] args) throws Exception {

        PhoneBook book1 = new PhoneBook();


        book1.add("Michael", "Jordan","mic@cydeo.com",
                "+1123654789");
        book1.add("Larry", "Bird","larry@cydeo.com",
                "+7123654789");
        book1.add("Jim", "Carey","jim@cydeo.com", "+6123654789");
        book1.add("Mike", "Carey","jim@cydeo.com", "+6123654789");
        book1.add("Jane", "Carey","jim@cydeo.com", "+6123654789");

      //  book1.printNodes();

//        System.out.println("find by name :");
//        System.out.println(book1.findByName("Michael"));

        System.out.println("find by last name");
        System.out.println(book1.findAllByLastName("Carey").size());

    }
}
