package idat.edu.pe.apiPetit.Service.Implement;

import idat.edu.pe.apiPetit.Dto.LocalizationDTO;
import idat.edu.pe.apiPetit.Entity.Location;
import idat.edu.pe.apiPetit.Entity.User;
import idat.edu.pe.apiPetit.Repository.LocationRepository;
import idat.edu.pe.apiPetit.Repository.UserRepository;
import idat.edu.pe.apiPetit.Service.LocationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<LocalizationDTO> findAll() {
        return repository.findAll().stream().map(location -> mappingDTO(location)).collect(Collectors.toList());
    }

    @Override
    public LocalizationDTO findById(Integer id) {
        return mappingDTO(repository.findById(id).orElse(null));
    }

    @Override
    public void save(Integer id, LocalizationDTO locationDTO) {
        Location location = mappingEntity(locationDTO);
        User user = userRepository.findById(id).orElse(null);
        location.setUser(user);
        repository.save(location);
    }

    @Override
    public void saveAndFlush(LocalizationDTO locationDTO) {
        repository.saveAndFlush(mappingEntity(locationDTO));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Location mappingEntity(LocalizationDTO locationDTO) {
        Location location = modelMapper.map(locationDTO, Location.class);
        return location;
    }

    public LocalizationDTO mappingDTO(Location location) {
        LocalizationDTO locationDTO = modelMapper.map(location, LocalizationDTO.class);
        return locationDTO;
    }
}
