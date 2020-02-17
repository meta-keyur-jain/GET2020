package com.metacube.assignment.EADAssignment6;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("inventory")
public class InventoryResource {

	InventoryRepository repo = new InventoryRepository();

	/*
	 * This function is used to get the whole inventory.
	 */

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Inventory> getInventory() {

		return repo.getInventorys();
	}

	/*
	 * This function is used to add the new inventory.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String create(Inventory a1) {
		repo.create(a1);
		return "value added";
	}

	/*
	 * This function is used to delete whole inventory.
	 */
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String inventorydelete() {
		repo.deleteinventory();
		return "table deleted";
	}

	/*
	 * This function is used to delete inventory by name.
	 */
	@DELETE
	@Path("{name}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String inventoryNameDelete(@PathParam("name") String name) {

		repo.deleteName(name);
		return "name deleted";

	}

	/*
	 * This function is used to upadte the value by name.
	 */
	@PUT
	@Path("{name}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String inventoryupdate(Inventory a) {
		try {
			repo.inventoryUpdate(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "updated";
	}

	/*
	 * This function is used to update whole inventory.
	 */
	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String inventoryUpdateWithoutName(List<Inventory> listInv) {
		repo.inventoryUpdateWithoutname(listInv);
		return "table updated";
	}

}
