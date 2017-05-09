package org.PickMePetStore.persistence.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class TransactionModel extends Model {
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserModel user;

	@ManyToMany//(fetch = FetchType.EAGER)
	@JoinTable(name = "transaction_pet", joinColumns = { @JoinColumn(name = "transactionId") }, inverseJoinColumns = {
			@JoinColumn(name = "petId") })
	private List<PetModel> pets = new ArrayList<PetModel>();

	private int grandTotal;

	private String approval;

	public TransactionModel(){
		
	}
	
	public TransactionModel(UserModel user) {
		this.user = user;
		this.approval = "UNFINISHED";
	}
	
	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public List<PetModel> getPets() {
		return pets;
	}

	public void setPets(List<PetModel> pets) {
		this.pets = pets;
	}

	public int getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}
	
	public void addTransactionItem(PetModel pet) {
		if (!pets.contains(pet)) {
			pets.add(pet);
		}
		updateGrandTotal();
	}

	public void removeTransactionItem(PetModel pet) {
		pets.remove(pet);
		updateGrandTotal();
	}

	public void updateGrandTotal() {
		grandTotal = 0;
		for (PetModel pet : pets) {
			grandTotal = grandTotal + pet.getPrice();
		}
	}
}
