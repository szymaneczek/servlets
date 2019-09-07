package pl.sda.hello.world.filters;


import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter implements Filter {
    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain
    ) throws IOException, ServletException {
        PrintWriter writer = servletResponse.getWriter();
        writer.write("<html><body><div id=\"servletResponse\" style='text-align: center;' ");
        String login = servletRequest.getParameter("login");
        if (login.equals("admin")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            writer.print(
                    "<p id='errMsg' style='color: red, font-size: larger;'>User id is invalid!</p> ");
        }
        writer.write("</div></body></html>");
        writer.close();
    }
}
