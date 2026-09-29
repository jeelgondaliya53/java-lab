abstract class Employee{
    String name;
    int id;
    Employee(String name,int id)
    {
        this.name=name;
        this.id=id;
    }
    abstract double monthlySalary();
}
class Fulltime extends Employee
{
    double salary;
    Fulltime(String name,int id,double salary)
    {
        super(name,id);
        this.salary=salary;
   
    }
    double monthlySalary()
    {
        return salary;
    }
}
class Parttime extends Employee {
    int hours;
    double rate;

    Parttime(String name,int id,int hours,double rate) {
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }

    double monthlySalary() {
        return hours * rate;
    }
}
class Intern extends Employee{
    double stipend;
    Intern(String name,int id,double stipend)
    {
        super(name,id);
        this.stipend=stipend;
    }
    double monthlySalary(){
        return stipend;
    }
}
public class Payroll {
    public static void main(String[] args) {

        Employee[] employees = {
            new Fulltime("Jeel", 1, 70000),
            new Parttime("teju", 2, 90, 5000),
            new Intern("ruhi", 3, 25000),
            new Fulltime("hasti", 4, 60000)
        };

        double total = 0;

        for (Employee e : employees) {

            double salary = e.monthlySalary();

            System.out.println(
                "Name: " + e.name +", ID: " + e.id +", Salary: " + salary
            );

            if (e instanceof Intern) {
                System.out.println("This employee is an Intern.");
            }
            total = total + salary;
        }

        System.out.println("-------------------------");
        System.out.println("Total Payroll: " + total);
    }
}
