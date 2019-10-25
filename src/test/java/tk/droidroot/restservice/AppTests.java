package tk.droidroot.restservice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import tk.droidroot.restservice.DTO.StudentDTO;
import tk.droidroot.restservice.Models.StudentEntity;
import tk.droidroot.restservice.Service.StudentService;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppTests {

    public AppTests(){}

    @Autowired
    StudentService service;

    @Test
    public void createTest() {
        StudentDTO dto = new StudentDTO();
        dto.setId((long)1);
        dto.setName("Alexander");
        dto.setSurname("Goryakin");
        dto.setAge(24);
        dto.setDepartment("DAFE");
        dto.setCourse(1);
        dto.setGroup(911);

        StudentEntity entity = service.create(dto);

        assertEquals(entity.getName(), dto.getName());
        assertEquals(entity.getSurname(), dto.getSurname());
        assertEquals(entity.getAge(), dto.getAge());
        assertEquals(entity.getDepartment(), dto.getDepartment());
        assertEquals(entity.getCourse(), dto.getCourse());
        assertEquals(entity.getGroup(), dto.getGroup());
    }

    @Test
    public void getTest() {
        StudentDTO dto = new StudentDTO();
        dto.setId((long)2);
        dto.setName("Alexander");
        dto.setSurname("Goryakin");
        dto.setAge(24);
        dto.setDepartment("DAFE");
        dto.setCourse(1);
        dto.setGroup(911);

        StudentEntity entity = service.create(dto);

        StudentDTO dto1 = service.findById((long)2);

        assertEquals(dto1.getId(), dto.getId());
        assertEquals(dto1.getName(), dto.getName());
        assertEquals(dto1.getSurname(), dto.getSurname());
        assertEquals(dto1.getAge(), dto.getAge());
        assertEquals(dto1.getDepartment(), dto.getDepartment());
        assertEquals(dto1.getCourse(), dto.getCourse());
        assertEquals(dto1.getGroup(), dto.getGroup());
    }

    @Test
    public void updateTest() {
        StudentDTO dto = new StudentDTO();
        dto.setId((long)1);
        dto.setName("Alexander");
        dto.setSurname("Goryakin");
        dto.setAge(25);
        dto.setDepartment("DAFE");
        dto.setCourse(1);
        dto.setGroup(911);

        StudentEntity entity = service.update(dto, (long)1);

        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getName(), dto.getName());
        assertEquals(entity.getSurname(), dto.getSurname());
        assertEquals(entity.getAge(), dto.getAge());
        assertEquals(entity.getDepartment(), dto.getDepartment());
        assertEquals(entity.getCourse(), dto.getCourse());
        assertEquals(entity.getGroup(), dto.getGroup());
    }

    @Test
    public void deleteTest() {
        StudentDTO dto = new StudentDTO();
        dto.setId((long)1);
        dto.setName("Alexander");
        dto.setSurname("Goryakin");
        dto.setAge(24);
        dto.setDepartment("DAFE");
        dto.setCourse(1);
        dto.setGroup(911);

        service.delete((long)1);
        StudentDTO dto1 = service.findById((long)1);
        Assert.assertEquals(dto1, null);
    }

    @Test
    public void contextLoads() {
    }

}
