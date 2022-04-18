package edu.miu.cs545.waa.repository;

import edu.miu.cs545.waa.domain.User;
import edu.miu.cs545.waa.enums.RoleType;
import edu.miu.cs545.waa.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u JOIN u.roles r where r.roleType=?1 and u.status=?2")
    List<User> findByRoleTypeAndStatus(RoleType roleType, Status status);

    @Query("select u from User u JOIN u.roles r where r.roleType=?1")
    List<User> findByRoleType(RoleType roleType);

    @Query("select u from User u JOIN u.roles r where u.id=?1 and r.roleType=?2")
    User findByIdAndRoleType(Long id, RoleType roleType);

}
