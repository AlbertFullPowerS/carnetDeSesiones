package utez.edu.mx.carnetdesesiones.controllers.consultor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utez.edu.mx.carnetdesesiones.models.Appoinment.Appointment;
import utez.edu.mx.carnetdesesiones.models.Appoinment.DaoAppointment;
import utez.edu.mx.carnetdesesiones.models.Consultor.Consultor;
import utez.edu.mx.carnetdesesiones.models.Group.Group;
import utez.edu.mx.carnetdesesiones.models.RequestConsultor.DaoRequestConsultor;
import utez.edu.mx.carnetdesesiones.models.RequestConsultor.RequestConsultor;
import utez.edu.mx.carnetdesesiones.models.RequestStudents.DaoRequestStudents;
import utez.edu.mx.carnetdesesiones.models.RequestStudents.RequestStudents;
import utez.edu.mx.carnetdesesiones.models.Session.DaoSession;
import utez.edu.mx.carnetdesesiones.models.Session.Session;
import utez.edu.mx.carnetdesesiones.models.Student.Student;
import utez.edu.mx.carnetdesesiones.models.crud.Value;
import utez.edu.mx.carnetdesesiones.models.justifications.DaoJustifications;
import utez.edu.mx.carnetdesesiones.models.justifications.Justifications;
import utez.edu.mx.carnetdesesiones.models.user.DaoUser;
import utez.edu.mx.carnetdesesiones.models.user.User;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "Consultor",urlPatterns = {
        "/consultor/panel",
        "/consultor/profile",
        "/consultor/password-changes",
        "/consultor/sessions-view",
        "/consultor/appointments-view",
        "/consultor/session-student-view",
        "/consultor/save-register-session",
        "/consultor/save-justification",
        "/consultor/trasnfer-student"





})
public class ServletConsultor extends HttpServlet {
    private String action ;
    private String redirect = "/consultor/panel" ;

    private String email,password ;
    private User user;

    private long id  = 0 ;
    private long app;
    private String newid ;
    private Student student;
    private Consultor consultor;
    private Justifications justifications;

    private List<Group> groups;
    private String Card;
    private String Camp;
    private String campv2;

    private String valor;

    private  Value context;
    private HttpSession session ;
    private Session sess = new Session();
    private List<Session> sessions;
    private List<Appointment> appointments;
    private RequestStudents requestStudents;


    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException
    {
        req.setCharacterEncoding("UTF-8");
        session = req.getSession();
        action = req.getServletPath();
        switch (action)
        {
            /*Vistasde lso usuarios */
            case  "/consultor/panel":
                consultor = (Consultor) session.getAttribute("user");
                req.setAttribute("user",consultor);
                redirect = "/views/user/Consultor/panel.jsp";
                break;
            case  "/consultor/profile":
                req.setAttribute("consultor",consultor);
                redirect = "/views/user/Consultor/profile.jsp";
                break;
            case  "/consultor/sessions-view":
                id = 0 ;
                sessions = new DaoSession().findAllNextSessions(consultor.getId_consultor());
                req.setAttribute("sessions",sessions);

                redirect = "/views/user/Consultor/listSessions.jsp";
                break;
            case  "/consultor/appointments-view":
                id = 0 ;
                appointments = new DaoAppointment().findAllAppoinments(consultor.getId_consultor());
                if (appointments!=null){
                    req.setAttribute("appointments",appointments);
                    redirect = "/views/user/Consultor/appointments/listAppointments.jsp";
                }
                else {
                    redirect = "/consultor/panel?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);
                }

                break;
            case  "/consultor/session-student-view":

                if (id == 0)id = Long.parseLong(req.getParameter("id"));
                sessions = new DaoSession().findAllAppointment(id);
                if (appointments!=null){
                    req.setAttribute("sessions",sessions);
                    req.setAttribute("id",id);
                    redirect = "/views/user/Consultor/appointments/sessions.jsp";
                }
                else {
                    redirect = "/views/user/Consultor/appointments/listAppointments.jsp?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);
                }

                break;


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
            case "/consultor/password-changes":
                String ol_passowrd = req.getParameter("ol_passowrd");
                String new_passowrd = req.getParameter("new_passowrd");
                if (new DaoUser().ChangePassword(ol_passowrd,new_passowrd,consultor))
                {
                    redirect = "/consultor/profile";
                }else {
                    redirect = "/consultor/profile?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);
                }
                break;
            case "/consultor/save-register-session":
                long option = Long.parseLong(req.getParameter("option"));
                long id_session = Long.parseLong(req.getParameter("session"));
                System.out.println("Id :session" + id_session);
                sess.setId_session(id_session);


                switch ((int) option){
                    case 1:
                        if (new DaoSession().saveRegisterAttendance(sess))
                        {
                            redirect = "/consultor/session-student-view";
                        }else {
                            redirect = "/consultor/session-student-view?result= " + false + "&message" +
                                    "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);
                        }
                        break;
                    case 0:
                        if (new DaoSession().saveRegisterFalta(sess))
                        {
                            redirect = "/consultor/session-student-view";
                        }else {
                            redirect = "/consultor/session-student-view?result= " + false + "&message" +
                                    "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);
                        }
                        break;
                    default:
                        redirect = "/consultor/session-student-view?result= " + false + "&message" +
                                "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);

                }


                break;
            case "/consultor/save-justification":
                justifications = new Justifications();
                String text = req.getParameter("text");
                long sessionJ = Long.parseLong(req.getParameter("sessionJ"));
                 app = Long.parseLong(req.getParameter("app"));
                System.out.println("Id :session" + app);
                sess.setId_session(sessionJ);
                justifications.setSession(sess);
                justifications.setReason(text);




                        if (new DaoJustifications().saveJustificationApp(justifications,app,consultor))
                        {
                            redirect = "/consultor/session-student-view";
                        }else {
                            redirect = "/consultor/session-student-view?result= " + false + "&message" +
                                    "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);
                        }

                break;
            case  "/consultor/trasnfer-student":
                student=new Student();
                requestStudents = new RequestStudents();
                text = req.getParameter("text");
                 app = Long.parseLong(req.getParameter("id_appointment"));
                requestStudents.setReason(text);
                requestStudents.setUser(consultor);

                if(new DaoRequestStudents().saveRequesApp(requestStudents,app))
                {
                    redirect = "/consultor/session-student-view";
                }else {
                    redirect = "/consultor/session-student-view?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);
                }
                break;

        }
        resp.sendRedirect(req.getContextPath()+redirect);

        }
}
