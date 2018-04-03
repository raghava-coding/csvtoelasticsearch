package parser;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CsvParser {

    private static final Logger logger = Logger.getLogger("CsvParser");
    private final CsvMapper mapper;

    public CsvParser() {
        mapper = new CsvMapper();
    }

    public <T> List<T> loadObjectList(Class<T> type, String fileName) {
        CsvSchema schema = mapper.schemaFor(type);
        try {
            MappingIterator<T> booksIt = mapper.readerFor(type).with(schema).readValues(new File(fileName));
            return booksIt.readAll();
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(),e.getStackTrace());
        }
        return new ArrayList<T>();
    }
}
