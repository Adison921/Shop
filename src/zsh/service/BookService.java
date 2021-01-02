package zsh.service;

import zsh.pojo.Book;
import zsh.pojo.Page;

import java.util.List;

/**
 * @author zsh
 * @create 2021-01-02-18:00
 */
public interface BookService {
    public void addBook(Book book);
    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);
}
