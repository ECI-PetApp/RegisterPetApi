package com.eci.register.pet.domain.repositories;

import java.util.List;
import java.util.UUID;

public interface PetOwnerRepository {
    String searchOwnerById(UUID ownerId);
    List<UUID> getOwnerIdList();
}
