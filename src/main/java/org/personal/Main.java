package org.personal;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {
    public static void main(String[] args) {
        String apiUrl = "https://pokeapi.co/api/v2/pokemon/";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select an pokemon number you want to know about: ");
        String iD = scanner.next();

        apiUrl += iD;

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

            String name = json.get("name").getAsString();
            int height = json.get("height").getAsInt();
            int weight = json.get("weight").getAsInt();
            int id = json.get("id").getAsInt();

            System.out.println("Pokemon: " + name);
            System.out.println("Pokedex Number: " + id);
            System.out.println("Height: " + height);
            System.out.println("Weight: " + weight);

        } catch (Exception e) {
            System.out.println("Error fetching data: " + e.getMessage());
        }
    }
}