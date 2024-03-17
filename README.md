# tpdb-app
This project is a movie recommendation app that provides users with movie suggestions based on their preferences. It consists of a Spring Boot backend and a React frontend.

### Features
- Search for movied: Users can search for movies by title, genre, or other criteria.
- View movie details: Detailed information about each movie, including cast, release date, and ratings.
- Get personalized movie recommendations: The app suggests movies based on the user’s viewing history and preferences.

### Prerequisites
Before running the application, make sure you have the following installed:

- Java 11 or higher: Required for the Spring Boot backend.
- Node.js and npm: Needed for the React frontend.
- The Movie Database (TMDb) API key: Obtain your API key from TMDb to fetch movie data

### Installation
1) Clone the repository:
```sh
git clone https://github.com/rieux-renaud/tpdb-app.git
cd tpdb-app
```

2) Backend setup
- Navigate to the frontend directory:
```sh
cd movieProjectBackend
```

- Open the project in your favorite IDE (e.g., IntelliJ IDEA, Eclipse).
- Set your TMDb API key as an environment variable (e.g., TMDB_API_KEY).
- Run the Application.java file to start the Spring Boot backend.

3) Frontend setup
- Navigate to the frontend directory:
```sh
cd movieProjectFrontEnd
```
- Install dependencies:
```sh
npm install
```
- Start the React development server:
```sh
npm start
```

4) Access the app
- Open your web browser and visit http://localhost:3000.
- You should see the movie recommendation app running!


