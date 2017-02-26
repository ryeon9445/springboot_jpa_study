package springboot_jpa_study_lastest_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springboot_jpa_study_lastest_project.repository.MemberRepository;
import springboot_jpa_study_lastest_project.vo.MemberVO;

@SpringBootApplication
public class DemoApplication
{
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
