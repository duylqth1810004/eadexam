package com.example.eadexam.controller;

import com.example.eadexam.entity.People;
import com.example.eadexam.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class PeopleController {
    @Autowired
    PeopleRepository pr;

    @RequestMapping("/")
    public String index(Model model){
        List<People> peopleList = (List<People>) pr.findAll();

        model.addAttribute("peopleList", peopleList);

        return "index";
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String save(People people){
        pr.save(people);
        return "redirect:/";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String editPeople(@RequestParam("id") int peopleId, Model model){
        Optional<People> peopleEdit = pr.findById(peopleId);
        peopleEdit.ifPresent(people -> model.addAttribute("people", people));
        return "redirect:/";
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deletePeople(@RequestParam("id") int peopleId, Model model){
        pr.deleteById(peopleId);
        return "redirect:/";
    }
}
