package hello.servlet.web.servletmvc;

//컨트롤러

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormSevlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-forms.jsp"; //WEB-INF안에 있는 자원들은 그냥호출로는 안불러짐. 항상 서블릿을 거쳐서 내부에서 호출해야 호출됨
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); // 컨트롤러에서 뷰로 이동할때 사용하는것
        dispatcher.forward(request,response); //forward 호출하면 서블릿에서 jsp 호출
        //dspatcher.forward() --> 리다이렉트가 아님!!
        // --> 다른서블릿이나 jsp로 이동할수 있는 긴으. 서버 내부에서 호출이 발생(클라이언트에서 서버에호출하는게아니라 서버 안에서 함수호출하듯이 내부적으로 호출이 이렁남)
        // redirect와 forward 차이 : 실제 클라이어트에 응답이 나갔다가 클라이언트가 리다이렉트 경로로 다시 서버에 요청(클라이언트가 인지 가능)
        // foward 는 서버 내부에서 호출이 일어나는 것이기 때문에 클라이언트가 인지할 수 없음


    }
}
