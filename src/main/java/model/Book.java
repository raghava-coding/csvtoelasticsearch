package model;

import lombok.Data;
import java.util.Set;

@Data
public class Book {
    private long book_id;
    private long goodreads_book_id;
    private String best_book_id;
    private String work_id;
    private long books_count;
    private String isbn;
    private Set<String> authors;
    private int original_publication_year;
    private String original_title;
    private String title;
    private String language_code;
    private String average_rating;
    private long ratings_count;
    private long work_ratings_count;
    private long work_text_reviews_count;
    private long ratings_1;
    private long ratings_2;
    private long ratings_3;
    private long ratings_4;
    private long ratings_5;
    private long image_url;
    private long small_image_url;
}
