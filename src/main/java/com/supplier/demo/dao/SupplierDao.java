package com.supplier.demo.dao;

import java.util.List;

import com.supplier.demo.dto.SupplierRequest;
import com.supplier.demo.model.Supplier;

public interface SupplierDao {

	List<Supplier> getSuppliers();//取得所有供應商
	
	Supplier getSupplierById(Integer supplierId);//以供應商ID取得
	
	Supplier getSupplierByAccount_target(String account);//以供應商帳號取得 用於驗證是否與資料庫重複
	
	Supplier getSupplierByName_target(String name);//以供應商姓名取得 用於驗證是否與資料庫重複
	
	List<Supplier> getSupplierByAccount(String account);//以供應商帳號取得 用於模糊查詢
	
	List<Supplier> getSupplierByName(String name);//以供應商姓名取得 用於模糊查詢
	
	List<Supplier> getSupplierByTimeRange(String startTime, String endTime);//以供應商新增時間取得
	
	Integer createSupplier(SupplierRequest supplierRequest);//新增供應商
	
	void updateSupplier(SupplierRequest supplierRequest, Integer supplierId);//修改供應商
	
	void deleteSupplierById(Integer supplierId);//刪除供應商
}
