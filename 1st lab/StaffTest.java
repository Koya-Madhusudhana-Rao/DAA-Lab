import java.util.Scanner;

class Staff {
    String staffId;
    String name;
    String phone;
    double salary;

    // Constructor
    public Staff(String staffId, String name, String phone, double salary) {
        this.staffId = staffId;
        this.name = name;
        this.phone = phone;
        this.salary = salary;
    }

    // Method to display staff information
    public void displayInfo() {
        System.out.println("Staff ID: " + staffId);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Salary: " + salary);
    }
}

class Teaching extends Staff {
    String domain;
    String publications;

    // Constructor
    public Teaching(String staffId, String name, String phone, double salary, String domain, String publications) {
        super(staffId, name, phone, salary);
        this.domain = domain;
        this.publications = publications;
    }

    // Method to display teaching staff information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Domain: " + domain);
        System.out.println("Publications: " + publications);
        System.out.println();
    }
}

class Technical extends Staff {
    String skills;

    // Constructor
    public Technical(String staffId, String name, String phone, double salary, String skills) {
        super(staffId, name, phone, salary);
        this.skills = skills;
    }

    // Method to display technical staff information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Skills: " + skills);
        System.out.println();
    }
}

class Contract extends Staff {
    int period;

    // Constructor
    public Contract(String staffId, String name, String phone, double salary, int period) {
        super(staffId, name, phone, salary);
        this.period = period;
    }

    // Method to display contract staff information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Contract Period (months): " + period);
        System.out.println();
    }
}

public class StaffTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create at least 3 staff objects for each category
        Teaching teachingStaff1 = new Teaching("T001", "John Doe", "1234567890", 60000.0, "Computer Science", "Research Papers");
        Teaching teachingStaff2 = new Teaching("T002", "Jane Smith", "9876543210", 55000.0, "Mathematics", "Books");
        Teaching teachingStaff3 = new Teaching("T003", "Bob Johnson", "5555555555", 70000.0, "Physics", "Journals");

        Technical technicalStaff1 = new Technical("Tech001", "Alice Brown", "1111111111", 45000.0, "Programming");
        Technical technicalStaff2 = new Technical("Tech002", "Charlie White", "2222222222", 50000.0, "Network Administration");
        Technical technicalStaff3 = new Technical("Tech003", "Eva Green", "3333333333", 48000.0, "Database Management");

        Contract contractStaff1 = new Contract("C001", "David Miller", "4444444444", 30000.0, 6);
        Contract contractStaff2 = new Contract("C002", "Grace Davis", "6666666666", 32000.0, 4);
        Contract contractStaff3 = new Contract("C003", "Sam Wilson", "9999999999", 28000.0, 8);

        // Display information for each staff object
        System.out.println("Teaching Staff:");
        teachingStaff1.displayInfo();
        teachingStaff2.displayInfo();
        teachingStaff3.displayInfo();

        System.out.println("Technical Staff:");
        technicalStaff1.displayInfo();
        technicalStaff2.displayInfo();
        technicalStaff3.displayInfo();

        System.out.println("Contract Staff:");
        contractStaff1.displayInfo();
        contractStaff2.displayInfo();
        contractStaff3.displayInfo();
    }
}
