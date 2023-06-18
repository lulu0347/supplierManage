package com.supplier.demo.dao;

import java.util.List;

import com.supplier.demo.dto.SupplierRequest;
import com.supplier.demo.model.Supplier;

public interface SupplierDao {

	List<Supplier> getSuppliers();//取得所有供應商
	
	Supplier getSupplierById(Integer supplierId);
	
	List<Supplier> getSupplierByAccount(String account);
	
	List<Supplier> getSupplierByName(String name);
	
	List<Supplier> getSupplierByTimeRange(String startTime, String endTime);
	
	Integer createSupplier(SupplierRequest supplierRequest);
	
	void updateSupplier(SupplierRequest supplierRequest, Integer supplierId);
	
	void deleteSupplierById(Integer supplierId);
}
