package erwin.springbootlearning.Service;

import erwin.springbootlearning.Entity.UserPrinciple;
import erwin.springbootlearning.Entity.Users;
import erwin.springbootlearning.Repository.UserDetailsRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailService implements UserDetailsService {
    private final UserDetailsRepository userDetailsRepository;
    public UserDetailService(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Users users =userDetailsRepository.findByUsername(username);
        if (users==null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrinciple(users);
    }


}
