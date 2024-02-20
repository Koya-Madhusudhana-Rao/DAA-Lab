    import java.util.Scanner;

    class Student {
        String usn;
        String name;
        String programme;
        String phone;

        // Constructor
        public Student(String usn, String name, String programme, String phone) {
            this.usn = usn;
            this.name = name;
            this.programme = programme;
            this.phone = phone;
        }

        // Method to display student information
        public void displayInfo() {
            System.out.println("USN: " + usn);
            System.out.println("Name: " + name);
            System.out.println("Programme: " + programme);
            System.out.println("Phone: " + phone);
            System.out.println();
        }
    }

    public class StudentTest {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number of students (n): ");
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Create an array to hold n Student objects
            Student[] students = new Student[n];

            // Input information for each student
            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter details for Student " + (i + 1) + ":");
                System.out.print("Enter USN: ");
                String usn = scanner.nextLine();
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Programme: ");
                String programme = scanner.nextLine();
                System.out.print("Enter Phone: ");
                String phone = scanner.nextLine();

                // Create a new Student object with the entered details
                students[i] = new Student(usn, name, programme, phone);
            }

            // Display information for each student
            System.out.println("\nStudent Information:");
            for (Student student : students) {
                student.displayInfo();
            }
        }
    }
