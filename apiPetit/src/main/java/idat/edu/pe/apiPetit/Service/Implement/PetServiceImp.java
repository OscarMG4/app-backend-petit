package idat.edu.pe.apiPetit.Service.Implement;

import idat.edu.pe.apiPetit.Dto.PetDTO;
import idat.edu.pe.apiPetit.Dto.QuoteDTO;
import idat.edu.pe.apiPetit.Entity.Pet;
import idat.edu.pe.apiPetit.Entity.PetType;
import idat.edu.pe.apiPetit.Exceptions.AppException;
import idat.edu.pe.apiPetit.Exceptions.ResourceNotFoundException;
import idat.edu.pe.apiPetit.Repository.PetRepository;
import idat.edu.pe.apiPetit.Repository.PetTypeRepository;
import idat.edu.pe.apiPetit.Service.PetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetServiceImp implements PetService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetTypeRepository petTypeRepository;

    @Override
    public PetDTO createPet(Integer petTypeId, PetDTO petDTO) {
        Pet pet = mappingEntity(petDTO);
        PetType petType = petTypeRepository.findById(petTypeId).orElseThrow(()-> new ResourceNotFoundException("PetType", "id", petTypeId));

        pet.setPetType(petType);

        Pet newPet = petRepository.save(pet);
        PetDTO petResponse = mappingDTO(newPet);

        return petResponse;
    }

    @Override
    public List<PetDTO> showPets() {
        List<Pet> pets = petRepository.findAll();
        return pets.stream().map(pet -> mappingDTO(pet)).collect(Collectors.toList());
    }

    @Override
    public List<PetDTO> showPetsByTypeId(Integer petTypeId) {
        List<Pet> pets = petRepository.findByPetTypeId(petTypeId);
        return pets.stream().map(pet -> mappingDTO(pet)).collect(Collectors.toList());
    }

    @Override
    public List<PetDTO> showPetsByType(String petType) {
        List<Pet> pets = petRepository.findByPetType(petType);
        return pets.stream().map(pet -> mappingDTO(pet)).collect(Collectors.toList());
    }

    @Override
    public PetDTO showPetsId(Integer petTypeId, Integer id) {
        PetType petType = petTypeRepository.findById(petTypeId).orElseThrow(()-> new ResourceNotFoundException("PetType", "id", petTypeId));
        Pet pet = petRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pet", "id", id));

        if (!pet.getPetType().getIdPetType().equals(petType.getIdPetType())){
            throw new AppException(HttpStatus.BAD_REQUEST, "Esta mascota no existe!");
        }

        return mappingDTO(pet);
    }

    @Override
    public PetDTO updatePet(PetDTO petDTO, Integer id, Integer petTypeId) {
        PetType petType = petTypeRepository.findById(petTypeId).orElseThrow(()-> new ResourceNotFoundException("PetType", "id", petTypeId));
        Pet pet = petRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pet", "id", id));

        if (!pet.getPetType().getIdPetType().equals(petType.getIdPetType())){
            throw new AppException(HttpStatus.BAD_REQUEST, "Esta mascota no existe!");
        }

        pet.setName(petDTO.getName());
        pet.setSex(petDTO.getSex());
        pet.setRace(petDTO.getRace());
        pet.setAge(petDTO.getAge());

        Pet newPet = petRepository.save(pet);

        return mappingDTO(newPet);
    }

    @Override
    public void deletePet(Integer petTypeId, Integer id) {
        PetType petType = petTypeRepository.findById(petTypeId).orElseThrow(()-> new ResourceNotFoundException("PetType", "id", petTypeId));
        Pet pet = petRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pet", "id", id));

        if (!pet.getPetType().getIdPetType().equals(petType.getIdPetType())){
            throw new AppException(HttpStatus.BAD_REQUEST, "Esta mascota no existe!");
        }

        petRepository.delete(pet);
    }

    private Pet mappingEntity(PetDTO petDTO){
        Pet pet = modelMapper.map(petDTO, Pet.class);
        return pet;
    }

    private PetDTO mappingDTO(Pet pet){
        PetDTO petDTO = modelMapper.map(pet, PetDTO.class);
        return petDTO;
    }

}
