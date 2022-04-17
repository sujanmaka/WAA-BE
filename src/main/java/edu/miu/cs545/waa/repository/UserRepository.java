package edu.miu.cs545.waa.repository;

import edu.miu.cs545.waa.domain.User;
import edu.miu.cs545.waa.enums.Role;
import edu.miu.cs545.waa.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRoleAndStatus(Role role, Status status);

    List<User> findByRole(Role role);

    User findByIdAndRole(Long id, Role role);

    User findByUserIdAndRole(String userId, Role role);
}
