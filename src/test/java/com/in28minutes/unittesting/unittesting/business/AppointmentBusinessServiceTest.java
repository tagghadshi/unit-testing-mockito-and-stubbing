package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.unittesting.data.AppointmentsRepository;
import com.in28minutes.unittesting.unittesting.model.Appointments;

@ExtendWith(MockitoExtension.class)
class AppointmentBusinessServiceTest {

	@Mock
	AppointmentsRepository repository;
	
	@InjectMocks
	AppointmentBusinessService business;
	
	@Test
	void testCreate() {
		Appointments a = new Appointments(10, "Rohit Sharma", (byte)19, "rohitsharma45@gmail.com", 9999999999l);
		when(repository.save(a)).thenReturn(a);
		Appointments saved = business.createAppointment(a);
		assertEquals(a.getUserName(), saved.getUserName());
	}

	@Test
	void testRetrieveAppointment() {
		Optional<Appointments> a = Optional.ofNullable(new Appointments(10, "Rohit Sharma", (byte)19, "rohitsharma45@gmail.com", 9999999999l));
		when(repository.findById(10)).thenReturn(a);
		Optional<Appointments> saved = business.retrieveAppointment(10);
		assertEquals(a, saved);
	}
	
	@Test
	void testUpdateAppointment() {
		Appointments a = new Appointments(10, "Rohit Sharma", (byte)19, "rohitsharma45@gmail.com", 9999999999l);
		when(repository.saveAndFlush(a)).thenReturn(a);
		Appointments saved = business.updateAppointment(a);
		assertEquals(a, saved);
	}
	
	@Test
	void testDeleteAppointment() {
		Appointments a = new Appointments(10, "Rohit Sharma", (byte)19, "rohitsharma45@gmail.com", 9999999999l);
		try {
			business.deleteAppointment(a);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error While Deleting.. Fail to Delete ");
		}
	}
	
	@Test
	void testRetrieveAllAppointments() {
		List<Appointments> a = Arrays.asList(new Appointments(10, "Rohit Sharma", (byte)19, "rohitsharma45@gmail.com", 9999999999l));
		when(repository.findAll()).thenReturn(a);
		List<Appointments> saved = business.retrieveAllAppointments();
		assertEquals(saved, a);
	}
	
}
