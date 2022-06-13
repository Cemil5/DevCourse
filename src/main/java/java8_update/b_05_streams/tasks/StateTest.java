package java8_update.b_05_streams.tasks;

import java.util.List;
import java.util.stream.Collectors;

public class StateTest {
    /*
    Suppose we have a State class that contains list of cities.
    Create a list of States and print all the cities.
     */
    public static void main(String[] args) {


        State va = new State();
        va.addCity("McLean");
        va.addCity("Arlington");
        va.addCity("Fairfax");
        va.addCity("FallsChurch");

        State tx = new State();
        tx.addCity("Dallas");
        tx.addCity("Plano");
        tx.addCity("Austin");
        tx.addCity("Houston");

        List<State> list = List.of(va, tx);




//        list.stream().map(state -> state.getCity()).forEach(System.out::println);

        list.stream()
                .map(state -> state.getCity())
                .flatMap(List::stream)
                .forEach(System.out::println);

        list.stream()
                .map(State::getCity)
                .flatMap(List::stream)
                .forEach(System.out::println);


        List<String> result = list.stream()
                .map(State::getCity)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("result = " + result);
    }


}
