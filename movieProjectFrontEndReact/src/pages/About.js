import React from "react";
import Header from "../components/Header";

const about = () => {
  return (
    <div className="about-page">
      <Header />

      <div className="row">
        <div className="column">
          <div className="card">
            <img src={"./img/renaud.jpg"} alt="Renaud" />
            <div className="container">
              <h2>Renaud RIEUX</h2>
              <p>
                Ce site internet a été codé en React. Il s'agit d'un
                entrainement effectué pour me familiariser avec ce Framework et
                pour manipuler des API. Les données sont issues du site TMDB
                "The Movie Database". Le style du site internet est inspiré des
                modèles disponibles sur le site dribbble.com.
              </p>
              <p>Contact : rieux.renaud.94@gmail.com</p>
              <p>
                <button className="button">Contact</button>
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default about;
