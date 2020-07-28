package ru.social.network.homeless.animals.webapi.service.impl

import org.springframework.stereotype.Service
import ru.social.network.homeless.animals.webapi.model.Animal
import ru.social.network.homeless.animals.webapi.repository.AnimalRepository
import ru.social.network.homeless.animals.webapi.service.AnimalService
import java.util.*

@Service
class AnimalServiceImpl(val animalRepository: AnimalRepository) : AnimalService {

    override fun getAnimal(animalId: UUID): Optional<Animal> {
       return animalRepository.findById(animalId)
    }

    override fun getAnimals(animalIds: Set<UUID>): List<Animal> {
        return animalRepository.findAllById(animalIds)
    }

    override fun createAnimal(animal: Animal): Animal {
        return animalRepository.save(animal)
    }

    override fun editAnimal(animal: Animal): Animal {
        return animalRepository.save(animal)
    }

    override fun deleteAnimal(animalId: UUID) {
        return animalRepository.deleteById(animalId)
    }
}