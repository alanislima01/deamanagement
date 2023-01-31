package br.com.dea.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.dea.management.user.domain.User;
import br.com.dea.management.user.repository.UserRepository;
import br.com.dea.management.user.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import java.util.List;
import java.util.Optional;
import br.com.dea.management.student.domain.Student;
import br.com.dea.management.student.repository.StudentRepository;
import java.time.LocalDate;

@SpringBootApplication

public class DeamanagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DeamanagementApplication.class, args);
	}

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StudentRepository studentRepository;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void run(String... args) throws Exception {
		//Deletando os usuqarios antigos
		this.userRepository.deleteAll();

		//Criando novos usuarios para o banco de dados
		for (int i = 0; i < 100; i++) {
			User u = new User();     //Creating some students
			u.setEmail("email " + i);
			u.setName("name " + i);
			u.setLinkedin("linkedin " + i);
			u.setPassword("pwd " + i);

			Student student = new Student();
			student.setUniversity("UNI " + i);
			student.setGraduation("Grad " + i);
			student.setFinishDate(LocalDate.now());
			student.setUser(u);
		}
		this.studentRepository.save(student);
	}

	}
}