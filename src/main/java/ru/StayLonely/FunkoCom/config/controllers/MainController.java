package ru.StayLonely.FunkoCom.config.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.StayLonely.FunkoCom.config.dao.PostDAO;
import ru.StayLonely.FunkoCom.config.models.Post;
import ru.StayLonely.FunkoCom.config.models.User;

@Controller
@RequestMapping("")
public class MainController {

    private final PostDAO postDAO;

    public MainController(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @GetMapping("/home")
    public String mainPage(Model model)
    {
        model.addAttribute("news", postDAO.index());
        return "mainPage/home";
    }

    @GetMapping("/news")
    public String newsPage(Model model){
        model.addAttribute("news", postDAO.index());
        model.addAttribute("post", new Post());
        return "mainPage/news";
    }

    @GetMapping("/news/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("post", postDAO.show(id));
        return "mainPage/showNews";
    }



    @PostMapping("/news/create")
    public String create(@ModelAttribute("post") @Valid Post p, BindingResult result){

        if (result.hasErrors()){
            return "redirect:/news";
        }
        postDAO.save(p);
        return "redirect:/news";
    }

    @DeleteMapping("news/delete/{id}")
    public String delete(@PathVariable("id") int id){
        postDAO.delete(id);
        return "redirect:/news";
    }

    @PatchMapping("news/{id}")
    public String update(@ModelAttribute("person")  @Valid Post post,BindingResult result,  @PathVariable("id") int id){

        if (result.hasErrors()){
            return "redirect:/news";
        }

        postDAO.update(id, post);

        return "redirect:/news/{id}";
    }


    @Autowired
    private CustomUser DetailsService userDetailsService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser  (@ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        userDetailsService.createUser(user);
        return "redirect:/login";
    }

}
