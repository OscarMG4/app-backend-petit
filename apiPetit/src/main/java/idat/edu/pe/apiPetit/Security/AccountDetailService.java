package idat.edu.pe.apiPetit.Security;

import idat.edu.pe.apiPetit.Entity.Account;
import idat.edu.pe.apiPetit.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountDetailService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         Account account = accountRepository.findByAccount(username);

        if(account != null){
            List <GrantedAuthority> listGranted = new ArrayList<>();

            for (int i = 0; i < account.getRoles().size(); i++) {
                listGranted.add(new SimpleGrantedAuthority(account.getRoles().get(i).getRole()));
            }

            GrantedAuthority granted = new SimpleGrantedAuthority(account.getRoles().toString());
            return new User(
                    account.getEmail(),
                    account.getPass(),
                    listGranted);


        } else {
            throw new UsernameNotFoundException("Cuenta con correo " + "'" + username + "'" + " no existe.");
        }
    }
}
