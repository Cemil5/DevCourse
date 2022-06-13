package java8_update.b_01_behaviorParameterization.apple;

public class AppleGreenColorPredicate  implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals(Color.GREEN);
    }
}
