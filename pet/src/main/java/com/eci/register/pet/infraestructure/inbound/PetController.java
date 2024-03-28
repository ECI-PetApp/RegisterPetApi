package com.eci.register.pet.infraestructure.inbound;

import java.util.UUID;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eci.register.pet.application.PetUseCase;
import com.eci.register.pet.domain.dtos.PetRequest;
import com.eci.register.pet.domain.entities.Pet;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/pet")
@AllArgsConstructor
public class PetController {

    private final PetUseCase petUseCase;

    @PostMapping
    public ResponseEntity<UUID> createPet(@RequestBody PetRequest pet)
    {
        return ResponseEntity.ok(petUseCase.registerPet(pet));
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getPets() {
        return ResponseEntity.ok(petUseCase.getAll());
    }
}
