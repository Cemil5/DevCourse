package JavaReview.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
//@AllArgsConstructor
public enum Status {

    OPEN("Open"), IN_PROGRESS("In progress"), UAT_TEST("UAT Testing"), COMPLETED("Completed");

    private final String value;

    Status(String value) {   // constructor
        this.value = value;
    }
}
