import java.util.Arrays;
import java.util.Comparator;

public class MovieComparator {
  static class Movie{
    String name;
    int rating;

    public Movie(String name, int rating) {
      this.name = name;
      this.rating = rating;
    }

    public String toString(){
      return this.name+" rating="+this.rating;
    }
  }

  static class MovieRatingComparator implements Comparator<Movie>{

    @Override
    public int compare(Movie o1, Movie o2) {
      return o1.rating - o2.rating;
    }
  }

  static class MovieNameComparator implements Comparator<Movie>{

    @Override
    public int compare(Movie o1, Movie o2) {
      return o1.name.compareTo(o2.name);
    }
  }

  public static void main(String[] args) {
    Movie[] movies = new Movie[4];
    movies[0] = new Movie("ram", 3);
    movies[1] = new Movie("mohan", 1);
    movies[2] = new Movie("madan", 5);
    movies[3] = new Movie("arnav", 2);
    printMovies(movies);
    Arrays.sort(movies, new MovieRatingComparator());
    printMovies(movies);
    Arrays.sort(movies, new MovieNameComparator());
    printMovies(movies);
  }

  static void printMovies(Movie[] movies){
    for(Movie mv: movies){
      System.out.print(mv.toString()+"       ");
    }
    System.out.println();
  }
}
