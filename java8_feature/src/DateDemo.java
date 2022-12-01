import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateDemo {
    public static void main(String[] args) {
        System.out.println("-----------------basic-----------------");
        basic();
        System.out.println("-----------------format-----------------");
        format();
        System.out.println("-----------------chain-----------------");
        chain();
        System.out.println("-----------------revise-----------------");
        revise();
        System.out.println("-----------------time interval-----------------");
        timeInterval();
    }

    private static void timeInterval() {
        LocalDateTime start = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        LocalDateTime end = LocalDateTime.of(2020, 1, 9, 19, 25, 30);
        Duration duration = Duration.between(start, end);
        System.out.println(Duration.parse(duration.toString()));

        Period p = LocalDate.of(2019, 11, 19).until(LocalDate.of(2020, 1, 9));
        System.out.println(p);
    }

    /*
    会对日期做自动的调整，将没有31号的变成30号
     */
    private static void revise() {
        LocalDateTime dateTime = LocalDateTime.of(2019, 10, 26, 20, 30, 59);
        System.out.println(dateTime);
        LocalDateTime dateTime1 = dateTime.withDayOfMonth(31);
        System.out.println(dateTime1);
        LocalDateTime dateTime2 = dateTime1.withMonth(9);
        System.out.println(dateTime2);
    }

    private static void chain() {
        LocalDateTime dateTime = LocalDateTime.of(2019, 10, 26, 20, 30, 59);
        System.out.println(dateTime);
        //加5天减3小时
        LocalDateTime dateTime1 = dateTime.plusDays(5).minusHours(3);
        System.out.println(dateTime1);
        //减1月
        LocalDateTime dateTime2 = dateTime1.minusMonths(1);
        System.out.println(dateTime2);
    }

    private static void format() {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(pattern.format(LocalDateTime.now()));
        LocalDateTime localDateTime = LocalDateTime.parse("2019/11/30 15:16:17", pattern);
        System.out.println(localDateTime);
    }

    private static void basic() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localDateTime.toLocalDate());
        System.out.println(localTime);
        System.out.println(localDateTime.toLocalTime());
        System.out.println(LocalDateTime.of(2022, 11, 30, 13, 23, 12));
        System.out.println(localDateTime);
    }
}
