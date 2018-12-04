package com.example.demo.web;

import com.example.demo.entity.Book;
import com.example.demo.respository.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingListController {

    @Autowired
    private BookRespository bookRespository;

    @RequestMapping(value="/{reader}", method=RequestMethod.GET)
    public String readersBooks(
            @PathVariable("reader") String reader,
            Model model) {
        List<Book> readingList =
                bookRespository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }
    @RequestMapping(value="/{reader}", method=RequestMethod.POST)
    public String addToReadingList(
            @PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        bookRespository.save(book);
        return "redirect:/{reader}";
    }
}
