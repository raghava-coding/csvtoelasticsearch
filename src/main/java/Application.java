import loader.DataLoader;
import model.Book;
import parser.CsvParser;

import java.util.List;

public class Application {
    public static void main(String args[]) {
        CsvParser parser = new CsvParser();
        DataLoader loader = new DataLoader();
        List<Book> books = parser.loadObjectList(Book.class, "/Users/raghava.juvvaji/Downloads/books.csv");
        loader.saveData("test-index", "test", books);
    }
}
