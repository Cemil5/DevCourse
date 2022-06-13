package com.example.streampracticetask.practice;

import com.example.streampracticetask.model.*;
import com.example.streampracticetask.service.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Practice {

    public static CountryService countryService;
    public static DepartmentService departmentService;
    public static EmployeeService employeeService;
    public static JobHistoryService jobHistoryService;
    public static JobService jobService;
    public static LocationService locationService;
    public static RegionService regionService;

    public Practice(CountryService countryService, DepartmentService departmentService,
                    EmployeeService employeeService, JobHistoryService jobHistoryService,
                    JobService jobService, LocationService locationService,
                    RegionService regionService) {

        Practice.countryService = countryService;
        Practice.departmentService = departmentService;
        Practice.employeeService = employeeService;
        Practice.jobHistoryService = jobHistoryService;
        Practice.jobService = jobService;
        Practice.locationService = locationService;
        Practice.regionService = regionService;

    }

    // You can use the services above for all the CRUD (create, read, update, delete) operations.
    // Above services have all the required methods.
    // Also, you can check all the methods in the ServiceImpl classes inside the service.impl package, they all have explanations.

    // Display all the employees
    public static List<Employee> getAllEmployees() {
        return employeeService.readAll();
    }

    // Display all the countries
    public static List<Country> getAllCountries() {
        return countryService.readAll();
    }

    // Display all the departments
    public static List<Department> getAllDepartments() {
        return departmentService.readAll();
    }

    // Display all the jobs
    public static List<Job> getAllJobs() {
        return jobService.readAll();
    }

    // Display all the locations
    public static List<Location> getAllLocations() {
        return locationService.readAll();
    }

    // Display all the regions
    public static List<Region> getAllRegions() {
        return regionService.readAll();
    }

    // Display all the job histories
    public static List<JobHistory> getAllJobHistories() {
        return jobHistoryService.readAll();
    }

    // Display all the employees' first names
    public static List<String> getAllEmployeesFirstName() {
        return employeeService.readAll().stream()
                .map(Employee::getFirstName)
                .collect(Collectors.toList());
    }

    // Display all the countries' names
    public static List<String> getAllCountryNames() {
        return countryService.readAll().stream()
                .map(Country::getCountryName)
                .collect(Collectors.toList());
    }

    // Display all the departments' managers' first names
    public static List<String> getAllDepartmentManagerFirstNames() {
        return departmentService.readAll().stream()
                .map(department -> department.getManager().getFirstName())
                .collect(Collectors.toList());
    }

    // Display all the departments where manager name of the department is 'Steven'
    public static List<Department> getAllDepartmentsWhichManagerFirstNameIsSteven() {
        return departmentService.readAll().stream()
                .filter(department -> department.getManager().getFirstName().equalsIgnoreCase("steven"))
                .collect(Collectors.toList());
    }

    // Display all the departments where postal code of the location of the department is '98199'
    public static List<Department> getAllDepartmentsWhereLocationPostalCodeIs98199() {
        return departmentService.readAll().stream()
                .filter(department -> department.getLocation().getPostalCode().equalsIgnoreCase("98199"))
                .collect(Collectors.toList());
    }

    // Display the region of the IT department
    public static Region getRegionOfITDepartment() throws Exception {
        return departmentService.readAll().stream()
                .filter(department -> department.getDepartmentName().equalsIgnoreCase("IT"))
                .map(department -> department.getLocation().getCountry().getRegion())
                .findFirst().get();

    }

    // Display all the departments where the region of department is 'Europe'
    public static List<Department> getAllDepartmentsWhereRegionOfCountryIsEurope() {
        return departmentService.readAll().stream()
                .filter(department -> department.getLocation().getCountry().getRegion().getRegionName().equalsIgnoreCase("europe"))
                .collect(Collectors.toList());
    }

    // Display if there is any employee with salary less than 1000. If there is none, the method should return true
    public static boolean checkIfThereIsNoSalaryLessThan1000() {
        return employeeService.readAll().stream()
                .noneMatch(employee -> employee.getSalary() < 1000);
    }

    // Check if the salaries of all the employees in IT department are greater than 2000 (departmentName: IT)
    public static boolean checkIfThereIsAnySalaryGreaterThan2000InITDepartment() {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getDepartment().getDepartmentName().equalsIgnoreCase("it"))
                .allMatch(employee -> employee.getSalary() > 1000);
    }

    // Display all the employees whose salary is less than 5000
    public static List<Employee> getAllEmployeesWithLessSalaryThan5000() {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getSalary() < 5000)
                .collect(Collectors.toList());
    }

    // Display all the employees whose salary is between 6000 and 7000
    public static List<Employee> getAllEmployeesSalaryBetween() {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getSalary() > 6000)
                .filter(employee -> employee.getSalary() < 7000)
                .collect(Collectors.toList());
    }

    // Display the salary of the employee Grant Douglas (lastName: Grant, firstName: Douglas)
    public static Long getGrantDouglasSalary() throws Exception {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getFirstName().equalsIgnoreCase("douglas"))
                .filter(employee -> employee.getLastName().equalsIgnoreCase("grant"))
                .map(Employee::getSalary)
                .findFirst().get();

    }

    // Display the maximum salary an employee gets
    public static Long getMaxSalary() {
        // my solution
//        return employeeService.readAll().stream()
//                .map(Employee::getSalary)
//                .reduce(Long::max).get();

        // other options
        //        return employeeService.readAll().stream()
//                .max(Comparator.comparing(Employee::getSalary))
//                .get().getSalary();
//        return employeeService.readAll().stream()
//                .map(Employee::getSalary)
//                .reduce((a, b) -> a > b ? a : b)
//                .get();
//        return employeeService.readAll().stream()
//                .sorted(Comparator.comparing(Employee::getSalary).reversed())
//                .findFirst().orElseThrow(() -> new Exception("No Employee Found!")).getSalary();

        return employeeService.readAll().stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("no employee found")).getSalary();
    }

    // Display the employee(s) who gets the maximum salary
    public static List<Employee> getMaxSalaryEmployee() {
        // my first solution
//        return employeeService.readAll().stream()
//                .filter(employee -> {
//                    try {
//                        return employee.getSalary()==getMaxSalary();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        return false;
//                    }
//                })
//                .collect(Collectors.toList());

        return employeeService.readAll().stream()
                .filter(employee -> employee.getSalary().equals(getMaxSalary()))
                .collect(Collectors.toList());
    }

    // Display the max salary employee's job
    //TODO - should return List<Job> because max salary can be more than 1
    public static List<Job> getMaxSalaryEmployeeJob() throws Exception {
//        return employeeService.readAll().stream()
//                .collect(Collectors.toList())
//                .stream()
//                .sorted(Comparator.comparing(Employee::getSalary).reversed())
//                .findFirst().get().getJob();
//        return getMaxSalaryEmployee().stream()
//                .map(Employee::getJob)
//                .findAny().orElseThrow();
        return employeeService.readAll()
                .stream()
                .filter(employee -> employee.getSalary().equals(getMaxSalary()))
                .map(Employee::getJob)
                .collect(Collectors.toList());
    }

    // Display the max salary in Americas Region
    public static Long getMaxSalaryInAmericasRegion() throws Exception {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getDepartment()
                        .getLocation()
                        .getCountry()
                        .getRegion()
                        .getRegionName().equalsIgnoreCase("Americas"))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow().getSalary();
    }

    // Display the second maximum salary an employee gets
    // TODO olternatif çözüm. eğer iki employe max salary, iki employee secondMax alıyorsa,
    //  repodaki çözüm farklı sonuç verebilir
    public static Long getSecondMaxSalary() {
        /*
        return employeeService.readAll().stream()
                .map(Employee::getSalary)
                .reduce((a, b) -> {
                    try {
                        return a > b && a < getMaxSalary() ? a : b;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }).orElseThrow(() -> new Exception("Employee couldn't be found"));
         */
//        return employeeService.readAll().stream()
//                .sorted(Comparator.comparing(Employee::getSalary).reversed())
//                .collect(Collectors.toList()).get(1).getSalary();
        return employeeService.readAll().stream()
                .map(Employee::getSalary)
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .limit(1)
                .findFirst().orElseThrow();
    }

    // Display the employee(s) who gets the second maximum salary
    public static List<Employee> getSecondMaxSalaryEmployee() {
        return employeeService.readAll().stream()
                .filter(employee -> {
                    try {
                        return employee.getSalary().equals(getSecondMaxSalary());
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                })
                .collect(Collectors.toList());
    }

    // Display the minimum salary an employee gets
    public static Long getMinSalary() {
//        return employeeService.readAll().stream()
//                .min(Comparator.comparing(Employee::getSalary))
//                .orElseThrow().getSalary();
        return employeeService.readAll().stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow().getSalary();
    }

    // Display the employee(s) who gets the minimum salary
    public static List<Employee> getMinSalaryEmployee() {
//        return employeeService.readAll().stream()
//                .filter(employee -> {
//                    try {
//                        return employee.getSalary().equals(getMinSalary());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    return false;
//                }).collect(Collectors.toList());

        // writes all salary in sorted order
        System.out.println(employeeService.readAll().stream()
                .map(Employee::getSalary)
                .sorted()
                .collect(Collectors.toList()));
        Long minSalary = employeeService.readAll().stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow().getSalary();
        System.out.println("minSalary = " + minSalary);
        List<Employee> result = employeeService.readAll().stream()
                .filter(employee -> employee.getSalary().equals(minSalary))
                .collect(Collectors.toList());
        System.out.println("result = " + result);
        return result;
    }

    // Display the second minimum salary an employee gets
    // TODO alternatif çözüm: min salary alan iki kişi varsa, repo çözümü hatalı sonuç üretiyor
    public static Long getSecondMinSalary() {
        //my solution
//        return employeeService.readAll().stream()
//                .sorted(Comparator.comparing(Employee::getSalary))
//                .map(Employee::getSalary)
//                .collect(Collectors.toList()).get(1);
//        return employeeService.readAll().stream()
//                .map(Employee::getSalary)
//                .sorted()
//                .skip(1)
//                .findFirst().orElseThrow();
        return employeeService.readAll().stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted()
                .skip(1)
                .findFirst().orElseThrow();
    }

    // Display the employee(s) who gets the second minimum salary
    public static List<Employee> getSecondMinSalaryEmployee() {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getSalary().equals(getSecondMinSalary()))
                .collect(Collectors.toList());
    }

    // Display the average salary of the employees
    public static Double getAverageSalary() {
//        return employeeService.readAll().stream()
//                .collect(Collectors.averagingDouble(Employee::getSalary));    // same
        return employeeService.readAll().stream()
                .mapToDouble(Employee::getSalary)
                .average().orElseThrow();                                       // same
    }

    // Display all the employees who are making more than average salary
    public static List<Employee> getAllEmployeesAboveAverage() {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getSalary() > getAverageSalary())
                .collect(Collectors.toList());
    }

    // Display all the employees who are making less than average salary
    public static List<Employee> getAllEmployeesBelowAverage() {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getSalary() < getAverageSalary())
                .collect(Collectors.toList());
    }

    // Display all the employees separated based on their department id number
    public static Map<Long, List<Employee>> getAllEmployeesForEachDepartment() {
        return employeeService.readAll().stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment().getId()));
    }

    // Display the total number of the departments
    public static Long getTotalDepartmentsNumber() {
//        return employeeService.readAll().stream()                 // same
//                .map(Employee::getDepartment)
//                .count();
        //   return departmentService.readAll().stream().count();      // same
        return (long) departmentService.readAll().size();           // same
    }

    // Display the employee whose first name is 'Alyssa' and manager's first name is 'Eleni' and department name is 'Sales'
    //TODO birden fazla employee varsa list döndürmek daha iyi olabilir
    public static List<Employee> getEmployeeWhoseFirstNameIsAlyssaAndManagersFirstNameIsEleniAndDepartmentNameIsSales() throws Exception {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getFirstName().equalsIgnoreCase("Alyssa"))
                .filter(employee -> employee.getManager().getFirstName().equalsIgnoreCase("Eleni"))
                .filter(employee -> employee.getDepartment().getDepartmentName().equalsIgnoreCase("Sales"))
                .collect(Collectors.toList());
    }

    // Display all the job histories in ascending order by start date
    public static List<JobHistory> getAllJobHistoriesInAscendingOrder() {
        return jobHistoryService.readAll().stream()
                .sorted(Comparator.comparing(JobHistory::getStartDate))
                .collect(Collectors.toList());
    }

    // Display all the job histories in descending order by start date
    public static List<JobHistory> getAllJobHistoriesInDescendingOrder() {
        return jobHistoryService.readAll().stream()
                .sorted(Comparator.comparing(JobHistory::getStartDate).reversed())
                .collect(Collectors.toList());
    }

    // Display all the job histories where the start date is after 01.01.2005
    public static List<JobHistory> getAllJobHistoriesStartDateAfterFirstDayOfJanuary2005() {
        return jobHistoryService.readAll().stream()
                .sorted(Comparator.comparing(JobHistory::getStartDate))
                .filter(jobHistory -> jobHistory.getStartDate().isAfter(LocalDate.of(2005, 1, 1)))
                .collect(Collectors.toList());
    }

    // Display all the job histories where the end date is 31.12.2007 and the job title of job is 'Programmer'
    public static List<JobHistory> getAllJobHistoriesEndDateIsLastDayOfDecember2007AndJobTitleIsProgrammer() {
        return jobHistoryService.readAll().stream()
                .filter(jobHistory -> jobHistory.getEndDate().isEqual(LocalDate.of(2007, 12, 31)))
                .filter(jobHistory -> jobHistory.getJob().getJobTitle().equalsIgnoreCase("Programmer"))
                .collect(Collectors.toList());
    }

    // Display the employee whose job history start date is 01.01.2007
    // and job history end date is 31.12.2007 and
    // department's name is 'Shipping'
    public static Employee getEmployeeOfJobHistoryWhoseStartDateIsFirstDayOfJanuary2007AndEndDateIsLastDayOfDecember2007AndDepartmentNameIsShipping() throws Exception {
        //        return jobHistoryService.readAll().stream()
//                .filter(jobHistory -> jobHistory.getStartDate().equals(LocalDate.of(2007, 1, 1)))
//                .filter(jobHistory -> jobHistory.getEndDate().equals(LocalDate.of(2007, 12, 31)))
//                .filter(jobHistory -> jobHistory.getDepartment().getDepartmentName().equals("Shipping"))
//                .map(JobHistory::getEmployee)
//                .findAny().get();
        return jobHistoryService.readAll().stream()
                .filter(jobHistory -> jobHistory.getStartDate().isEqual(LocalDate.of(2007, 01, 01)))
                .filter(jobHistory -> jobHistory.getEndDate().isEqual(LocalDate.of(2007, 12, 31)))
                .filter(jobHistory -> jobHistory.getDepartment().getDepartmentName().equalsIgnoreCase("Shipping"))
                .findFirst().orElseThrow().getEmployee();
    }

    // Display all the employees whose first name starts with 'A'
    public static List<Employee> getAllEmployeesFirstNameStartsWithA() {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getFirstName().startsWith("A"))
                .collect(Collectors.toList());
    }

    // Display all the employees whose job id contains 'IT'
    public static List<Employee> getAllEmployeesJobIdContainsIT() {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getJob().getId().contains("IT"))
                .collect(Collectors.toList());
    }

    // Display the number of employees whose job title is programmer and department name is 'IT'
    public static Long getNumberOfEmployeesWhoseJobTitleIsProgrammerAndDepartmentNameIsIT() {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getJob().getJobTitle().equalsIgnoreCase("programmer"))
                .filter(employee -> employee.getDepartment().getDepartmentName().equalsIgnoreCase("IT"))
                .count();
    }

    // Display all the employees whose department id is 50, 80, or 100
    public static List<Employee> getAllEmployeesDepartmentIdIs50or80or100() {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getDepartment().getId().equals(50L) ||
                        employee.getDepartment().getId().equals(80L) ||
                        employee.getDepartment().getId().equals(100L))
                .collect(Collectors.toList());
    }

    // Display the initials of all the employees
    // Note: You can assume that there is no middle name
    public static List<String> getAllEmployeesInitials() {
//        return employeeService.readAll().stream()
//                .map(employee -> employee.getFirstName().substring(0,1).toUpperCase() +
//                        "." + employee.getLastName().substring(0,1).toUpperCase()+".")
//                .collect(Collectors.toList());    // same
        return employeeService.readAll().stream()
                .map(employee -> {
                    String firstInitial = employee.getFirstName().substring(0, 1);
                    String secondInitial = employee.getLastName().substring(0, 1);
                    return firstInitial + secondInitial;
                })
                .collect(Collectors.toList());      // same
    }

    // Display the full names of all the employees
    public static List<String> getAllEmployeesFullNames() {
        return employeeService.readAll().stream()
                .map(employee -> {
                    String first = employee.getFirstName();
                    String last = employee.getLastName();
                    return String.join(" ", first, last);
                })
                .collect(Collectors.toList());
    }

    // Display the length of the longest full name(s)
    //TODO alternatif çözüm incelenebilir
    public static Integer getLongestNameLength() throws Exception {
//        Employee employee = employeeService.readAll().stream()
//                .reduce((employee1, employee2) ->
//                        employee1.getFirstName().length()
//                                + employee1.getLastName().length()
//                                > employee2.getFirstName().length()
//                                + employee2.getLastName().length() ? employee1 : employee2)
//                .orElseThrow(() -> new Exception("Something went wrong!"));
//        return employee.getFirstName().length() + employee.getLastName().length() + 1;

        return employeeService.readAll().stream()
                .map(employee -> {
                    String fullName = employee.getFirstName() + " " + employee.getLastName();
                    return fullName.length();
                })
                .reduce(Integer::max).orElseThrow();
    }

    // Display the employee(s) with the longest full name(s)
    public static List<Employee> getLongestNamedEmployee() {
        int longestLength = employeeService.readAll().stream()
                .map(employee -> {
                    String fullName = employee.getFirstName() + " " + employee.getLastName();
                    return fullName.length();
                })
                .reduce(Integer::max).orElseThrow();
        return employeeService.readAll().stream()
                .filter(employee -> (employee.getFirstName() + " " + employee.getLastName()).length() == longestLength)
                .collect(Collectors.toList());
    }

    // Display all the employees whose department id is 90, 60, 100, 120, or 130
    public static List<Employee> getAllEmployeesDepartmentIdIs90or60or100or120or130() {
        //        return employeeService.readAll().stream()
//                .map(employee -> {
//                    Long departmentId = employee.getDepartment().getId();
//                    if (departmentId.equals(90L) || departmentId.equals(60L) || departmentId.equals(100L) || departmentId.equals(120L) || departmentId.equals(130L)) {
//                        return employee;
//                    } else {
//                        return null;
//                    }
//                }).collect(Collectors.toList());                      // same

        return employeeService.readAll().stream()
                .filter(employee -> employee.getDepartment().getId().equals(90L) ||
                        employee.getDepartment().getId().equals(60L) ||
                        employee.getDepartment().getId().equals(100L) ||
                        employee.getDepartment().getId().equals(120L) ||
                        employee.getDepartment().getId().equals(130L))
                .collect(Collectors.toList());                               // same
    }

    // Display all the employees whose department id is NOT 90, 60, 100, 120, or 130
    //TODO soru ... NOT 90, 60, 100, 120, and 130 olması gerekmez mi?
    public static List<Employee> getAllEmployeesDepartmentIdIsNot90or60or100or120or130() {
//        return employeeService.readAll().stream()
//                .filter(employee -> employee.getDepartment().getId() != (90L) &&
//                        employee.getDepartment().getId() != (60L) &&
//                        employee.getDepartment().getId() != (100L) &&
//                        employee.getDepartment().getId() != (120L) &&
//                        employee.getDepartment().getId() != (130L))
//                .collect(Collectors.toList());                            // same
        return employeeService.readAll().stream()
                .filter(employee -> !employee.getDepartment().getId().equals(90L) &&
                        !employee.getDepartment().getId().equals(60L) &&
                        !employee.getDepartment().getId().equals(100L) &&
                        !employee.getDepartment().getId().equals(120L) &&
                        !employee.getDepartment().getId().equals(130L))
                .collect(Collectors.toList());                               // same
    }

}