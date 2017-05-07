/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.merval.rest;

import com.core.merval.model.RavaData;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 * @author Gonzalo H. Mendoza
 * email: yogonza524@gmail.com
 * StackOverflow: http://stackoverflow.com/users/5079517/gonza
 */
@Path("/data")
public class Rest {

    @GET
    @Path("/leaderPanel")
    public Response leaderPanel() {
        
        int code = 404;
        String result = "Not info loaded yet, please try again or contact to JDev Inc. Team";
        
        try {
            //Get data from URL
            Document leaderPanel = get("https://www.ravaonline.com/v2/precios/panel.php?m=LID");
            
            if (leaderPanel != null && leaderPanel.select(".tablapanel") != null) {
            
                //Prepare output
                result = find(leaderPanel);
                
                code = result != null && !result.isEmpty() ? 200 : 500;
        }
            
        } catch (IOException ex) {
            Logger.getLogger(Rest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Response.status(code).entity(result).build();
    }
    
    @GET
    @Path("/options")
    public Response options() {
        
        int code = 404;
        String result = "Not info loaded yet, please try again or contact to JDev Inc. Team";
        
        try {
            //Get data from URL
            Document leaderPanel = get("https://www.ravaonline.com/v2/precios/panel.php?m=OPC");
            
            if (leaderPanel != null && leaderPanel.select(".tablapanel") != null) {
            
                //Prepare output
                result = find(leaderPanel);
                
                code = result != null && !result.isEmpty() ? 200 : 500;
        }
            
        } catch (IOException ex) {
            Logger.getLogger(Rest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Response.status(code).entity(result).build();
    }
    
    public Document get(String url) throws IOException{

        Connection.Response response= Jsoup.connect(url)
            .ignoreContentType(true)
            .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")  
            .referrer("http://www.google.com")   
            .timeout(12000) 
            .followRedirects(true)
            .execute();

        return response.parse();
    }
    
    private String find(Document leaderPanel){
        String output = "";
        
        Elements e = leaderPanel.select(".tablapanel tr:not(:first-child) ");

        for(Element row : e){
            Element species = row.select("td:nth-child(1)").first();
            Element last = row.select("td:nth-child(2)").first();
            Element percentageDay = row.select("td:nth-child(3)").first();
            Element previous = row.select("td:nth-child(4)").first();
            Element opening = row.select("td:nth-child(5)").first();
            Element min = row.select("td:nth-child(6)").first();
            Element max = row.select("td:nth-child(7)").first();
            Element hour = row.select("td:nth-child(8)").first();
            Element nominalVolume = row.select("td:nth-child(9)").first();
            Element effectiveVolume = row.select("td:nth-child(10)").first();

            RavaData data = new RavaData.RavaDataBuilder()
                    .species(species.text())
                    .last(!last.text().contains("-")? Double.valueOf(last.text().replaceAll(",", ".")) : 0.0)
                    .percentageDay(!percentageDay.text().contains("-")? Double.valueOf(percentageDay.text().replaceAll(",", ".")) : 0.0)
                    .previous(!previous.text().contains("-")? Double.valueOf(previous.text().replaceAll(",", ".")) : 0.0)
                    .opening(!opening.text().contains("-")? Double.valueOf(opening.text().replaceAll(",", ".")) : 0.0)
                    .min(!min.text().contains("-")? Double.valueOf(min.text().replaceAll(",", ".")) : 0.0)
                    .max(!max.text().contains("-")? Double.valueOf(max.text().replaceAll(",", ".")) : 0.0)
                    .hour(hour.text())
                    .nominalVolume(!nominalVolume.text().isEmpty() && nominalVolume.text().length() > 0 && !nominalVolume.text().equals("-") ? Integer.valueOf(nominalVolume.text().replaceAll("\\.", "")) : 0)
                    .effectiveVolume(!effectiveVolume.text().isEmpty() && !nominalVolume.text().contains("-") ? Integer.valueOf(effectiveVolume.text().replaceAll("\\.", "")) : 0)
                    .build();

            output += data.toCSV();
        }
                
        return output;
    }
}
