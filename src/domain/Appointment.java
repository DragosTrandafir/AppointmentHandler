package domain;

import java.util.Objects;

public class Appointment extends Entity
{
    //private attributes
    private String patientName;
    private String doctorName;
    private String hour;
    private String date;

    //constructor
    public Appointment(int id, String patientName, String doctorName, String hour, String date){
        super(id);
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.hour = hour;
        this.date = date;
    }


    //getters
    public String getPatientName(){
        return patientName;
    }
    public String getDoctorName(){
        return doctorName;
    }
    public String getHour(){
        return hour;
    }
    public String getDate(){
        return date;
    }

    //setters
    public void setPatientName(String patientName){
        this.patientName = patientName;
    }
    public void setDoctorName(String doctorName){
        this.doctorName = doctorName;
    }
    public void setHour(String hour){
        this.hour = hour;
    }
    public void setDate(String date){
        this.date = date;
    }

    // checking if 2 objects are egual -> same data values & same bucket using hashCode
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Appointment that = (Appointment) other;
        return id == that.id && Objects.equals(patientName, that.patientName) && Objects.equals(doctorName, that.doctorName) && Objects.equals(hour, that.hour) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientName, doctorName, hour, date);
    }

    public String toString(){
        return "Appointment [id=" + id + ", patientName=" + patientName + ", doctorName="+ doctorName + ", hour=" + hour + ", date=" + date + "]";
    }
}
