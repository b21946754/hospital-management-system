import java.io.*;
import java.util.ArrayList;

public class Output {
    ArrayList<String> log;

    public Output() {
        log = new ArrayList<String>();
    }

    public void addLog(String mode, Patient patient){
        if(mode.equals("AddPatient")){
            this.log.add("Patient " + patient.id + " " + patient.name + " added");
        } else if(mode.equals("RemovePatient")){
            this.log.add("Patient " + patient.id + " " + patient.name + " removed");
        }
    }

    public void addLog(String mode, String s){
        if(mode.equals("CreateAdmission")){
            this.log.add("Admission " + s + " created");
        }
    }

    public void addLog(String mode, ArrayList<String> s){
        if(mode.equals("TotalCost")){
            this.log.addAll(s);
        }
    }

    public void addLog(String mode, PatientDAOImp patientDAOImp){
        if(mode.equals("ListAllPatients")){
            this.log.add("Patient List:");
            patientDAOImp.patients.sort(new PatientNameComparator());
            for(Patient p : patientDAOImp.patients){
                this.log.add(p.id + " " + p.name + " " + p.surname + " " + p.phoneNumber + " " + p.address);
            }
        }
    }


    public void addLog(String mode, Examination e, int a){
        if(mode.equals("AddExamination")){
            this.log.add(e.description().split(" ")[0] + " examination added to admission " + a);
        }
    }

    public void printLog(){
        try {
            File file = new File("output.txt");
            FileWriter fw = new FileWriter(file);
            for (String line : log) {
                fw.write(line + "\n");
            }
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error while printing out");
        }
    }

    // Takes patients DAO and prints it to the desired file according to necessary file format
    public static void printPatient(ArrayList<Patient> patients, String fileName){
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file);
            for(Patient patient : patients) {
                fw.write(patient.id + "\t" + patient.name + " " + patient.surname + "\t");
                fw.write(patient.phoneNumber + "\t" + patient.address + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while writing to file");
        }
    }

    public static void printAdmission(ArrayList<Admission> admissions, String filename){
        try {
            admissions.sort(new AdmissionComparator());
            File file = new File(filename);
            FileWriter fw = new FileWriter(file);
            for(Admission admission : admissions){
                fw.write(admission.id + "\t" + admission.patientID + "\n");
                for(Examination examination : admission.examinations){
                    String[] splitDesc = examination.description().split(" ", 2);
                    fw.write(splitDesc[0] + "\t" + splitDesc[1] + "\n");
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while writing to file");
        }
    }
}
