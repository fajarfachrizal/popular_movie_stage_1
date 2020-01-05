package com.example.fajar.popular_movie_stage_1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fajar.popular_movie_stage_1.parser.Movies;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fajar on 13.06.2018.
 * A placeholder fragment containing a simple view.
 */
public class MovieDetailsFragment extends Fragment {

    private final static String BASE_POSTER_URL = "https://image.tmdb.org/t/p/";
    private final static String LOGO_SIZE = "w500";
    private static final String KEY_MOVIE = "MOVIE";

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.cover_image)
    ImageView detail_image;
    @BindView(R.id.year)
    TextView year_of_released;
    @BindView(R.id.average_rating)
    TextView ratings;
    @BindView(R.id.description)
    TextView moviesDescription;

    public MovieDetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_details, container, false);

        Movies movies = getActivity().getIntent().getParcelableExtra(KEY_MOVIE);

        if (movies != null) {
            ButterKnife.bind(this, view);
            System.out.println(movies);
            title.setText(movies.getTitle());
            loadImage(movies.getPosterPath());
            year_of_released.setText(String.format("%.4s", movies.getReleaseDate()));
            ratings.setText(String.format("%s/10", movies.getVoteAverage()));
            moviesDescription.setText(movies.getOverview());
        }

        return view;
    }


    private void loadImage(String path) {
        String urlBuilder = new StringBuilder()
                .append(BASE_POSTER_URL)
                .append(LOGO_SIZE)
                .append(path).toString();

        Picasso.with(getContext())
                .load(urlBuilder)
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .into(detail_image);
    }
}
