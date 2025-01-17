class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    // getters
    public String getTitle() {
        return title;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public String[] getAuthors() {
        return authors;
    }

    // setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }
}