import java.util.*;

class Patient {
    String id;
    String name;
    String bloodGroup;
    String condition;
    String contact;

    Patient(String id, String name, String bloodGroup, String condition, String contact) {
        this.id = id;
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.condition = condition;
        this.contact = contact;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Condition: " + condition);
        System.out.println("Contact: " + contact);
        System.out.println("---------------------------");
    }
}

public class MediVault {

    // Binary Search
    public static Patient binarySearch(Patient arr[], String key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int compare = arr[mid].id.compareTo(key);

            if (compare == 0)
                return arr[mid];

            if (compare < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }

    // Sorting by ID
    public static void sortPatients(Patient arr[]) {
        Arrays.sort(arr, Comparator.comparing(p -> p.id));
    }

    public static void main(String[] args) {

        Patient patients[] = {
            new Patient("MV101", "Ravi", "O+", "Diabetes", "9876543210"),
            new Patient("MV104", "Sita", "AB+", "Allergy", "9876543444"),
            new Patient("MV102", "Anita", "A+", "Heart Patient", "9876543222"),
            new Patient("MV103", "Kiran", "B+", "Asthma", "9876543333")
        };

        System.out.println("---- Sorted Patient Records ----");

        sortPatients(patients);

        for (Patient p : patients)
            p.display();

        System.out.println("Searching for Patient ID MV103\n");

        Patient result = binarySearch(patients, "MV103");

        if (result != null)
            result.display();
        else
            System.out.println("Patient not found");
    }
}