/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fileexporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Rabeen
 */
public class TxtExporter implements DataExportInterface
{

    @Override
    public String addContent(String location,String codeName, String bloodColour, int numberOfAntennas, int legs, String homePlanet)
    {
        File file = new File(location+"/"+codeName+".txt");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try
        {
            fileWriter = new FileWriter(file.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);
            if (!file.exists())
            {
                file.createNewFile();
            }
            bufferedWriter.write("Code Name          : "+codeName);
            bufferedWriter.newLine();
            bufferedWriter.write("Blood Colour       : "+bloodColour);
            bufferedWriter.newLine();
            bufferedWriter.write("Number Of Antennas : "+numberOfAntennas);
            bufferedWriter.newLine();
            bufferedWriter.write("Number of Legs     : "+legs);
            bufferedWriter.newLine();
            bufferedWriter.write("Home Planet        : "+homePlanet);
            bufferedWriter.newLine();
            
            return file.getAbsolutePath();

        } catch (IOException e)
        {
            e.printStackTrace();
            return "File not saved";
        }
        finally
        {
            try
            {
                bufferedWriter.close();
            } catch (Exception e)
            {
            }
            try
            {
                fileWriter.close();
            } catch (Exception e)
            {
            }
            
        }
    }
}
