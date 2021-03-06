package main.model.entity;

public class Book {
    private int id;
    private String name, author, genre, series;

    public Book(int id, String name, String author, String genre, String series) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.series = series;
    }

    public  Book(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}
