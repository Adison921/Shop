package zsh.dao;
import zsh.pojo.Book;

import java.util.List;

/**
 * @author zsh
 * @create 2021-01-02-17:46
 */
public interface BookDao {


    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();


    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);
}
