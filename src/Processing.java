public class Processing {
    public static PatientDAO processPatientFile(String[][] patientFile){
        PatientDAO patientDAO = new PatientDAOImp();
        for(String[] line : patientFile){
            String[] ns = line[1].split(" ");
            Patient tempPatient = new Patient(Integer.parseInt(line[0]), ns[0], ns[1], line[2], line[3]);
            patientDAO.add(tempPatient);
        }
        return patientDAO;
    }

    public static AdmissionDAO processAdmissionFile(String[][] admissionFile){

        AdmissionDAO admissionDAO = new AdmissionDAOImp();
        int tempID = 0;
        for(String[] line : admissionFile) {
            if(line[0].equals("Inpatient") || line[0].equals("Outpatient")){
                admissionDAO.addExamination(tempID, makeExamination(line, 0));
            } else {
                tempID = Integer.parseInt(line[0]);
                admissionDAO.createAdmission(tempID, Integer.parseInt(line[1]));
            }
        }
            return admissionDAO;
    }
    // Takes input.txt file as array and takes admission and patient DAOs, executes the commands
    public static void processInputFile(String[][] inputFile, PatientDAO patientDAO, AdmissionDAO admissionDAO){
        Output output = new Output();
        for(String[] line : inputFile){
            switch (line[0]) {
                case "AddPatient":
                    String address = "Address: ";
                    boolean spaceSwitch = false;
                    for (int i = 5; i < line.length; i++) {
                        if(spaceSwitch)
                            address += " ";
                        else
                            spaceSwitch = true;
                        address += line[i];
                    }
                    Patient patient = new Patient(Integer.parseInt(line[1]), line[2], line[3], line[4], address);
                    patientDAO.add(patient);
                    output.addLog(line[0], patient);
                    break;
                case "RemovePatient":
                    output.addLog(line[0], patientDAO.getByID(Integer.parseInt(line[1])));
                    patientDAO.deleteByID(Integer.parseInt(line[1]));
                    admissionDAO.deleteByID(Integer.parseInt(line[1]));
                    break;
                case "CreateAdmission":
                    admissionDAO.createAdmission(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
                    output.addLog(line[0], line[1]);
                    break;
                case "AddExamination":
                    Examination e =  makeExamination(line, 2);
                    admissionDAO.addExamination(Integer.parseInt(line[1]), e);
                    output.addLog(line[0], e, Integer.parseInt(line[1]));
                    break;
                case "TotalCost":
                    output.addLog(line[0], admissionDAO.totalCost(Integer.parseInt(line[1])));
                    break;
            }
        }
        output.addLog("ListAllPatients", ((PatientDAOImp) patientDAO));
        output.printLog();
    }
    // Reads the decorators of the examination and creates and object according to them. Placement indicates starting index in line
    public static Examination makeExamination(String[] line, int placement){
        Examination tempExamination = null;
        if(line[placement].equals("Inpatient")){
            tempExamination = new InpatientExamination();
        } else if(line[placement].equals("Outpatient")){
            tempExamination = new OutpatientExamination();
        }
        for(int i = placement + 1; i < line.length; i++){
            switch (line[i]) {
                case "doctorvisit":
                    tempExamination = new DoctorVisitDecorator(tempExamination);
                    break;
                case "tests":
                    tempExamination = new TestsDecorator(tempExamination);
                    break;
                case "imaging":
                    tempExamination = new ImagingDecorator(tempExamination);
                    break;
                case "measurements":
                    tempExamination = new MeasurementsDecorator(tempExamination);
                    break;
            }
        }
        return tempExamination;
    }
}
