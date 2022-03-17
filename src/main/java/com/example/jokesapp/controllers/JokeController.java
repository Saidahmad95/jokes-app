package com.example.jokesapp.controllers;

import com.example.jokesapp.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private final JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping(value = {"/", ""})
    public String showJoke(Model model) {
        model.addAttribute("joke", jokeService.getJoke());
        return "index";
    }

    @GetMapping("funny")
    public String responseFunny(Model model) {
        model.addAttribute("isFunny", "WOHAHAHA");
        return "funny";
    }
    @GetMapping("notFunny")
    public String responseNotFunny(Model model) {
        model.addAttribute("isNotFunny", "Oooooo I'm sorry");
        return "notFunny";
    }
}
