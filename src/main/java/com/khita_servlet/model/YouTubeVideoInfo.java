package com.khita_servlet.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class YouTubeVideoInfo {

    // Método para obter a duração do vídeo
    public static int getVideoDuration(String videoId, String apiKey) {
        String urlString = "https://www.googleapis.com/youtube/v3/videos?id=" + videoId + "&part=contentDetails&key=" + apiKey;

        try {
            // Criar URL e abrir conexão
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Ler a resposta da API
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            String duracao = "";

            while ((inputLine = in.readLine()) != null) {
                if (inputLine.matches(".*\"duration\": .*")){
                    duracao = inputLine.strip();
                }
            }

            String[] separado = duracao.split(": ");

            duracao=separado[1].replace('\"',' ').replace(',',' ').strip();




            separado = duracao.split("PT")[1].split("H");

            String hora = separado[0];

            if (hora.matches(".*[A-Z]")){
                hora = "0";
                separado = separado[0].split("M");
            }
            else{
                separado = separado[1].split("M");
            }



            String minutos = separado[0];

            separado = separado[1].split("S");

            String segundos = separado[0];


            // Fechar conexões
            in.close();
            conn.disconnect();

            int segundosTotais;

            segundosTotais = Integer.parseInt(hora)*3600+
                    Integer.parseInt(minutos)*60+
                    Integer.parseInt(segundos);

            return segundosTotais;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }



    // Método para obter o título do vídeo
    public static String getVideoTitle(String videoId, String apiKey) {
        String urlString = "https://www.googleapis.com/youtube/v3/videos?id=" + videoId + "&part=snippet&key=" + apiKey;

        try {
            // Criar URL e abrir conexão
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Ler a resposta da API
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            String titulo = "";

            while ((inputLine = in.readLine()) != null) {
                if (inputLine.matches(".*\"title\": .*")){
                    titulo = inputLine.strip();
                }
            }

            String[] separado = titulo.split(": ");

            titulo = separado[1].replace('\"',' ').replace(',',' ').strip();


            // Fechar conexões
            in.close();
            conn.disconnect();

            return titulo;

        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to retrieve data.";
        }
    }

}
