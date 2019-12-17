package com.springbootjdbc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcController {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@GetMapping("/executeQuery")
	public String executeSqlQuery() {
		int result = 0;
		if(jdbcTemplate != null) {
			String sql = "insert into sampletable values('30','Harsha')";
			result = jdbcTemplate.update(sql);
			if(result == 1) {
				return "Record Inserted Successfully.";
			}else {
				return "Error Occured while inserting record.";
			}
			
		}else {
			return "JdbcTemplate Obj is NULL";
		}
		
		
	}
}
