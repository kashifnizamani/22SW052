import java.util.ArrayList;
import java.util.Scanner;

public class MovieRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieStore movieStore = new MovieStore();


        movieStore.addMovie(new Movie("Inception", "Sci-Fi", "Christopher Nolan", 600));
        movieStore.addMovie(new Movie("The Godfather", "Crime", "Francis Ford Coppola", 550));
        movieStore.addMovie(new Movie("Pulp Fiction", "Crime", "Quentin Tarantino", 525));
        movieStore.addMovie(new Movie("The Shawshank Redemption", "Drama", "Frank Darabont", 525));
        movieStore.addMovie(new Movie("The Dark Knight", "Action", "Christopher Nolan", 625));
        movieStore.addMovie(new Movie("Forrest Gump", "Drama", "Robert Zemeckis", 550));
        movieStore.addMovie(new Movie("Seven", "Mystery", "David Fincher", 575));
        movieStore.addMovie(new Movie("The Lord of the Rings", "Fantasy", "Peter Jackson", 625));
        movieStore.addMovie(new Movie("Fight Club", "Drama", "David Fincher", 550));
        movieStore.addMovie(new Movie("Interstellar", "Sci-Fi", "Christopher Nolan", 625));
        movieStore.addMovie(new Movie("Schindler's List", "Drama", "Steven Spielberg", 575));

        while (true) {
            System.out.println("Welcome to the Movie Rental Store!");
            System.out.println("1. Rent a movie");
            System.out.println("2. Return a movie");
            System.out.println("3. Exit");
            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.println("How would you like to search for a movie?");
                    System.out.println("1. By genre");
                    System.out.println("2. By director");
                    System.out.println("3. By name");
                    System.out.print("Please enter your choice: ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    switch (searchChoice) {
                        case 1:
                            System.out.print("Enter your preferred genre: ");
                            String genre = scanner.nextLine();
                            ArrayList<Movie> genreMatches = movieStore.findMoviesByGenre(genre);
                            if (genreMatches.isEmpty()) {
                                System.out.println("No movies found in this genre.");
                            } else {
                                System.out.println("Movies in the " + genre + " genre:");
                                for (int i = 0; i < genreMatches.size(); i++) {
                                    System.out.println((i + 1) + ". " + genreMatches.get(i).getName());
                                }
                                System.out.print("Enter the number of the movie you want to rent: ");
                                int selectedMovie = scanner.nextInt();
                                if (selectedMovie >= 1 && selectedMovie <= genreMatches.size()) {
                                    Movie selected = genreMatches.get(selectedMovie - 1);
                                    System.out.println("Enter the number of days you want to rent for: ");
                                    int days = scanner.nextInt();
                                    double cost = selected.calculateRentalCost(days);
                                    System.out.println("Movie rented: " + selected.getName() + " for RS " + cost);
                                } else {
                                    System.out.println("Invalid selection.");
                                }
                            }
                            break;

                        case 2:
                            System.out.print("Enter your favorite director: ");
                            String director = scanner.nextLine();
                            ArrayList<Movie> directorMatches = movieStore.findMoviesByDirector(director);
                            if (directorMatches.isEmpty()) {
                                System.out.println("No movies found by this director.");
                            } else {
                                System.out.println("Movies directed by " + director + ":");
                                for (int i = 0; i < directorMatches.size(); i++) {
                                    System.out.println((i + 1) + ". " + directorMatches.get(i).getName());
                                }
                                System.out.print("Enter the number of the movie you want to rent: ");
                                int selectedMovie = scanner.nextInt();
                                if (selectedMovie >= 1 && selectedMovie <= directorMatches.size()) {
                                    Movie selected = directorMatches.get(selectedMovie - 1);
                                    System.out.println("Enter the number of days you want to rent for: ");
                                    int days = scanner.nextInt();
                                    double cost = selected.calculateRentalCost(days);
                                    System.out.println("Movie rented: " + selected.getName() + " for RS " + cost);
                                } else {
                                    System.out.println("Invalid selection.");
                                }
                            }
                            break;

                        case 3:
                            System.out.print("Enter the name of the movie: ");
                            String movieName = scanner.nextLine();
                            Movie foundMovie = movieStore.findMovieByName(movieName);
                            if (foundMovie == null) {
                                System.out.println("Movie not found in the collection.");
                            } else {
                                System.out.println("Enter the number of days you want to rent for: ");
                                int days = scanner.nextInt();
                                double cost = foundMovie.calculateRentalCost(days);
                                System.out.println("Movie rented: " + foundMovie.getName() + " for RS " + cost);
                                // Add code for renting the movie and calculating the price based on duration
                            }
                            break;

                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                            break;
                    }
                    break;

                case 2:
                    System.out.print("Enter the name of the movie you want to return: ");
                    String returnMovieName = scanner.nextLine();
                    // Add code for returning the movie to the collection
                    System.out.println(returnMovieName + " has been successfully returned.");
                    break;

                case 3:
                    System.out.println("Thank you for visiting the Movie Rental Store. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
