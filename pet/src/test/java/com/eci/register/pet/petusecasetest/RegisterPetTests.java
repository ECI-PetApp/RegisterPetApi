package com.eci.register.pet.petusecasetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.eci.register.pet.application.PetUseCase;
import com.eci.register.pet.domain.dtos.PetRequest;
import com.eci.register.pet.domain.repositories.PetOwnerRepository;
import com.eci.register.pet.domain.repositories.PetRepository;

class RegisterPetTests {

    @Mock
    PetRepository petRepo;
    @Mock
    PetOwnerRepository petOwnerRep;
    
    @InjectMocks
    PetUseCase petCase;

    @BeforeEach
    void init()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void Should_Petregister_When_Idowner()
    {
        //Arrange
        PetRequest pet = PetRequest.builder()
        .petName("Toby") 
        .petLastName("Restrepo")
        .ownerId(UUID.fromString("cbcada6c-a67e-475b-a519-63457b893a96"))
        .build();
        UUID petIdExpect = UUID.fromString("acea60ba-33f2-46f6-9f0c-4e78773f2f33");
        when(petRepo.createPet(pet)).thenReturn(petIdExpect);
        String petOwnerExpectMessage = "Si existe el dueño de mascota";
        when(petOwnerRep.searchOwnerById(UUID.fromString("cbcada6c-a67e-475b-a519-63457b893a96"))).thenReturn(petOwnerExpectMessage);
        
        //Action
        UUID petId = petCase.registerPet(pet);
        //Assert
        assertEquals(petIdExpect, petId);
    }

    @Test
    void Should_Exception_When_idOwnerDoesNotExists()
    {
        //Arrange
        PetRequest pet = PetRequest.builder()
        .petName("Toby") 
        .petLastName("Restrepo")
        .ownerId(UUID.fromString("cbcada6c-a67e-475b-a519-63457b893a96"))
        .build();
        String petOwnerExpectMessage = "Error: No existe el dueño de mascota";
        when(petOwnerRep.searchOwnerById(UUID.fromString("cbcada6c-a67e-475b-a519-63457b893a96"))).thenReturn(petOwnerExpectMessage);

        //Action
        Exception exception = assertThrows(
            IllegalArgumentException.class, 
            ()-> petCase.registerPet(pet)); 
        
        //Assert
        assertEquals(petOwnerExpectMessage, exception.getMessage());
    }
}
