package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller -> 스프링빈으로 자동 등록, 컨트롤러로 인식(=RequestmappingHandlerMapping에서 handler 정보를 꺼낼 수 있는 handle임을 인식)
//@Component+@RequestMapping 이 같이 있어도 =RequestmappingHandlerMapping이 인식함
@Controller
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process(){ // 애노테이션 기반으로 동작하므로 메서드 이름은 아무거나 지어도 됨
        return new ModelAndView("new-form");
    }
}
