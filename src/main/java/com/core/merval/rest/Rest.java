/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.merval.rest;

import com.core.merval.model.RavaData;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
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
        
        File file = null;
        String title = "leaderPanel.csv";
        
        file = createFile(title, result);
        
        //return Response.status(code).entity(result).build();
        if (file != null) {
            ResponseBuilder response = Response.ok((Object) file); 
            response.header("Content-Disposition", "attachment; filename=\"" + title + "\"");
            return response.build();
        }
        
        return Response.status(500).entity("Error: process aborted, please try later").build();
        //return Response.status(code).entity(result).build();
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
        
        File file = null;
        String title = "options.csv";
        
        file = createFile(title, result);
        
        //return Response.status(code).entity(result).build();
        if (file != null) {
            ResponseBuilder response = Response.ok((Object) file); 
            response.header("Content-Disposition", "attachment; filename=\"" + title + "\"");
            return response.build();
        }
        
        return Response.status(500).entity("Error: process aborted, please try later").build();
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
                    .last(last.text())
                    .percentageDay(percentageDay.text())
                    .previous(previous.text())
                    .opening(opening.text())
                    .min(min.text())
                    .max(max.text())
                    .hour(hour.text())
                    .nominalVolume(nominalVolume.text())
                    .effectiveVolume(effectiveVolume.text())
                    .build();

            output += data.toCSV();
        }
                
        return output;
    }

    private File createFile(String title, String result) {
        //Create a file
        try(PrintWriter writer = new PrintWriter(title, "UTF-8")) {
            writer.print(result);
            writer.close();
            
            return new File(title);
            
        } catch (IOException e) {
           // do something
            System.out.println("Error creating file");
        }
        return null;
    }
}
