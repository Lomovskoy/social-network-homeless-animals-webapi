package ru.social.network.homeless.animals.webapi.service

import ru.social.network.homeless.animals.webapi.model.Animal
import java.util.*

interface AnimalService {

    fun getAnimal(animalId: UUID): Optional<Animal>

    fun getAnimals(animalIds: Set<UUID>): List<Animal>

    fun createAnimal(animal: Animal): Animal

    fun editAnimal(animal: Animal): Animal

    fun deleteAnimal(animalId: UUID)
    
}