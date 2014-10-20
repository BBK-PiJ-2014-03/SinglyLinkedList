public class Patient {
    private String name;
    private int age;
    private String illness;
    
    private Patient nextPatient;
    private Patient prevPatient;
    
    public Patient(String name, int age, String illness) {
        this.name = name;
        this.age = age;
        this.illness = illness;
        this.nextPatient = null;
        this.prevPatient = null;
    }
    
    public void addPatient (Patient newPatient) {
        if (this.nextPatient == null) {
            newPatient.prevPatient = this;
            this.nextPatient = newPatient;
            
        }
        else {
            this.nextPatient.addPatient(newPatient);
        }
    }
    
    public void deletePatient(Patient patient) {
        if (this.prevPatient == null) {
            this.nextPatient.prevPatient = null;
        }
        else if (this.nextPatient == null) {
            this.prevPatient.nextPatient = null;
        }
        else {
            this.prevPatient.nextPatient = this.nextPatient;
            this.nextPatient.prevPatient = this.prevPatient;
        }       
    }
    
    public Patient getNext() {
        return nextPatient;
    }
    public Patient getPrev() {
        return prevPatient;
    }
    public String getName() {
        return name;
    }
    
    public String toString () {
        return ("\nPatient Name: " + this.name +
                "\nPatient Age: " + this.age +
                "\nPatient Illness: " + this.illness + "\n");
    }
}