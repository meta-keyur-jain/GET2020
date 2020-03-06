package com.metacube.metaparkingsystemv2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.metaparkingsystemv2.dao.VehicleDao;
import com.metacube.metaparkingsystemv2.models.Employee;
import com.metacube.metaparkingsystemv2.models.Vehicle;

@Service
public class VehicleService {

	@Autowired
	private VehicleDao vehicleDao;

	/*
	 * This is used to add the vehicle details to database.
	 */
	@Transactional
	public int addVehicle(Vehicle vehicle) {
		return vehicleDao.save(vehicle).getVehicleId();
	}
	/*
	 * This is used to get the vehicle details from database.
	 */
	@Transactional
	public Vehicle getVehicleById(int vehicleId) {
		return vehicleDao.findById(vehicleId).orElse(new Vehicle());
	}

	/*
	 * This is used to update the vehicle details.
	 */
	@Transactional
	public int updateVehicle(Vehicle vehicle) {
		return vehicleDao.save(vehicle).getVehicleId();
	}

	/*
	 * This is used to get the employee by vehicle id.
	 */
	@Transactional
	public Vehicle getVehicleByEmpId(Employee employee) {
		return vehicleDao.findVehicleByEmployee(employee);
	}
}
