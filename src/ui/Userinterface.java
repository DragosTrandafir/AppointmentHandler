package ui;

import domain.Appointment;
import filter.FilterByDoctorName;
import filter.FilterByHour;
import repo.AppointmentsRepository;
import repo.FilteredRepository;
import repo.MemoryRepository;

import java.util.Iterator;
import java.util.Scanner;

public class Userinterface {
    static final int DISPLAY_ALL_OPTION = 1;
    static final int ADD_APPOINTMENT_OPTION = 2;
    static final int MODIFY_AT_ID_OPTION = 3;
    static final int REMOVE_AT_ID_OPTION = 4;
    static final int GET_APPOINTMENTS_OF_DOCTOR_OPTION = 5;
    static final int GET_DOCTORS_MOST_APPOINTMENTS_OPTION = 6;

    static final int DISPLAY_ALL_OPTION_FILTER = 7;
    static final int ADD_APPOINTMENT_OPTION_FILTER = 8;
    static final int MODIFY_AT_ID_OPTION_FILTER = 9;
    static final int REMOVE_AT_ID_OPTION_FILTER = 10;

    static final int EXIT_OPTION = 0;

    public static String printMenuNormalRepo(){
        return "MENU NORMAL REPO\n"+DISPLAY_ALL_OPTION+".Print appointments\n"+ADD_APPOINTMENT_OPTION+".Add appointment\n"+MODIFY_AT_ID_OPTION+".Modify at id (put a different id for the new object)" +
                "\n"+REMOVE_AT_ID_OPTION+".Remove appointment\n"+GET_APPOINTMENTS_OF_DOCTOR_OPTION+".Get the ids of the appointments of a certain doctor" +
                "\n"+GET_DOCTORS_MOST_APPOINTMENTS_OPTION+".Get the name of the doctor with the most appointments" +
                "\n"+EXIT_OPTION+".Exit all\n";
    }
    public static String printMenuFilterRepo(){
        return "MENU FILTER REPO\n"+DISPLAY_ALL_OPTION_FILTER+".Print appointments\n"+ADD_APPOINTMENT_OPTION_FILTER+".Add appointment\n"+MODIFY_AT_ID_OPTION_FILTER+".Modify at id(put a different id for the new object)"
                + "\n"+REMOVE_AT_ID_OPTION_FILTER+".Remove appointment\n"+
                "\n"+EXIT_OPTION+".Exit all";
    }

    public static int readInteger(){
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextInt())
            return scanner.nextInt();
        return 0;
    }
    public static String readString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void main(String []Args){

        Appointment appointment1= new Appointment(123,"Dragos Trandafir","Andrei Ionescu","07:00","12.12.2004");
        Appointment appointment2= new Appointment(341,"Patient0","Doctor0","10:00","10.10.2010");
        Appointment appointment3= new Appointment(342,"Patient1","Doctor1","10:00","13.10.2010");
        Appointment appointment4= new Appointment(343,"Patient2","Doctor2","11:00","10.1.2010");
        Appointment appointment5= new Appointment(344,"Patient3","Doctor0","17:00","8.7.2010");

        AppointmentsRepository appointmentsRepository = new AppointmentsRepository();
        appointmentsRepository.add(appointment1.getId(),appointment1);
        appointmentsRepository.add(appointment2.getId(),appointment2);
        appointmentsRepository.add(appointment3.getId(),appointment3);
        appointmentsRepository.add(appointment4.getId(),appointment4);
        appointmentsRepository.add(appointment5.getId(),appointment5);

        //FilteredRepository<Integer,Appointment> filteredAppointmentsRepository= new FilteredRepository<Integer,Appointment>(new FilterByDoctorName("Doctor0"));// decide here what filter with value you want to impose
        FilteredRepository<Integer,Appointment> filteredAppointmentsRepository= new FilteredRepository<Integer,Appointment>(new FilterByHour("08:00","16:00"));// decide here what filter with value you want to impose

        filteredAppointmentsRepository.add(appointment1.getId(),appointment1);
        filteredAppointmentsRepository.add(appointment2.getId(),appointment2);
        filteredAppointmentsRepository.add(appointment3.getId(),appointment3);
        filteredAppointmentsRepository.add(appointment4.getId(),appointment4);
        filteredAppointmentsRepository.add(appointment5.getId(),appointment5);


        boolean exit = false;
        while(!exit){
            System.out.println(printMenuNormalRepo());
            System.out.println(printMenuFilterRepo());
            System.out.print("\nOption chosen: ");
            int option = readInteger();

            switch(option) {
                //normal repo options
                case DISPLAY_ALL_OPTION:
                    appointmentsRepository.printALl();
                    break;
                case ADD_APPOINTMENT_OPTION:
                    System.out.println("Id:");
                    int id_add_appointment = readInteger();

                    System.out.println("Patient name:");
                    String patientName_add_appointment = readString();

                    System.out.println("Doctor name:");
                    String doctorName_add_appointment = readString();

                    System.out.println("Hour:");
                    String hour_add_appointment = readString();

                    System.out.println("Date:");
                    String date_add_appointment = readString();

                    Appointment readAppointment_add_appointment = new Appointment(id_add_appointment,patientName_add_appointment,doctorName_add_appointment,hour_add_appointment,date_add_appointment);
                    appointmentsRepository.add(id_add_appointment,readAppointment_add_appointment);
                    break;
                case MODIFY_AT_ID_OPTION:
                    System.out.println("Modify at this id:");
                    int idWhereToModify = readInteger();

                    System.out.println("Id:");
                    int id_modify_appointment = readInteger();

                    System.out.println("Patient name:");
                    String patientName_modify_appointment = readString();

                    System.out.println("Doctor name:");
                    String doctorName_modify_appointment = readString();

                    System.out.println("Hour:");
                    String hour_modify_appointment = readString();

                    System.out.println("Date:");
                    String date_modify_appointment = readString();

                    Appointment readAppointment_modify_appointment = new Appointment(id_modify_appointment,patientName_modify_appointment,doctorName_modify_appointment,hour_modify_appointment,date_modify_appointment);
                    appointmentsRepository.modify(idWhereToModify,readAppointment_modify_appointment);
                    break;
                case REMOVE_AT_ID_OPTION:
                    System.out.println("Remove at this id:");
                    int idWhereToRemove = readInteger();

                    appointmentsRepository.delete(idWhereToRemove);
                    break;
                case GET_APPOINTMENTS_OF_DOCTOR_OPTION:
                    System.out.println("Doctor name:");
                    String doctorName_appointments_of_doctor = readString();

                    System.out.println(appointmentsRepository.getAppointmentsOfDoctor(doctorName_appointments_of_doctor));
                    break;
                case GET_DOCTORS_MOST_APPOINTMENTS_OPTION:
                    System.out.println(appointmentsRepository.getDoctorMostAppointments());
                    break;
                case EXIT_OPTION:
                    exit = true;
                    break;

                // Filter repo options
                case DISPLAY_ALL_OPTION_FILTER:
                    filteredAppointmentsRepository.printALl();
                    break;
                case ADD_APPOINTMENT_OPTION_FILTER:
                    System.out.println("Id:");
                    int id_add_appointment_f = readInteger();

                    System.out.println("Patient name:");
                    String patientName_add_appointment_f = readString();

                    System.out.println("Doctor name:");
                    String doctorName_add_appointment_f = readString();

                    System.out.println("Hour:");
                    String hour_add_appointment_f = readString();

                    System.out.println("Date:");
                    String date_add_appointment_f = readString();

                    Appointment readAppointment_add_appointment_f = new Appointment(id_add_appointment_f,patientName_add_appointment_f,doctorName_add_appointment_f,hour_add_appointment_f,date_add_appointment_f);
                    filteredAppointmentsRepository.add(id_add_appointment_f,readAppointment_add_appointment_f);
                    break;
                case MODIFY_AT_ID_OPTION_FILTER:
                    System.out.println("Modify at this id:");
                    int idWhereToModify_f = readInteger();

                    System.out.println("Id:");
                    int id_modify_appointment_f = readInteger();

                    System.out.println("Patient name:");
                    String patientName_modify_appointment_f = readString();

                    System.out.println("Doctor name:");
                    String doctorName_modify_appointment_f = readString();

                    System.out.println("Hour:");
                    String hour_modify_appointment_f = readString();

                    System.out.println("Date:");
                    String date_modify_appointment_f = readString();

                    Appointment readAppointment_modify_appointment_f = new Appointment(id_modify_appointment_f,patientName_modify_appointment_f,doctorName_modify_appointment_f,hour_modify_appointment_f,date_modify_appointment_f);
                    filteredAppointmentsRepository.modify(idWhereToModify_f,readAppointment_modify_appointment_f);
                    break;
                case REMOVE_AT_ID_OPTION_FILTER:
                    System.out.println("Remove at this id:");
                    int idWhereToRemove_f = readInteger();

                    filteredAppointmentsRepository.delete(idWhereToRemove_f);
                    break;
            }

        }
    }
}
