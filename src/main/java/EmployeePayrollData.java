import java.time.LocalDate;

public class EmployeePayrollData {
    int id;
    String name;
    double salary;
    LocalDate startDate;
    public EmployeePayrollData(int id, String name, double salary, LocalDate startDate){
        this.id=id;
        this.name=name;
        this.salary=salary;
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "EmpPayrollData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
    public boolean equals(Object o){
        if (this == o) return true;
        if (o==null||getClass()!=o.getClass()) return false;
        EmployeePayrollData that = (EmployeePayrollData) o;
        return id == that.id &&
                Double.compare(that.salary,salary)==0 &&
                name.equals(that.name);
    }
}
