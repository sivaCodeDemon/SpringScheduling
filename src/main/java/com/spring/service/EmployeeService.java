package com.spring.service;


import com.spring.dao.EmoployeeRepo;
import com.spring.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmoployeeRepo emoployeeRepo;

    /*
    fixedrate basically specied by milliseconds it invoking the task accordingly
    fixed delay is a delay of previous task and next task it also reresents in a millisecods
     */
    @Scheduled(fixedRate = 1000)
    public void addEmpToHDB(){
        log.info("START:   addEmpToHDB()    :UserService.java ");
        Employee emp = new Employee();
        emp.setEmp_Id(1);
        emp.setEmp_Name("Siva Kantamreddi");
        emoployeeRepo.save(emp);
        log.info("END:   addEmpToHDB()    :UserService.java ");
        System.out.println("User "+new Date().toGMTString());
    }

    /*
	cron defined like a second,minute,hour,day of month,month ,day of week (******)
	and it excuted as per this expression
	 */
    @Scheduled(cron = "0/30 * * * * *")
    public void fetchAllEmpFromDb() {
        log.info("START:   fetchAllEmpFromDb()    :UserService.java ");
        List<Employee> u= emoployeeRepo.findAll();
        System.out.println("Fetching from the db"+ new Date().toGMTString());
        System.out.println(u.size());
        log.info("END:   fetchAllEmpFromDb()    :UserService.java ");
        log.info("Users :{}",u);
    }
}
