package com.metacube.metaparkingsystemv2.daoimpl;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.metaparkingsystemv2.dao.VehicleDao;
import com.metacube.metaparkingsystemv2.models.Employee;
import com.metacube.metaparkingsystemv2.models.Vehicle;

@Repository
public class VehicleDaoImpl implements VehicleDao {

	/*
	 * The EntityManager API is used to access a database in a particular unit of work
	 */
	@Autowired
	private EntityManager entityManager;
	
	/*
	 * This is used to get vechile details by vechile id.
	 */
	@Override
	public Vehicle getVehicle(int vehicleId) {
		Session session = entityManager.unwrap(Session.class);
		Vehicle vehicle = session.get(Vehicle.class, vehicleId);
		return vehicle;
	}
	
	/*
	 * This is used to add vechile details.
	 */

	@Override
	public int addVehicle(Vehicle vehicle) {
		Session session = entityManager.unwrap(Session.class);
		System.out.println(vehicle);
		session.saveOrUpdate(vehicle);
		System.out.println("Vehicle Id : " + vehicle.getVehicleId());
		return vehicle.getVehicleId();
	}

	/*
	 * This is used to get the vechile by employee id.
	 */
	@Override
	public Vehicle getVehicleByEmpId(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		System.out.println(employee);
		Query<Vehicle> query = session.createQuery("from Vehicle where employee = :employee", Vehicle.class);
		query.setParameter("employee", employee);
		Vehicle vehicle = null;
		try {
			vehicle = query.uniqueResult();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return vehicle;
	}
}
