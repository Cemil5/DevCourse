package java8_update.b_05_streams.tasks;

import java8_update.b_05_streams.Type;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dish {
    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;
}
