package zsh.test;

import org.junit.Test;
import zsh.dao.BookDao;
import zsh.dao.impl.BookDaoImpl;
import zsh.pojo.Book;
import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author zsh
 * @create 2021-01-02-17:54
 */
public class BookDaoTest {
private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"����Ϊʲô��ô˧��", "191125", new BigDecimal(9999),1100000,0,null
        ));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"��Ҷ�������ô˧��", "����", new BigDecimal(9999),1100000,0,null
        ));
    }

    @Test
    public void queryBookById() {
        System.out.println( bookDao.queryBookById(21) );

    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }
}