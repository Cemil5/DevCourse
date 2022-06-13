package com.example.lessons.b_03_lambda.orange_withFunctional_Interface;

import lombok.Builder;
import lombok.Data;

//@Getter
//@Setter
//@ToString
@Builder
@Data
public class Orange {

    private int weight;
    private Color color;

}


//@Builder generates an @AllArgsConstructor unless there is another @XConstructor