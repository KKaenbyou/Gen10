package corbos.fieldagent.dao;

import corbos.fieldagent.data.AgentRepository;
import corbos.fieldagent.entities.Agent;
import corbos.fieldagent.entities.Assignment;
import corbos.fieldagent.entities.Country;
import corbos.fieldagent.service.LookupService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@EnableJpaRepositories
@Service
public class AgentDao {
    
    AgentRepository agent;
    @Autowired
    JdbcTemplate jdbc;
    @Autowired
    LookupService ls;
    
    @Transactional
    public Agent addAgent(Agent agent) {
        final String INSERT_AGENT = "INSERT INTO agent(identifier, first_name, middle_name, last_name, "
                + "picture_url, birth_date, height, activation_date, is_active, agency_id, security_clearance_id) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        jdbc.update(INSERT_AGENT,
                agent.getIdentifier(),
                agent.getFirstName(),
                agent.getMiddleName(),
                agent.getLastName(),
                agent.getPictureUrl(),
                agent.getBirthDate(),
                agent.getHeight(),
                agent.getActivationDate(),
                agent.isActive(),
                agent.getAgency().getAgencyId(),
                agent.getSecurityClearance().getSecurityClearanceId());
        return agent;
    }
    
    @Transactional
    public Assignment addAssignment(Assignment assign) {
        final String INSERT_AGENT = "INSERT INTO assignment(identifier, country_code, start_date, projected_end_date, actual_end_date, "
                + "notes) "
                + "VALUES(?,?,?,?,?,?)";
        jdbc.update(INSERT_AGENT,
                assign.getAgent().getIdentifier(),
                assign.getCountry().getCountryCode(),
                assign.getStartDate(),
                assign.getProjectedEndDate(),
                assign.getActualEndDate(),
                assign.getNotes());
        return assign;
    }

    @Transactional
    public void deleteAgent(String id) {
        final String DELETE_AGENT = "DELETE FROM agent WHERE identifier = ?";
        jdbc.update(DELETE_AGENT, id);
    }
    
    @Transactional
    public void deleteAssignment(String id) {
        final String DELETE_ASSIGNMENT = "DELETE FROM assignment WHERE assignment_Id = ?";
        jdbc.update(DELETE_ASSIGNMENT, id);
    }
    
    @Transactional
    public void deleteAssignmentbyId(String id) {
        final String DELETE_ASSIGNMENT = "DELETE FROM assignment WHERE identifier = ?";
        jdbc.update(DELETE_ASSIGNMENT, id);
    }

    public Agent getAgent(String id) {
        final String SELECT_AGENT_BY_ID = "SELECT * FROM agent WHERE identifier = ?";
        Agent agent = jdbc.queryForObject(SELECT_AGENT_BY_ID, new AgentMapper(), id);
        return agent;
    }
    
    public Assignment getAssign(String id) {
        final String SELECT_ASSIGNMENT_BY_ID = "SELECT * FROM assignment WHERE assignment_id = ?";
        Assignment assign = jdbc.queryForObject(SELECT_ASSIGNMENT_BY_ID, new AssignMapper(), id);
        return assign;
    }
    
    public Assignment findByAgentIdentifier(String id) {
        final String SELECT_ASSIGNMENT_BY_ID = "SELECT * FROM assignment WHERE identifier = ?";
        Assignment assign = jdbc.queryForObject(SELECT_ASSIGNMENT_BY_ID, new AssignMapper(), id);
        return assign;
    }
    
    public Country getCountry(String id) {
        final String SELECT_COUNTRY_BY_ID = "SELECT * FROM country WHERE country_code = ?";
        Country country = jdbc.queryForObject(SELECT_COUNTRY_BY_ID, new CountryMapper(), id);
        return country;
    }
    
    @Transactional
    public void updateAgent(Agent agent) {
        final String UPDATE_AGENT = "UPDATE agent SET identifier = ?, first_name = ?, middle_name = ?, last_name = ?, "
                + "picture_url = ?, birth_date = ?, height = ?, activation_date = ?, is_active = ?, agency_id = ?, security_clearance_id = ? WHERE identifier = ?";
        jdbc.update(UPDATE_AGENT,
                agent.getIdentifier(),
                agent.getFirstName(),
                agent.getMiddleName(),
                agent.getLastName(),
                agent.getPictureUrl(),
                agent.getBirthDate(),
                agent.getHeight(),
                agent.getActivationDate(),
                agent.isActive(),
                agent.getAgency().getAgencyId(),
                agent.getSecurityClearance().getSecurityClearanceId(),
                agent.getIdentifier());
    }
    
    @Transactional
    public void updateAssignment(Assignment assign) {
        final String UPDATE_AGENT = "UPDATE assignment SET start_date = ?, projected_end_date = ?, actual_end_date = ?, notes = ?, "
                + "country_code = ?, identifier = ? WHERE assignment_id = ?";
        jdbc.update(UPDATE_AGENT,                
                assign.getStartDate(),
                assign.getProjectedEndDate(),
                assign.getActualEndDate(),
                assign.getNotes(),
                assign.getCountry().getCountryCode(),
                assign.getAgent().getIdentifier(),
                assign.getAssignmentId());
    }

    public final class AgentMapper implements RowMapper<Agent> {
        @Override
        public Agent mapRow(ResultSet rs, int index) throws SQLException {
            Agent agent = new Agent();
            agent.setIdentifier(rs.getString("identifier"));
            agent.setFirstName(rs.getString("first_Name"));
            agent.setMiddleName(rs.getString("middle_Name"));
            agent.setLastName(rs.getString("last_Name"));
            agent.setPictureUrl(rs.getString("picture_url"));
            agent.setBirthDate(LocalDate.parse(rs.getString("birth_date")));
            agent.setHeight(Integer.parseInt(rs.getString("height")));
            agent.setActivationDate(LocalDate.parse(rs.getString("activation_date")));
            if(Integer.parseInt(rs.getString("is_active")) == 1) {
                agent.setActive(true);
            } else {
                agent.setActive(false);
            }
            agent.setAgency(ls.findAgencyById(Integer.parseInt(rs.getString("agency_id"))));
            agent.setSecurityClearance(ls.findSecurityClearanceById(Integer.parseInt(rs.getString("security_clearance_id"))));
            return agent;
        }
    }

    public final class AssignMapper implements RowMapper<Assignment> {
        @Override
        public Assignment mapRow(ResultSet rs, int index) throws SQLException {
            Assignment assign = new Assignment();
            assign.setAssignmentId(Integer.parseInt(rs.getString("assignment_id")));
            assign.setStartDate(LocalDate.parse(rs.getString("start_date")));
            assign.setProjectedEndDate(LocalDate.parse(rs.getString("projected_end_date")));
            try {
                assign.setActualEndDate(LocalDate.parse(rs.getString("actual_end_date")));
            } catch (NullPointerException e) {
                assign.setActualEndDate(LocalDate.parse("9000-09-10"));
            }
            try {
                assign.setNotes(rs.getString("notes"));
            } catch (NullPointerException e) {
                assign.setNotes("");
            }
            assign.setAgent(getAgent(rs.getString("identifier")));
            assign.setCountry(ls.findCountryByCode(rs.getString("country_code")));
            return assign;
        }
    }
    
    public final class CountryMapper implements RowMapper<Country> {
        @Override
        public Country mapRow(ResultSet rs, int index) throws SQLException {
            Country country = new Country();
            country.setCountryCode(rs.getString("country_code"));
            country.setName(rs.getString("name"));
            return country;
        }
    }
}
