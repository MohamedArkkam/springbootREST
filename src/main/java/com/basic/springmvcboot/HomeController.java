package com.basic.springmvcboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import com.basic.springmvcboot.model.Alien;
import com.basic.springmvcboot.repository.AlienRepository;


@Controller
public class HomeController {

    @Autowired
    AlienRepository alienRepository;

    @ModelAttribute
    public void modelData(Model m) {
        m.addAttribute("name", "John Doe");
    }

    @RequestMapping("/") 
    public String home() {
        return "index";
    }

    @GetMapping("getAliens")
    public String getAliens(Model m) {
      
        m.addAttribute("result", alienRepository.findAll());
        return "showAliens";
    }

    @GetMapping("getAlien")
    public String getAlien(@RequestParam int aid, Model m) {
        m.addAttribute("result", alienRepository.findById(aid));
        return "showAliens";
    }

    @GetMapping("getAlienByName")
    public String getAlienByName(@RequestParam String aname, Model m) {
        // m.addAttribute("result", alienRepository.findByAname(aname));
        m.addAttribute("result", alienRepository.find(aname));
        return "showAliens";
    }

    @PostMapping("/addAlien")
    public String addAlien(@ModelAttribute("a1") Alien a) {
        alienRepository.save(a);
        return "result";
    }
}