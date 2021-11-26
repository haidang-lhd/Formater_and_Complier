/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nhom26;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Format {
    
    public String sendPost(String code)
    {
        
        try {
            Document doc = Jsoup.connect("http://prettyprinter.de/index.php")
                    .data("source", code)
                    .data("addnewlines", "on")
                    .data("removeemptylines", "on")
                    .data("onelineperstatementexcludeforandquotes   ", "on")
                    .userAgent("Mozilla").ignoreContentType(true).post();
            
            return "<html><body>"+doc.getElementsByTag("code").toString()+"</body></html>";
            
        } catch (IOException ex) {
            Logger.getLogger(Format.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return "";
        
    }
    
   
}
