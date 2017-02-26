package springboot_jpa_study_lastest_project.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by CBR on 2017. 2. 5..
 */
@Entity
@Data
public class MemberVO
{
    @Id
    @GeneratedValue
    Long id;

    @Column
    String userId;

    @Column
    String username;

    @Column
    String userpassword;

    @Column
    String userphone;

    //
    @Column()
    int gender = 1;
}
