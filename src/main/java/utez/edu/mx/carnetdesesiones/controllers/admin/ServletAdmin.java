package utez.edu.mx.carnetdesesiones.controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utez.edu.mx.carnetdesesiones.models.AcademicProgram.AcademicProgram;
import utez.edu.mx.carnetdesesiones.models.AcademicProgram.DaoAcademicProgram;
import utez.edu.mx.carnetdesesiones.models.Admin.Admin;
import utez.edu.mx.carnetdesesiones.models.Appoinment.Appointment;
import utez.edu.mx.carnetdesesiones.models.Appoinment.DaoAppointment;
import utez.edu.mx.carnetdesesiones.models.Consultor.Consultor;
import utez.edu.mx.carnetdesesiones.models.Consultor.DaoConsultor;
import utez.edu.mx.carnetdesesiones.models.Group.DaoGroup;
import utez.edu.mx.carnetdesesiones.models.Group.Group;
import utez.edu.mx.carnetdesesiones.models.Periods.DaoPeriod;
import utez.edu.mx.carnetdesesiones.models.Periods.Periods;
import utez.edu.mx.carnetdesesiones.models.Report.DaoReport;
import utez.edu.mx.carnetdesesiones.models.RequestStudents.DaoRequestStudents;
import utez.edu.mx.carnetdesesiones.models.RequestStudents.RequestStudents;
import utez.edu.mx.carnetdesesiones.models.Session.DaoSession;
import utez.edu.mx.carnetdesesiones.models.Student.DaoStudent;
import utez.edu.mx.carnetdesesiones.models.Student.Student;
import utez.edu.mx.carnetdesesiones.models.Tutor.DaoTutor;
import utez.edu.mx.carnetdesesiones.models.Tutor.Tutor;
import utez.edu.mx.carnetdesesiones.models.crud.DataList;
import utez.edu.mx.carnetdesesiones.models.crud.Value;
import utez.edu.mx.carnetdesesiones.models.justifications.DaoJustifications;
import utez.edu.mx.carnetdesesiones.models.justifications.Justifications;
import utez.edu.mx.carnetdesesiones.models.user.DaoUser;
import utez.edu.mx.carnetdesesiones.models.user.User;


import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "Admin",urlPatterns = {
        "/admin/panel",
        "/admin/profile",
        "/admin/password-changes",
        /*-----Student ----*/
        "/admin/student",
        "/admin/user-view-update",
        "/admin/user-view-one-update",
        "/admin/student/update",
        "/admin/student/delete",
        "/admin/student/save",
        "/admin/student/create"
        /*-----Student----*/
        /*-----Consultor----*/
        ,"/admin/consultor",
        "/admin/user-view-update-consultor",
        "/admin/user-view-one-update-consultor",
        "/admin/consultor/update",
        "/admin/consultor/create",
        "/admin/consultor/save",
        "/admin/consultor/delete"
        /*-----Consultor----*/
        /*-----Group----*/
        ,"/admin/group",
        "/admin/user-view-update-group",
        "/admin/user-view-one-update-group",
        "/admin/group/update",
        "/admin/group/create",
        "/admin/group/save",
        "/admin/group/delete"
        /*-----Consultor----*/
        /*-----Periods----*/
        ,"/admin/period",
        "/admin/user-view-update-period",
        "/admin/user-view-one-update-period",
        "/admin/period/update",
        "/admin/period/create",
        "/admin/period/save",
        "/admin/period/delete"
        /*-----Periods----*/
        /*-----Tutors----*/
        ,"/admin/tutor",
        "/admin/user-view-update-tutor",
        "/admin/user-view-one-update-tutor",
        "/admin/tutor/update",
        "/admin/tutor/create",
        "/admin/tutor/save",
        "/admin/tutor/group-delete",
        "/admin/tutor/group-save",
        "/admin/tutor/delete",

        /*-----Tutors----*/
        /*-----Citas----*/
        "/admin/appointment-consultor",
        "/admin/appointment-select-consultor",
        "/admin/appointment-view-sessions",
        "/admin/appointment-select-student",
        "/admin/appointment-save",

        /*-----Citas----*/

        /*----------------Notifications------------------*/
        "/admin/notifications",
        "/admin/transferens-select-consultor",
        "/admin/deny-transfer",
        "/admin/transfer",
        "/admin/notifications/justification",
        "/admin/view-report"
        /*----------------Notificaciones------------------*/



})
public class ServletAdmin extends HttpServlet {
    private String action ;
    private String redirect = "/admin/panel" ;

    private String email,password ;
    private User user;

    private String id ;
    private ArrayList<String> varStudent  = new ArrayList<>(Arrays.asList("name","status", "first_last_name", "second_last_name","password","phone","email","enrollment"));

    private String newid ;
    private Student student;
    private Consultor consultor;
    private Tutor tutor;
    private Periods period;
    private Group group;
    private  AcademicProgram academicProgram;
    private Appointment appointment;
    private LocalDate localDate;
    private LocalTime localTime;

    private List<Group> groups;
    private List<RequestStudents> requestStudents;

    private List<AcademicProgram> academicPrograms;
    private String Card;
    private String Camp;
    private String campv2;

    private String valor;

    private  Value context;
    private Value op;
    private  int passGrupsTutors = 0 ;
    private boolean isNumeric;

    private List<Consultor> Consultors;
    private RequestStudents requestStudent;
    private List<Justifications> justifications;
    private Justifications justification;
    private HttpSession session ;
    private Admin admin ;
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException
    {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        session = req.getSession();
        switch (action)
        {
            /*Vistasde lso usuarios */
            case  "/admin/panel":

                admin = (Admin) session.getAttribute("user");
                req.setAttribute("user",admin);
                redirect = "/views/user/Admin/Inicio/panel.jsp";
                break;
            case  "/admin/profile":
                req.setAttribute("admin",admin);
                redirect = "/views/user/Admin/Inicio/profile.jsp";
                break;
            case  "/admin/student":
                List<Student> students = new DaoStudent().findAll();
                req.setAttribute("students" , students);
                redirect = "/views/user/Admin/users/student/ListEstudents.jsp";
                break;
            case  "/admin/consultor":
                Consultors =  new DaoConsultor().findAll();
                req.setAttribute("Consultors" , Consultors);
                redirect = "/views/user/Admin/users/consultor/ListConsultors.jsp";
                break;
            case  "/admin/period":
                List<Periods> periods =  new DaoPeriod().findAll();
                req.setAttribute("periods" , periods);
                redirect = "/views/user/Admin/users/periods/ListPeriods.jsp";
                break;
            case  "/admin/group":
                List<Group> groups =  new DaoGroup().findAllMax();
                req.setAttribute("groups" , groups);
                redirect = "/views/user/Admin/users/group/ListGroups.jsp";
                break;
            case  "/admin/tutor":
                List<Tutor> tutors =  new DaoTutor().findAll();
                req.setAttribute("tutors" , tutors);
                redirect = "/views/user/Admin/users/tutor/ListTutors.jsp";
                break;
                /*-----------//Listas//------------*/

            /*---------Vista de datos de un usuario -------*/

            case "/admin/user-view-update":
                 newid = req.getParameter("id");
                if (newid != null ) id = req.getParameter("id");
                Student student = new Student();
                student = new DaoStudent().findOne(id != null  ? Long.parseLong(id) : 0 );
                if (student != null )
                {
                    req.setAttribute("student",student);
                    redirect = "/views/user/Admin/users/student/updateView.jsp";
                }
                else
                {
                    redirect = "/admin/student?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);
                }
                break;
            case "/admin/user-view-update-consultor":
                 newid = req.getParameter("id");
                if (newid != null ) id = req.getParameter("id");
                consultor = new Consultor();
                consultor = new DaoConsultor().findOne(id != null  ? Long.parseLong(id) : 0 );
                if (consultor != null )
                {
                    req.setAttribute("consultor",consultor);
                    redirect = "/views/user/Admin/users/consultor/updateView.jsp";
                }
                else
                {
                    redirect = "/admin/consultor?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);
                }
                break;
            case "/admin/user-view-update-period":
                newid = req.getParameter("id");
                if (newid != null ) id = req.getParameter("id");
                period = new Periods();
                period = new DaoPeriod().findOne(id != null  ? Long.parseLong(id) : 0 );
                if (period != null )
                {
                    req.setAttribute("period",period);
                    redirect = "/views/user/Admin/users/periods/updateView.jsp";
                }
                else
                {
                    redirect = "/admin/period?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);
                }
                break;
            case "/admin/user-view-update-group":
                newid = req.getParameter("id");
                if (newid != null ) id = req.getParameter("id");
                group = new Group();
                group = new DaoGroup().findOne(id != null  ? Long.parseLong(id) : 0 );
                if (group != null )
                {
                    req.setAttribute("group",group);
                    redirect = "/views/user/Admin/users/group/updateView.jsp";
                }
                else
                {
                    redirect = "/admin/group?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);
                }
                break;
            case "/admin/user-view-update-tutor":
                newid = req.getParameter("id");
                if (newid != null ) id = req.getParameter("id");
                tutor = new Tutor();
                tutor = new DaoTutor().findOne(id != null  ? Long.parseLong(id) : 0 );
                if (tutor != null )
                {
                    req.setAttribute("tutor",tutor);
                    passGrupsTutors = 0;
                    redirect = "/views/user/Admin/users/tutor/updateView.jsp";
                }
                else
                {
                    redirect = "/admin/tutor?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);
                }
                break;
            /*---------//Vista de datos de un usuario// -------*/
            /*---------//Creacion de usuarios// -------*/
            case "/admin/student/create":

                groups = new DaoGroup().findAll();
                req.setAttribute("groups",groups);
                redirect = "/views/user/Admin/users/student/create.jsp";
                break;

            case "/admin/consultor/create":
                redirect = "/views/user/Admin/users/consultor/create.jsp";
                break;
            case "/admin/period/create":
                redirect = "/views/user/Admin/users/periods/create.jsp";
                break;
            case "/admin/group/create":
                req.setAttribute("periods",new DaoPeriod().findAll());
                 req.setAttribute("academic",new DaoAcademicProgram().findAll());
                 req.setAttribute("tutors",new DaoTutor().findAll());
                redirect = "/views/user/Admin/users/group/create.jsp";
                break;
            case "/admin/tutor/create":
                redirect = "/views/user/Admin/users/tutor/create.jsp";
                break;

            /*---------//Creacion de usuarios// -------*/



                /*---------Actualizar por uno ---------*/

            case "/admin/user-view-one-update":

                Card = req.getParameter("Card");
                Camp = req.getParameter("Camp");

                Student sstudent = new Student();
                sstudent = new DaoStudent().findOne(id != null  ? Long.parseLong(id) : 0 );
                 op = new Value(Card,Camp,sstudent);
                if (sstudent != null )
                {
                    groups = new DaoGroup().findAll();
                    req.setAttribute("groups",groups);
                    req.setAttribute("student",sstudent);
                    req.setAttribute("op",op);


                    redirect = "/views/user/Admin/users/student/updateOne.jsp";
                }
                else
                {
                    redirect = "../index.jsp?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Acción no realizada", StandardCharsets.UTF_8);
                }
                break;
            case "/admin/user-view-one-update-consultor":

                Card = req.getParameter("Card");
                Camp = req.getParameter("Camp");
                 consultor = new Consultor();
                consultor = new DaoConsultor().findOne(id != null  ? Long.parseLong(id) : 0 );
                 op = new Value(Card,Camp,consultor);
                if (consultor != null )
                {
                    req.setAttribute("consultor",consultor);
                    req.setAttribute("op",op);


                    redirect = "/views/user/Admin/users/consultor/updateOne.jsp";
                }
                else
                {
                    redirect = "/admin/user-view-update-consultor?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Acción no realizada", StandardCharsets.UTF_8);
                }



                break;
            case "/admin/user-view-one-update-period":

                Card = req.getParameter("Card");
                Camp = req.getParameter("Camp");
                period = new Periods();
                period = new DaoPeriod().findOne(id != null  ? Long.parseLong(id) : 0 );
                op = new Value(Card,Camp,period);
                if (period != null )
                {
                    req.setAttribute("period",period);
                    req.setAttribute("op",op);
                    redirect = "/views/user/Admin/users/periods/updateOne.jsp";
                }
                else
                {
                    redirect = "/admin/user-view-update-period?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Acción no realizada", StandardCharsets.UTF_8);
                }



                break;
            case "/admin/user-view-one-update-group":

                Card = req.getParameter("Card");
                Camp = req.getParameter("Camp");
                group = new Group();
                group = new DaoGroup().findOne(id != null  ? Long.parseLong(id) : 0 );
                op = new Value(Card,Camp,group);
                if (group != null )
                {
                    System.out.println(op.getCampv2());
                    if (op.getCampv2().equals("fk_period")) req.setAttribute("periods",new DaoPeriod().findAll());
                    if (op.getCampv2().equals("fk_academic_program")) req.setAttribute("academic",new DaoAcademicProgram().findAll());
                    if (op.getCampv2().equals("fk_tutor")) req.setAttribute("tutors",new DaoTutor().findAll());

                    req.setAttribute("group",group);
                    req.setAttribute("op",op);
                    redirect = "/views/user/Admin/users/group/updateOne.jsp";
                }
                else
                {
                    redirect = "/admin/user-view-update-group?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Acción no realizada", StandardCharsets.UTF_8);
                }



                break;
            case "/admin/user-view-one-update-tutor":
                if (passGrupsTutors == 0)
                {

                    Card = req.getParameter("Card");
                    Camp = req.getParameter("Camp");
                    tutor = new Tutor();
                    tutor = new DaoTutor().findOne(id != null  ? Long.parseLong(id) : 0 );
                    op = new Value(Card,Camp,tutor);
                    if (tutor != null )
                    {
                        req.setAttribute("tutor",tutor);
                        if (op.getCampv2().equals("viewGroups"))
                        {
                            req.setAttribute("tutorGroups",new DaoGroup().findAllTutor(Long.parseLong(id)));
                            req.setAttribute("groups",new DaoGroup().findAll());
                            passGrupsTutors = 1;
                            redirect = "/views/user/Admin/users/tutor/updateGroups.jsp";

                        }
                        else
                        {

                            req.setAttribute("op",op);
                            redirect = "/views/user/Admin/users/tutor/updateOne.jsp";
                        }

                    }
                    else
                    {
                        redirect = "/admin/user-view-update-tutor?result= " + false + "&message" +
                                "=" + URLEncoder.encode("¡Error! Acción no realizada", StandardCharsets.UTF_8);
                    }

                }
                else {
                    req.setAttribute("tutor",tutor);
                    req.setAttribute("tutorGroups",new DaoGroup().findAllTutor(Long.parseLong(id)));
                    req.setAttribute("groups",new DaoGroup().findAll());
                    redirect = "/views/user/Admin/users/tutor/updateGroups.jsp";
                }



                break;
                /*//-------Actualizar por uno ------//*/



            /* ++++++  */
            /*                                      Citas                       */
            /* ++++++  */

            case  "/admin/appointment-select-consultor":
                Consultors =  new DaoConsultor().findAll();
                req.setAttribute("Consultors" , Consultors);
                redirect = "/views/user/Admin/appointment/selectConsultor.jsp";
                break;
            case  "/admin/appointment-consultor":
                newid = req.getParameter("id");
                if (newid != null ) id = req.getParameter("id");
                req.setAttribute("sessions" , new DaoSession().findAllCal(Long.parseLong(id)));
                consultor = new DaoConsultor().findOne(Long.parseLong(id));
                req.setAttribute("consultor" , consultor);
                redirect = "/views/user/Admin/appointment/createAppointment.jsp";
                break;
            case  "/admin/appointment-view-sessions":
                if (req.getParameter("selectedDateTime") != null )
                {
                    if (req.getParameter("selectedDateTime").length() < 19)
                        localTime = LocalTime.parse(('0'+req.getParameter("selectedDateTime").substring(11,req.getParameter("selectedDateTime").length())));
                        else
                        localTime = LocalTime.parse((req.getParameter("selectedDateTime").substring(11,req.getParameter("selectedDateTime").length())));

                    localDate = LocalDate.parse(req.getParameter("selectedDateTime").substring(0,10));

                }
               ArrayList<DataList> listDate = new Value(localDate,localTime).getDataList();
                req.setAttribute("consultor" , new DaoConsultor().findOne(Long.parseLong(id)));

                req.setAttribute("listDate" , listDate);

                redirect = "/views/user/Admin/appointment/viewSessions.jsp";
                break;
            case  "/admin/appointment-select-student":
                students =  new DaoStudent().findAll();
                req.setAttribute("students" , students);
                redirect = "/views/user/Admin/appointment/selectStudent.jsp";
                break;
            /* ++++++  */
            /*                                      Citas                        */
            /* ++++++  */

            /*------------------Notifications---------------------------*/
            case "/admin/notifications":
               requestStudents = new DaoRequestStudents().findAll();
                justifications = new DaoJustifications().findAll();
                req.setAttribute("periods",new DaoPeriod().findAll());

                req.setAttribute("requestStudents" , requestStudents);
                req.setAttribute("justifications" , justifications);
                redirect = "/views/user/Admin/notifications/listNotifications.jsp";
                break;
            case "/admin/transferens-select-consultor":
                appointment = new Appointment();
                appointment.setId_appointment(Long.parseLong(req.getParameter("id_appointment")));
                req.setAttribute("Consultors" , new DaoConsultor().findAll());
                redirect = "/views/user/Admin/notifications/listConsultores.jsp";
                break;
            /*-------------------NOTIFICATIONS---------------------------*/


            /*------------------REPORTE-------------------------*/
            case "/admin/view-report":
                long dataR = Long.parseLong(req.getParameter("periodsInput-hidden"));
                period =  new DaoPeriod().findOne(dataR);

                req.setAttribute("reports" ,new DaoReport().findAll(period.getDateBegin().substring(0,10),(period.getDateEnd().substring(0,10))));

                redirect = "/views/user/Admin/notifications/report.jsp";
                break;

            /*----------------------------------------------*/
        }

        req.getRequestDispatcher(redirect).forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req , HttpServletResponse resp ) throws  ServletException  , IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");



        action = req.getServletPath();
        switch (action)
        {
            /*----------//Delate de los usuarios//---------*/
            case "/admin/student/delete":
                 newid = req.getParameter("id_delate");
                if (newid != null ) id = req.getParameter("id_delate");
                if (new DaoStudent().delate(Long.parseLong(id)))
                {

                    redirect = "/admin/student";
                }
                else
                {
                    redirect = "/admin/user-view-update?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Acción no realizada", StandardCharsets.UTF_8);
                }



                break;
            case "/admin/consultor/delete":
                 newid = req.getParameter("id");
                if (newid != null ) id = req.getParameter("id_delate");

                if (new DaoConsultor().delate(Long.parseLong(id)))
                {

                    redirect = "/admin/consultor";
                }
                else
                {
                    redirect = "/admin/user-view-update-consultor?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Acción no realizada", StandardCharsets.UTF_8);
                }



                break;
            case "/admin/period/delete":
                newid = req.getParameter("id");
                if (newid != null ) id = req.getParameter("id_delate");

                if (new DaoPeriod().delate(Long.parseLong(id)))
                {

                    redirect = "/admin/period";
                }
                else
                {
                    redirect = "/admin/user-view-update-period?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Acción no realizada", StandardCharsets.UTF_8);
                }



                break;
            case "/admin/group/delete":
                newid = req.getParameter("id");
                if (newid != null ) id = req.getParameter("id_delate");

                if (new DaoGroup().delate(Long.parseLong(id)))
                {

                    redirect = "/admin/group";
                }
                else
                {
                    redirect = "/admin/user-view-update-group?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Acción no realizada", StandardCharsets.UTF_8);
                }



                break;
            case "/admin/tutor/delete":
                newid = req.getParameter("id");
                if (newid != null ) id = req.getParameter("id_delate");

                if (new DaoTutor().delate(Long.parseLong(id)))
                {

                    redirect = "/admin/tutor";
                }
                else
                {
                    redirect = "/admin/user-view-update-tutor?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Acción no realizada", StandardCharsets.UTF_8);
                }



                break;
            case "/admin/tutor/group-delete":



                group= new Group();
                group.setId_group(Long.parseLong(req.getParameter("id")));
                if (   new DaoTutor().delateGroup(group) )

                    redirect = "/admin/user-view-one-update-tutor";
                else
                    redirect = redirect = "/admin/user-view-update-tutor?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Registrar", StandardCharsets.UTF_8);


                break;
            /*----------//Delate de los usuarios//---------*/

                /*-----------------------*/
            case "/admin/student/update":
                 campv2 = req.getParameter("object");
                 valor = req.getParameter("valor");
                 isNumeric = (valor != null && valor.matches("[0-9]+"));
                if (isNumeric || varStudent.contains(campv2))context = new Value(id,campv2,valor);
                else {
                    redirect = redirect = "/admin/user-view-update?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Actualizar ", StandardCharsets.UTF_8);
                    break;
                }

                if (   new DaoStudent().updateOne(context) )

                    redirect = "/admin/user-view-update";

                else
                    redirect = redirect = "/admin/user-view-update?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Actualizar ", StandardCharsets.UTF_8);
                break;
            case "/admin/consultor/update":

                 campv2 = req.getParameter("object");
                 valor = req.getParameter("valor");
                System.out.println(campv2 + " " + valor);
                 context = new Value(id,campv2,valor);
                if (   new DaoConsultor().updateOne(context) )

                    redirect = "/admin/user-view-update-consultor";

                else
                    redirect = redirect = "/admin/user-view-update-consultor?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Actualizar ", StandardCharsets.UTF_8);
                break;
            case "/admin/period/update":

                campv2 = req.getParameter("object");
                valor = req.getParameter("valor");
                System.out.println(campv2 + " " + valor);
                context = new Value(id,campv2,valor);
                if (   new DaoPeriod().updateOne(context) )

                    redirect = "/admin/user-view-update-period";

                else
                    redirect = redirect = "/admin/user-view-update-period?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Actualizar ", StandardCharsets.UTF_8);
                break;
            case "/admin/group/update":

                campv2 = req.getParameter("object");

                valor = req.getParameter("valor");
                isNumeric = (valor != null && valor.matches("[0-9]+"));
                if(isNumeric || campv2.equals("group"))context = new Value(id,campv2,valor);
                else{
                    redirect = redirect = "/admin/user-view-update-group?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Registrar", StandardCharsets.UTF_8);
                break;}

                System.out.println(campv2 + " " + valor);

                if (   new DaoGroup().updateOne(context) )

                    redirect = "/admin/user-view-update-group";

                else
                    redirect = redirect = "/admin/user-view-update-group?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Actualizar ", StandardCharsets.UTF_8);
                break;
            case "/admin/tutor/update":

                campv2 = req.getParameter("object");
                valor = req.getParameter("valor");
                System.out.println(campv2 + " " + valor);
                context = new Value(id,campv2,valor);
                if (   new DaoTutor().updateOne(context) )

                    redirect = "/admin/user-view-update-tutor";

                else
                    redirect = redirect = "/admin/user-view-update-tutor?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Actualizar ", StandardCharsets.UTF_8);
                break;
                /*----------//Update de los usuarios//---------*/
            /*----------//Save de los usuarios//---------*/
            case "/admin/student/save":

                Group group = new Group();

                valor = req.getParameter("answerInput-hidden");
                isNumeric = (valor != null && valor.matches("[0-9]+"));
                if (isNumeric)group.setId_group(Long.parseLong(valor));
                else {redirect = redirect = "/admin/student/create?result= " + false + "&message" +
                        "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Registrar", StandardCharsets.UTF_8);
                break;}

                Student student = new Student();
                student.setName(req.getParameter("name"));
                student.setEmail( req.getParameter("email"));
                student.setPassword(req.getParameter("password"));
                student.setFirst_last_name(req.getParameter("first_last_name"));
                student.setSecond_last_name(req.getParameter("second_last_name"));
                student.setEnrollment(req.getParameter("enrollment"));
                student.setPhone(req.getParameter("phone"));

                student.setGroup(group);

                if (   new DaoStudent().save(student) )

                    redirect = "/admin/student";
                else
                    redirect = redirect = "/admin/student/create?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Registrar", StandardCharsets.UTF_8);


                break;
            case "/admin/consultor/save":


                 consultor = new Consultor();
                consultor.setName(req.getParameter("name"));
                consultor.setEmail( req.getParameter("email"));
                consultor.setPassword(req.getParameter("password"));
                consultor.setFirst_last_name(req.getParameter("first_last_name"));
                consultor.setSecond_last_name(req.getParameter("second_last_name"));


                if (   new DaoConsultor().save(consultor) )

                    redirect = "/admin/consultor";
                else
                    redirect = redirect = "/admin/consultor/create?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Registrar", StandardCharsets.UTF_8);


                break;
            case "/admin/period/save":


                period = new Periods();
                period.setName(req.getParameter("name"));
                period.setDateBegin( req.getParameter("date_begin"));
                period.setDateEnd(req.getParameter("date_end"));



                if (   new DaoPeriod().save(period) )

                    redirect = "/admin/period";
                else
                    redirect = redirect = "/admin/period/create?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Registrar", StandardCharsets.UTF_8);


                break;
            case "/admin/group/save":
                period = new Periods();
                tutor = new Tutor();
                academicProgram = new AcademicProgram();
                group = new Group();

                    String tuto = req.getParameter("tutorsInput-hidden");
                    isNumeric = (tuto != null && tuto.matches("[0-9]+"));
                    if(isNumeric)tutor.setId_tutor(Long.parseLong(tuto));
                    else{
                        redirect = redirect = "/admin/group/create?result= " + false + "&message" +
                                "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Registrar", StandardCharsets.UTF_8);
                        break;}

                    valor= req.getParameter("periodsInput-hidden");
                    isNumeric = (valor != null && valor.matches("[0-9]+"));
                    if(isNumeric)period.setId_Periods(Long.parseLong(valor));
                    else{
                        redirect = redirect = "/admin/group/create?result= " + false + "&message" +
                                "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Registrar", StandardCharsets.UTF_8);
                    break;}

                    String acade = req.getParameter("academicInput-hidden");
                    isNumeric= (acade != null && acade.matches("[0-9]+"));
                    if (isNumeric)academicProgram.setId_AcademicProgram(Long.parseLong(acade));
                    else{
                        redirect = redirect = "/admin/group/create?result= " + false + "&message" +
                                "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Registrar", StandardCharsets.UTF_8);
                        break;}



                    group.setGrade(req.getParameter("grade"));
                    group.setGroup(req.getParameter("group"));

                    group.setAcademic_program(academicProgram);
                    group.setPeriodo(period);
                    group.setTutor(tutor);





                if (   new DaoGroup().save(group) )

                    redirect = "/admin/group";
                else
                    redirect = redirect = "/admin/group/create?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Registrar", StandardCharsets.UTF_8);


                break;

            case "/admin/tutor/save":


                tutor = new Tutor();
                tutor.setName(req.getParameter("name"));
                tutor.setEmail( req.getParameter("email"));
                tutor.setPassword(req.getParameter("password"));
                tutor.setFirst_last_name(req.getParameter("first_last_name"));
                tutor.setSecond_last_name(req.getParameter("second_last_name"));


                if (   new DaoTutor().save(tutor) )

                    redirect = "/admin/tutor";
                else
                    redirect = redirect = "/admin/tutor/create?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Registrar", StandardCharsets.UTF_8);


                break;
            case "/admin/tutor/group-save":



                group= new Group();
                String idGroup = req.getParameter("answerInput-hidden");
                isNumeric = (idGroup != null && idGroup.matches("[0-9]+"));
                if (isNumeric)group.setId_group(Long.parseLong(idGroup));

                if (   new DaoTutor().addGroup(group,tutor) )

                    redirect = "/admin/user-view-one-update-tutor";
                else
                    redirect = redirect = "/admin/user-view-update-tutor?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Registrar", StandardCharsets.UTF_8);


                break;
            /*----------//Save de los usuarios//---------*/

            /* ++++++  */
            /*                                      Citas                        */
            /* ++++++  */
            case  "/admin/appointment-save":
                student = new Student();
                student.setId_student(Long.parseLong(req.getParameter("id")));
                appointment = new Appointment();
                appointment.setPlace(req.getParameter("place"));
                appointment.setStudent(student);
                String dateEnd = String.valueOf(localDate) + " " +String.valueOf(localTime);

                if (new DaoAppointment().save(appointment,dateEnd ,consultor))
                {
                    redirect = "/admin/appointment-select-consultor";
                }
                else {
                    redirect = redirect = "/admin/appointment-select-student?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Registrar", StandardCharsets.UTF_8);

                }


                break;

            /* ++++++  */
            /*                                      Citas                        */
            /* ++++++  */

            /*------------------Notifications---------------------------*/
            case "/admin/deny-transfer":
                requestStudent = new RequestStudents();
                requestStudent.setId_request(Long.parseLong(req.getParameter("id_appointmentD")));
                if (new DaoRequestStudents().denyTranfer(requestStudent))
                {
                    redirect = "/admin/notifications";

                }else
                {
                    redirect = redirect = "/admin/notifications?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Registrar", StandardCharsets.UTF_8);

                }
                break;
            case "/admin/transfer":
                consultor = new Consultor();
                consultor.setId_consultor(Long.parseLong(req.getParameter("id_consultor")));
                if (new DaoRequestStudents().Tranfer(consultor,appointment))
                {
                    redirect = "/admin/notifications";

                }else
                {
                    redirect = redirect = "/admin/notifications?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Registrar", StandardCharsets.UTF_8);

                }
                break;
            case "/admin/notifications/justification":
                justification = new Justifications();
                justification.setId_justification(Long.parseLong(req.getParameter("id_just")));
                long optio = Long.parseLong(req.getParameter("option"));

                if (new DaoJustifications().Accept(justification,optio))
                {
                    redirect = "/admin/notifications";

                }else
                {
                    redirect = redirect = "/admin/notifications?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Tu usuario No se puede Registrar", StandardCharsets.UTF_8);

                }
                break;
            case "/admin/password-changes":
                String ol_passowrd = req.getParameter("ol_passowrd");
                String new_passowrd = req.getParameter("new_passowrd");
                if (new DaoUser().ChangePassword(ol_passowrd,new_passowrd,admin))
                {
                    redirect = "/admin/profile";
                }else {
                    redirect = "/admin/profile?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);
                }
                break;


            /*-------------------NOTIFICATIONS---------------------------*/




        }
        resp.sendRedirect(req.getContextPath()+redirect);

        }
}
