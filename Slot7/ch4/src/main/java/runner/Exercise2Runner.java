package runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pojo.Course;
import pojo.Student;
import service.CourseService;
import service.EnrollmentService;
import service.StudentService;

import java.util.Collection;

@Component
@Order(3)
@Profile("ex2")
@RequiredArgsConstructor
public class Exercise2Runner implements CommandLineRunner {

    // CHI inject Service interface
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;
    private final StudentService studentService;          // cua Exercise 1 (TODO 16a, 21)

    @Override
    public void run(String... args) {
        partB();
        partC();
        partD();
        bonus();        // chay tren du lieu goc -> truoc Part E
        partE();
    }

    private void partB() { todo6(); todo7(); }
    private void partC() { todo8(); todo9(); todo10(); todo11(); }
    private void partD() { todo12(); todo13(); todo14(); todo15(); todo16(); todo17(); todo18(); todo19(); }
    private void bonus() { todo25(); }
    private void partE() { todo20(); todo21(); todo22(); todo23(); todo24(); }

    // ===== helpers =====
    private void title(String t) {
        System.out.println("\n===== " + t + " =====");
    }

    private void printList(String label, Collection<?> list) {
        System.out.println("-- " + label + ":");
        list.forEach(o -> System.out.println("   " + o));
        System.out.println("   -> " + list.size() + " record(s)");
    }

    /** Chay 1 thao tac ghi, in [OK] hoac [FAIL] + message (dung cho Part E). */
    private void attempt(String label, Runnable action) {
        try {
            action.run();
            System.out.println("   [OK]   " + label);
        } catch (RuntimeException e) {
            System.out.println("   [FAIL] " + label + " -> " + e.getMessage());
        }
    }

    // ===== TODOs - se dien dan =====
    private void todo6() {
        title("TODO 6: count, findAll(Sort), findById");
        System.out.println("Total courses: " + courseService.count());
        printList("All courses order by code", courseService.findAllOrderByCode());
        for (long id : new long[]{2L, 99L}) {
            System.out.println("findById(" + id + "): "
                    + courseService.findById(id).map(Course::toString).orElse("Not found"));
        }
    }
    private void todo7()  { title("TODO 7  - chua implement"); }
    private void todo8()  { title("TODO 8  - chua implement"); }
    private void todo9()  { title("TODO 9  - chua implement"); }
    private void todo10() { title("TODO 10 - chua implement"); }
    private void todo11() { title("TODO 11 - chua implement"); }
    private void todo12() { title("TODO 12 - chua implement"); }
    private void todo13() { title("TODO 13 - chua implement"); }
    private void todo14() { title("TODO 14 - chua implement"); }
    private void todo15() { title("TODO 15 - chua implement"); }
    private void todo16() { title("TODO 16 - chua implement"); }
    private void todo17() { title("TODO 17 - chua implement"); }
    private void todo18() { title("TODO 18 - chua implement"); }
    private void todo19() { title("TODO 19 - chua implement"); }
    private void todo20() { title("TODO 20 - chua implement"); }
    private void todo21() { title("TODO 21 - chua implement"); }
    private void todo22() { title("TODO 22 - chua implement"); }
    private void todo23() { title("TODO 23 - chua implement"); }
    private void todo24() { title("TODO 24 - chua implement"); }
    private void todo25() { title("TODO 25 - chua implement"); }
}
