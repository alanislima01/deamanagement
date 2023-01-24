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

@SpringBootApplication

public class DeamanagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DeamanagementApplication.class, args);
	}

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void run(String... args) throws Exception {
		//Deletando os usuqarios antigos
		this.userRepository.deleteAll();

		//Criando novos usuarios para o banco de dados
		for (int i = 0; i < 5; i++) {
			User u = new User();
			u.setEmail("email " + i);
			u.setName("name " + i);
			u.setLinkedin("linkedin " + i);
			u.setPassword("pwd " + i);

			this.userRepository.save(u);
		}

		//Pegando os usuarios
		List<User> users = this.userService.findAllUsers();
		users.forEach(u -> System.out.println("Name: " + u.getName()));

		//@Query
		Optional<User> loadedUserByName = this.userRepository.findByName("name 1");
		System.out.println("User name 1 (From @Query) name: " + loadedUserByName.get().getName());

		TypedQuery<User> q = entityManager.createNamedQuery("myQuery", User.class);
		q.setParameter("name", "name 2");
		User userFromNamedQuery = q.getResultList().get(0);
		System.out.println("User name 2 (From NamedQuery) name: " + userFromNamedQuery.getName());

		//Pegando os users por email
		User loadedUser = this.userService.findUserByEmail("email 1");
		System.out.println("User email 1 name: " + loadedUser.getName());

		//Atualizando ou adicionando o linkedin dos usuarios
		loadedUser.setLinkedin("new linkedin");
		this.userRepository.save(loadedUser);

	}