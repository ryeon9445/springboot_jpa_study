package springboot_jpa_study_lastest_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springboot_jpa_study_lastest_project.repository.MemberRepository;
import springboot_jpa_study_lastest_project.vo.MemberVO;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CBR on 2017. 2. 5..
 */
@Controller
public class MemberController
{
//    @Autowired
//    MemberRepository memberRepository;
//
//    @RequestMapping("/")
//    public String menu()
//    {
//        return "menu";
//    }
//
//    @RequestMapping("/board")
//    public String intex()
//    {
//        return "index";
//    }
//
//    @RequestMapping("/add")
//    public String add()
//    {
//        System.out.println("add");
//        return "add";
//    }
//
//    @RequestMapping(value = "/addProc", method = RequestMethod.POST)
//    public String addProc(@ModelAttribute("memberVO") MemberVO memberVO)
//    {
//        memberRepository.save(memberVO);
//        System.out.println("addProc");
//        return "redirect:/";
//    }

    ////

    @Autowired
    MemberRepository memberRepository;

    @RequestMapping("/")
    public String index()
    {
        return "index";
    }

    @RequestMapping(value ="/memberJoin", method = RequestMethod.POST)
    public String memberJoin(@ModelAttribute("memberVO") MemberVO memberVO)
    {
        memberRepository.save(memberVO);

//        Map returnMap = new HashMap();
//        returnMap.put("code", true);
//        return returnMap;
        return "redirect:/memberListTpl.html";
    }

    @RequestMapping(value ="/memberList")
    @ResponseBody
    public Map memberList()
    {
        System.out.println("memberList");
        Map rMap = new HashMap();
        //rMap.put("mList", memberRepository.findAll());
        rMap.put("mList", memberRepository.findAllByOrderByIdAsc());
        return rMap;
    }

    @RequestMapping(value = "/memberOne/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map memberOne(@PathVariable Long id)
    {
        System.out.println("memberOne : " + id);
        Map rMap = new HashMap();
        rMap.put("mOne", memberRepository.findOne(id));
        return rMap;
    }

    @RequestMapping(value = "/memberUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Map memberUpdate(@ModelAttribute("memberVO") MemberVO memberVO)
    {
        System.out.println("memberUpdate : " + memberVO);
        memberRepository.save(memberVO);
        Map returnMap = new HashMap();
        returnMap.put("code" , true);
        return returnMap;
//      return "redirect:/memberList";
//        return returnMap;
    }

    @RequestMapping(value = "/memberDelete/{id}",  method = RequestMethod.GET)
    @ResponseBody
    public Map memberDelete(@PathVariable Long id)
    {
        System.out.println("memberDelete : " + id);
        memberRepository.delete(id);
        Map returnMap = new HashMap();
        returnMap.put("code", true);
        return returnMap;

    }






}

