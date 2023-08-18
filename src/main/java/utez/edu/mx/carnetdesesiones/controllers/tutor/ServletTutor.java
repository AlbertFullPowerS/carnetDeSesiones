package utez.edu.mx.carnetdesesiones.controllers.tutor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utez.edu.mx.carnetdesesiones.models.Consultor.Consultor;
import utez.edu.mx.carnetdesesiones.models.Group.Group;
import utez.edu.mx.carnetdesesiones.models.Session.DaoSession;
import utez.edu.mx.carnetdesesiones.models.Session.Session;
import utez.edu.mx.carnetdesesiones.models.Student.DaoStudent;
import utez.edu.mx.carnetdesesiones.models.Student.Student;
import utez.edu.mx.carnetdesesiones.models.Tutor.Tutor;
import utez.edu.mx.carnetdesesiones.models.crud.Value;
import utez.edu.mx.carnetdesesiones.models.user.DaoUser;
import utez.edu.mx.carnetdesesiones.models.user.User;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Tutor",urlPatterns = {
        "/tutor/panel",
        "/tutor/list-students",
        "/tutor/view-student",
        "/tutor/profile",
        "/tutor/password-changes"
})
public class ServletTutor extends HttpServlet {
    private String action ;
    private Tutor tutor;

    private String redirect = "/user/session" ;

    private String email,password ;
    private User user;

    private String id ;
    private long id_tutor ;
    private String idU;
    private String newid ;
    private Student student;
    private Consultor consultor;

    private List<Group> groups;
    private List<Session> sessions;
    private String Card;
    private String Camp;
    private String campv2;
    private HttpSession session ;
    private String valor;

    private  Value context;
    private List<Student> students;

    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException
    {
        req.setCharacterEncoding("UTF-8");
        session = req.getSession();
        action = req.getServletPath();
        switch (action)
        {
            /*Vistasde lso usuarios */
            case  "/tutor/panel":
                tutor = (Tutor) session.getAttribute("user");
                req.setAttribute("user",tutor);
                redirect = "/views/user/Tutor/panel.jsp";
                break;
            case  "/tutor/profile":
                req.setAttribute("tutor",tutor);
                redirect = "/views/user/Tutor/profile.jsp";
                break;
            case  "/tutor/list-students":
                 tutor = (Tutor) session.getAttribute("user");
                students = new DaoStudent().findAllTutor(tutor.getId_tutor());
                req.setAttribute("students",students);
                redirect = "/views/user/Tutor/listStudent.jsp";
                break;
            case  "/tutor/view-student":
                id = req.getParameter("id");
                idU = req.getParameter("idU");
                sessions = new DaoSession().findAllHistory(Long.parseLong(id));
                if (sessions != null)
                {
                    req.setAttribute("student",new DaoStudent().findOne(Long.parseLong(idU)));

                    req.setAttribute("sessions",sessions);
                    redirect = "/views/user/Tutor/listSessions.jsp";
                }else {
                    redirect = "/tutor/list-students?result= " + false + "&message" +
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
            case "/tutor/password-changes":
                String ol_passowrd = req.getParameter("ol_passowrd");
                String new_passowrd = req.getParameter("new_passowrd");
                if (new DaoUser().ChangePassword(ol_passowrd,new_passowrd,tutor))
                {
                    redirect = "/tutor/profile";
                }else {
                    redirect = "/tutor/profile?result= " + false + "&message" +
                            "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);
                }
                break;

        }
        resp.sendRedirect(req.getContextPath()+redirect);

        }
}
