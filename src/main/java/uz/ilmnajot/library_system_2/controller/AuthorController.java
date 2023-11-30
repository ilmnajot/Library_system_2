package uz.ilmnajot.library_system_2.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.ilmnajot.library_system_2.entity.Author;
import uz.ilmnajot.library_system_2.service.AuthorService;
import uz.ilmnajot.library_system_2.service.BookService;

import java.util.List;


@RestController
@RequestMapping("/author")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorController {

    public static final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    final BookService bookService;
    final AuthorService authorService;

    public AuthorController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }
    @GetMapping("/list")
    public String listAuthors(Model model){
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        return "list-authors";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Author author = new Author();
        model.addAttribute("authors", author);
        return "author-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("authorId") int id, Model model){
        Author author=authorService.findById(id);
        model.addAttribute("authors", author);
        return "author-form";
    }
    @PostMapping("/save")
    public String saveAuthor(@ModelAttribute("authors") Author author){
        authorService.save(author);
        return "redirect:/author/list";
    }
    @GetMapping("/delete")
    public String deleteAuthor(@RequestParam("authorId") int id){
        authorService.deleteId(id);
        return "redirect:/author/list";
    }
}
