package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.JobRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "My Jobs");
        model.addAttribute("jobs", jobRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());

        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model, @RequestParam int employerId,
                                    @RequestParam(required = false) List<Integer> skills) {

        if (errors.hasErrors()) {
       //     model.addAttribute("title", "Add Job");
            return "add";
        }

       Optional<Employer> result = employerRepository.findById(employerId);
        if (result.isEmpty()){
            model.addAttribute("title", "Invalid  Employer ID: " + employerId);
        }else {
            Employer employer = (Employer) result.get();
             newJob.setEmployer(employer);
        }

        Employer employer = (Employer) result.get();
        newJob.setEmployer(employer);

        jobRepository.save(newJob);

        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
        newJob.setSkills(skillObjs);

       /* if (result.isEmpty()){
            model.addAttribute("title", "Invalid Skill: " + skills);
        }else {
            Skill skill = (Skill) result.get();*/

        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {
        Optional<Job> result =  jobRepository.findById(jobId);
        Job job = (Job) result.get();
        model.addAttribute("job", job);

        return "view";
    }


}
