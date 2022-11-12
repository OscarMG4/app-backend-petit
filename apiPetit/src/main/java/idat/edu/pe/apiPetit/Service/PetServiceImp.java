package idat.edu.pe.apiPetit.Service;

import idat.edu.pe.apiPetit.Dto.PetDTO;
import idat.edu.pe.apiPetit.Entity.Pet;
import idat.edu.pe.apiPetit.Exceptions.ResourceNotFoundException;
import idat.edu.pe.apiPetit.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetServiceImp implements PetService{
    @Autowired
    private PetRepository petRepository;

    private Pet mapingEntity(PetDTO petDTO){
        Pet pet = new Pet();

        pet.setIdPet(petDTO.getId());
        pet.setTypePet(petDTO.getTypePet());
        pet.setName(petDTO.getName());
        pet.setSex(petDTO.getSex());
        pet.setRace(petDTO.getRace());
        pet.setAge(petDTO.getAge());

        return pet;
    }

    private PetDTO mapingDTO(Pet pet){
        PetDTO petDTO = new PetDTO();

        petDTO.setId(pet.getIdPet());
        petDTO.setTypePet(pet.getTypePet());
        petDTO.setName(pet.getName());
        petDTO.setSex(pet.getSex());
        petDTO.setRace(pet.getRace());
        petDTO.setAge(pet.getAge());

        return petDTO;
    }

    @Override
    public PetDTO createPet(PetDTO petDTO) {
        Pet pet = mapingEntity(petDTO);
        Pet newPet = petRepository.save(pet);
        PetDTO userResponse = mapingDTO(newPet);

        return userResponse;
    }

    @Override
    public List<PetDTO> showPets() {
        List<Pet> pets = petRepository.findAll();
        return pets.stream().map(pet -> mapingDTO(pet)).collect(Collectors.toList());
    }

    @Override
    public PetDTO showPetsId(Integer id) {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pet", "id", id));
        return mapingDTO(pet);
    }

    @Override
    public PetDTO updatePet(PetDTO petDTO, Integer id) {
        Pet petId = petRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pet", "id", id));

        petId.setTypePet(petDTO.getTypePet());
        petId.setName(petDTO.getName());
        petId.setSex(petDTO.getSex());
        petId.setRace(petDTO.getRace());
        petId.setAge(petDTO.getAge());

        Pet petUpdated = petRepository.save(petId);
        return mapingDTO(petUpdated);
    }

    @Override
    public void deletePet(Integer id) {
        Pet petId = petRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pet", "id", id));
        petRepository.delete(petId);
    }


}
