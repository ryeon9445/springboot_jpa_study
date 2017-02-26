package springboot_jpa_study_lastest_project.controller;

import com.sun.xml.internal.ws.api.model.MEP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springboot_jpa_study_lastest_project.repository.NewMemberRepository;
import springboot_jpa_study_lastest_project.vo.NewMemberVO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CBR on 2017. 2. 25..
 */
@Controller
public class NewMemberController
{
    @Autowired
    NewMemberRepository newMemberRepository;

    @RequestMapping(value="/newMemberList")
    @ResponseBody
    public Map newMemberList()
    {
        Map rMap = new HashMap();
        rMap.put("mList", newMemberRepository.findAll());

        System.out.println("newMemberList" + rMap.toString());
        return rMap;
    }

    @RequestMapping(value="/newMemberListByLike", method = RequestMethod.POST)
    @ResponseBody
    public Map newMemberListByLike(@RequestBody List<Map<String, Object>> list)
    {
        System.out.println("newMemberListByUserId POST : " + list);
        Map rMap = new HashMap();
        //rMap.put("mList", newMemberRepository.findByUserIdContaining("fffff"));

//        List<NewMemberVO> findByUserIdContaining(@Param("userId") String userId);
//        List<NewMemberVO> findByUserNameContaining(@Param("userName") String userName);
//        List<NewMemberVO> findByUserPhoneContaining(@Param("userPhone") String userPhone);
//        List<NewMemberVO> findByUserAddrContaining(@Param("userAddr") String userAddr);

        List<NewMemberVO> resultData = null;

        for (Map map : list)
        {
            if (map.containsKey("userId"))
            {
                resultData = newMemberRepository.findByUserIdContaining((String)map.get("userId"));
            }
            if (map.containsKey("userName"))
            {
                resultData = newMemberRepository.findByUserNameContaining((String)map.get("userName"));
            }
            if (map.containsKey("userPhone"))
            {
                resultData = newMemberRepository.findByUserPhoneContaining((String)map.get("userPhone"));
            }
            if (map.containsKey("userAddr"))
            {
                resultData = newMemberRepository.findByUserAddrContaining((String)map.get("userAddr"));
            }
            if (map.containsKey("dateStartDate") && map.containsKey("dateEndDate"))
            {

                SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    Date startDate = transFormat.parse((String)map.get("dateStartDate"));
                    Date endDate = transFormat.parse((String)map.get("dateEndDate"));

                    System.out.println("::: " + startDate + " / " + endDate);
                    resultData = newMemberRepository.findByCreatedDateAfterAndCreatedDateBefore(startDate, endDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

        }
        
        rMap.put("mList", resultData);

        System.out.println("newMemberListByUserId : " + rMap.toString());
        return rMap;
    }

    @RequestMapping(value ="/newMemberJoin", method = RequestMethod.POST)
    public String newMemerJoin(@ModelAttribute("newMemberVO")NewMemberVO newMemberVO)
    {
        System.out.println("newMemberJoin : \n" + newMemberVO.toString());
        newMemberRepository.save(newMemberVO);

        return "redirect:/newMemberListTpl.html";
    }

    @RequestMapping(value="/newMemberUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Map memberUpdate(@ModelAttribute("newMemberVO") NewMemberVO newMemberVO)
    {
        System.out.println("memberUdpate : " + newMemberVO);
        newMemberRepository.save(newMemberVO);
        Map returnMap = new HashMap();
        returnMap.put("code", true);
        return returnMap;
    }

    @RequestMapping(value = "/newMemberDelete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map newMemberDelete(@PathVariable Long id)
    {
        System.out.println("memberDelete :  " + id);
        newMemberRepository.delete(id);
        Map returnMap = new HashMap();
        returnMap.put("code", true);
        return returnMap;
    }

    @RequestMapping(value = "/newMemberDelete", method = RequestMethod.POST)
    @ResponseBody
    public Map newMemberDelete(@RequestBody List<Map<String, Object>> list)
    {
        System.out.println("memberDelete POST : " + list);
        Map returnMap = new HashMap();
        for (Map map : list)
        {
            newMemberRepository.delete(Long.valueOf((String) map.get("id")));
        }
        returnMap.put("code", true);
        return returnMap;
    }
}
