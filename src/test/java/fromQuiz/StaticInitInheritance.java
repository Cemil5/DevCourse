package fromQuiz;

public class StaticInitInheritance {

    public static void main(String[] args) {
        C c = new C();
    }
}
class A {
    {
        System.out.println(1);
    }
}

class B extends A {
    static {
        System.out.println(2);
    }
}

class C extends B {
    {
        System.out.println(3);
    }
}