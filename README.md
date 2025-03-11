# Pokémon API Fetcher

This Java program fetches Pokémon data from the [PokéAPI](https://pokeapi.co/) based on a user's chosen Pokédex number.

## Features
- Fetches Pokémon name, height, id, and weight.
- Uses Java's built-in `HttpClient` to make API calls.
- Parses JSON using `Gson`.

## How to Run
1. Install Java (version 11+).
2. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/your-repo-name.git
3. Compile and run the program:
   ```bash
   javac PokemonFetcher.java
   java PokemonFetcher

## Example Output
   ```
    Select an pokemon number you want to know about: 25
    Pokemon: Pikachu
    Pokedex Number: 25
    Height: 4
    Weight: 60
   ```

## Future Improvements
- Add error handling for invalid inputs
- Allow users to fetch multiple Pokemon at once.
- Cache results to reduce API calls.