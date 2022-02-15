// @author Kenji Kaenbyou

package kk.milestone3test;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class Milestone3 {
    
    public static void main(String[] args) {
        
        // Date Stuff
        LocalDate ld = LocalDate.now();
        LocalDate past = ld.minusDays(9);
        LocalDate future = ld.plusDays(9);
        Period difference = ld.until(past);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate ld2 = LocalDate.parse("02/07/2010", formatter);
        String formatted = ld.format(formatter);
        String formatted2 = past.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        
        Date legacyDate = new Date();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(legacyDate.toInstant(), ZoneId.systemDefault());
        ld = zdt.toLocalDate();
        
        System.out.println(past + " \n" + future + " \n" + difference + " \n" + ld2 + " \n "
                + formatted + " \n" + formatted2 + " \n" + ld);
        
        // Lambda Stuff
        Predicate<Person> oldEnoughToVote = p -> p.getAge() >= 18;
        Consumer<Person> howOld = p -> System.out.println(p.getName() + " is " + p.getAge() + " years old.");
        // ToIntFunction<Person> toAge = p -> p.getAge();
        ToIntFunction<Person> toAge = Person::getAge;
        
        ServerDao dao = new ServerDaoInMemImpl();
        List<Server> dells = dao.getServersByManufacturer("Dell");
        for(Server currentServer : dells) {
            System.out.println(currentServer.getName());
        }

        dells.stream().forEach(s -> System.out.println(s.getName()));
    }
}