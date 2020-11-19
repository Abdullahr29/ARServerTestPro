import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(urlPatterns ={"/patients"}, loadOnStartup = 1)
public class Servlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("html");
        resp.getWriter().write("<HTML>\n" +
                "\n" +
                "<HEAD>\n" +
                "\n" +
                "<TITLE>Your Title Here</TITLE>\n" +
                "\n" +
                "</HEAD>\n" +
                "\n" +
                "<BODY BGCOLOR=\"FFFFFF\">\n" +
                "\n" +
                "<CENTER><IMG SRC=\"clouds.jpg\" ALIGN=\"BOTTOM\"> </CENTER>\n" +
                "\n" +
                "<HR>\n" +
                "\n" +
                "<a href=\"https://www.linkedin.com/in/abdullah-rehman-05622b198/\">Link Name</a>\n" +
                "\n" +
                "is a link to another nifty site\n" +
                "\n" +
                "<H1>My name is Abdullah</H1>\n" +
                "\n" +
                "<H2>I am a bioengineer</H2>\n" +
                "\n" +
                "Send me mail at <a href=\"mailto:ayr18@ic.ac.uk\">\n" +
                "\n" +
                "ayr18@ic.ac.uk</a>.\n" +
                "\n" +
                "<P>Feel free to hit me up!\n" +
                "\n" +
                "<P> <B>Lets have some fun!</B>\n" +
                "\n" +
                "<BR> <B><I>This is my first hosted website</I></B>\n" +
                "\n" +
                "<HR>\n" +
                "\n" +
                "</BODY>\n" +
                "\n" +
                "</HTML>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Gson gson = new Gson();
        Patient p = gson.fromJson(reqBody, Patient.class);
        resp.setContentType("application/json");
        resp.getWriter().write("Thank you client! "+reqBody);
        System.out.println(p.toPrint());

    }

}
