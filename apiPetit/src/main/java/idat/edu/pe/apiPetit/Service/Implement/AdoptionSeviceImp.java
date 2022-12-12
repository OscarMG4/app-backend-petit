package idat.edu.pe.apiPetit.Service.Implement;

import idat.edu.pe.apiPetit.Dto.AdoptionDTO;
import idat.edu.pe.apiPetit.Dto.UbicacionDTO;
import idat.edu.pe.apiPetit.Entity.*;
import idat.edu.pe.apiPetit.Exceptions.AppException;
import idat.edu.pe.apiPetit.Exceptions.ResourceNotFoundException;
import idat.edu.pe.apiPetit.Repository.*;
import idat.edu.pe.apiPetit.Service.AdoptionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdoptionSeviceImp implements AdoptionService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AdoptionRepository adoptionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private LocationRepository locationRepository;


    @Override
    public AdoptionDTO createAdoption(Integer idPet, Integer idState, Integer idUser, AdoptionDTO adoptionDTO) {
        Adoption adoption = mappingEntity(adoptionDTO);

        Pet pet = petRepository.findById(idPet).orElseThrow(() -> new ResourceNotFoundException("Pet", "id", idPet));
        State state = stateRepository.findById(idState).orElseThrow(() -> new ResourceNotFoundException("State", "id", idState));
        User user = userRepository.findById(idUser).orElseThrow(() -> new ResourceNotFoundException("User", "id", idUser));

        adoption.setPet(pet);
        adoption.setState(state);
        adoption.setUser(user);

        Adoption newAdoption = adoptionRepository.save(adoption);
        AdoptionDTO adoptionResponse = mappingDTO(newAdoption);

        return adoptionResponse;
    }

    @Override
    public List<AdoptionDTO> showAdoptions() {
        List<Adoption> adoptions = adoptionRepository.findAll();
        return adoptions.stream().map(adoption -> mappingDTO(adoption)).collect(Collectors.toList());
    }

    @Override
    public List<AdoptionDTO> showAdoptionsByUserId(Integer userId) {
        List<Adoption> adoptions = adoptionRepository.findByIdUser(userId);
        return adoptions.stream().map(adoption -> mappingDTO(adoption)).collect(Collectors.toList());
    }

    @Override
    public AdoptionDTO showAdoptionById(Integer idUser, Integer idAdoption) {
        User user = userRepository.findById(idUser).orElseThrow(() -> new ResourceNotFoundException("User", "id", idUser));
        Adoption adoption = adoptionRepository.findById(idAdoption).orElseThrow(() -> new ResourceNotFoundException("Adoption", "id", idAdoption));

        if (!adoption.getUser().getIdUser().equals(user.getIdUser())) {
            throw new AppException(HttpStatus.BAD_REQUEST, "EL registro de adopción no existe!");
        }

        return mappingDTO(adoption);
    }

    @Override
    public AdoptionDTO updateAdoption(Integer idUser, Integer idAdoption, AdoptionDTO adoptionDTO) {
        User user = userRepository.findById(idUser).orElseThrow(() -> new ResourceNotFoundException("User", "id", idUser));
        Adoption adoption = adoptionRepository.findById(idAdoption).orElseThrow(() -> new ResourceNotFoundException("Adoption", "id", idAdoption));

        if (!adoption.getUser().getIdUser().equals(user.getIdUser())) {
            throw new AppException(HttpStatus.BAD_REQUEST, "EL registro de adopción no existe!");
        }

        adoption.setDescription(adoptionDTO.getDescription());

        Adoption newAdoption = adoptionRepository.save(adoption);
        AdoptionDTO responseAdoption = mappingDTO(newAdoption);

        return responseAdoption;
    }

    @Override
    public void deleteAdoption(Integer idUser, Integer idAdoption) {
        User user = userRepository.findById(idUser).orElseThrow(() -> new ResourceNotFoundException("User", "id", idUser));
        Adoption adoption = adoptionRepository.findById(idAdoption).orElseThrow(() -> new ResourceNotFoundException("Adoption", "id", idAdoption));

        if (!adoption.getUser().getIdUser().equals(user.getIdUser())) {
            throw new AppException(HttpStatus.BAD_REQUEST, "EL registro de adopción no existe!");
        }

        adoptionRepository.delete(adoption);
    }

    private AdoptionDTO mappingDTO(Adoption adoption) {
        AdoptionDTO adoptionDTO = modelMapper.map(adoption, AdoptionDTO.class);
        return adoptionDTO;
    }

    private Adoption mappingEntity(AdoptionDTO adoptionDTO) {
        Adoption adoption = modelMapper.map(adoptionDTO, Adoption.class);
        return adoption;
    }

    @Override
    public List<UbicacionDTO> obtenerUbicaciones(Integer idState) {
        List<UbicacionDTO> ubicaciones = new ArrayList<>();
        List<Adoption> adopciones = adoptionRepository.findByIdState(idState);

        for (Adoption adopcion : adopciones) {
            User user = userRepository.findById(adopcion.getUser().getIdUser()).orElse(null);
            Pet pet = petRepository.findById(adopcion.getPet().getIdPet()).orElse(null);
            if (user != null && pet != null) {
                Location location = locationRepository.findByIdUser(user.getIdUser());
                ubicaciones.add(new UbicacionDTO(adopcion.getIdAdoption(), user.getNames() + " " + user.getLastNames(),
                        pet.getName(), location.getLatitude(), location.getLength()));
            }
        }

        return ubicaciones;
    }
}
