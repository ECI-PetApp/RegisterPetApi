package com.eci.register.pet.infraestructure.outbound;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.eci.register.pet.domain.dtos.PetRequest;
import com.eci.register.pet.domain.entities.Pet;
import com.eci.register.pet.domain.repositories.PetRepository;

@Repository
public class PetRepositoryImpl implements PetRepository {
    
    static List<Pet> pets = new ArrayList<>();

    public PetRepositoryImpl() {
        Pet petOne = Pet.builder()
        .name("Toby")
        .lastName("Restrepo")
        .ownerId(UUID.fromString("cbcada6c-a67e-475b-a519-63457b893a96"))
        .build(); 
        pets.add(petOne);
    }

    @Override
    public UUID createPet(PetRequest pet) {
        Pet petAdd = Pet.builder()
        .name(pet.getPetName())
        .lastName(pet.getPetLastName())
        .ownerId(pet.getOwnerId())
        .petId(UUID.randomUUID())
        .build();
        pets.add(petAdd);
        return petAdd.getPetId();
    }

    @Override
    public List<Pet> getAll() {
        return pets;
    }

}
