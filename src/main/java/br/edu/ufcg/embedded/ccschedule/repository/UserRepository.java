package br.edu.ufcg.embedded.ccschedule.repository;

import br.edu.ufcg.embedded.ccschedule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
