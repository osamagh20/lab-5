package com.example.lab5.studentController;

import com.example.lab5.ApiResponse.ApiResponse;
import com.example.lab5.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class studentController {
    ArrayList<Student> students = new ArrayList<>();

    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse("student added");
    }

    @GetMapping("/get")
    public ArrayList<Student> getAllStudents() {

        return students;
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@PathVariable int index,@RequestBody Student student) {
        students.set(index, student);
        return new ApiResponse("student updated");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index) {
        students.remove(index);
        return new ApiResponse("student deleted");
    }

    @GetMapping("/getHonor/{index}")
    public String displayStudentByHonor(@PathVariable int index) {

        if(students.get(index).getGPA() >=4.75 && students.get(index).getGPA()<= 5) {
            return "First class Honor";
        }else if (students.get(index).getGPA()>=4.25 && students.get(index).getGPA()<=4.74){
            return "Second class Honor";

        }
            return "Student not have honor";

    }

    @GetMapping("/getByAvg")
    public ArrayList<Student> getStudentsByAvg(){
        double total = 0.0;
        double average = 0.0;
        ArrayList<Student> studentsAvg = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            total = total + students.get(i).getGPA();
            average = total / students.size();
        }
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getGPA()>average){
                studentsAvg.add(students.get(i));
            }
        }
        return studentsAvg;
    }


}
