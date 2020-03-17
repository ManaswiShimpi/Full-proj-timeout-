package com.lti.demo.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lti.demo.model.Patient;
import com.lti.demo.service.PatientService;

@RestController
@RequestMapping("admission")
public class AdmissionController {
	@Autowired
	private PatientService patientService;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private MyCallable myCallable;

	@Value("${server.servlet.session.timeout}")
	private String timeLimit;

	@RequestMapping("/physician")
	public List<Object> getEmployees() {
		

		Object[] employeesList = restTemplate.getForObject("http://Hr/hr/getAll", Object[].class);

		return Arrays.asList(employeesList);
	}

	@RequestMapping("/create")
	public String create(@RequestParam(value = "PId", required = true) String PId, @RequestParam("name") String name,
			@RequestParam("nationality") String nationality) {
		Patient p = patientService.create(PId, name, nationality);
		return p.toString();
	}

	@RequestMapping("/get")
	public Patient getPatient(@RequestParam("PId") String PId) {

		System.out.println("get API for Patient");
		return patientService.getByPId(PId);

	}

	/// Interceptr
	// Excutor timeout

	@RequestMapping("/getAll")
	public List<Patient> getAll()  throws InterruptedException, ExecutionException, TimeoutException  {
		
		/*
		 * ExecutorService executor=Executors.newFixedThreadPool(20);
		 * List<Future<String>> list=new ArrayList<Future<String>>();
		 * System.out.println("start time:"+(System.currentTimeMillis()/100)); for(int
		 * loopldx=0;loopldx<20;loopldx++) { Future<String>
		 * future=executor.submit(myCallable); list.add(future); } for (Future<String>
		 * fut:list) { fut.get(); } executor.shutdown();
		 * System.out.println("end time:"+(System.currentTimeMillis()/100));
		 */
		/*
		 * ExecutorService ex = Executors.newSingleThreadExecutor(); Future<?> f =
		 * ex.submit(new Runnable() { public void run() { try { Thread.sleep(19000); }
		 * catch (InterruptedException e) { e.printStackTrace(); }
		 * System.out.println("finished"); } }); f.get(20, TimeUnit.SECONDS);
		 */
		 return patientService.getAll();

	}

	@RequestMapping("/update")
	public String update(@RequestParam String PId, @RequestParam String name, @RequestParam String nationality) {
		Patient p = patientService.update(PId, name, nationality);
		return p.toString();
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam String PId) {
		patientService.delete(PId);
		return "Deleted" + PId;
	}

	@RequestMapping("/deleteAll")
	public String deleteAll() {
		patientService.deleteAll();
		return "Deleted all records";
	}
}