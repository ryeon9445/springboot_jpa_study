package springboot_jpa_study_lastest_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import springboot_jpa_study_lastest_project.vo.MemberVO;

import java.util.List;

/**
 * Created by CBR on 2017. 2. 5..
 */
public interface MemberRepository extends JpaRepository<MemberVO, Long>
{
    MemberVO findByUserId(@Param("userId") String userId);

    List<MemberVO> findAllByOrderByIdAsc();

    //@Query(value = "select MemberVO.user_id, MemberVO.username, MemberVO.userpassword, MemberVO.userphone, g.gender from MemberVO inner join GenderVO g on MemberVO.gender = g.id")

}
