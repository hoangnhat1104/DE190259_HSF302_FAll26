package fu.de190259.Chapter6.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ten khong duoc de trong")
    @Size(min = 2, max = 50, message = "Ten phai tu 2 den 50 ky tu")
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotBlank(message = "Email khong duoc de trong")
    @Email(message = "Email khong dung dinh dang")
    @Size(max = 100, message = "Email toi da 100 ky tu")
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @NotNull(message = "Tuoi khong duoc de trong")
    @Min(value = 18, message = "Tuoi toi thieu la 18")
    @Max(value = 30, message = "Tuoi toi da la 30")
    @Column(name = "age", nullable = false)
    private Integer age;

    @NotBlank(message = "Chuyen nganh khong duoc de trong")
    @Column(name = "major", nullable = false, length = 20)
    private String major;

    @NotNull(message = "GPA khong duoc de trong")
    @DecimalMin(value = "0.0", message = "GPA toi thieu la 0.0")
    @DecimalMax(value = "4.0", message = "GPA toi da la 4.0")
    @Column(name = "gpa", nullable = false)
    private Double gpa;

    // ========== Constructors ==========

    /** JPA bat buoc co constructor khong tham so */
    public Student() {}

    /** Dung cho seed data — khong co id vi DB tu sinh */
    public Student(String name, String email, Integer age, String major, Double gpa) {
        this.name  = name;
        this.email = email;
        this.age   = age;
        this.major = major;
        this.gpa   = gpa;
    }

    // ========== Getters & Setters ==========

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public Double getGpa() { return gpa; }
    public void setGpa(Double gpa) { this.gpa = gpa; }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}
