package com.huma.exerciseapp.classes;

import com.huma.exerciseapp.model.MovieSerial;

import java.util.ArrayList;
import java.util.List;

public final class MovieList {

    public static final String[] MOVIE_CATEGORY = {
            "فیلم",
            "سریال"
    };

    public static List<List<MovieSerial>> setupMovies() {

        List<List<MovieSerial>> listAll = new ArrayList<>();
        List<MovieSerial> listMovie = new ArrayList<>();
        List<MovieSerial> listSerial = new ArrayList<>();

        String[] titleMovies = {
                "فیلم پیپا 2022",
                "فیلم سقوط 2022",
                "فیلم یتیم اولین قتل 2 2022",
                "فیلم اوما 2022",
                "فیلم حال و هوای سئول 2022",
                "فیلم هیولا 2022",
                "فیلم منطقه مرده 2022",
                "فیلم سامری 2022",
                "فیلم قطار سریع السیر 2022",
                "فیلم یک فرصت دیگر 2021"
        };

        String[] titleSerials = {
                "سریال آندور 2022",
                "سریال شی هالک 2022",
                "سریال من گروت هستم 2022",
                "سریال ریچر 2022",
                "سریال مرد شنی 2022",
                "سریال مرد در مقابل زنبور 2022",
                "سریال خانه کاغذی کره ای 2022",
                "سریال دی ام زد 2022",
                "سریال بزرگ شدن حیوان 2021",
                "سریال چرخ زمان 2021"
        };

        String[] countryMovies = {
                "محصول آمریکا", "محصول کانادا", "محصول ژاپن", "محصول کره جنوبی", "محصول هندوستان",
                "محصول ایران", "محصول ترکیه", "محصول آمریکا", "محصول آمریکا", "محصول آمریکا"
        };

        String[] countrySerials = {
                "محصول هندوستان", "محصول کانادا", "محصول تایوان", "محصول چین", "محصول هند",
                "محصول ایران", "محصول ترکیه", "محصول آمریکا", "محصول آلمان", "محصول آمریکا"
        };

        String[] cardImageUrlMovies = {
                "https://movielandz.com/wp-content/uploads/2022/07/Pipa-2022.jpg",
                "https://movielandz.com/wp-content/uploads/2022/08/Fall-2022.jpg",
                "https://movielandz.com/wp-content/uploads/2022/08/Orphan-First-Kill-2022.jpg",
                "https://movielandz.com/wp-content/uploads/2022/04/Umma-2022.jpg",
                "https://movielandz.com/wp-content/uploads/2022/08/Seoul-Vibe-2022.jpg",
                "https://movielandz.com/wp-content/uploads/2022/08/Beast-2022-Kha.jpg",
                "https://movielandz.com/wp-content/uploads/2022/08/Dead-Zone-2022.jpg",
                "https://movielandz.com/wp-content/uploads/2022/08/Samaritan-2022.jpg",
                "https://movielandz.com/wp-content/uploads/2022/03/Bullet-Train-2022-1.jpg",
                "https://movielandz.com/wp-content/uploads/2022/03/One-More-Shot-2021.jpg"
        };

        String[] cardImageUrlSerials = {
                "https://movielandz.com/wp-content/uploads/2022/06/Andor.jpg",
                "https://movielandz.com/wp-content/uploads/2022/08/She-Hulk-Attorney-at-Law.-2022.jpg",
                "https://movielandz.com/wp-content/uploads/2022/08/I-Am-Groot.2022.jpg",
                "https://movielandz.com/wp-content/uploads/2022/02/Reacher-2022-1.jpg",
                "https://movielandz.com/wp-content/uploads/2022/06/The-Sandman-2022.jpg",
                "https://movielandz.com/wp-content/uploads/2022/05/Man-vs-Bee-2022.jpg",
                "https://movielandz.com/wp-content/uploads/2022/03/Money-Heist-Korea.jpg",
                "https://movielandz.com/wp-content/uploads/2022/03/DMZ-2022.jpg",
                "https://movielandz.com/wp-content/uploads/2022/03/Growing-Up-Animal-2021.jpg",
                "https://movielandz.com/wp-content/uploads/2022/03/The-Wheel-of-Time-2021.jpg"
        };

        for (int index = 0; index < titleMovies.length; ++index) {

            listMovie.add(buildMovieInfo(titleMovies[index], countryMovies[index], cardImageUrlMovies[index]));
        }

        for (int index = 0; index < titleSerials.length; ++index) {
            listSerial.add(buildMovieInfo(titleSerials[index], countrySerials[index], cardImageUrlSerials[index]));
        }

        listAll.add(listMovie);
        listAll.add(listSerial);
        return listAll;
    }

    private static MovieSerial buildMovieInfo(String title, String studio, String cardImageUrl) {
        MovieSerial movie = new MovieSerial();
        movie.setTitle(title);
        movie.setStudio(studio);
        movie.setCardImageUrl(cardImageUrl);
        return movie;
    }
}