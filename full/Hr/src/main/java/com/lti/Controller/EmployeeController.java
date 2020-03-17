package com.lti.Controller;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Employee;
import com.lti.service.EmployeeService;

@RestController
@RequestMapping("/hr")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	HttpServletRequest request;

	ResponseEntity responseEntity;

	@RequestMapping("/create")
	public String create(@RequestParam("empid") String empid, @RequestParam("name") String name,
			@RequestParam("department") String department,
			@RequestParam(value = "salary", required = true) float salary) {
		Employee p = employeeService.create(empid, name, department, salary);
		return p.toString();
	}

	@RequestMapping("/get")
	public Employee getEmployee(@RequestParam("empid") String empid) {
		return employeeService.getByEmpid(empid);
	}

	@RequestMapping("/getAll")
	public ResponseEntity getAll() throws Exception {
	
		
		  ExecutorService executorService =
		  Executors.newSingleThreadScheduledExecutor();
		 /* 
		  Runnable callable = new Runnable() {
		  
		  @Override public void run(){ timeoutcheck("timelimit"); } }; Future future =
		  executorService.submit(callable); try { System.out.println(future.get(19,
		  TimeUnit.SECONDS)); } catch (InterruptedException e) { e.printStackTrace(); }
		  catch (ExecutionException e) { e.printStackTrace(); } catch(TimeoutException
		  e) { return new ResponseEntity<String>("timeout exception",
		  HttpStatus.GATEWAY_TIMEOUT); } return new
		  ResponseEntity<String>("successfully call", HttpStatus.OK); }
		  
		  
		  public String timeoutcheck(String timeOutMessage) { try {
		  Thread.sleep(20000); } catch (InterruptedException e) { e.printStackTrace();
		  } return timeOutMessage; }
		  
		 */
		
		
	
	  Runnable callable = new Runnable() {
	  
	  @Override public void run(){ timeoutcheck("timelimit"); } }; Future future =
	  executorService.submit(callable); try { System.out.println(future.get(20,
	  TimeUnit.SECONDS)); } catch (InterruptedException e) { e.printStackTrace(); }
	  catch (ExecutionException e) { e.printStackTrace(); } catch(TimeoutException
	  e) { return new ResponseEntity<String>("timeout exception",
	  HttpStatus.GATEWAY_TIMEOUT); } return new
	  ResponseEntity<String>("successfully call", HttpStatus.OK); }
	  
	  
	  public String timeoutcheck(String timeOutMessage) { try {
	  Thread.sleep(20000); } catch (InterruptedException e) { e.printStackTrace();
	  } return timeOutMessage; }
	 
		
		/*
		 * ExecutorService ex = Executors.newSingleThreadExecutor(); Future<?> f =
		 * ex.submit(new Runnable() { public void run() { long startTime =
		 * System.currentTimeMillis(); List<Employee> employeeList =
		 * employeeService.getAll(); long endTime = System.currentTimeMillis();
		 * if(endTime - startTime > 20 * 1000) { responseEntity = new
		 * ResponseEntity("timeout exception for beyond 20 seconds.",
		 * HttpStatus.GATEWAY_TIMEOUT); } else { responseEntity =
		 * ResponseEntity.ok().body(employeeList); } return; }}); return responseEntity;
		 */
		  
		 // f.get(20,TimeUnit.SECONDS);
		//return responseEntity;
		 
	
	/*
	 * long startTime = System.currentTimeMillis(); List<Employee> employeeList =
	 * employeeService.getAll(); long endTime = System.currentTimeMillis(); if
	 * (endTime - startTime > 20 * 1000) { responseEntity = new
	 * ResponseEntity("timeout exception for beyond 20 seconds.",
	 * HttpStatus.GATEWAY_TIMEOUT); } else { responseEntity =
	 * ResponseEntity.ok().body(employeeList); } return responseEntity;
	 * 
	 * }
	 */
	 

	@RequestMapping("/update")
	public String update(@RequestParam String empid, @RequestParam String name, @RequestParam String department,
			@RequestParam float salary) {
		Employee p = employeeService.update(empid, name, department, salary);
		return p.toString();
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam String empid) {
		employeeService.delete(empid);
		return "Deleted" + empid;
	}

	@RequestMapping("/deleteAll")
	public String deleteAll() {
		employeeService.deleteAll();
		return "Deleted all records";
	}

}
