package uz.ilmnajot.library_system_2.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.ilmnajot.library_system_2.entity.Publisher;
import uz.ilmnajot.library_system_2.service.PublisherService;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/publisher")
public class PublisherController {

    final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/list")
    public String listPublisher(Model model) {
        List<Publisher> publishers = publisherService.findAll();
        model.addAttribute("publishers", publishers);
        return ";ist-publishers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Publisher publisher = new Publisher();
        model.addAttribute("publishers", publisher);
        return "publisher-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("publisherId") int id, Model model) {
        Publisher publisher = publisherService.findById(id);
        model.addAttribute("publishers", publisher);
        return "publisher-form";
    }

    @PostMapping("/save")
    public String savePublisher(@ModelAttribute("publishers") Publisher publisher) {
        publisherService.save(publisher);
        return "redirect:/publisher/list";
    }

    @GetMapping("/delete")
    public String deletePublisher(@RequestParam("publisherId") int id) {
        publisherService.deleteById(id);
        return "redirect:/publisher/list";
    }
}
