package kk.kr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import kk.kr.data.FeedbackRepo;
import kk.kr.data.FoodRepo;
import kk.kr.data.OrderRepo;
import kk.kr.data.UserRepo;
import kk.kr.entities.Feedback;
import kk.kr.entities.Food;
import kk.kr.entities.Order;
import kk.kr.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class Lookup {

    UserRepo userRepo;
    FoodRepo foodRepo;
    OrderRepo orderRepo;
    FeedbackRepo feedbackRepo;
    
    @Autowired
    JdbcTemplate jdbc;
    
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }
    public List<Food> findAllFood() {
        return foodRepo.findAll();
    }
    public List<Order> findAllOrder() {
        return orderRepo.findAll();
    }
    public List<Feedback> findAllFeedback() {
        return feedbackRepo.findAll();
    }
    
    public User findUser(String username) {
        final String SELECT_AGENT_BY_ID = "SELECT * FROM user WHERE username = ?";
        User agent = jdbc.queryForObject(SELECT_AGENT_BY_ID, new UserMapper(), username);
        return agent;
    }
    public Food findFood(String name) {
        return foodRepo.findById(name).orElse(null);
    }
    public Order findOrder(int id) {
        return orderRepo.findById(id).orElse(null);
    }
    public Feedback findFeedback(int id) {
        return feedbackRepo.findById(id).orElse(null);
    }
    
    public final class UserMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int index) throws SQLException {
            User user = new User();
            user.setUsername(rs.getString("username"));
            user.setRealname(rs.getString("realname"));
            user.setPassword(rs.getString("password"));
            user.setPoints(Integer.parseInt(rs.getString("points")));
            return user;
        }
    }
}
