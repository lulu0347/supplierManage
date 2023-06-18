package com.supplier.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supplier.demo.dto.SupplierRequest;
import com.supplier.demo.model.Supplier;
import com.supplier.demo.service.SupplierService;

@RestController
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	
	@GetMapping("/suppliers")
	public ResponseEntity<List<Supplier>> getSuppliers(){
		
		List<Supplier> supplierList = supplierService.getSuppliers();
		
		return ResponseEntity.status(HttpStatus.OK).body(supplierList);
	}	
	
	@GetMapping("/supplier/supplierId/{supplierId}")
	public ResponseEntity<Supplier> getSupplierById(@PathVariable Integer supplierId){
		
		Supplier supplier = supplierService.getSupplierById(supplierId);
		
		if(supplier != null) {
			return ResponseEntity.status(HttpStatus.OK).body(supplier);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/supplier/account/target/{account}")
	public ResponseEntity<Supplier> getSupplierByAccount_target(@PathVariable String account){
		
		Supplier supplier = supplierService.getSupplierByAccount_target(account);
		
		if(supplier != null) {
			return ResponseEntity.status(HttpStatus.OK).body(supplier);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/supplier/name/target/{name}")
	public ResponseEntity<Supplier> getSupplierByName_target(@PathVariable String name){
		
		Supplier supplier = supplierService.getSupplierByName_target(name);
		
		if(supplier != null) {
			return ResponseEntity.status(HttpStatus.OK).body(supplier);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/supplier/account/{account}")
	public ResponseEntity<List<Supplier>> getSupplierByAccount(@PathVariable String account){
		
		List<Supplier> supplierList = supplierService.getSupplierByAccount(account);
		
		if(supplierList != null) {
			return ResponseEntity.status(HttpStatus.OK).body(supplierList);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/supplier/name/{name}")
	public ResponseEntity<List<Supplier>> getSupplierByName(@PathVariable String name){
		
		List<Supplier> supplierList = supplierService.getSupplierByName(name);
		
		if(supplierList != null) {
			return ResponseEntity.status(HttpStatus.OK).body(supplierList);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/supplier/timeRange/{startTime}/{endTime}")
	public ResponseEntity<List<Supplier>> getSupplierByTimeRange(@PathVariable String startTime,
			@PathVariable String endTime){
		
		List<Supplier> supplierList = supplierService.getSupplierByTimeRange(startTime, endTime);
		
		if(supplierList != null) {
			return ResponseEntity.status(HttpStatus.OK).body(supplierList);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping("/supplier")
	public ResponseEntity<Supplier> createSupplier(@RequestBody @Valid SupplierRequest supplierRequest){
		
		Integer supplierId = supplierService.createSupplier(supplierRequest);
		
		Supplier supplier = supplierService.getSupplierById(supplierId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(supplier);//201
	}
	
	@PutMapping("/supplier/{supplierId}")
	public ResponseEntity<Supplier> updateSupplier(@RequestBody @Valid SupplierRequest supplierRequest, @PathVariable Integer supplierId){
		
		Supplier supplier = supplierService.getSupplierById(supplierId);
		
		if(supplier == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();//404
		}
		
		supplierService.updateSupplier(supplierRequest, supplierId);
		
		Supplier updatedSupplier = supplierService.getSupplierById(supplierId);
		
		return ResponseEntity.status(HttpStatus.OK).body(updatedSupplier);//200
	}

	@DeleteMapping("supplier/{supplierId}")
	public ResponseEntity<?> deleteSupplierById(@PathVariable Integer supplierId){

		supplierService.deleteSupplierById(supplierId);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();//204
	}
	
}
