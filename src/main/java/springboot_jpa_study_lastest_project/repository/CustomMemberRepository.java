package springboot_jpa_study_lastest_project.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by CBR on 2017. 2. 18..
 */
@Repository
public class CustomMemberRepository
{
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<Object[]> findAll()
    {
//        select MemberVO.user_id, MemberVO.username, MemberVO.userpassword, MemberVO.userphone, g.gender from MemberVO inner join GenderVO g on MemberVO.gender = g.id

        List resultList =  em.createQuery("from MemberVO").getResultList();

        Iterator iterator = resultList.iterator();

        while (iterator.hasNext())
        {
            Object[] row = (Object[]) iterator.next();
            String id = (String) row[0];
            String userId = (String) row[1];
            String username = (String) row[2];
            String userpassword = (String) row[3];
            String userphone = (String) row[4];
            int gender = (int) row[5];

            System.out.println(String.format("%s , %s, %s, %s, %s, %d" , id, userId, username, userpassword, userphone, gender));
        }


        return resultList;
    }

}
