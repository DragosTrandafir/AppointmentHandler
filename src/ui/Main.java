package ui;
import domain.Appointment;
import repository.Repo;
import service.AppointmentController;
import java.util.Scanner; //this is for read

public class Main {
    static final int DISPLAY_ALL_OPTION = 1;
    static final int ADD_APPOINTMENT_OPTION = 2;
    static final int MODIFY_AT_ID_OPTION = 3;
    static final int REMOVE_AT_ID_OPTION = 4;
    static final int GET_APPOINTMENTS_OF_DOCTOR_OPTION = 5;
    static final int GET_DOCTORS_MOST_APPOINTMENTS_OPTION = 6;
    static final int EXIT_OPTION = 0;
    public static String printMenu(){
        return "MENU\n"+DISPLAY_ALL_OPTION+".Print appointments\n"+ADD_APPOINTMENT_OPTION+".Add appointment\n"+MODIFY_AT_ID_OPTION+".Modify at id" +
                "\n"+REMOVE_AT_ID_OPTION+".Remove appointment\n"+GET_APPOINTMENTS_OF_DOCTOR_OPTION+".Get the ids of the appointments of a certain doctor" +
                "\n"+GET_DOCTORS_MOST_APPOINTMENTS_OPTION+".Get the name of the doctor with the most appointments" +
                "\n"+EXIT_OPTION+".Exit";
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
    public static void main(String[] args) {
        Appointment appointment1= new Appointment(123,"Dragos Trandafir","Andrei Ionescu","12:00","12.12.2004");
        Appointment appointment2= new Appointment(341,"Patient0","Doctor0","10:00","10.10.2010");
        Appointment appointment3= new Appointment(342,"Patient1","Doctor1","10:00","13.10.2010");
        Appointment appointment4= new Appointment(343,"Patient2","Doctor2","11:00","10.1.2010");
        Appointment appointment5= new Appointment(344,"Patient3","Doctor0","16:00","8.7.2010");

        Repo repo = new Repo(); // add all the appointments in the repository
        repo.addAppointment(appointment1);
        repo.addAppointment(appointment2);
        repo.addAppointment(appointment3);
        repo.addAppointment(appointment4);
        repo.addAppointment(appointment5);

        AppointmentController controller = new AppointmentController(repo);

        boolean exit = false;
        while(!exit){
            System.out.println(printMenu());
            System.out.print("\nOption chosen: ");
            int option = readInteger();

            switch(option) {
                case DISPLAY_ALL_OPTION:
                    System.out.print(controller.toString());
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
                    controller.addAppointment(id_add_appointment, patientName_add_appointment, doctorName_add_appointment, hour_add_appointment, date_add_appointment);
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
                    controller.modifyAppointment(idWhereToModify,id_modify_appointment,patientName_modify_appointment,doctorName_modify_appointment,hour_modify_appointment,date_modify_appointment);
                    break;
                case REMOVE_AT_ID_OPTION:
                    System.out.println("Remove at this id:");
                    int idWhereToRemove = readInteger();
                    controller.deleteAppointment(idWhereToRemove);
                    break;
                case GET_APPOINTMENTS_OF_DOCTOR_OPTION:
                    System.out.println("Doctor name:");
                    String doctorName_appointments_of_doctor = readString();
                    System.out.println(controller.getAppointmentsOfDoctor(doctorName_appointments_of_doctor));
                    break;
                case GET_DOCTORS_MOST_APPOINTMENTS_OPTION:
                    System.out.println(controller.getDoctorMostAppointments());
                    break;
                case EXIT_OPTION:
                    exit = true;
                    break;
            }

        }
    }
}
