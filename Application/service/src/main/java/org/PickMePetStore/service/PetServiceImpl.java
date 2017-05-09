package org.PickMePetStore.service;

import java.util.List;

import org.PickMePetStore.persistence.model.PetModel;
import org.PickMePetStore.persistence.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private PetRepository petRepository;

	public List<PetModel> findAllPets() {
		List<PetModel> pets = petRepository.findAll();
		return pets;
	}

	public void addCourse(PetModel pet) {
		petRepository.save(pet);
	}

	public List<PetModel> findPetsByCategory(String category) {
		List<PetModel> pets = petRepository.findByCategory(category);
		return pets;
	}

	public PetModel findPetById(int id) {
		return petRepository.findById(id);
	}

	public void removeById(int id) {
		petRepository.delete(id);
	}

	@Override
	public void addPet(PetModel pet) {
		petRepository.save(pet);
	}


}
