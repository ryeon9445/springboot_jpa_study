package springboot_jpa_study_lastest_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import springboot_jpa_study_lastest_project.vo.NewMemberVO;

import java.util.Date;
import java.util.List;

/**
 * Created by CBR on 2017. 2. 25..
 */
public interface NewMemberRepository extends JpaRepository<NewMemberVO, Long>
{
//    MemberVO findByUserId(@Param("userId") String userId);
//    List<MemberVO> findAllByOrderByIdAsc();

    //NewMemberVO findByUserId(@Param("userId") String userId);

    List<NewMemberVO> findByUserIdContaining(@Param("userId") String userId);
    List<NewMemberVO> findByUserNameContaining(@Param("userName") String userName);
    List<NewMemberVO> findByUserPhoneContaining(@Param("userPhone") String userPhone);
    List<NewMemberVO> findByUserAddrContaining(@Param("userAddr") String userAddr);

    List<NewMemberVO> findByCreatedDateAfterAndCreatedDateBefore(Date createdDate1, Date createdDate2);



}
