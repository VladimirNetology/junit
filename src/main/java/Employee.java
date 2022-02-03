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

    public void setLastName(String lastName) {
        System.out.println("Фамилия изменена на: " + lastName);
        this.lastName = lastName;
    }

    public void setFistName(String fistName) {
        System.out.println("Фамилия изменена на: " + fistName);
        this.fistName = fistName;
    }

    public void setAge(int age) {
        if (age < 16 || age > 80 ) {
            System.out.println("Не верно указан возраст");
        } else {
            System.out.println("Имя изменено на: " + age);
            this.age = age;
        }
    }

    public void setSex(String sex) {
        System.out.println("Пол изменен на: " + sex);
        this.sex = sex;
    }

    public void setEducation(String education) {
        System.out.println("Образование изменено на: " + education);
        this.education = education;
    }

    public void setTitle(String title) {
        System.out.println("Должность изменена на: " + title);
        this.title = title;
    }

    public void setDepartment(String department) {
        System.out.println("Отдел изменен на: " + department);
        this.department = department;
    }

    @Override
    public String toString() {
        return lastName + "\t\t" + fistName + "\t\t" + age + "\t\t" + sex + "\t\t" + education + "\t\t" + title + "\t\t\t" + department;
    }

    public static String listPrint(List<Employee> employeeList) {
        String text = "";
        System.out.println();
        System.out.println("Список сотрудников:");
        System.out.println("Фамилия\t\tИмя\t\tВозраст\t\tПол\t\tОбразование\t\tДолжность\t\t\tОтдел");
        for (Employee worker : employeeList) {
            System.out.println(worker.toString());
            text += worker.toString();
        }
        return text;
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
