# Pokémon API Fetcher

This Java program fetches Pokémon data from the [PokéAPI](https://pokeapi.co/) based on a user's chosen Pokédex number.

## Features
- Fetches Pokémon name, height, id, and weight.
- Uses Java's built-in `HttpClient` to make API calls.
- Parses JSON using `Gson`.

## How to Run
To compile and run the program a Maven wrapper is included for the time being.
1. Install Java (version 11+).
2. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/your-repo-name.git
3. To run for the first time on windows open cmd in the project folder and enter the following:
   ```bash
    mvnw.cmd package
    java -jar API_work-1.0-SNAPSHOT.jar
   ```
   Then to run after first install:
   ```cmd
   java -jar API_work-1.0-SNAPSHOT.jar

## Example Output
   ```
    Select a Pokédex number you want to know about: 25
    Pokémon: Pikachu
    Pokédex Number: 25
    Height: 4
    Weight: 60
   ```

## Future Improvements
- Add error handling for invalid inputs
- Allow users to fetch multiple Pokemon at once.
- Implement a simple GUI interface.
- Cache results to reduce API calls.