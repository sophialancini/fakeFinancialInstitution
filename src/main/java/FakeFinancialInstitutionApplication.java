import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.lancini.fakeFinancialInstitution.*")
@EntityScan(basePackages = {"com.lancini.fakeFinancialInstitution.*"})
@EnableJpaRepositories(basePackages = "com.lancini.fakeFinancialInstitution.repositories")
public class FakeFinancialInstitutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakeFinancialInstitutionApplication.class, args);
	}

}
