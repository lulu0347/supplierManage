package com.supplier.demo.dao.impl;

import java.util.Map;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.supplier.demo.dao.SupplierDao;
import com.supplier.demo.dto.SupplierRequest;
import com.supplier.demo.model.Supplier;
import com.supplier.demo.rowMapper.SupplierRowMapper;

@Repository
@Component
public class SupplierDaoImpl implements SupplierDao{
	
	@Value("${supplier.getSuppliers}")
	private String getSuppliers;
	
	@Value("${supplier.getSupplierById}")
	private String getSupplierById;
	
	@Value("${supplier.getSupplierByAccount}")
	private String getSupplierByAccount;
	
	@Value("${supplier.getSupplierByName}")
	private String getSupplierByName;
	
	@Value("${supplier.getSupplierByTimeRange}")
	private String getSupplierByTimeRange;
	
	@Value("${supplier.createSupplier}")
	private String createSupplier;
	
	@Value("${supplier.updateSupplier}")
	private String updateSupplier;
	
	@Value("${supplier.deleteSupplierById}")
	private String deleteSupplierById;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<Supplier> getSuppliers() {
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		List<Supplier> list = namedParameterJdbcTemplate.query(getSuppliers, map, new SupplierRowMapper());
		
		return list;
	}

	@Override
	public Supplier getSupplierById(Integer supplierId) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("supplierId", supplierId);
		
		List<Supplier> list = namedParameterJdbcTemplate.query(getSupplierById, map, new SupplierRowMapper());
		
		if(list.size() >0) {
			return list.get(0);
		}else {
			return null;
		}
	}

	@Override
	public Supplier getSupplierByAccount(String account) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("account", account);
		
		List<Supplier> list = namedParameterJdbcTemplate.query(getSupplierByAccount, map, new SupplierRowMapper());
		
		if(list.size() >0) {
			return list.get(0);
		}else {
			return null;
		}
	}

	@Override
	public Supplier getSupplierByName(String name) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", name);
		
		List<Supplier> list = namedParameterJdbcTemplate.query(getSupplierByName, map, new SupplierRowMapper());
		
		if(list.size() >0) {
			return list.get(0);
		}else {
			return null;
		}
	}
	
	@Override
	public List<Supplier> getSupplierByTimeRange(String startTime, String endTime) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		
		List<Supplier> list = namedParameterJdbcTemplate.query(getSupplierByTimeRange, map, new SupplierRowMapper());
		
		return list;
	}

	@Override
	public Integer createSupplier(SupplierRequest supplierRequest) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("account", supplierRequest.getAccount());
		map.put("name", supplierRequest.getName());
		map.put("phone", supplierRequest.getPhone());
		map.put("address", supplierRequest.getAddress());
		map.put("email", supplierRequest.getEmail());
		map.put("last_create_staff", supplierRequest.getLast_create_staff());
		map.put("last_create_time", new Timestamp(new Date().getTime()));
		map.put("last_modify_staff", null);
		map.put("last_modify_time", null);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(createSupplier, new MapSqlParameterSource(map), keyHolder);

		int supplierId = keyHolder.getKey().intValue();
		
		return supplierId;
	}

	@Override
	public void updateSupplier(SupplierRequest supplierRequest, Integer supplierId) {
		
		Map<String,Object> map = new HashMap<String,Object>();	
		map.put("supplierId", supplierId);
		
		map.put("account", supplierRequest.getAccount());
		map.put("name", supplierRequest.getName());
		map.put("phone", supplierRequest.getPhone());
		map.put("address", supplierRequest.getAddress());
		map.put("email", supplierRequest.getEmail());
		map.put("last_modify_staff", supplierRequest.getLast_modify_staff());
		map.put("last_modify_time", new Timestamp(new Date().getTime()));
		
		namedParameterJdbcTemplate.update(updateSupplier, map);
	}

	@Override
	public void deleteSupplierById(Integer supplierId) {
		
		Map<String,Object> map = new HashMap<String,Object>();		
		map.put("supplierId", supplierId);
		
		namedParameterJdbcTemplate.update(deleteSupplierById, map);
	}
}
