package idat.edu.pe.apiPetit.Service;

import idat.edu.pe.apiPetit.Dto.PetDTO;
import idat.edu.pe.apiPetit.Dto.UserDTO;

import java.util.List;

public interface PetService {
    PetDTO createPet(PetDTO petDTO);
    List<PetDTO> showPets();
    PetDTO showPetsId(Integer id);
    PetDTO updatePet(PetDTO petDTO, Integer id);
    void deletePet(Integer id);

}
