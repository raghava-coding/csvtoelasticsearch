import loader.DataLoader;
import model.Book;
import parser.CsvParser;

import java.util.List;
import java.util.Properties;

public class Application {
    public static void main(String args[]) throws Exception {
        Properties properties = new Properties();
        properties.load(Application.class.getClassLoader().getResourceAsStream("application.properties"));
        CsvParser parser = new CsvParser();
        List<Book> books = parser.loadObjectList(Book.class, properties.getProperty(Constants.FILE));
        DataLoader loader = new DataLoader(properties.getProperty(Constants.CLUSTER));
        loader.saveData(properties.getProperty(Constants.INDEX), properties.getProperty(Constants.TYPE), books);
    }
}
