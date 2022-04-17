package edu.miu.cs545.waa.repository;

import edu.miu.cs545.waa.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
  User findByEmail(String email);
}
