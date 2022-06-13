package java8_update.b_05_streams.tasks;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {

    private Trader trader;
    private int year;
    private int value;


}
