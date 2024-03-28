package com.eci.register.pet.domain.dtos;

import java.util.UUID;

import io.micrometer.common.lang.NonNull;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PetRequest {
    @NonNull
    private final String petName;
    @NonNull
    private final String petLastName;
    @NonNull
    private final UUID ownerId;
}
