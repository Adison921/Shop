package zsh.test;

import org.junit.Test;
import zsh.pojo.Book;
import zsh.service.BookService;
import zsh.service.impl.BookServiceImpl;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author zsh
 * @create 2021-01-02-18:06
 */
public class BookServiceTest {
private BookService bookService=new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"国哥在手，天下我有！", "1125", new BigDecimal(1000000), 100000000, 0, null));
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"社会我国哥，人狠话不多！", "1125", new BigDecimal(999999), 10, 111110, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }
}