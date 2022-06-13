package com.example.lessons.b_05_streams.tasks;

import com.example.lessons.b_05_streams.Type;
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
