/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.core.merval.model.RavaData;
import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author gonza
 */
public class JsoupTest {
    
    public JsoupTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     @Ignore
     public void opcionesTest() throws IOException {
         Document leaderPanel = get("https://www.ravaonline.com/v2/precios/panel.php?m=LID");
            
        if (leaderPanel != null && leaderPanel.select(".tablapanel") != null) {
            
            //Prepare output
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
            
            System.out.println(output);
        }
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
}
