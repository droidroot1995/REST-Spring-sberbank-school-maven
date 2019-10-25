package tk.droidroot.restservice.DTO;

import java.util.Objects;


public class StudentDTO {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String department;
    private Integer course;
    private Integer group;

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        StudentDTO studentDTO = (StudentDTO) o;

        return Objects.equals(id, studentDTO.id) && Objects.equals(name, studentDTO.name) &&
                Objects.equals(surname, studentDTO.surname) && Objects.equals(age, studentDTO.age) &&
                Objects.equals(department, studentDTO.department) && Objects.equals(course, studentDTO.course) &&
                Objects.equals(group, studentDTO.group);

    }

    @Override
    public int hashCode() {
        return 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

}
