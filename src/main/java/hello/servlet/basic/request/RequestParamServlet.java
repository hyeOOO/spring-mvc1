package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 1. 파라미터 전송 기능(쿼리 파라미터&post HTML Form)
 * 요청 URL 1 : http://localhost:8080/request-param?username=hello&age=20
 * 요청 URL 2 : http://localhost:8080/request-param
 *             content-type : application/x-www-form-urlencoded
 *             message body : username=hello&age=20
 * 즉, 쿼리 파라미터, POST HTML Form을 전송하면 똑같이 getParameter로 파라미터를 꺼내서 쓸 수 있다.
 * GET URL 쿼리 파라미터 형식은 HTTP 메시지 바디를 사용하지 않기 때문에 content-type이 없다.
 * 반대로 POST HTML Form 방식은 HTTP 메세지 바디에 데이터를 포함해서 보내기때문에 바디에 포함된 데이터가 어떤 형식인지 Content-type을 필수로 지정해야한다.
 */
@WebServlet(name = "requestParamServelt", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        System.out.println("request.getParameter(username) = " + username);
        String age = request.getParameter("age");
        System.out.println("request.getParameter(age) = " + age);
        System.out.println();

        // 동일 파라미터 조회 시 위 전체 파라미터, 단일 파라미터에는 첫 번째로 전달된 값만 보임
        System.out.println("[이름이 같은 복수 파라미터 조회]");
        System.out.println("request.getParameterValues(username)");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username=" + name);
        }

        response.getWriter().write("ok");
    }
}
