package com.jembot;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;
import org.json.JSONObject;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();

        while (true) {
            System.out.print("you>: ");
            String inputText = scanner.nextLine();

            if (inputText.equalsIgnoreCase("exit") ||
                inputText.equalsIgnoreCase("quit") ||
                inputText.equalsIgnoreCase("murtad") ||
                inputText.equalsIgnoreCase("keluar")) {
                System.out.println("byedah...");
                break;
            }

            try {
                String responseMessage = sendRequest(client, inputText);
                System.out.println("bot>: " + responseMessage);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static String sendRequest(HttpClient client, String text) throws Exception {
        String postData = "text=" + text + "&lc=id";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.simsimi.vn/v1/simtalk"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(BodyPublishers.ofString(postData))
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        JSONObject jsonResponse = new JSONObject(response.body());

        return jsonResponse.optString("message", "error");
    }
}
