class Movie extends RentalItem {
    private String genre;
    private String director;

    public Movie(String name, String genre, String director, double price) {
        super(name, price);
        this.genre = genre;
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getPrice() * days;
    }
}
