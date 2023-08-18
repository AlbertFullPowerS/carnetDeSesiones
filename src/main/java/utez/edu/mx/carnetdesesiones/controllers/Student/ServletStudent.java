package utez.edu.mx.carnetdesesiones.controllers.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utez.edu.mx.carnetdesesiones.models.Consultor.Consultor;
import utez.edu.mx.carnetdesesiones.models.Group.Group;
import utez.edu.mx.carnetdesesiones.models.RequestStudents.DaoRequestStudents;
import utez.edu.mx.carnetdesesiones.models.RequestStudents.RequestStudents;
import utez.edu.mx.carnetdesesiones.models.Session.DaoSession;
import utez.edu.mx.carnetdesesiones.models.Session.Session;
import utez.edu.mx.carnetdesesiones.models.Student.DaoStudent;
import utez.edu.mx.carnetdesesiones.models.Student.Student;
import utez.edu.mx.carnetdesesiones.models.Tutor.Tutor;
import utez.edu.mx.carnetdesesiones.models.crud.Value;
import utez.edu.mx.carnetdesesiones.models.justifications.DaoJustifications;
import utez.edu.mx.carnetdesesiones.models.justifications.Justifications;
import utez.edu.mx.carnetdesesiones.models.user.DaoUser;
import utez.edu.mx.carnetdesesiones.models.user.User;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "Student",urlPatterns = {
        "/student/panel",
        "/student/history",
        "/student/view-change-consulter",
        "/student/change-consulter",
        "/student/sessions",
        "/student/profile",
        "/student/password-changes",
        "/student/save-justification"

})
public class ServletStudent extends HttpServlet {
    private String action ;
    private String redirect = "/user/session" ;

    private String email,password ;
    private User user;

    private String id ;
    private String newid ;
    private Student student;
    private Consultor consultor;

    private List<Group> groups;
    private List<Session> sessions;
    private Session sess;
    private Justifications justifications;
    private RequestStudents requestStudents;
    private String Card;
    private HttpSession session ;

    private String text;

    private String valor;

    private  Value context;

    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException
    {
        req.setCharacterEncoding("UTF-8");
        session = req.getSession();
        action = req.getServletPath();
        switch (action)
        {
            /*Vistasde lso usuarios */
            case  "/student/panel":
                student = (Student) session.getAttribute("user");
                req.setAttribute("user",student);
                redirect = "/views/user/Student/panel.jsp";
                break;
            case  "/student/profile":
                req.setAttribute("studentU",student);
                redirect = "/views/user/Student/profile.jsp";
                break;
            case  "/student/history":

                sessions = new DaoSession().findAllHistory(student.getId_student());
                if (sessions != null)
                {
                    req.setAttribute("studentU",student);
                    req.setAttribute("sessions",sessions);
                    redirect = "/views/user/Student/history.jsp";
                }else {
                    redirect = "/student/panel?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);
                }
                break;
            case  "/student/view-change-consulter":
                redirect = "/views/user/Student/changeConsultor.jsp";
                break;
            case  "/student/sessions":
                 sessions = new DaoSession().findAllStudent(student.getId_student());
                req.setAttribute("sessions",sessions);
                req.setAttribute("studentU",student);
                redirect = "/views/user/Student/sessions.jsp";
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
            case "/student/password-changes":
                String ol_passowrd = req.getParameter("ol_passowrd");
                String new_passowrd = req.getParameter("new_passowrd");
                if (new DaoUser().ChangePassword(ol_passowrd,new_passowrd,student))
                {
                    redirect = "/student/profile";
                }else {
                    redirect = "/student/profile?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);
                }
                break;
            case "/student/save-justification":
                sess = new Session();
                justifications = new Justifications();
                 text = req.getParameter("text");
                sess.setId_session(Long.parseLong(req.getParameter("idSession")));
                System.out.println("session : "+ sess.getId_session() + "student id :" + student.getId_student());
                 justifications.setSession(sess);
                 justifications.setReason(text);
                if (new DaoJustifications().saveJustification(justifications,student.getId_student(),student))
                {
                    redirect = "/student/sessions";
                }else {
                    redirect = "/student/sessions?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);
                }
                break;

            case  "/student/change-consulter":
                requestStudents = new RequestStudents();
                 text = req.getParameter("text");
                 requestStudents.setReason(text);
                 requestStudents.setUser(student);
                if(new DaoRequestStudents().saveReques(requestStudents,student.getId_student()))
                {
                    redirect = "/student/view-change-consulter";
                }else {
                    redirect = "/student/view-change-consulter?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);
                }
                break;

        }
        resp.sendRedirect(req.getContextPath()+redirect);

        }
}
