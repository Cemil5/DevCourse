package javaReview.streams.exercises;

/*
import com.cybertek.enums.Gender;
import com.cybertek.enums.Status;
import com.cybertek.oop.encapsulation.User;
import com.cybertek.oop.inheritance.Project;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;*/

public class MyStreamDemo {
/*
    public static void main(String[] args) {
        System.out.println("getListOfProject() = " + getListOfProject().get(0).getProjectName());
        System.out.println("getListOfProject() = " + getListOfProject().stream().findFirst().get().getProjectName());

        System.out.println("getListOfProject(getListOfProject(Status.IN_PROGRESS)) = "
                + getListOfProject(Status.IN_PROGRESS).get(0).getProjectName());
        System.out.println("getListOfProject(getListOfProject(Status.IN_PROGRESS)) = "
                + getListOfProject(Status.IN_PROGRESS).stream().findFirst().get().getProjectName());

        System.out.println("getListOfProject(DataGenerator.manager4).get(0).getAssignedManager().getFirstName() = "
                + getListOfProject(DataGenerator.manager4).get(0).getAssignedManager().getFirstName());

        System.out.println("getProjectByProjectCode(\"PRJ002\") = " + getProjectByProjectCode("PRJ002").get(0).getProjectDetail());

        for (User u : getListOfUsers()){
            System.out.println("u = " + u.getFirstName());
        }

        System.out.println("getUserByFirstName(\"Craig\") = " + getUserByFirstName("Richard").getFirstName());

        System.out.println("getUserByUserId(10L) = " + getUserByUserId(10L));


        for (User u : deleteUser("Richard")){
            System.out.println("deleteUser = " + u.getFirstName());
        }

        for (Project u : updateProjectStatus(Status.IN_PROGRESS, Status.COMPLETED)){
            System.out.println(u.getProjectStatus() + " " + u.getProjectName());
        }

        System.out.println("totalProjectDurationForManager(DataGenerator.manager1) = " + totalProjectDurationForManager(DataGenerator.manager1));

        System.out.println("findTotalMaleInCompany() = " + findTotalMaleInCompany());
    }

    //   Task-1

    public static @NotNull List<Project> getListOfProject(){
        return DataGenerator.getProjects();
    }

    // task-2   use lambda
    public static List<Project> getListOfProject(Status status){
        List<Project> list = DataGenerator.getProjects();
        return list.stream().filter(st -> st.getProjectStatus().equals(status)).collect(Collectors.toList());
    }


    //    task - 3 get only project with the given manager name // task-10 aynı değil mi?
    public static List<Project> getListOfProject(User manager){
        List<Project> list = DataGenerator.getProjects();
        return list.stream().filter(mn -> mn.getAssignedManager().equals(manager)).collect(Collectors.toList());
    }


    // task - 4
    public static List<Project> getProjectByProjectCode(String projectCode){
        List<Project> list = DataGenerator.getProjects();
        return list.stream().filter(cd -> cd.getProjectCode().equals(projectCode)).collect(Collectors.toList());
    }


    //    task - 5
    public static List<User> getListOfUsers(){
        return DataGenerator.getUsers();
    }


    //     task - 6 find first user
    public static User getUserByFirstName(String firstName){
        return getListOfUsers().stream().filter(st -> st.getFirstName().equals(firstName)).findFirst().get();
    }


    // task - 7
    public static String getUserByUserId(Long id){
        return getListOfUsers().stream().filter(lg -> lg.getId() == id).findFirst().get().getFirstName();
    }


    //   task - 8    delete the given user and return the rest
    public static List<User> deleteUser(String firstName){
        return getListOfUsers().stream().filter(st -> !st.getFirstName().equals(firstName)).collect(Collectors.toList());
    }


    //     task - 9
    public static List<Project> updateProjectStatus(Status oldStatus, Status newStatus){
        List<Project> list = DataGenerator.getProjects();
        list.stream().filter(old -> old.getProjectStatus().equals(oldStatus)).forEach(nt -> nt.setProjectStatus(newStatus));
        return list;
    }

    // task - 10   //
    public static List<Project> findProjectByManager(User manager){
        List<Project> list = DataGenerator.getProjects();
        return list.stream().filter(mn ->mn.getAssignedManager().equals(manager)).collect(Collectors.toList());
    }


    // task - 11   Period
    public static Integer totalProjectDurationForManager(User manager){
        List<Project> list = DataGenerator.getProjects();
        list = list.stream().filter(mn ->mn.getAssignedManager().equals(manager)).collect(Collectors.toList());
        int a = 0;
        Period period = Period.ofYears(0);
        for (Project project : list){
            period = Period.between(project.getStartDate(), project.getEndDate());
            a += period.getDays();
        }
        return a;
    }


    // task - 12
    public static long findTotalMaleInCompany(){
        List<User> users = DataGenerator.getUsers();
        List<User> mn = DataGenerator.getManagers();
        int a = (int) users.stream().filter(gn -> gn.getGender().equals(Gender.MALE)).count();
        return a += (int) mn.stream().filter(gn -> gn.getGender().equals(Gender.MALE)).count();
    } */
}
