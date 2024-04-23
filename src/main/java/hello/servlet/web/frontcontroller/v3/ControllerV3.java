package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    // 서블릿 종속성 제거(request, response 객체를 파라미터로 안받음)
    ModelView process(Map<String, String> paramMap);
}
