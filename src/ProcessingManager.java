public class ProcessingManager {
    public static void runProgram(String inputPath) {
        String[][] inputFile = Input.splitReadFile(inputPath, " ");
        String[][] patientFile = Input.splitReadFile("patient.txt", "\t");
        String[][] admissionFile = Input.splitReadFile("admission.txt", "[\t ]");

        PatientDAOImp patientDAO = (PatientDAOImp) Processing.processPatientFile(patientFile);
        AdmissionDAOImp admissionDAO = (AdmissionDAOImp) Processing.processAdmissionFile(admissionFile);

        Processing.processInputFile(inputFile, patientDAO, admissionDAO);

        patientDAO.patients.sort(new PatientIDComparator());
        admissionDAO.admissions.sort(new AdmissionComparator());

        Output.printAdmission(admissionDAO.admissions, "admissionout.txt");
        Output.printPatient(patientDAO.patients, "patientout.txt");
    }
}
