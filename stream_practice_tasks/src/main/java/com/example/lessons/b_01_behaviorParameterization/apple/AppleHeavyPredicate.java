package com.example.lessons.b_01_behaviorParameterization.apple;

public class AppleHeavyPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight()>200;
    }
}
