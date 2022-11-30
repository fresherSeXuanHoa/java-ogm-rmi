package org.rmi.server.util;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.rmi.server.entity.Book;
import org.rmi.server.entity.BookType;
import org.rmi.server.service.BookService;
import org.rmi.server.service.BookTypeService;

public class MockDBUtil {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		BookService bookService = new BookService();
		BookTypeService bookTypeService = new BookTypeService();

		BookType novel = new BookType("Sách Truyện, Tiểu Thuyết");
		BookType syllabus = new BookType("Giáo Trình");
		BookType psychology = new BookType("Sách Tâm Lý");

		bookTypeService.save(novel);
		bookTypeService.save(syllabus);
		bookTypeService.save(psychology);

		Book coMotNgayBoMeSeGiaDi = new Book("Có Một Ngày, Bố Mẹ Sẽ Già Đi", 75000.00, 500, "Nhiều tác giả",
				"NXB Thế Giới", novel);
		Book hinhHocViPhan = new Book("Giáo trình Hình học vi phân", 85000.00, 89, "Nguyễn Doãn Tuấn",
				"NXB Đại học sư phạm", syllabus);
		Book henGapNhauTrongVuTru = new Book("Hẹn gặp nhau trong vũ trụ", 115000.00, 130, "Jack Cheng", "NXB Trẻ",
				psychology);

		bookService.save(coMotNgayBoMeSeGiaDi);
		bookService.save(hinhHocViPhan);
		bookService.save(henGapNhauTrongVuTru);

		System.out.println("Imported Mock Data!");
	}
}
