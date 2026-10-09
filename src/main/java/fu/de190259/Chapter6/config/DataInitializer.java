package fu.de190259.Chapter6.config;

import fu.de190259.Chapter6.entity.Student;
import fu.de190259.Chapter6.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    private final StudentRepository studentRepository;

    public DataInitializer(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) {
        if (studentRepository.count() > 0) {
            log.info("Bang students da co du lieu -> bo qua seed");
            return;
        }
        studentRepository.saveAll(List.of(
                new Student("Nguyen Van An",  "an@fpt.edu.vn",    20, "CNTT", 3.5),
                new Student("Tran Thi Binh",  "binh@fpt.edu.vn",  21, "KTPM", 3.2),
                new Student("Le Minh Cuong",  "cuong@fpt.edu.vn", 19, "ATTT", 3.8),
                new Student("Pham Thi Dung",  "dung@fpt.edu.vn",  22, "HTTT", 2.9)
        ));
        log.info("Da seed {} sinh vien", studentRepository.count());
    }
}
