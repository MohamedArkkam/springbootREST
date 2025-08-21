package com.basic.springmvcboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.basic.springmvcboot.model.Alien;
import com.basic.springmvcboot.repository.AlienRepository;

@Controller
public class AlienController {

    @Autowired
    AlienRepository alienRepository;

    @GetMapping("aliens")
    @ResponseBody
    public List<Alien> getAliens() {
        List<Alien> aliens = alienRepository.findAll();
        return aliens;
    }

    @GetMapping("alien/{aid}")
    @ResponseBody
    public Alien getAlien(@PathVariable int aid) {
        Alien alien = alienRepository.findById(aid).orElse(null);
        return alien;
    }

    @PostMapping("alien")
    @ResponseBody
    public Alien addAlien(Alien alien) {
        alienRepository.save(alien);
        return alien;
    }

    @DeleteMapping("alien/{aid}")
    public String deleteAlien(@PathVariable int aid) {
        alienRepository.deleteById(aid);
        return "success";
    }

}
