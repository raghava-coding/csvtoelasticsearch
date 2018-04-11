package loader;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Bulk;
import io.searchbox.core.BulkResult;
import io.searchbox.core.Index;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DataLoader {
    private JestClient jestClient;
    private static final Logger logger = Logger.getLogger("CsvParser");

    public DataLoader(String cluster) {
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                .Builder(cluster)
                .multiThreaded(true)
                .build());
        jestClient = factory.getObject();
    }

    public <T> void saveData(String index, String type, List<T> docs) {
        Bulk bulk = new Bulk.Builder().addAction(docs.stream().map(doc -> new Index.Builder(doc).index(index).type(type).build()).collect(Collectors.toList())).build();
        try {
            BulkResult result = jestClient.execute(bulk);
            logger.log(Level.SEVERE, result.getErrorMessage());
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}
