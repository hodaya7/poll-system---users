package com.pollsSystem.pollsSystem.service;

import com.pollsSystem.pollsSystem.model.PollAnswerFromPollAnswerService;
import com.pollsSystem.pollsSystem.model.User;
import com.pollsSystem.pollsSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.createUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public void updateUserById(Long userId, User user) {
        userRepository.updateUserById(userId, user);
    }

    @Autowired PollAnswerExternalService pollAnswerExternalService;
    @Override
    public void deleteUser(Long id) throws Exception {
        if (userRepository.getUserById(id) != null){
           List<PollAnswerFromPollAnswerService> responsePollAnswers= pollAnswerExternalService.getPollAnswersByUserId(id);
            for (PollAnswerFromPollAnswerService pollAnswer : responsePollAnswers) {
                // שליפת ה-answer_number של התשובה
                Long answerNumber = pollAnswer.getAnswerNumber();

                // קריאה לשירות החיצוני למחיקת התשובה לפי answer_number
                pollAnswerExternalService.deletePollAnswerById(answerNumber);
            }
            userRepository.deleteUser(id);
        }
        else
            throw new Exception("user is not exists");
    }

    @Override
    public String getUserNameById(Long userId) {
        return userRepository.getUserNameById(userId);
    }
}
