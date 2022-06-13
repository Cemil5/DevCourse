package a_selfStudy_Code_Leet_Hacker.possibleMentorQuestions.a4_objectClass;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TwoFighters_CodeWars_7kyu {

    public static String declareWinner2(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        // Your code goes here. Have fun!
        do {
            if (firstAttacker.equals(fighter1.name)) {
                fighter2.health -= fighter1.damagePerAttack;
                firstAttacker = fighter2.name;
            } else {
                fighter1.health -= fighter2.damagePerAttack;
                firstAttacker = fighter1.name;
            }
        }while (fighter1.health>0 && fighter2.health >0);

        if(fighter2.health >0){
            return fighter2.name ;
        } else  {
            return fighter1.name ;
        }
    }

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        Fighter a=fighter1, b=fighter2;
        if (firstAttacker.equals(fighter2.name)) {
            a = fighter2; b = fighter1;
        }
        while (true) {
            if ((b.health -= a.damagePerAttack) <= 0) return a.name;  // a wins
            if ((a.health -= b.damagePerAttack) <= 0) return b.name;  // b wins
        }
    }

    @Test
    public void basicTests() {
        assertEquals("Lew", declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew"));
        assertEquals("Harry", declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));
        assertEquals("Harald", declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
        assertEquals("Harald", declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
    }

    public static String declareWinner1(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        // Your code goes here. Have fun!
        if (firstAttacker.equals(fighter1.name)){
            fighter2.health -= fighter1.damagePerAttack;
            if(fighter2.health>0){
                return fighter1.name + " attacks "+fighter2.name + "; " + fighter2.name + " now has " + fighter2.health + " health.";
            } else {
                return fighter1.name + " attacks "+fighter2.name + ": " + fighter2.name + " now has " + fighter2.health + " health and is dead." + fighter2.name + " wins.";
            }
        } else{
            fighter1.health -= fighter2.damagePerAttack;
            if(fighter1.health>0){
                return fighter2.name + " attacks "+fighter1.name + "; " + fighter1.name + " now has " + fighter1.health + " health.";
            } else {
                return fighter2.name + " attacks "+fighter1.name + ": " + fighter1.name + " now has " + fighter1.health + " health and is dead." + fighter1.name + " wins." ;
            }
        }
    }




    public class Fighter {
        public String name;
        public int health, damagePerAttack;
        public Fighter(String name, int health, int damagePerAttack) {
            this.name = name;
            this.health = health;
            this.damagePerAttack = damagePerAttack;
        }
    }
}

/*
Two fighters, one winner.
7 kyu
Create a function that returns the name of the winner in a fight between two fighters.

Each fighter takes turns attacking the other and whoever kills the other first is victorious. Death is defined as having health <= 0.

Each fighter will be a Fighter object/instance. See the Fighter class below in your chosen language.

Both health and damagePerAttack (damage_per_attack for python) will be integers larger than 0. You can mutate the Fighter objects.

Example:
  declare_winner(Fighter("Lew", 10, 2), Fighter("Harry", 5, 4), "Lew") => "Lew"

  Lew attacks Harry; Harry now has 3 health.
  Harry attacks Lew; Lew now has 6 health.
  Lew attacks Harry; Harry now has 1 health.
  Harry attacks Lew; Lew now has 2 health.
  Lew attacks Harry: Harry now has -1 health and is dead. Lew wins.
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

