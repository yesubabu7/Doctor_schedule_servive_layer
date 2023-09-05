package base.models;
public class Patient {
    private int patientId;
    private String name;
    private String gender;
    private String phone;
    private int age;

    public Patient() {
        // Default constructor
    }

    public Patient(int doctorid,int patientId, String name, String gender, String phone, int age) {
        this.patientId = patientId;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.age = age;
    }

    // Getter and setter methods

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }
}
