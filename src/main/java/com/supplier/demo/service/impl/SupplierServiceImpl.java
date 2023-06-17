package com.supplier.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.supplier.demo.dao.SupplierDao;
import com.supplier.demo.dto.SupplierRequest;
import com.supplier.demo.model.Supplier;
import com.supplier.demo.service.SupplierService;

@Service
@Component
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private SupplierDao supplierDao;
	
	@Override
	public List<Supplier> getSuppliers() {
		return supplierDao.getSuppliers();
	}

	@Override
	public Supplier getSupplierById(Integer supplierId) {
		return supplierDao.getSupplierById(supplierId);
	}
	
	@Override
	public Supplier getSupplierByAccount(String account) {
		return supplierDao.getSupplierByAccount(account);
	}

	@Override
	public Supplier getSupplierByName(String name) {
		return supplierDao.getSupplierByName(name);
	}

	@Override
	public List<Supplier> getSupplierByTimeRange(String startTime, String endTime) {
		return supplierDao.getSupplierByTimeRange(startTime, endTime);
	}

	@Override
	public Integer createSupplier(SupplierRequest supplierRequest) {
		return supplierDao.createSupplier(supplierRequest);
	}

	@Override
	public void updateSupplier(SupplierRequest supplierRequest, Integer supplierId) {
		supplierDao.updateSupplier(supplierRequest,supplierId);
	}

	@Override
	public void deleteSupplierById(Integer supplierId) {
		supplierDao.deleteSupplierById(supplierId);
	}
}
