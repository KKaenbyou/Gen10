package kk.kr.dao;

import kk.kr.data.FeedbackRepo;
import kk.kr.data.FoodRepo;
import kk.kr.data.OrderRepo;
import kk.kr.data.UserRepo;
import kk.kr.entities.Feedback;
import kk.kr.entities.Order;
import kk.kr.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@EnableJpaRepositories
@Service
public class KDao {

    @Autowired
    UserRepo userRepo;
    @Autowired
    FoodRepo foodRepo;
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    FeedbackRepo feedbackRepo;
    
    @Autowired
    Lookup lookup;
    @Autowired
    JdbcTemplate jdbc;
    
    @Transactional
    public Feedback addFeedback(Feedback feedback) {
        final String fbString = "INSERT INTO feedback(userfeedback) "
                + "VALUES(?)";
        jdbc.update(fbString,
                feedback.getUserfeedback());
        return feedback;
    }
    
    @Transactional
    public Order addOrder(Order order) {
        final String orderString = "INSERT INTO `order`(username, total) "
                + "VALUES(?,?)";
        System.out.println(orderString);
        jdbc.update(orderString,
                order.getUser().getUsername(),
                order.getTotal());
        return order;
    }
    
    @Transactional
    public User addUser(User user) {
        final String userString = "INSERT INTO `user`(username, realname, password) "
                + "VALUES(?,?,?)";
        System.out.println(userString);
        jdbc.update(userString,
                user.getUsername(),
                user.getRealname(),
                user.getPassword());
        return user;
    }
}
