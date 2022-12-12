package idat.edu.pe.apiPetit.Service;

import idat.edu.pe.apiPetit.Dto.LocalizationDTO;

import java.util.List;

public interface LocationService {
    List<LocalizationDTO> findAll();

    LocalizationDTO findById(Integer id);

    void save(Integer id, LocalizationDTO locationDTO);

    void saveAndFlush(LocalizationDTO locationDTO);

    void deleteById(Integer id);
}
