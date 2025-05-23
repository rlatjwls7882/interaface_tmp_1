package kr.kro.interface_web.service;

import kr.kro.interface_web.domain.User;
import kr.kro.interface_web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void createUser(String id, String name, String content) {
        User user = new User(id, name, content);
        userRepository.save(user);
    }

    public boolean existsUser(String id) {
        return userRepository.existsById(id);
    }

    public User getUser() {
        List<User> users = (List<User>) userRepository.findAll();
        return users.get(users.size() - 1);
    }

    public void updateUser(String userId, String content) {
        User user = userRepository.findById(userId).orElse(null);
        user.update(content);
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
