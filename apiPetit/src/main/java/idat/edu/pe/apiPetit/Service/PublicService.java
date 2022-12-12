package idat.edu.pe.apiPetit.Service;

import idat.edu.pe.apiPetit.Dto.PublicRequestDTO;
import idat.edu.pe.apiPetit.Dto.PublicResponseDTO;

public interface PublicService {
    PublicResponseDTO createAccount(PublicRequestDTO requestDTO);
}
