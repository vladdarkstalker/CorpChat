package com.corpchat.CorpChat;

import dbmodels.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class CorpChatApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/hello")
	public String check() {
		return "Hello World";
	}

	public static void main(String[] args) {
		SpringApplication.run(CorpChatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "SELECT * FROM users";
		List<User> listUsers = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(User.class));
		for (User user : listUsers) {
			System.out.println(user);
		}
	}

}
