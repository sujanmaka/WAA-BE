package edu.miu.cs545.waa.service.impl;

import edu.miu.cs545.waa.domain.Role;
import edu.miu.cs545.waa.domain.User;
import edu.miu.cs545.waa.repository.RoleRepo;
import edu.miu.cs545.waa.repository.UserRepo;
import edu.miu.cs545.waa.service.UserService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service class for user
 *
 * @version 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

  private final UserRepo userRepo;
  private final RoleRepo roleRepo;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo,
      PasswordEncoder passwordEncoder) {
    this.userRepo = userRepo;
    this.roleRepo = roleRepo;
    this.passwordEncoder = passwordEncoder;
  }

  /**
   * Persist the data in the database
   *
   * @param user to save
   */
  @Override
  public void save(User user) {
    List<Role> roleList = (List<Role>) roleRepo.findAll();
    user.setRoles(roleList);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepo.save(user);
  }

  /**
   * Delete the specific object by id
   *
   * @param id of object
   */
  @Override
  public void deleteById(long id) {
    userRepo.deleteById(id);
  }

  /**
   * @return list of all objects
   */
  @Override
  public List<User> getAll() {
    return (List<User>) userRepo.findAll();
  }

  /**
   * Find the object by id
   *
   * @param id of object
   * @return T
   */
  @Override
  public User findById(long id) {
    Optional<User> user = userRepo.findById(id);
    return user.orElse(null);
  }

  /**
   * find UserDetails by username
   *
   * @param username in our case is email
   * @return UserDetails to verify user
   * @throws UsernameNotFoundException
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepo.findByEmail(username);
    if (user != null) {
      List<String> roles = user.getRoles().stream().map(Role::getRole).collect(Collectors.toList());
      return new org.springframework.security.core.userdetails.User(user.getEmail(),
          user.getPassword(),
          AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",", roles)));
    } else {
      throw new UsernameNotFoundException(username);
    }
  }
}
