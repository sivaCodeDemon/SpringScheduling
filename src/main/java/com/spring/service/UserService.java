package com.spring.service;


import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.spring.dao.User1Repository;
import com.spring.dao.UserRepository;
import com.spring.model.Model;
import com.spring.model.Users;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private User1Repository repository;
	

	/*
	fixedrate basically specied by milliseconds it invoking the task accordingly
	fixed delay is a delay of previous task and next task it also reresents in a millisecods
	 */
	@Scheduled(fixedRate = 5000)
	public void addToH2Db() {
		log.info("START:   addToH2Db()    :UserService.java ");
		Users users = new Users();
		users.setName("User"+new Random().nextInt(1122));
		repository.save(users);
		log.info("END:   addToH2Db()    :UserService.java ");
		System.out.println("User "+new Date().toGMTString());
	}
	/*
	cron defined like a second,minute,hour,day of month,month ,day of week (******)
	and it excuted as per this expression
	 */
	@Scheduled(cron = "0/30 * * * * *")
	public void fetchAllFromDb() {
		log.info("START:   fetchAllFromDb()    :UserService.java ");
		List<Users> u= repository.findAll();
		System.out.println("Fetching from the db"+ new Date().toGMTString());
		System.out.println(u.size());
		log.info("END:   fetchAllFromDb()    :UserService.java ");
		log.info("Users :{}",u);
	}
}
