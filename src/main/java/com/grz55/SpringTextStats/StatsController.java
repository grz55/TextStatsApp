package com.grz55.SpringTextStats;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class StatsController implements WebMvcConfigurer {

    @GetMapping("/")
    public String getForm(TextAnalyzer textAnalyzer){
        return "index";
    }

    @PostMapping("/")
    public String getStats(Model model, @Valid TextAnalyzer textAnalyzer){
        model.addAttribute("wordsCount",textAnalyzer.getWordsCount());
        model.addAttribute("linesCount",textAnalyzer.getLinesCount());
        model.addAttribute("charactersCount",textAnalyzer.getCharactersCount());
        return "index";
    }
}

