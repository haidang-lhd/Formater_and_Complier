/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nhom26;
import com.google.gson.Gson;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Comp {
    
   
    String clientId = "ef626b90640f4daad31639272990ee3"; //Replace with your client ID
    String clientSecret = "aae9da5bd9a2b29546b46dc0843ad2d8018a719d855573b686c89bf4512c7088"; //Replace with your client Secret


    String script = "";
    String language = "";
    String versionIndex = "2";
    public String sendPost(String lang,String code,String stdinz)
    {
        
        language=lang;
        script=code;
        String rs="";
        try {
            URL url = new URL("https://api.jdoodle.com/v1/execute");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            String input =  "{"+
                                "\"clientId\":\""+clientId+"\","+
                                "\"clientSecret\":\""+clientSecret+"\","+
                                "\"script\":\""+code
                                                .replace("\"", "\\\"")
                                                .replace("\n", "\\n")
//                                                .replaceAll("\\n", "\n")
                                                +"\","+
                                "\"stdin\":\""+stdinz
                                                .replace("\"", "\\\"")
                                                .replace("\n", "\\n")
//                                                .replaceAll("\\n", "\n")
                                                +"\","+
                                "\"language\":\""+language+"\","+
                                "\"versionIndex\":\""+versionIndex+"\""+
                                "}";;

           // System.out.println(input);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(input.getBytes());
            outputStream.flush();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
              //  System.err.println("nô");
               return "server cannot compile this code";
                // throw new RuntimeException("Please check your inputs : HTTP error code : "+ connection.getResponseCode());
            }

            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(new InputStreamReader(
            (connection.getInputStream())));

            String output;

            while ((output = bufferedReader.readLine()) != null) {
                
                rs=output;
            }
            Gson gson = new Gson(); // Create Gson
            Complier complier = gson.fromJson(rs, Complier.class);
            
            connection.disconnect();
            //System.out.println(rs);
            return complier.output;
            

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
      //  System.out.println(rs);
        return rs;
    }
     public class Complier
    {
      
        public String output;
       
        public String statusCode;
    
        public String memory;

        public String cpuTime;
    }
     


}
