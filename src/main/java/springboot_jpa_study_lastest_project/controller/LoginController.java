package springboot_jpa_study_lastest_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springboot_jpa_study_lastest_project.repository.MemberRepository;
import springboot_jpa_study_lastest_project.vo.MemberVO;

import java.util.Map;

/**
 * Created by CBR on 2017. 2. 5..
 */
@Controller
public class LoginController
{
    private static final String LOGIN_URL = "redirect:/login";
    private static final String BASE_URL = "redirect:/board";

    @Autowired
    MemberRepository memberRepository;

    @RequestMapping("/login")
    public String login()
    {
        System.out.println("login()");
        return "login";
    }

    private boolean isLogin(MemberVO memberVo, MemberVO membreV01)
    {
        //return memberVo.getUserId().equals(membreV01.getUserId()) && memberVo.getUserpassword().equals(membreV01.getUserpassword())
        return (memberVo.getUserId().equals(membreV01.getUserId()) && memberVo.getUserpassword().equals(membreV01.getUserpassword()))
                ? true : false;
    }

    @RequestMapping(value = "/loginProc", method = RequestMethod.POST)
    public String loginProc(@ModelAttribute("memberVO") MemberVO memberVO)
    {
        MemberVO vo = memberRepository.findByUserId(memberVO.getUserId());

        System.out.println("loginProc : " + memberVO.getUserId() + " , " + memberVO.getUserpassword());

        if (vo == null) {
            System.out.println("fail because vo == null ");
            return LOGIN_URL;
        } else {
            if (isLogin(vo, memberVO))
            {
                System.out.println("success");
                return BASE_URL;
            } else
            {
                System.out.println("fail id password");
                return LOGIN_URL;
            }
        }
    }
}
