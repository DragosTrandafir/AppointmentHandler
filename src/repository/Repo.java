package repository;
import domain.Appointment;
import java.util.ArrayList;

public class Repo {
    private ArrayList<Appointment> appointments= new ArrayList<>();

    public boolean checkId(int id) {
        for (Appointment appointment : appointments)
            if (appointment.getId() == id) {
                return false;
            }
        return true;

    }
    public void addAppointment(Appointment appointment){
        if(checkId(appointment.getId()))
            appointments.add(appointment);
    }
    public void removeAppointment(int id){
        appointments.removeIf(appointment -> appointment.getId() == id);
    }
    public void modifyAppointment(int id, Appointment other){
        for(int i=0; i<appointments.size(); i++)
            if(appointments.get(i).getId() == id && (checkId(other.getId())))
                appointments.set(i, other);
    }
    public ArrayList<Integer> getAppointmentsOfDoctor(String doctorName){
        ArrayList<Integer> ids = new ArrayList<>();
        for(Appointment appointment: appointments){
            if(appointment.getDoctorName().equals(doctorName)){
                ids.add(appointment.getId());
            }
        }
        return ids;
    }

    public Integer getNrOfAppointmentsOfDoctor(String doctorName) {
        int count = 0;
        for (Appointment appointment : appointments)
            if (appointment.getDoctorName().equals(doctorName)) {
                count++;
            }
        return count;

    }
    public String getDoctorMostAppointments(){
        int maxx=0;
        String doctorName=appointments.get(0).getDoctorName();
        for(Appointment appointment: appointments){
            if(getNrOfAppointmentsOfDoctor(appointment.getDoctorName())>maxx) {
                maxx = getNrOfAppointmentsOfDoctor(appointment.getDoctorName());
                doctorName=appointment.getDoctorName();
            }
        }
        return doctorName;
    }
    public String toString(){
        String outputString="Appoinments:\n";
        for(Appointment appointment:appointments){
            outputString += appointment.toString()+"\n";
        }
        return outputString;

    }
}
