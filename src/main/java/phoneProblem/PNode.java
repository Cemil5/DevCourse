package phoneProblem;

public class PNode {

        phoneProblem.PNode next;

        String firstName;
        String lastName;
        String email;
        String phoneNumber;


        public PNode(String firstName, String lastName, String email, String phoneNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phoneNumber = phoneNumber;
        }

    @Override
    public String toString() {
        return "PNode{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
