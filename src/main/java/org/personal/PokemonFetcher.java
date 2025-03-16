package org.personal;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PokemonFetcher {
    public static void main(String[] args) {
        String apiUrl = "https://pokeapi.co/api/v2/pokemon/";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! To start, enter a global PokéDex number or Pokémon name.");

        do {
            System.out.println("Select a PokéDex number you want to know about: ");
            String iD = scanner.nextLine();

            String url = apiUrl + iD;

            try {
                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .GET()
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

                String name = json.get("name").getAsString();
                int height = json.get("height").getAsInt();
                int weight = json.get("weight").getAsInt();
                int id = json.get("id").getAsInt();
//            String type = json.get("types").getAsString();
                JsonArray Jtypes = json.get("types").getAsJsonArray();
                StringBuilder types = new StringBuilder();

                for (int i = 0; i < Jtypes.size(); i++) {
                    //this line is overcomplicated but is the shortest way to access the required field I can see atm.
                    types.append(Jtypes.get(i).getAsJsonObject().getAsJsonObject("type").get("name").getAsString());
                    if (i < Jtypes.size() - 1) {
                        types.append(", ");
                    }
                }

                System.out.println("Pokémon: " + name);
                System.out.println("Global PokéDex ID: " + id);
                System.out.println("Types: " + types);
                System.out.println("Height: " + height);
                System.out.println("Weight: " + weight);

            } catch (Exception e) {
                System.out.println("Error fetching data: " + e.getMessage());
            }

            System.out.println("Press x to exit, or any other key to continue");
        } while (!scanner.nextLine().equals("x"));
    }
}