package idat.edu.pe.apiPetit.Service;

import idat.edu.pe.apiPetit.Dto.AdoptionDTO;
import idat.edu.pe.apiPetit.Dto.UbicacionDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdoptionService {

    AdoptionDTO createAdoption(Integer idPet, Integer idState, Integer idUser, AdoptionDTO adoptionDTO);
    List<AdoptionDTO> showAdoptions();
    List<AdoptionDTO> showAdoptionsByUserId(@Param("idUser") Integer userId);
    AdoptionDTO showAdoptionById(Integer idUser, Integer idAdoption);
    AdoptionDTO updateAdoption(Integer idUser, Integer idAdoption, AdoptionDTO adoptionDTO);
    void deleteAdoption(Integer idUser, Integer idAdoption);
    List<UbicacionDTO> obtenerUbicaciones(Integer idState);
}
