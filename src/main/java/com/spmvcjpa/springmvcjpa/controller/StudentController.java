package com.spmvcjpa.springmvcjpa.controller;

import com.spmvcjpa.springmvcjpa.model.Student;
import com.spmvcjpa.springmvcjpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

   /* @GetMapping("/index")
    public String registerUser(Model model){
        model.addAttribute("student",new Student());
        return "index";
    }
    @RequestMapping(value="/save",method=RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student student){
        System.out.println(student);
        studentRepository.save(student);
        return "index";
    }

    @PostMapping("/update/{id}")
        public String updateStudent(@PathVariable Integer id){

            return "update";
    }*/

    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Student> studentList = studentRepository.findAll();
        model.addAttribute("student",studentList);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewStudentForm(Model model){
        Student student=new Student();
        model.addAttribute("student",student);
        return "insert";
    }

    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student student){
        studentRepository.save(student);
        return "redirect:/";
    }

    @RequestMapping("/update/{id}")
    public ModelAndView showUpdateStudentForm(@PathVariable Integer id){
        ModelAndView mav=new ModelAndView("update");
        Student student=studentRepository.findById(id).get();
        mav.addObject("student",student);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentRepository.deleteById(id);
        return "redirect:/";
    }

}
