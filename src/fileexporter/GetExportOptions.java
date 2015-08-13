/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fileexporter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class GetExportOptions
{

    public List getExportsOptions()
    {
        BufferedReader br = null;
        FileReader fileReader = null;
        List<String> options = new ArrayList();
        try
        {

            String sCurrentLine;
            fileReader = new FileReader("config.txt");
            br = new BufferedReader(fileReader);

            while ((sCurrentLine = br.readLine()) != null)
            {
                options.add(sCurrentLine);
            }
            return options;
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
            return options;
        } finally
        {
            try
            {
                if (br != null)
                {
                    br.close();
                }
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
            try
            {
                if (fileReader != null)
                {
                    fileReader.close();
                }
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
