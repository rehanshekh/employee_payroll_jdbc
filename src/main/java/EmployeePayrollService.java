import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeePayrollService {
    public List<EmployeePayrollData> empPayrollList;
    private EmployeePayrollDBService employeePayrollDBService;

    public EmployeePayrollService() {
        employeePayrollDBService = EmployeePayrollDBService.getInstance();
    }

    public EmployeePayrollService(List<EmployeePayrollData> empPayrollList) {
        this();
        this.empPayrollList = empPayrollList;
    }

    public static void main(String[] args) {
        ArrayList<EmployeePayrollData> empPayrollList = new ArrayList<>();
        EmployeePayrollService empPayrollService = new EmployeePayrollService(empPayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        empPayrollService.readEmpPayrollData(consoleInputReader);
        empPayrollService.writeEmpPayrollData(IOService.CONSOLE_IO);
    }

    public List<EmployeePayrollData> readEmployeePayrollData(IOService ioService) {
        if (ioService.equals(IOService.DB_IO)) {
            this.empPayrollList = employeePayrollDBService.readData();
        }
        return this.empPayrollList;

    }

    public void writeEmpPayrollData(EmployeePayrollService.IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO)) {
            System.out.println("\nWriting Employee Payroll Roaster to Console\n" + empPayrollList);
        } else if (ioService.equals(IOService.FILE_IO)) {
            EmployeePayrollIOService.writeData(empPayrollList);
        }
    }

    public void readEmpPayrollData(Scanner consoleInputReader) {
        System.out.println("Enter Employee id:");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name:");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary");
        double salary = consoleInputReader.nextInt();
        System.out.println("Enter the start date");
        LocalDate startDate = null;
        empPayrollList.add(new EmployeePayrollData(id, name, salary, startDate));
    }

    public int updateEmployeeSalary(String name, double salary) {
        int result = employeePayrollDBService.updateEmployeeData(name, salary);
        if (result == 0) return result;
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollData(name);
        if (employeePayrollData != null) {
            employeePayrollData.salary = salary;
        }
        return result;
    }

    private EmployeePayrollData getEmployeePayrollData(String name) {
        return this.empPayrollList.stream().filter(employeePayrollDataItem -> employeePayrollDataItem.name.equals(name)).findFirst().orElse(null);
    }

    public boolean checkEmployeePayrollInSyncWithDB(String name) {
        List<EmployeePayrollData> employeePayrollDataList = EmployeePayrollDBService.getInstance().getEmployeePayrollData(name);
        return employeePayrollDataList.get(0).equals(getEmployeePayrollData(name));
    }


    public List<EmployeePayrollData> readEmployeePayrollDataForDateRange(IOService ioService, LocalDate startDate, LocalDate endDate) {
        if (ioService.equals(IOService.DB_IO))
            return employeePayrollDBService.getEmployeePayrollForDateRange(startDate, endDate);
        return null;

    }

    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}


}
