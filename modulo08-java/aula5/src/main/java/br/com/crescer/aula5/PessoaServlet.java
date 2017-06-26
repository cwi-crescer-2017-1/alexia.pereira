package br.com.crescer.aula5;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author alexia.pereira
 */
public class PessoaServlet extends HttpServlet {

    List<String> nomes = new ArrayList<>();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        try (final PrintWriter out = resp.getWriter();) {
//            out.append("Aléxia");
        resp.setContentType("text/html");
        try (final PrintWriter out = resp.getWriter();) {
            out.append("<!DOCTYPE html>");
            out.append("<html>");
            out.append("<head>");
            out.append("<title>Java - aula5</title>");
            out.append("<meta charset=\"UTF-8\">");
            out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.append("</head>");
            out.append("<body>");
            out.append("<form action=\"pessoa\" method=\"POST\">");
            out.append("<input name=\"nome\" type=\"text\">");
            out.append("<input type=\"submit\"/>");
            out.append("</form>");
            out.append("</body>");
            out.append("</html>");
            
            nomes.forEach(n -> out.append(n + "</br>"));
            
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        nomes.add(req.getParameter("nome"));
        resp.sendRedirect("/aula5/pessoa");
        
    }
    
    
}
