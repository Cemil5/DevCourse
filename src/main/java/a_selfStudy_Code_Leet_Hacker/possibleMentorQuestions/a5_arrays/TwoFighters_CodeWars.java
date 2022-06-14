package a_selfStudy_Code_Leet_Hacker.possibleMentorQuestions.a5_arrays;


import org.testng.annotations.Test;

public class TwoFighters_CodeWars {

    @Test
    public void basicTests() {
//        assertEquals("Tom", declareWinner(new Fighter("Tom", 10, 2), new Fighter("Harry", 5, 4), "Tom"));
//        assertEquals("Harry", declareWinner(new Fighter("Tom", 10, 2), new Fighter("Harry", 5, 4), "Harry"));
//        assertEquals("Harald", declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
//        assertEquals("Harald", declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));
//        assertEquals("Harald", declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
//        assertEquals("Harald", declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
    }

    public static String declareWinner1(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        // Your code goes here. Have fun!
        if (firstAttacker.equals(fighter1.name)) {
            fighter2.health -= fighter1.damagePerAttack;
            if (fighter2.health > 0) {
                return fighter1.name + " attacks " + fighter2.name + "; " + fighter2.name + " now has " + fighter2.health + " health.";
            } else {
                return fighter1.name + " attacks " + fighter2.name + ": " + fighter2.name + " now has " + fighter2.health + " health and is dead." + fighter2.name + " wins.";
            }
        } else {
            fighter1.health -= fighter2.damagePerAttack;
            if (fighter1.health > 0) {
                return fighter2.name + " attacks " + fighter1.name + "; " + fighter1.name + " now has " + fighter1.health + " health.";
            } else {
                return fighter2.name + " attacks " + fighter1.name + ": " + fighter1.name + " now has " + fighter1.health + " health and is dead." + fighter1.name + " wins.";
            }
        }
    }


    public static class Fighter {
        public String name;
        public int health, damagePerAttack;

        public void setInfo(String name, int health, int damagePerAttack) {
            this.name = name;
            this.health = health;
            this.damagePerAttack = damagePerAttack;
        }
    }

//        public Fighter(String name, int health, int damagePerAttack) {
//            this.name = name;
//            this.health = health;
//            this.damagePerAttack = damagePerAttack;
//        }
//    }

    public static String declareWinner2(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        do {
            if (firstAttacker.equals(fighter1.name)) {
                fighter2.health -= fighter1.damagePerAttack;
                firstAttacker = fighter2.name;
            } else {
                fighter1.health -= fighter2.damagePerAttack;
                firstAttacker = fighter1.name;
            }
        } while (fighter1.health > 0 && fighter2.health > 0);

        if (fighter2.health > 0) {
            return fighter2.name + " wins";
        } else {
            return fighter1.name + " wins";
        }
    }

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        Fighter a = fighter1, b = fighter2;
        if (firstAttacker.equals(fighter2.name)) {
            a = fighter2;
            b = fighter1;
        }
        while (true) {
            if ((b.health -= a.damagePerAttack) <= 0) return a.name + " wins";  // a wins
            if ((a.health -= b.damagePerAttack) <= 0) return b.name + " wins";  // b wins
        }
    }
    public static void main(String[] args) {
        Fighter fighter1 = new Fighter();
        fighter1.setInfo("Tom", 10, 2);
        Fighter fighter2 = new Fighter();
        fighter2.setInfo("Harry", 5, 4);
        System.out.println(declareWinner(fighter1, fighter2, "Tom"));
    }


}

/*
Two fighters, one winner
7 kyu

Create a function that returns the name of the winner in a fight between two fighters.
Each fighter takes turns attacking the other and whoever kills the other first is victorious. Death is defined as having health <= 0.
Each fighter will be a Fighter object/instance (which contains name, health, damagePerAttack and also setInfo method or constructor).
Both health and damagePerAttack will be integers larger than 0. You can mutate the Fighter objects.

Example:
  input :
  declareWinner(Fighter("Tom", 10, 2), Fighter("Harry", 5, 4), "Tom")
  output : "Tom wins"
  Explanation :
  Tom attacks Harry; Harry now has 3 health.
  Harry attacks Tom; Tom now has 6 health.
  Tom attacks Harry; Harry now has 1 health.
  Harry attacks Tom; Tom now has 2 health.
  Tom attacks Harry: Harry now has -1 health and is dead. Tom wins.

public class Fighter {
  public String name;
  public int health, damagePerAttack;
  public Fighter(String name, int health, int damagePerAttack) {
    this.name = name;
    this.health = health;
    this.damagePerAttack = damagePerAttack;
  }
}
 */

