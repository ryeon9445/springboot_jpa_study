package springboot_jpa_study_lastest_project.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by CBR on 2017. 2. 19..
 */
@Entity
@Data
public class GenderVO
{
    @Id
    @GeneratedValue
    int id;

    @Column
    String gender;
}
