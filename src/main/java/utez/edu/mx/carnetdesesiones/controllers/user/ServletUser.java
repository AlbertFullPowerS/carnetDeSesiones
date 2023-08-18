package utez.edu.mx.carnetdesesiones.controllers.user;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utez.edu.mx.carnetdesesiones.models.Admin.Admin;
import utez.edu.mx.carnetdesesiones.models.Consultor.Consultor;
import utez.edu.mx.carnetdesesiones.models.Student.DaoStudent;
import utez.edu.mx.carnetdesesiones.models.Tutor.Tutor;
import utez.edu.mx.carnetdesesiones.models.Student.Student;
import utez.edu.mx.carnetdesesiones.models.user.DaoUser;
import utez.edu.mx.carnetdesesiones.models.user.User;


import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "users",urlPatterns = {
        "/user/login",
        "/user/logout"
})
public class ServletUser extends HttpServlet {
    private String action ;
    private String redirect = "/user/login" ;

    private String email,password ;
    private User user;
    private HttpSession session;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action) {
            case "/user/login":
                redirect = "/index.jsp";
                break;
            case "/user/logout":
                session = req.getSession();
                session.invalidate();
                redirect = "/index.jsp";
                break;
        }
        req.getRequestDispatcher(redirect)
                .forward(req, resp);
    }
    private String getServletNameFromServletContext(String servletClassName) {
        ServletContext servletContext = getServletContext();
        for (ServletRegistration registration : servletContext.getServletRegistrations().values()) {
            if (registration.getClassName().equals(servletClassName)) {
                return registration.getName();
            }
        }
        return null;
    }
    protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws jakarta.servlet.ServletException, java.io.IOException
    {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        action = req.getServletPath();
        session = req.getSession();
        switch (action)
        {
            case  "/user/login":
                email = req.getParameter("email");
                password = req.getParameter("password");
                try {
                    User user = new DaoUser().login(email, password);
                    if (user != null)
                    {
                        session = req.getSession();
                        session.setAttribute("user", user);

                        switch (user.getClass().getSimpleName())
                        {
                            case "Admin":

                                Admin admin = (Admin) user;
                                req.setAttribute("user",admin);
                                redirect = "/admin/panel";
                                break;
                            case "Consultor":
                                Consultor consultor = (Consultor) user;
                                req.setAttribute("user",consultor);
                                redirect = "/consultor/panel";
                                break;
                            case "Student":
                                Student student = (Student) user;
                                System.out.println("User :" +student.getId_user());
                                req.setAttribute("user",student);
                                req.setAttribute("student",student);
                                redirect = "/student/panel";
                                break;
                            case "Tutor":
                                Tutor tutor = (Tutor) user;
                                System.out.println(tutor.getId_tutor());
                                req.setAttribute("user",tutor);
                                req.setAttribute("tutor",tutor);
                                redirect = "/tutor/panel";
                                break;
                            default:
                                redirect = "/index.jsp?result= " + false + "&message" +
                                        "=" + URLEncoder.encode("¡Error! Accion no relizada", StandardCharsets.UTF_8);
                        }
                    } else {
                        throw new Exception("Credentials mismatch");

                    }

                }catch (Exception e){
                    redirect = "/user/login?result=false&message=" + URLEncoder
                            .encode("Usuario y/o contraseña incorrecta",
                                    StandardCharsets.UTF_8);
                }
                break;
        }
        resp.sendRedirect(req.getContextPath()
                + redirect);
    }

}
