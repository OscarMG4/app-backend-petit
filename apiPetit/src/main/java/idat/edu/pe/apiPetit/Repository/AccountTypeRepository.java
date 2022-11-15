package idat.edu.pe.apiPetit.Repository;

import idat.edu.pe.apiPetit.Entity.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {

}
