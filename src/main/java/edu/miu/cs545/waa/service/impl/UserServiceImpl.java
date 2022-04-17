package edu.miu.cs545.waa.service.impl;

import edu.miu.cs545.waa.domain.User;
import edu.miu.cs545.waa.enums.Role;
import edu.miu.cs545.waa.repository.UserRepository;
import edu.miu.cs545.waa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void updateBuyerRewardPoint(String userId) {
        User user = userRepository.findByUserIdAndRole(userId, Role.BUYER);
        user.setRewardPoint(user.getRewardPoint() + 100);
        userRepository.save(user);
    }
}
