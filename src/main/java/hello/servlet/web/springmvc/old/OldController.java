package hello.servlet.web.springmvc.old;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//스프링빈의 이름을 url로 지정하면 url호출 시 매핑됨
//물론, 애노테이션 기반의 컨트롤러인 @RequestMapping과 매핑된다면 그것이 더 우선순위가 높음
@Component("/springmvc/old-controller")
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        // 먼저, new-form이라는 이름의 스프링빈으로 등록된 뷰를 찾는데 없어서 InternalResourceViewResolver가 호출됨.
        // InternalResourceViewResolver은 InternalResourceView를 반환하는데 이는 JSP처럼 forward()를 호출해서 처리할 수 있는 경우 사용
        // 그 뒤 view.render() 호출되어서 forward()를 사용해 jsp 실행
        return new ModelAndView("new-form");
    }
}
