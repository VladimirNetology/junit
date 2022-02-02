import java.util.List;

public class Employee {
    private String lastName;
    private String fistName;
    private int age;
    private String sex;
    private String education;
    private String title;
    private String department;

    public Employee(String lastName, String fistName, int age, String sex, String education, String title, String department) {
        this.lastName = lastName;
        this.fistName = fistName;
        this.age = age;
        this.sex = sex;
        this.education = education;
        this.title = title;
        this.department = department;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFistName() {
        return fistName;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getEducation() {
        return education;
    }

    public String getTitle() {
        return title;
    }

    public String getDepartment() {
        return department;
    }


    @Override
    public String toString() {
        return lastName + "\t\t" + fistName + "\t\t" + age + "\t\t" + sex + "\t\t" + education + "\t\t" + title + "\t\t\t" + department;
    }

    public static void listPrint(List<Employee> employeeList) {
        for (Employee worker : employeeList) {
            System.out.println(worker.toString());
        }
    }

    public static Employee searchBySurname(String lastName, String firstName, List<Employee> employeeList) {
        for (int i = 0; i < employeeList.size(); i++) {
            Employee worker = employeeList.get(i);
            if (lastName.equals(worker.getLastName()) && firstName.equals(worker.getFistName())) {
                return worker;
            }
        }
        return null;
    }

    public String getWorkerName(int index) {
        String[] arg = new String[] {"Winter", "Spring", "Summer", "Autumn"};
        return arg[index];
    }
}
