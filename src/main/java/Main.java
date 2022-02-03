import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Ввод информации о сотруднике: (фамилия, имя, возраст, пол, образование, должность, отдел)");
            String lastName = scanner.next();
            if ("end".equals(lastName)) {
                System.out.println("Конец ввода сотрудников");
                break;
            }
            String firstName = scanner.next();
            int age = scanner.nextInt();
            String sex = scanner.next();
            String education = scanner.next();
            String title = scanner.next();
            String department = scanner.next();

            Employee emp = new Employee(lastName, firstName, age, sex, education, title, department);
            list.add(emp);

            System.out.println("Сотрудник '" + lastName + "' сохранен.");
            System.out.println("Введите 'end' для конца или продолжите вводить нового сотрудника");
        }
        Employee.listPrint(list);
        System.out.println();

        while (true) {
            System.out.println("Введите фамилию и имя работника, для которого хотите изменить данные:");
            System.out.println("Если не хотите менять данные, введите 'end'");
            String lastName = scanner.next();
            if ("end".equals(lastName)) {
                System.out.println("Конец редактирования сотрудников");
                break;
            }
            String firstName = scanner.next();

            Employee empIndex = Employee.searchBySurname(lastName, firstName, list);
            if (empIndex != null) {
                // TODO опросы по атрибутам
                System.out.println("Сотрудник '" + empIndex.getLastName() + " " + empIndex.getFistName() + "' редактирование:");

                System.out.println("Меняем [ФАМИЛИЯ - "+ empIndex.getLastName()+"]? 'yes' - смена.");
                String input = scanner.next();
                if (input == null) { }
                if ("yes".equals(input)) {
                    System.out.println("Введите новую фамилию:");
                    input = scanner.next();
                    empIndex.setLastName(input);
                }
                System.out.println("Меняем [ИМЯ - "+ empIndex.getFistName()+"]? 'yes' - смена.");
                input = scanner.next();
                if ("yes".equals(input)) {
                    System.out.println("Введите новое имя:");
                    input = scanner.next();
                    empIndex.setFistName(input);
                }
                System.out.println("Меняем [ВОЗРАСТ - "+ empIndex.getAge()+"]? 'yes' - смена.");
                input = scanner.next();
                if ("yes".equals(input)) {
                    System.out.println("Введите новый возраст:");
                    input = scanner.next();
                    empIndex.setAge(Integer.parseInt(input));
                }
                System.out.println("Меняем [ПОЛ - "+ empIndex.getSex()+"]? 'yes' - смена.");
                input = scanner.next();
                if ("yes".equals(input)) {
                    System.out.println("Введите новый пол:");
                    input = scanner.next();
                    empIndex.setSex(input);
                }
                System.out.println("Меняем [ОБРАЗОВАНИЕ - "+ empIndex.getEducation()+"]? 'yes' - смена.");
                input = scanner.next();
                if ("yes".equals(input)) {
                    System.out.println("Введите новое образование:");
                    input = scanner.next();
                    empIndex.setEducation(input);
                }
                System.out.println("Меняем [ДОЛЖНОСТЬ - "+ empIndex.getTitle()+"]? 'yes' - смена.");
                input = scanner.next();
                if ("yes".equals(input)) {
                    System.out.println("Введите новую должность:");
                    input = scanner.next();
                    empIndex.setTitle(input);
                }
                System.out.println("Меняем [ОТДЕЛ - "+ empIndex.getDepartment()+"]? 'yes' - смена.");
                input = scanner.next();
                if ("yes".equals(input)) {
                    System.out.println("Введите новый отдел:");
                    input = scanner.next();
                    empIndex.setDepartment(input);
                }
                System.out.println("Редактирование закончено.");
            } else {
                System.out.println("Сотрудник '" + lastName + " " + firstName + "' не найден.");
            }
        }
        Employee.listPrint(list);
    }
}
