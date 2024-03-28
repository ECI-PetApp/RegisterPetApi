package com.eci.register.pet.domain.entities;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Pet {
    private final UUID petId;
    private final String name;
    private final String lastName;
    private final UUID ownerId;
}
