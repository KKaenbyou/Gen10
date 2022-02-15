package corbos.fieldagent.controller;

import corbos.fieldagent.data.AgencyRepository;
import corbos.fieldagent.dao.AgentDao;
import corbos.fieldagent.data.AgentRepository;
import corbos.fieldagent.data.AssignmentRepository;
import corbos.fieldagent.data.CountryRepository;
import corbos.fieldagent.data.SecurityClearanceRepository;
import corbos.fieldagent.entities.Agency;
import corbos.fieldagent.entities.Agent;
import corbos.fieldagent.entities.Assignment;
import corbos.fieldagent.entities.Country;
import corbos.fieldagent.entities.SecurityClearance;
import corbos.fieldagent.service.LookupService;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@EnableJpaRepositories
public class HomeController {

    @Autowired
    AgencyRepository agency;
    @Autowired
    AgentRepository agent;
    @Autowired
    AssignmentRepository assign;
    @Autowired
    CountryRepository country;
    @Autowired
    SecurityClearanceRepository clear;

    @Autowired
    AgentDao dao;
    @Autowired
    LookupService ls;
    Set<ConstraintViolation<Agent>> violations = new HashSet<>();
    Set<ConstraintViolation<Assignment>> assviolations = new HashSet<>();
    Set<String> stringError = new HashSet<>();

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("agent", agent.findAll());
        stringError.clear();
        violations.clear();
        assviolations.clear();
        return "home";
    }

    @GetMapping("inputError")
    public String error(Model model) {
        return "inputError";
    }

    @GetMapping("addAgent")
    public String addAgent(Model model) {
        List<Agency> agencyList = ls.findAllAgencies();
        List<SecurityClearance> securityClearanceList = ls.findAllSecurityClearances();
        model.addAttribute("errors", violations);
        model.addAttribute("agencyList", agencyList);
        model.addAttribute("securityClearanceList", securityClearanceList);
        model.addAttribute("stringError", stringError);
        return "addAgent";
    }

    @GetMapping("addAssignment")
    public String addAssignment(Model model) {
        List<Agency> agencyList = ls.findAllAgencies();
        List<SecurityClearance> securityClearanceList = ls.findAllSecurityClearances();
        List<Country> countryList = ls.findAllCountries();
        model.addAttribute("errors", violations);
        model.addAttribute("agentList", agent.findAll());
        model.addAttribute("countryList", countryList);
        model.addAttribute("agencyList", agencyList);
        model.addAttribute("securityClearanceList", securityClearanceList);
        model.addAttribute("stringError", stringError);
        return "addAssignment";
    }

    @PostMapping("newAgent")
    public String addAgent(HttpServletRequest request) {
        String identifier = request.getParameter("identifier");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String picturlUrl = request.getParameter("pictureURL");
        String birth = request.getParameter("birth");
        String height = request.getParameter("height");
        String activeDate = request.getParameter("activeDate");
        String isActive = request.getParameter("isActive");
        String agency = request.getParameter("agencyId");
        String security = request.getParameter("securityId");

        Agent agent = new Agent();
        try {
            agent.setIdentifier(identifier);
            agent.setFirstName(firstName);
            agent.setMiddleName(middleName);
            agent.setLastName(lastName);
            agent.setPictureUrl(picturlUrl);
            agent.setBirthDate(LocalDate.parse(birth));
            agent.setHeight(Integer.parseInt(height));
            agent.setActivationDate(LocalDate.parse(activeDate));
            try {
                if (isActive.equals("isActive")) {
                    agent.setActive(true);
                }
            } catch (NullPointerException e) {
                agent.setActive(false);
            }
            agent.setAgency(ls.findAgencyById(Integer.parseInt(agency)));
            agent.setSecurityClearance(ls.findSecurityClearanceById(Integer.parseInt(security)));
        } catch (DateTimeParseException | NumberFormatException e) {
            return "redirect:/inputError";
        }
        
         if(agent.getBirthDate().isBefore(LocalDate.parse("1900-01-01"))){
            stringError.add("Birth date can't be before 1900-01-01.");
            return "redirect:/addAgent";
        }
        if(agent.getBirthDate().isAfter(LocalDate.parse("2010-01-01"))){
            stringError.add("Birth date can't be after 2010-01-01.");
            return "redirect:/addAgent";
        }

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(agent);
        if (violations.isEmpty()) {
            dao.addAgent(agent);
            return "redirect:/";
        }
        return "redirect:/addAgent";
    }

    @PostMapping("newAssignment")
    public String newAassignment(HttpServletRequest request) {
        String agentS = request.getParameter("agent");
        String countryS = request.getParameter("country");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String actualDate = request.getParameter("actualDate");
        String notes = request.getParameter("notes");

        Assignment assignment = new Assignment();
        try {
            assignment.setAgent(dao.getAgent(agentS));
            assignment.setCountry(dao.getCountry(countryS));
            assignment.setStartDate(LocalDate.parse(startDate));
            assignment.setProjectedEndDate(LocalDate.parse(endDate));
            assignment.setNotes(notes);
        } catch (DateTimeParseException e) {
            return "redirect:/inputError";
        }
        try {
            assignment.setActualEndDate(LocalDate.parse(actualDate));
        } catch (DateTimeParseException e) {
            assignment.setActualEndDate(LocalDate.parse("9000-09-10"));
        }
        
        List<Assignment> assignmentList = assign.findByAgentIdentifier(agentS);
        for(int i = 0; i< assignmentList.size(); i++){
            if(assignment.getAssignmentId() != assignmentList.get(i).getAssignmentId()  ){
                if(assignment.getStartDate().isAfter(assignmentList.get(i).getStartDate())&& assignment.getStartDate().isBefore(assignmentList.get(i).getProjectedEndDate())){
                        stringError.add("Agent is already on assignment.");
                        return "redirect:/addAssignment";
                    }
                if(assignment.getProjectedEndDate().isAfter(assignmentList.get(i).getStartDate())&& assignment.getProjectedEndDate().isBefore(assignmentList.get(i).getProjectedEndDate())){
                        stringError.add("Agent is already on assignment.");
                        return "redirect:/addAssignment";
                    }
                if((assignment.getStartDate().compareTo(assignmentList.get(i).getStartDate()) == 0) || assignment.getStartDate().compareTo(assignmentList.get(i).getProjectedEndDate())==0){
                        stringError.add("Agent is already on assignment.");
                        return "redirect:/addAssignment";
                    }
                if((assignment.getProjectedEndDate().compareTo(assignmentList.get(i).getStartDate())==0)|| assignment.getProjectedEndDate().compareTo(assignmentList.get(i).getProjectedEndDate())==0){
                        stringError.add("Agent is already on assignment.");
                        return "redirect:/addAssignment";
                    }
                }   
            }
        if(assignment.getStartDate().isAfter((assignment.getProjectedEndDate()))){
            stringError.add("Start date can't be after projected end date.");
            return "redirect:/addAssignment";
        }
        if(assignment.getActualEndDate()!= null && assignment.getStartDate().compareTo(assignment.getActualEndDate())>0){
            stringError.add("Start date can't be after actual end date.");
            return "redirect:/addAssignment";
        }

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        assviolations = validate.validate(assignment);
        if (violations.isEmpty()) {
            dao.addAssignment(assignment);
        }
        return "redirect:/";
    }

    @GetMapping("deleteAgent")
    public String deleteAgent(HttpServletRequest request) {
        String id = request.getParameter("id");
        dao.deleteAssignmentbyId(id);
        dao.deleteAgent(id);
        return "redirect:/";
    }

    @GetMapping("editAgent")
    public String editAgent(String id, Model model) {
        Agent agent = dao.getAgent(id);
        String active;
        List<Agency> agencyList = ls.findAllAgencies();
        List<SecurityClearance> securityList = ls.findAllSecurityClearances();
        List<Assignment> assignments = assign.findByAgentIdentifier(id);
        for (int i = 0; i < assignments.size(); i++) {
            assign.findById(assignments.get(i).getAssignmentId());
        }
        if (agent.isActive() == true) {
            active = "Active";
        } else {
            active = "Inactive";
        }
        model.addAttribute("errors", violations);
        model.addAttribute("agent", agent);
        model.addAttribute("agencyList", agencyList);
        model.addAttribute("securityClearanceList", securityList);
        model.addAttribute("assignList", assignments);
        model.addAttribute("agentIsActive", active);
        model.addAttribute("stringError", stringError);
        return "editAgent";
    }

    @GetMapping("editAssignment")
    public String editAssignment(String id, String identifier, Model model) {
        Agent agentS = dao.getAgent(identifier);
        Assignment assign = dao.getAssign(id);
        List<Country> countryList = ls.findAllCountries();
        List<Agent> agentList = agent.findAll();

        model.addAttribute("agent", agentS);
        model.addAttribute("errors", violations);
        model.addAttribute("assign", assign);
        model.addAttribute("countryList", countryList);
        model.addAttribute("agentList", agentList);
        model.addAttribute("stringError", stringError);
        return "editAssignment";
    }

    @PostMapping("editedAgent")
    public String editAgent(HttpServletRequest request) {
        String identifier = request.getParameter("identifier");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String picturlUrl = request.getParameter("pictureURL");
        String birth = request.getParameter("birth");
        String height = request.getParameter("height");
        String activeDate = request.getParameter("activeDate");
        String isActive = request.getParameter("isActive");
        String agency = request.getParameter("agencyId");
        String security = request.getParameter("securityId");

        Agent agent = new Agent();
        try {
            agent.setIdentifier(identifier);
            agent.setFirstName(firstName);
            agent.setMiddleName(middleName);
            agent.setLastName(lastName);
            agent.setPictureUrl(picturlUrl);
            agent.setBirthDate(LocalDate.parse(birth));
            agent.setHeight(Integer.parseInt(height));
            agent.setActivationDate(LocalDate.parse(activeDate));
            try {
                if (isActive.equals("isActive")) {
                    agent.setActive(true);
                }
            } catch (NullPointerException e) {
                agent.setActive(false);
            }
            agent.setAgency(ls.findAgencyById(Integer.parseInt(agency)));
            agent.setSecurityClearance(ls.findSecurityClearanceById(Integer.parseInt(security)));
        } catch (DateTimeParseException | NumberFormatException e) {
            return "redirect:/inputError";
        }
        
        if(agent.getBirthDate().isBefore(LocalDate.parse("1900-01-01"))){
            stringError.add("Birth date can't be before 1900-01-01.");
            return "redirect:editAgent?id=" + agent.getIdentifier();
        }
        if(agent.getBirthDate().isAfter(LocalDate.parse("2010-01-01"))){
            stringError.add("Birth date can't be after 2010-01-01.");
            return "redirect:editAgent?id=" + agent.getIdentifier();
        }

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(agent);
        if (violations.isEmpty()) {
            dao.updateAgent(agent);
        }
        return "redirect:/editAgent?id=" + agent.getIdentifier();
    }

    @PostMapping("editedAssignment")
    public String editAssignment(HttpServletRequest request) {
        String assignId = request.getParameter("assignmentId");
        String agentS = request.getParameter("agent");
        String countryS = request.getParameter("country");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String actualDate = request.getParameter("actualDate");
        String notes = request.getParameter("notes");

        Assignment assignment = new Assignment();
        assignment.setAssignmentId(Integer.parseInt(assignId));
        try {
            assignment.setAgent(dao.getAgent(agentS));
            assignment.setCountry(dao.getCountry(countryS));
            assignment.setStartDate(LocalDate.parse(startDate));
            assignment.setProjectedEndDate(LocalDate.parse(endDate));
            assignment.setNotes(notes);
        } catch (DateTimeParseException e) {
            return "redirect:/inputError";
        }
        try {
            assignment.setActualEndDate(LocalDate.parse(actualDate));
        } catch (DateTimeParseException e) {
            assignment.setActualEndDate(LocalDate.parse("9000-09-10"));
        }
        
        List<Assignment> assignmentList = assign.findByAgentIdentifier(agentS);
        for(int i = 0; i< assignmentList.size(); i++){
            if(assignment.getAssignmentId() != assignmentList.get(i).getAssignmentId()  ){
                if(assignment.getStartDate().isAfter(assignmentList.get(i).getStartDate())&& assignment.getStartDate().isBefore(assignmentList.get(i).getProjectedEndDate())){
                        stringError.add("Agent is already on assignment.");
                        return "redirect:/editAssignment?id=" + assignment.getAssignmentId() + "&identifier=" + agentS;
                    }
                if(assignment.getProjectedEndDate().isAfter(assignmentList.get(i).getStartDate())&& assignment.getProjectedEndDate().isBefore(assignmentList.get(i).getProjectedEndDate())){
                        stringError.add("Agent is already on assignment.");
                        return "redirect:/editAssignment?id=" + assignment.getAssignmentId() + "&identifier=" + agentS;
                    }
                if((assignment.getStartDate().compareTo(assignmentList.get(i).getStartDate()) == 0) || assignment.getStartDate().compareTo(assignmentList.get(i).getProjectedEndDate())==0){
                        stringError.add("Agent is already on assignment.");
                        return "redirect:/editAssignment?id=" + assignment.getAssignmentId() + "&identifier=" + agentS;
                    }
                if((assignment.getProjectedEndDate().compareTo(assignmentList.get(i).getStartDate())==0)|| assignment.getProjectedEndDate().compareTo(assignmentList.get(i).getProjectedEndDate())==0){
                        stringError.add("Agent is already on assignment.");
                        return "redirect:/editAssignment?id=" + assignment.getAssignmentId() + "&identifier=" + agentS;
                    }
                }   
            }
        if(assignment.getStartDate().isAfter((assignment.getProjectedEndDate()))){
            stringError.add("Start date can't be after projected end date.");
            return "redirect:/editAssignment?id=" + assignment.getAssignmentId() + "&identifier=" + agentS;
        }
        if(assignment.getActualEndDate()!= null && assignment.getStartDate().compareTo(assignment.getActualEndDate())>0){
            stringError.add("Start date can't be after actual end date.");
            return "redirect:/editAssignment?id=" + assignment.getAssignmentId() + "&identifier=" + agentS;
        }

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        assviolations = validate.validate(assignment);
        if (violations.isEmpty()) {
            dao.updateAssignment(assignment);
        }
        return "redirect:/";
    }

    @GetMapping("deleteAssignment")
    public String deleteAssignment(HttpServletRequest request) {
        String id = request.getParameter("id");
        dao.deleteAssignment(id);
        return "redirect:/";
    }

    @PostMapping("cancel")
    public String cancel(HttpServletRequest request) {
        return "redirect:/";
    }
}
