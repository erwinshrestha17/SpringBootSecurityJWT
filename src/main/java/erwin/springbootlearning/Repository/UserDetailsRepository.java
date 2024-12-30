package erwin.springbootlearning.Repository;

import erwin.springbootlearning.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<Users,Long> {

    Users findByUsername(String username);
}
