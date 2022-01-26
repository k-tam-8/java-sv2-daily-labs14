package day02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {
    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return new ArrayList<>(movies);
    }

    public List<Movie> filterByActor(String actor) {
        return movies.stream()
                .filter(movie -> movie.getActors().contains(actor)).collect(Collectors.toList());
    }

    public int longestMovie(){
        return movies.stream()
                .mapToInt(Movie::getLength)
                .max().orElseThrow(() -> new IllegalArgumentException("Not valid"));
    }
}
