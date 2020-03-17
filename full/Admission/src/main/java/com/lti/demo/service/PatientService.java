package com.lti.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.demo.model.Patient;
import com.lti.demo.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;

//create
	public Patient create(String pId, String name, String nationality) {
		return patientRepository.save(new Patient(pId, name, nationality));

	}

//retrive
	public List<Patient> getAll() {
		return patientRepository.findAll();
	}

	public Patient getByPId(String PId) {
		return patientRepository.getByPId(PId);
	}

//update
	public Patient update(String PId, String name, String nationality) {
		Patient p = patientRepository.getByPId(PId);
		p.setname(name);
		p.setnationality(nationality);
		return patientRepository.save(p);
	}

//Delete
	public void deleteAll() {
		patientRepository.deleteAll();
	}

	public void delete(String PId) {
		Patient p = patientRepository.getByPId(PId);
		patientRepository.delete(p);
	}
}
