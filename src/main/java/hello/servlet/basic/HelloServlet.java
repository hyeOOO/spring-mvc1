package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 스프링 부트 실행 시 메인의 @ServletComponentScan을 통해 helloServlet이라는 이름의 서블릿을 등록함
// 사용자가 /hello로 요청이 오면 서블릿을 통해 HTTp 요청 메시지를 파싱하고 서블릿 컨테이너는 이 서블릿 내 service 메서드 실행
// HttpServletRequest - 파싱에 대한 결과가 담겨져 있음
// 요청에 대해 서블릿 컨테이너가 일정 작업을 수행 후 종료와 동시에 응답 객체 반환
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    //service는 접근제한자가 protected인게 실행됨 public은 해당안됨
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        //각 request, response 객체의 주소값이 나옴
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        //요청과 함께 받은 파라미터를 꺼냄.
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //응답헤더 설정
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello "+username);
    }
}
