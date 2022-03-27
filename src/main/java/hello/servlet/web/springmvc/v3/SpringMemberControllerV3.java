package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    // spring에서는 문자를 반환해도 알아서 스프링이 뷰네임으로 인식하고 작동해줌
    // (String을 어떻게인식하는지 다양한 방법은 추후에 설명예정)
    @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    // == @GetMapping("/new-form")
    public String newForm() {
        return "new-forms";
    }

    @RequestMapping(method = RequestMethod.GET) // /members는 이 컨트롤러 requestMapping에 매핑되있음
    public String Members( Model model) {
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    // == @PostMapping("/save")
    public String save(
            @RequestParam("username") String username //스프링에서는 파라미터를 직접 바로 꺼내올 수 있음
            , @RequestParam("age") int age // request.getParameter("age")와 거의 같다고 보면 됨
            , Model model ) {

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member); //모델에 member 담아주기

        return "save-result"; //viewName 반환
    }
}
