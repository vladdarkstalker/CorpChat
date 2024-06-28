package com.corpchat.CorpChat;

import dbmodels.*;
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

//		String sqlUser = "SELECT * FROM users";
//		List<User> listUsers = jdbcTemplate.query(sqlUser, BeanPropertyRowMapper.newInstance(User.class));
//		listUsers.forEach(System.out::println);
//
//		String sqlChannel = "SELECT * FROM channels";
//		List<User> listChannel = jdbcTemplate.query(sqlChannel, BeanPropertyRowMapper.newInstance(User.class));
//		listChannel.forEach(System.out::println);
//
//		String sqlChannelMembers = "SELECT * FROM channel_members";
//		List<User> listChannelMembers = jdbcTemplate.query(sqlChannelMembers, BeanPropertyRowMapper.newInstance(User.class));
//		listChannelMembers.forEach(System.out::println);
//
//		String sqlPosts = "SELECT * FROM posts";
//		List<User> listPosts = jdbcTemplate.query(sqlPosts, BeanPropertyRowMapper.newInstance(User.class));
//		listPosts.forEach(System.out::println);
//
//		String sqlPostLikes = "SELECT * FROM post_likes";
//		List<User> listPostLikes = jdbcTemplate.query(sqlPostLikes, BeanPropertyRowMapper.newInstance(User.class));
//		listPostLikes.forEach(System.out::println);
//
//		String sqlPrivateChats = "SELECT * FROM private_chats";
//		List<User> listPrivateChats = jdbcTemplate.query(sqlPrivateChats, BeanPropertyRowMapper.newInstance(User.class));
//		listPrivateChats.forEach(System.out::println);
//
//		String sqlMessages = "SELECT * FROM messages";
//		List<User> listMessages = jdbcTemplate.query(sqlMessages, BeanPropertyRowMapper.newInstance(User.class));
//		listMessages.forEach(System.out::println);
	}

}
