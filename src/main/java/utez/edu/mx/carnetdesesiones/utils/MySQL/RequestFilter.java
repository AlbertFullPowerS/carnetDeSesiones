package utez.edu.mx.carnetdesesiones.utils.MySQL;

import jakarta.servlet.*;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.*;

@WebFilter(urlPatterns = {"/*"})

public class RequestFilter implements Filter {


    List<String> whiteList = new ArrayList<>();
    ArrayList<String> adminURL = new ArrayList<>();
    ArrayList<String> consultorURL = new ArrayList<>();
    ArrayList<String> tutorURL = new ArrayList<>();
    ArrayList<String> studentURL = new ArrayList<>();
    ArrayList<String> jspURL = new ArrayList<>();



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //Endpoints publicos
        whiteList.add("/user/login");
        whiteList.add("/user/logout");

        ServletContext servletContext = filterConfig.getServletContext();
        adminURL.addAll( servletContext.getServletRegistrations().get("Admin").getMappings());
        consultorURL.addAll( servletContext.getServletRegistrations().get("Consultor").getMappings());
        tutorURL.addAll( servletContext.getServletRegistrations().get("Tutor").getMappings());
        studentURL.addAll( servletContext.getServletRegistrations().get("Student").getMappings());
        jspURL.addAll( servletContext.getServletRegistrations().get("jsp").getMappings());


        adminURL.addAll(jspURL);
        consultorURL.addAll(jspURL);
        tutorURL.addAll(jspURL);
        studentURL.addAll(jspURL);


    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String action = request.getServletPath();
        System.out.println(action);
        if (whiteList.contains(action)|| urlAcess(action)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = request.getSession();
            if (session.getAttribute("user") != null) {



                System.out.println(session.getAttribute("user").getClass().getSimpleName());
                switch (session.getAttribute("user").getClass().getSimpleName())
                {
                    case "Admin":
                        if (adminURL.contains(action)  || urlAcess(action)){
                            filterChain.doFilter(servletRequest, servletResponse);
                        }else response.sendRedirect(request.getContextPath() + "/user/logout");
                        break;
                    case "Tutor":
                        if (tutorURL.contains(action)|| urlAcess(action)){
                            filterChain.doFilter(servletRequest, servletResponse);
                        }else response.sendRedirect(request.getContextPath() + "/user/logout");
                        break;
                    case "Student":
                        if (studentURL.contains(action)|| urlAcess(action)){
                            filterChain.doFilter(servletRequest, servletResponse);
                        }else response.sendRedirect(request.getContextPath() + "/user/logout");
                        break;
                    case "Consultor":
                        if (consultorURL.contains(action)|| urlAcess(action)){
                            filterChain.doFilter(servletRequest, servletResponse);
                        }else response.sendRedirect(request.getContextPath() + "/user/logout");
                        break;
                }








            } else {
                response.sendRedirect(request.getContextPath() + "/user/login");
            }
        }
    }
public boolean urlAcess (String s){
        if (s.substring(s.length() - 4).equals(".css")
                || s.substring(s.length() - 3).equals(".js")
                || s.substring(s.length() - 4).equals(".png")
                || s.substring(s.length() - 4).equals(".ttf")
                || s.substring(s.length() - 4).equals(".ico")) return true;
    return false;
}
    @Override
    public void destroy() {

    }
}
