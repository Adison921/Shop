package zsh.service.impl;

import zsh.dao.BookDao;
import zsh.dao.impl.BookDaoImpl;
import zsh.pojo.Book;
import zsh.pojo.Page;
import zsh.service.BookService;

import java.util.List;

/**
 * @author zsh
 * @create 2021-01-02-18:02
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao=new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
      bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
      return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();

        // ����ÿҳ��ʾ������
        page.setPageSize(pageSize);
        // ���ܼ�¼��
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        // �����ܼ�¼��
        page.setPageTotalCount(pageTotalCount);
        // ����ҳ��
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
        // ������ҳ��
        page.setPageTotal(pageTotal);

        // ���õ�ǰҳ��
        page.setPageNo(pageNo);

        // ��ǰҳ���ݵĿ�ʼ����
        int begin = (page.getPageNo() - 1) * pageSize;
        // ��ǰҳ����
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);
        // ���õ�ǰҳ����
        page.setItems(items);

        return page;
    }
}
