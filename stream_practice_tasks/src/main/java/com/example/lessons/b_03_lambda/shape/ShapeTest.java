package com.example.lessons.b_03_lambda.shape;

public class ShapeTest {
    public static void main(String[] args) {

        Drawable drawable = () -> System.out.println("Drawing a circle");
        drawable.draw();


        Drawable2 drawable2 = shape -> System.out.println("drawing a " + shape);
        drawable2.draw("Triangle");

        Drawable3 drawable3 = ((shape, name) -> System.out.println(name + " is drawing a " + shape));
        drawable3.draw("Square", "Ozzy");

        Drawable4 drawable4 = ((shape, area) -> "Drawing a " + shape + " and it's area is " + area);
        System.out.println(drawable4.draw("Circle", 200));

        Drawable3 drawable31 = (shape, name) -> {
            System.out.println("what kind of shape is this? : " + shape);
            System.out.println("Who is drawing this shape? : " + name);
        };
        drawable31.draw("Triangle", "Mike");
    }
}
