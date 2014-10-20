import java.util.Scanner;

public class Hospital {
    private Patient patientListStart = null;
    
    Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        Hospital userHospital = new Hospital();
        
        userHospital.launch();
        
        userHospital.printPatientInfo();
        
        userHospital.patientDeleter("Jim Smith");
        
        userHospital.printPatientInfo();
    }
    
    public void launch() {
        
        for (int count = 0; count < 4; count++) {
            
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
        
        if (patientIterator.getName().equals(name)) {
            patientListStart = patientIterator.getNext();
        }
        else {
            do {
                if (patientIterator.getName().equals(name)) {
                    patientIterator.deletePatient(patientIterator);
                }
                else {
                    patientIterator = patientIterator.getNext();
                }
                
            } while (patientIterator.getNext() != null);
        }
    }
}