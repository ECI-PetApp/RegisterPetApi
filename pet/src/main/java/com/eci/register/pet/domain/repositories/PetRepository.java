package com.eci.register.pet.domain.repositories;

import java.util.List;
import java.util.UUID;
import com.eci.register.pet.domain.dtos.PetRequest;
import com.eci.register.pet.domain.entities.Pet;

public interface PetRepository {
    UUID createPet(PetRequest pet);
    List<Pet> getAll();
}
