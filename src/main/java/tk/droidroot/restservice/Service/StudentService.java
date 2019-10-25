package tk.droidroot.restservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.droidroot.restservice.DTO.StudentDTO;
import tk.droidroot.restservice.Models.StudentEntity;
import tk.droidroot.restservice.Repositories.StudentRepository;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public StudentDTO findById(Long id) {
        try {
            StudentEntity student = repository.getOne(id);
            StudentDTO dto = new StudentDTO();
            dto.setId(student.getId());
            dto.setName(student.getName());
            dto.setSurname(student.getSurname());
            dto.setAge(student.getAge());
            dto.setDepartment(student.getDepartment());
            dto.setCourse(student.getCourse());
            dto.setGroup(student.getGroup());

            return dto;
        }
        catch(EntityNotFoundException e){
            System.out.println("Entity not found");
        }

        return null;
    }

    public StudentEntity create(StudentDTO studentDTO){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(studentDTO.getName());
        studentEntity.setSurname(studentDTO.getSurname());
        studentEntity.setAge(studentDTO.getAge());
        studentEntity.setDepartment(studentDTO.getDepartment());
        studentEntity.setCourse(studentDTO.getCourse());
        studentEntity.setGroup(studentDTO.getGroup());
        return repository.save(studentEntity);
    }

    public StudentEntity update(StudentDTO studentDTO, Long id){
        return repository.findById(id).map(studentEntity -> {
            studentEntity.setName(studentDTO.getName());
            studentEntity.setSurname(studentDTO.getSurname());
            studentEntity.setAge(studentDTO.getAge());
            studentEntity.setDepartment(studentDTO.getDepartment());
            studentEntity.setCourse(studentDTO.getCourse());
            studentEntity.setGroup(studentDTO.getGroup());
            return repository.save(studentEntity);
        }).orElseGet(() -> {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setId(id);
            studentEntity.setName(studentDTO.getName());
            studentEntity.setSurname(studentDTO.getSurname());
            studentEntity.setAge(studentDTO.getAge());
            studentEntity.setDepartment(studentDTO.getDepartment());
            studentEntity.setCourse(studentDTO.getCourse());
            studentEntity.setGroup(studentDTO.getGroup());
            return repository.save(studentEntity);
        });
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
