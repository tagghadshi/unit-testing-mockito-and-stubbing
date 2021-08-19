
package com.in28minutes.unittesting.unittesting.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.in28minutes.unittesting.unittesting.data.AppointmentsRepository;
import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Appointments;

public class AppointmentBusinessService {

	@Autowired
	private AppointmentsRepository repository;

	public Appointments createAppointment(Appointments appointment) {
		return repository.save(appointment);
	}

	public Optional<Appointments> retrieveAppointment(long appointmentId) {
		return repository.findById((int) appointmentId);
	}

	public Appointments updateAppointment(Appointments appointment) {
		return repository.saveAndFlush(appointment);
	}

	public void deleteAppointment(Appointments a) throws Exception {
		repository.delete(a);
//		throw new Exception(); // To fail the Test
	}

	public List<Appointments> retrieveAllAppointments() {
		return repository.findAll();
	}

}
