import React from "react";

const Card = ({ movie }) => {
  const dateFormatter = (date) => {
    let [yy, mm, dd] = date.split("-");
    return [dd, mm, yy].join("/");
  };

  const addStorage = () => {
    let storedData = window.localStorage.movies
      ? window.localStorage.movies.split(",")
      : [];

    if (!storedData.includes(movie.id.toString())) {
      storedData.push(movie.id);
      window.localStorage.movies = storedData;
    }
  };

  return (
    <div className="card">
      <img
        src={
          movie.poster_path
            ? "https://image.tmdb.org/t/p/w500/" + movie.poster_path
            : "./img/poster.jpg"
        }
        alt="affiche film"
      ></img>
      <h2>{movie.title}</h2>
      {movie.release_date ? (
        <h5>Sorti le : {dateFormatter(movie.release_date)}</h5>
      ) : (
        ""
      )}
      <h4>
        {movie.vote_average}/10 <span>⭐</span>
      </h4>
      {movie.overview ? <h3>Synopsys </h3> : ""}
      <p>{movie.overview}</p>
      <div className="btn" onClick={() => addStorage()}>
        Ajouter aux coups de coeur
      </div>
    </div>
  );
};

export default Card;
