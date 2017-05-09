package org.PickMePetStore.service;

import java.util.List;

import org.PickMePetStore.persistence.model.PetModel;


public interface PetService {

	void addPet(PetModel pet);

	List<PetModel> findAllPets();

	List<PetModel> findPetsByCategory(String category);

	PetModel findPetById(int id);

	void removeById(int id);

}
