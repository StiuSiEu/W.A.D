package org.PickMePetStore.persistence.repository;

import java.util.List;

import org.PickMePetStore.persistence.model.PetModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<PetModel, Integer>{
	
	List<PetModel> findAll();

	List<PetModel> findByCategory(String category);

	PetModel findById(int id);
}
