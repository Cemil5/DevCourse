package java8_update.b_04_doubleColonOperator;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class CalculatorTest {
    public static void main(String[] args) {

       //Reference to a static method
        Calculate s1 = (x,y) -> Calculator.findSum(x,y);
        s1.calculate(10,20);    // 30

        Calculate s2 = Calculator::findSum;
        s2.calculate(100,35);   // 135

        System.err.println("similar to : ");
        Calculator.findSum(10, 20); // 30


        //Reference to instance method
        Calculate m1 = (x,y) -> new Calculator().findMultiply(x,y);
        m1.calculate(5,6);  // 30

        Calculator obj = new Calculator();
        Calculate m2 = obj::findMultiply;
        m2.calculate(8,9);  // 72

        Calculate m3 = new Calculator()::findMultiply;
        m3.calculate(6,6);  // 36

        System.err.println("similar to : ");
        new Calculator().findMultiply(6, 6);

        // Reference to instance method without new keyword
        // we pass the class as a first parameter
        BiFunction<String,Integer,String> fn = (str,i) -> str.substring(i);
        System.out.println(fn.apply("Developer",6));

        BiFunction<String,Integer,String> fn2 = String::substring;
        System.out.println(fn2.apply("Developer",6));

        Consumer<Integer> display = i -> System.out.println(i);
        display.accept(20);

        Consumer<Integer> display2 = System.out::println;
        display2.accept(50);


         BiFunction<MyClass,Integer,Double> v2 = MyClass::method;

         BiFunction<String,String,String> v3 = String::concat;


    }
}
