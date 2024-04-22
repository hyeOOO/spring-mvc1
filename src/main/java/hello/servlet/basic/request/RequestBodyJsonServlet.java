package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * POST http://localhost:8080/request-body-json
 * content-type: application/json
 * message body: {"username": "hello", "age": 20}
 * 결과: messageBody = {"username": "hello", "age": 20}
 */
@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    // json 결과를 파싱 후 자바 객체 변환시켜주는 스프링 부트 Spring MVC의 기본 JSON 변환 라이브러리 -> Jackson의 ObjecctMapper
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // json 또한 결국 "문자"이므로 Inputstream 필요
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);

        // objectMapper를 통해 HelloData 클래스 형식의 Json으로 파싱
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);

        System.out.println("helloData.Username = " + helloData.getUsername());
        System.out.println("helloData.Age = " + helloData.getAge());

        response.getWriter().write("ok");

    }
}
