package idat.edu.pe.apiPetit.Service.Implement;

import idat.edu.pe.apiPetit.Dto.AdoptionDTO;
import idat.edu.pe.apiPetit.Entity.Adoption;
import idat.edu.pe.apiPetit.Entity.Pet;
import idat.edu.pe.apiPetit.Entity.State;
import idat.edu.pe.apiPetit.Entity.User;
import idat.edu.pe.apiPetit.Exceptions.AppException;
import idat.edu.pe.apiPetit.Exceptions.ResourceNotFoundException;
import idat.edu.pe.apiPetit.Repository.AdoptionRepository;
import idat.edu.pe.apiPetit.Repository.PetRepository;
import idat.edu.pe.apiPetit.Repository.StateRepository;
import idat.edu.pe.apiPetit.Repository.UserRepository;
import idat.edu.pe.apiPetit.Service.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdoptionSeviceImp implements AdoptionService {

    @Autowired
    private AdoptionRepository adoptionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private StateRepository stateRepository;

    private AdoptionDTO mappingDTO(Adoption adoption){
        AdoptionDTO adoptionDTO = new AdoptionDTO();

        adoptionDTO.setId(adoption.getIdAdoption());
        adoptionDTO.setDescription(adoption.getDescription());

        return adoptionDTO;
    }

    private Adoption mappingEntity(AdoptionDTO adoptionDTO){
        Adoption adoption = new Adoption();

        adoption.setIdAdoption(adoptionDTO.getId());
        adoption.setDescription(adoptionDTO.getDescription());

        return adoption;
    }

    @Override
    public AdoptionDTO createAdoption(Integer idPet, Integer idState, Integer idUser, AdoptionDTO adoptionDTO) {
        Adoption adoption = mappingEntity(adoptionDTO);

        Pet pet = petRepository.findById(idPet).orElseThrow(()-> new ResourceNotFoundException("Pet", "id", idPet));
        State state = stateRepository.findById(idState).orElseThrow(()-> new ResourceNotFoundException("State", "id", idState));
        User user = userRepository.findById(idUser).orElseThrow(()-> new ResourceNotFoundException("User", "id", idUser));

        adoption.setPet(pet);
        adoption.setState(state);
        adoption.setUser(user);

        Adoption newAdoption = adoptionRepository.save(adoption);
        AdoptionDTO adoptionResponse = mappingDTO(newAdoption);

        return adoptionResponse;
    }

    @Override
    public List<AdoptionDTO> showAdoptionsByUserId(Integer userId) {
        List<Adoption> adoptions = adoptionRepository.findByIdUser(userId);
        return adoptions.stream().map(adoption -> mappingDTO(adoption)).collect(Collectors.toList());
    }

    @Override
    public AdoptionDTO showAdoptionById(Integer idUser, Integer idAdoption) {
        User user = userRepository.findById(idUser).orElseThrow(()-> new ResourceNotFoundException("User", "id", idUser));
        Adoption adoption = adoptionRepository.findById(idAdoption).orElseThrow(()-> new ResourceNotFoundException("Adoption", "id", idAdoption));

        if(!adoption.getUser().getIdUser().equals(user.getIdUser())){
            throw new AppException(HttpStatus.BAD_REQUEST, "EL registro de adopción no existe!");
        }

        return mappingDTO(adoption);
    }

    @Override
    public AdoptionDTO updateAdoption(Integer idUser, Integer idAdoption, AdoptionDTO adoptionDTO) {
        User user = userRepository.findById(idUser).orElseThrow(()-> new ResourceNotFoundException("User", "id", idUser));
        Adoption adoption = adoptionRepository.findById(idAdoption).orElseThrow(()-> new ResourceNotFoundException("Adoption", "id", idAdoption));

        if(!adoption.getUser().getIdUser().equals(user.getIdUser())){
            throw new AppException(HttpStatus.BAD_REQUEST, "EL registro de adopción no existe!");
        }

        adoption.setDescription(adoptionDTO.getDescription());

        Adoption newAdoption = adoptionRepository.save(adoption);
        AdoptionDTO responseAdoption = mappingDTO(newAdoption);

        return responseAdoption;
    }

    @Override
    public void deleteAdoption(Integer idUser, Integer idAdoption) {
        User user = userRepository.findById(idUser).orElseThrow(()-> new ResourceNotFoundException("User", "id", idUser));
        Adoption adoption = adoptionRepository.findById(idAdoption).orElseThrow(()-> new ResourceNotFoundException("Adoption", "id", idAdoption));

        if(!adoption.getUser().getIdUser().equals(user.getIdUser())){
            throw new AppException(HttpStatus.BAD_REQUEST, "EL registro de adopción no existe!");
        }

        adoptionRepository.delete(adoption);
    }
}
