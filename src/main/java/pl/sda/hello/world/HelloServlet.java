package pl.sda.hello.world;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "HelloServlet",
        urlPatterns = {"/hello", "/Hello", "/qwer"},
        initParams = {
                @WebInitParam(name = "userId", value = "123456"),
                @WebInitParam(name = "localization", value = "Poland")
        },
        loadOnStartup = 1
)
public class HelloServlet extends HttpServlet {

    private String userId, localization;

    @Override
    public void init(ServletConfig config) {
        userId = config.getInitParameter("userId");
        localization = config.getInitParameter("localization");

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter writer = response.getWriter();
        writer.println("Hello world!");
        writer.println("<strong>UserId</strong>: " + userId);
        writer.println("Localization: " + localization);
        // response.sendRedirect("index.jsp");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        // requestDispatcher.forward(request, response);
        requestDispatcher.include(request, response);
    }
}
