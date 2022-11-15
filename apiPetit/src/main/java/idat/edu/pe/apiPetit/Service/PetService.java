package idat.edu.pe.apiPetit.Service;

import idat.edu.pe.apiPetit.Dto.PetDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetService {
    PetDTO createPet(Integer petTypeId, PetDTO petDTO);
    List<PetDTO> showPets();
    List<PetDTO> showPetsByTypeId(@Param("idPetType") Integer petTypeId);
    List<PetDTO> showPetsByType(@Param("petType") String petType);
    PetDTO showPetsId(Integer petTypeId, Integer id);
    PetDTO updatePet(PetDTO petDTO, Integer id, Integer petTypeId);
    void deletePet(Integer petTypeId, Integer id);

}
