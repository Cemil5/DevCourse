package java8_update.z_alumniB1_OOP.Inheritance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class BaseEntity {

    private long id;
    private LocalDateTime insertDateTime;
    private long insertUserId;
    private LocalDateTime lastUpdateTime;
    private long lastUpdateUserId;


}
