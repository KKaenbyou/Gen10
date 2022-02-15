package kk.kr.controller;

import java.util.HashSet;;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import kk.kr.dao.KDao;
import kk.kr.dao.Lookup;
import kk.kr.data.FeedbackRepo;
import kk.kr.data.FoodRepo;
import kk.kr.data.OrderRepo;
import kk.kr.data.UserRepo;
import kk.kr.entities.Feedback;
import kk.kr.entities.Order;
import kk.kr.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@EnableJpaRepositories
public class Kontroller {

    @Autowired
    UserRepo userRepo;
    @Autowired
    FoodRepo foodRepo;
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    FeedbackRepo feedbackRepo;

    @Autowired
    KDao dao;
    @Autowired
    Lookup lookup;
    
    Set<ConstraintViolation<User>> violations = new HashSet<>();
    Set<String> stringError = new HashSet<>();

    @GetMapping("")
    public String kr() {
        violations.clear();
        stringError.clear();
        return "kr";
    }

    @GetMapping("kr")
    public String kr2() {
        violations.clear();
        stringError.clear();
        return "kr";
    }

    @GetMapping("menu")
    public String menu(Model model) {
        model.addAttribute("errors", violations);
        model.addAttribute("stringError", stringError);
        model.addAttribute("food", foodRepo.findAll());
        return "menu";
    }

    @GetMapping("feedback")
    public String feedback() {
        return "feedback";
    }
    
    @GetMapping("loginmenu")
    public String loginmenu(Model model, String id) {
        model.addAttribute("errors", violations);
        model.addAttribute("stringError", stringError);
        model.addAttribute("food", foodRepo.findAll());
        model.addAttribute("user", lookup.findUser(id));
        return "loginmenu";
    }
    
    @GetMapping("newaccount")
    public String newAccount(Model model) {
        model.addAttribute("errors", violations);
        model.addAttribute("stringError", stringError);
        return "newaccount";
    }

    @PostMapping("addFeedback")
    public String addFeedback(HttpServletRequest request) {
        String feedbackinfo = request.getParameter("feedback");
        
        Feedback feedback = new Feedback();
        feedback.setUserfeedback(feedbackinfo);
        
        dao.addFeedback(feedback);
        return "redirect:/feedback";
    }
    
    @PostMapping("order")
    public String order(HttpServletRequest request, Model model) {
        String chickq = request.getParameter("Chickenq");
        String beefq = request.getParameter("Beefq");
        String porkq = request.getParameter("Porkq");
        String chickp = request.getParameter("Chickenp");
        String beefp = request.getParameter("Beefp");
        String porkp = request.getParameter("Porkp");
        
        int total = Integer.parseInt(chickq)*Integer.parseInt(chickp) + 
                Integer.parseInt(beefq)*Integer.parseInt(beefp) + 
                Integer.parseInt(porkq)*Integer.parseInt(porkp);
        
        if(total == 0){
                stringError.add("No items selected.");
                return "redirect:menu";
            }
        
        model.addAttribute("total", total);
        return "order";
    }
    
    @PostMapping("loginorder")
    public String loginorder(HttpServletRequest request, Model model) {
        String chickq = request.getParameter("Chickenq");
        String beefq = request.getParameter("Beefq");
        String porkq = request.getParameter("Porkq");
        String chickp = request.getParameter("Chickenp");
        String beefp = request.getParameter("Beefp");
        String porkp = request.getParameter("Porkp");
        String id = request.getParameter("id");
        
        int total = Integer.parseInt(chickq)*Integer.parseInt(chickp) + 
                Integer.parseInt(beefq)*Integer.parseInt(beefp) + 
                Integer.parseInt(porkq)*Integer.parseInt(porkp);
        
        if(total == 0){
                stringError.add("No items selected.");
                return "redirect:loginmenu?id=" + id;
            }
        
        model.addAttribute("user", lookup.findUser(id));
        model.addAttribute("total", total);
        return "loginorder";
    }
    
    @PostMapping("placeOrder")
    public String placeOrder(HttpServletRequest request) {
        String orderTotal = request.getParameter("orderTotal");
        
        Order order = new Order();
        order.setTotal(Integer.parseInt(orderTotal));
        order.setUser(lookup.findUser("Guest"));
        
        dao.addOrder(order);
        return "redirect:/kr";
    }
    
    @PostMapping("placeloginorder")
    public String placeloginorder(HttpServletRequest request) {
        String orderTotal = request.getParameter("orderTotal");
        String id = request.getParameter("id");
        
        Order order = new Order();
        order.setTotal(Integer.parseInt(orderTotal));
        order.setUser(lookup.findUser(id));
        
        dao.addOrder(order);
        return "redirect:/kr";
    }
    
    @PostMapping("newuser")
    public String newUser(HttpServletRequest request) {
        String username = request.getParameter("username");
        String realname = request.getParameter("realname");
        String password = request.getParameter("password");
        
        User user = new User();
        user.setUsername(username);
        user.setRealname(realname);
        user.setPassword(password);
        
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(user);
        
        if (violations.isEmpty()) {
            violations.clear();
            stringError.clear();
            dao.addUser(user);
            return "redirect:menu";
        }
        return "redirect:newaccount";
    }
    
    @PostMapping("login")
    public String login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        try {
            User user = lookup.findUser(username);
            if(!user.getPassword().equals(password)){
                stringError.add("Password does not match.");
                return "redirect:menu";
            }
        } catch(EmptyResultDataAccessException e) {
            stringError.add("User does not exist.");
            return "redirect:menu";
        }
        
        if (violations.isEmpty()) {
            violations.clear();
            stringError.clear();
            return "redirect:loginmenu?id=" + lookup.findUser(username).getUsername();
        }
        return "redirect:menu";
    }
}
