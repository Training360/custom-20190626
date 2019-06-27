package training360.employeejpa;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emp_name")
    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @OrderBy("name")
    private List<Skill> skills = new ArrayList<>();

    public void addAllSkills(List<Skill> newSkills) {
        skills.addAll(newSkills);
        newSkills.forEach(s -> s.setEmployee(this));
    }

    @PrePersist
    public void initDates() {
        createdAt = LocalDateTime.now();
        modifiedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void updateModifTime() {
        modifiedAt = LocalDateTime.now();
    }

    public Employee(String name) {
        this.name = name;
    }
}
