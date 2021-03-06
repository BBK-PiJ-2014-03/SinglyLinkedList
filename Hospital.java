import java.util.Scanner;

public class Hospital {
    private Patient patientListStart = null;
    
    Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        Hospital userHospital = new Hospital();
        
        userHospital.launch();
        
        /* userHospital.printPatientInfo(); */
        
        /* userHospital.patientDeleter("Sammy Watkins"); */
        
        userHospital.printPatientInfo();
        
        System.out.print("You have " + userHospital.patientCounter() +
                         " Patients.");
    }
    
    public void launch() {
        
        for (int count = 0; count < 7; count++) {
            
            String patientName;
            int patientAge;
            String patientIllness;
            
            System.out.print("Enter Patient name: ");
            patientName = keyboard.nextLine();
            System.out.print("Enter Patient age: ");
            patientAge = keyboard.nextInt();
            keyboard.nextLine();
            System.out.print("Enter Patient illness: ");
            patientIllness = keyboard.nextLine();
            
            
            if (patientListStart == null) {
                Patient fistPatient = new Patient(patientName, patientAge, patientIllness);
                patientListStart = fistPatient;
            }
            
            else {
                Patient anotherPatient = new Patient(patientName, patientAge, patientIllness);
                patientListStart.addPatient(anotherPatient);
            }
        }
    }
    public void printPatientInfo () {
        Patient patientIterator = patientListStart;
        System.out.print(patientIterator.toString());
        
        do {
            patientIterator = patientIterator.getNext();    
            System.out.print(patientIterator.toString());
        } while (patientIterator.getNext() != null);
    }
    
    public void patientDeleter(String name) {
        Patient patientIterator = patientListStart;
        
        boolean finish = false;
        
        do {
            if (patientIterator.getName().equals(name)) {
                patientIterator.deletePatient(patientIterator);
                finish =  true;
            }
            else {
                patientIterator = patientIterator.getNext();
            }
        } while (!finish);
    }
    
    public int patientCounter () {
        Patient patientIterator = patientListStart;
        int patientCount = 0;
        
        boolean finish = false;
        
        do {
            if (patientIterator.getNext() != null) {
                patientCount++;
                patientIterator = patientIterator.getNext();
            }
            else {
                patientCount++;
                finish = true;
            }
        } while (!finish);
        return patientCount;
    }
}