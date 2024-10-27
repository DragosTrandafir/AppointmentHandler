package service;

import domain.Appointment;
import repository.Repo;

import java.util.ArrayList;

public class AppointmentController {
    private Repo repo;

    public AppointmentController(Repo repo) {
        this.repo = repo;
    }
    public void addAppointment(int id, String patientName, String doctorName, String hour, String date) {
        Appointment appointment = new Appointment(id, patientName, doctorName, hour, date);
        repo.addAppointment(appointment);
    }
    public void deleteAppointment(int id) {
        repo.removeAppointment(id);
    }
    public void modifyAppointment(int idWhereToModify, int id, String patientName, String doctorName, String hour, String date){
        Appointment appointment = new Appointment(id, patientName, doctorName, hour, date);
        repo.modifyAppointment(idWhereToModify, appointment);
    }
    public ArrayList<Integer> getAppointmentsOfDoctor(String doctorName){
        return repo.getAppointmentsOfDoctor(doctorName);
    }
    public String getDoctorMostAppointments(){
        return repo.getDoctorMostAppointments();
    }
    public String toString(){
        return repo.toString();
    }
}
