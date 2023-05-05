package com.example.demo.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Product.Product;
import com.example.demo.repo.repo;


@RestController
@RequestMapping(path="/api/v1/HomeStay")
public class controllers {
	@Autowired
	private repo repository;
	
	
	@GetMapping("/showList")
	List<Product> getAllAttributes(){
		return repository.findAll();
	}
	
	// get homeStay
	@GetMapping("/search/{id}")
	ResponseEntity<ResponseObject> findById(@PathVariable Long id){
		Optional<Product> foundProduct = repository.findById(id);
		if(foundProduct.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseObject("ok","query product successfully", foundProduct)
					);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new ResponseObject("ok","Cannot found", foundProduct)
				);
		}
	}
	
	// search for name
	@PostMapping("/searchByName")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product Home) {
        //2 products must not have the same name !
        List<Product> foundHome = repository.findByName(Home.getName().trim());
		if(foundHome.size()>0) {
			return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseObject("ok","query product successfully", foundHome)
					);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new ResponseObject("ok","Cannot found", foundHome)
				);
		}
	}
	
	
	// insert new homestay
	@PostMapping("/insert")
	ResponseEntity<ResponseObject> inserHomestay(@RequestBody Product newHome){
        //2 products must not have the same name !
        List<Product> foundProducts = repository.findByName(newHome.getName().trim());
        if(foundProducts.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("failed", "Product name already taken", "")
            );
        }
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseObject("ok","insert successfully", repository.save(newHome)));
	}
	
	// update homestay
	@PutMapping("/update{id}")
	ResponseEntity<ResponseObject> updateHome(@RequestBody Product newHome,@PathVariable Long id){
		Product updateHome =  repository.findById(id)
				.map(product ->{
					product.setName(newHome.getName());
					product.setAddress(newHome.getAddress());
					product.setContact(newHome.getContact());
					product.setStatus(newHome.getStatus());
					product.setPrice(newHome.getPrice());
					product.setTotal(newHome.getTotal());
					return repository.save(product);
				}).orElseGet(()->{
					newHome.getId();
					return repository.save(newHome);
				});
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseObject("ok","update successfully", updateHome));
	}
    //Delete a Product => DELETE method
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id) {
        boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Delete home successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            new ResponseObject("failed", "Cannot find home to delete", "")
        );
    }
	
	
}
