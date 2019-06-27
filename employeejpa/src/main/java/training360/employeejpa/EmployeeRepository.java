package training360.employeejpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Employee employee) {
//        for (var skill: employee.getSkills()) {
//            em.persist(skill);
//        }
            em.persist(employee);
    }

    public List<Employee> listEmployees() {
        return em.createQuery("select distinct e from Employee e left join fetch e.skills order by e.name",
                Employee.class).getResultList();
    }

    @Transactional
    public void updateEmployee(long id, String modifiedName) {
      var employee = em.find(Employee.class, id);
      employee.setName(modifiedName);
    }

    @Transactional
    public void addSkills(long id, List<Skill> skills) {
        var employee = em.getReference(Employee.class, id);
        skills.forEach(s -> {s.setEmployee(employee); em.persist(s);});
    }
}
