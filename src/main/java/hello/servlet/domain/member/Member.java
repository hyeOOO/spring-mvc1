package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
    private Long id;
    private String username;
    private int age;

    public Member() {
    }

    // id는 회원가입시 발급이 되는 로직이므로 생성자는 username과 age만 생성
    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
