public class Patient implements Comparable<Patient>{
    int id;
    String name;
    String surname;
    String phoneNumber;
    String address;

    public Patient(int id, String name, String surname, String phoneNumber, String address){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Patient o) {
        return this.id - o.id;
    }

}
