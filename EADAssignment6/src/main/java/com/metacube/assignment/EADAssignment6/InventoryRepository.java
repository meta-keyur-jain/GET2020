package com.metacube.assignment.EADAssignment6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InventoryRepository {

	Connection conn = null;

	/*
	 * This function is for mysql connection
	 */
	public InventoryRepository() {
		String url = "jdbc:mysql://localhost:3306/inventorydb";
		String username = "root";
		String password = "keyur";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This function is for getting the list of inventory
	 */
	public List<Inventory> getInventorys() {
		List<Inventory> inventorys = new ArrayList<>();
		String sql = "select * from inventory";

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Inventory a = new Inventory();

				a.setName(rs.getString(1));
				a.setQuantity(rs.getInt(2));

				inventorys.add(a);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return inventorys;
	}

	/*
	 * This function is for creating new inventory.
	 * 
	 * @param it denotes inventory object.
	 */
	public void create(Inventory a1) {

		String sql = "insert into inventory values(?,?)";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, a1.getName());
			st.setInt(2, a1.getQuantity());
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * This function is for delete whole inventory
	 */
	public void deleteinventory() {

		String sql = "TRUNCATE table inventory";
		try {
			PreparedStatement st = conn.prepareStatement(sql);

			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * This function is for deleting the value in inventory by name.
	 * 
	 * @params it will String value which contain name.
	 * 
	 */
	public void deleteName(String name) {
		List<Inventory> inv = getInventorys();
		boolean flag = false;
		for (Inventory obj : inv) {
			if (obj.name.equalsIgnoreCase(name)) {
				flag = true;
				break;
			}

		}
		if (flag) {
			String sql = "delete from inventory where name=?";
			try {
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, name);
				st.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	/*
	 * This function is used to update inventory .
	 * 
	 * @param it denotes the object of inventory to update.
	 */
	public void inventoryUpdate(Inventory a) throws SQLException {

		String sql = "update inventory set quantity=? where name=?";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, a.getQuantity());
			st.setString(2, a.getName());
			st.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This function is used to update whole inventory.
	 * 
	 * @param it will take list of whole inventory.
	 */
	public void inventoryUpdateWithoutname(List<Inventory> listInv) {
		deleteinventory();

		for (Inventory a : listInv) {
			create(a);
		}

	}

}
