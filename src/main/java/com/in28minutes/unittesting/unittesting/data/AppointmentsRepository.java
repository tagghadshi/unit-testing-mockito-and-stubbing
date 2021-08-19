package com.in28minutes.unittesting.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.unittesting.unittesting.model.Appointments;

public interface AppointmentsRepository extends JpaRepository<Appointments, Integer>{

}
