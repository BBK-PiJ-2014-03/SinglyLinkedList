import java.util.Scanner;

public class Hospital {
    private Patient patientListStart = null;
    
    Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        Hospital userHospital = new Hospital();
        
        userHospital.launch();
        
        userHospital.printPatientInfo();
    }
    
    public void launch() {
        
        int num = 0;
        
        while (num < 10) {
            
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
            
            num++;
        }
    }
    public void printPatientInfo () {
    }
}