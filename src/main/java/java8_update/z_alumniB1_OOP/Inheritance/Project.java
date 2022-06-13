package java8_update.z_alumniB1_OOP.Inheritance;

import java8_update.z_alumniB1_OOP.Encapsulation.User;
import java8_update.a_enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor // Lombok creates this constructor, super with noargs  constructor.
@Getter
@Setter
public class Project extends BaseEntity{

    private String projectCode;
    private String projectName;
    private User assignedManager;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status projectStatus;
    private long projectDetail;

    @Override
    public String toString() {
        return "Project{" +
                "projectCode='" + projectCode + '\'' +
                ", projectName='" + projectName + '\'' +
                ", assignedManager=" + assignedManager +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", projectStatus='" + projectStatus + '\'' +
                ", projectDetail=" + projectDetail +
                '}';
    }

    // we need to create this constructor (super with  argument) manually
    public Project(long id, LocalDateTime insertDateTime, long insertUserId, LocalDateTime lastUpdateTime,
                   long lastUpdateUserId, String projectCode, String projectName, User assignedManager,
                   LocalDate startDate, LocalDate endDate, Status projectStatus, long projectDetail) {
        super(id, insertDateTime, insertUserId, lastUpdateTime, lastUpdateUserId);
        this.projectCode = projectCode;
        this.projectName = projectName;
        this.assignedManager = assignedManager;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectStatus = projectStatus;
        this.projectDetail = projectDetail;


    }
}
