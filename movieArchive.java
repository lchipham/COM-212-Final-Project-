public class movieArchive {
    private String title;
    private int releaseDate;
    private int idCode;
    private Boolean hold; //not sure about this

    public movieArchive(String title, int releaseDate, int idCode, int rating, Boolean hold) {
        this.title = title;
        this.releaseDate= releaseDate;
        this.idCode = idCode;
        this.hold = hold;
    }

    public String getTitle() {
        return title;
    }

    public int getID() {
        return idCode;
    } 

    //last 3 digits of ID code is the movie's rating
    public int getRating() {
        return idCode % 1000;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

}
