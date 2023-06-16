package com.supplier.demo.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.supplier.demo.model.Supplier;

public class SupplierRowMapper implements RowMapper<Supplier>{

	@Override
	public Supplier mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Supplier supplier = new Supplier();
		
		supplier.setSupplierId(rs.getInt("supplierId"));
		supplier.setAccount(rs.getString("account"));
		supplier.setName(rs.getString("name"));
		supplier.setPhone(rs.getString("phone"));
		supplier.setAddress(rs.getString("address"));
		supplier.setEmail(rs.getString("email"));
		supplier.setLast_create_staff(rs.getString("last_create_staff"));
		supplier.setLast_create_time(rs.getTimestamp("last_create_time"));
		supplier.setLast_modify_staff(rs.getString("last_modify_staff"));
		supplier.setLast_modify_time(rs.getTimestamp("last_modify_time"));

		return supplier;
	}

	
}
