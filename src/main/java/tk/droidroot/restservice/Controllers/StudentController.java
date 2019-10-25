package tk.droidroot.restservice.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.droidroot.restservice.DTO.StudentDTO;
import tk.droidroot.restservice.Models.StudentEntity;
import tk.droidroot.restservice.Service.StudentService;

@RestController
//@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/student/{id}")
    public StudentDTO get(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping("/student/create/")
    public StudentEntity create(@RequestBody StudentDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/student/update/{id}")
    public StudentEntity update(@RequestBody StudentDTO dto, @PathVariable("id") Long id){
        return service.update(dto, id);
    }

    @DeleteMapping("/student/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

}
