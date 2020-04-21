package routes.gson;

public class HRResponse {

    private int EmployeeId;
    private String EmployeeFirstName;
    private String EmployeeLastName;
    private int ManagerId;
    private String RoleName;
    private String DepartmentName;

    public HRResponse(int employeeId, String employeeFirstName, String employeeLastName, int managerId, String roleName, String departmentName) {
        EmployeeId = employeeId;
        EmployeeFirstName = employeeFirstName;
        EmployeeLastName = employeeLastName;
        ManagerId = managerId;
        RoleName = roleName;
        DepartmentName = departmentName;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public String getEmployeeFirstName() {
        return EmployeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        EmployeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return EmployeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        EmployeeLastName = employeeLastName;
    }

    public int getManagerId() {
        return ManagerId;
    }

    public void setManagerId(int managerId) {
        ManagerId = managerId;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }
}
