/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fileexporter;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileOutputStream;

public class PdfExporter implements DataExportInterface
{
    @Override
    public String addContent(String location,String codeName,String bloodColour,int numberOfAntennas,int legs,String homePlanet)
    {
        FileOutputStream fileOutputStream = null;
        Document document = new Document();
        try
        {
            String file = location+"/"+codeName+".pdf";
            fileOutputStream = new FileOutputStream(file);
            PdfWriter.getInstance(document,fileOutputStream);
            document.open();
            Paragraph subPara = new Paragraph("Alien Profile Details");
            document.add(subPara);
            document.add(new Paragraph("Code Name               : "+codeName));
            document.add(new Paragraph("Blood Colour              : "+bloodColour));
            document.add(new Paragraph("Number Of Antennas : "+numberOfAntennas));
            document.add(new Paragraph("Number of Legs          : "+legs));
            document.add(new Paragraph("Home Planet               : "+homePlanet));
            return file;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return "File Not Saved";
        }
        finally
        {
            try
            {
                document.close();
            } catch (Exception e)
            {
            }
            try
            {
                fileOutputStream.close();
            } catch (Exception e)
            {
            }
        }


    }
}
