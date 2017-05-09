package org.PickMePetStore.controller;

import org.PickMePetStore.persistence.model.PetModel;
import org.PickMePetStore.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/pet")
public class PetController {

	@Autowired
	private PetService petService;

	@GetMapping(params = { "id" })
	public String getPetById(@RequestParam("id") int petId) {
		petService.findPetById(petId);
		return "dummy";
	}

	@GetMapping("/all")
	public String viewCourses() {
		petService.findAllPets();
		return "dummy";
	}

	@GetMapping("/{category}")
	public String viewCoursesByType(@PathVariable("category") String petCategory) {
		petService.findPetsByCategory(petCategory);
		return "dummy";
	}

	@PostMapping("/add")
	public String processNewCourseForm(@RequestBody PetModel newPet) {
		petService.addPet(newPet);
		return "dummy";
	}

}
