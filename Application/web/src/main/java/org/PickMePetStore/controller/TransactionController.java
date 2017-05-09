package org.PickMePetStore.controller;

import org.PickMePetStore.persistence.model.PetModel;
import org.PickMePetStore.persistence.model.TransactionModel;
import org.PickMePetStore.persistence.model.UserModel;
import org.PickMePetStore.service.PetService;
import org.PickMePetStore.service.TransactionService;
import org.PickMePetStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping
	public TransactionModel transaction(Model model) {
		TransactionModel transaction = transactionService.getActiveTransaction();
		return transaction;
	}
	
	@PostMapping("add/{petId}")
	public String addItem(@PathVariable("petId") int petId) {
		transactionService.addPetToTransaction(petId);
		return "dummy";
	}
	
	@DeleteMapping("/remove/{petId}")
	public String removeItem(@PathVariable("petId") int petId) {
		transactionService.removePetFromTransaction(petId);
		return "dummy";
	}
	
	@PutMapping("/clear")
	public String clearCart() {
		transactionService.clearAllPets();
		return "cart";
	}
	
	@PutMapping("/checkout")
	public String transactionCheckout() {
		transactionService.checkout();
		return "cart";
	}
	
}
