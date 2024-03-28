package com.eci.register.pet.infraestructure.outbound;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.eci.register.pet.domain.repositories.PetOwnerRepository;

@Repository
public class PetOwnerRepositoryImpl implements PetOwnerRepository {

    private static List<UUID> ownerIdList = Arrays.asList(
        UUID.randomUUID(), 
        UUID.randomUUID());

    @Override
    public String searchOwnerById(UUID ownerId) {
        if (ownerIdList.contains(ownerId)) {
            return "Si existe el dueño de mascota";
        }
        return "Error: No existe el dueño de mascota";
    }

    @Override
    public List<UUID> getOwnerIdList() {
        return ownerIdList;
    }
}
