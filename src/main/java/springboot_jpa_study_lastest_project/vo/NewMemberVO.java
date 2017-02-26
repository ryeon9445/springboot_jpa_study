package springboot_jpa_study_lastest_project.vo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by CBR on 2017. 2. 25..
 */
@Entity
@Data
public class NewMemberVO
{
    @Id
    @GeneratedValue
    Long id;

    @Column
    String userId;

    @Column
    String userPassWd;

    @Column
    String userName;

    @Column
    String userPhone;

    @Column
    String userAddr;

    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate = new Date();
}
