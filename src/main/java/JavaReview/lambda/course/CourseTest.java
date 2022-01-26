package JavaReview.lambda.course;

public class CourseTest<javaCourse> {
    public static void main(String[] args) {
        Course java = new Java();
        java.study();


        Course selenium = new Selenium();
        selenium.study();


        // ******** Anonymous Inner Class ******** //

        Course java2 = new Course() {
            @Override
            public void study() {
                System.out.println("Studying Java2");
            }
        };
        java2.study();
    }
         // ******** Lambda ******** //
        Course javaCourse = () -> System.out.println("Studying Java");
       // javaCourse.study;


}
