import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollIOService {
    public static String FILE_NAME = "payroll-file.txt";

    public static void writeData(List<EmployeePayrollData> empPayrollList) {
        StringBuffer empBuffer = new StringBuffer("Hello\n");
        empPayrollList.forEach(employee -> {
            String empDataString = employee.toString().concat("\n");
            empBuffer.append(empDataString);
        });
        try {
            Files.write(Paths.get(FILE_NAME),empBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
