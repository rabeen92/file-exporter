/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fileexporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author Rabeen R
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
	  System.out.println("*******************************");
	  System.out.println("ALIEN REGISTRATION - by Rabeen R");
	  System.out.println("*******************************");
        Main fileExporter = new Main();
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            /*
            * Take inputs and validate them
            */
            System.out.println("Enter Code Name");
            String codeName = bufferRead.readLine();
            while(!fileExporter.validateStringInput(codeName))
            {
                System.out.println("Enter a valid value for Code Name");
                codeName=bufferRead.readLine();
            }
            
            System.out.println("Enter Blood Colour");
            String bloodColor = bufferRead.readLine();
            while(!fileExporter.validateStringInput(bloodColor))
            {
                System.out.println("Enter a valid value for blood");
                bloodColor=bufferRead.readLine();
            }
            
            System.out.println("Enter Number Of Antennas");
            String noOfAntennas = bufferRead.readLine();
            while (!fileExporter.validateIntInput(noOfAntennas))
            {
                System.out.println("Enter a valid value for number of Antennas");
                noOfAntennas = bufferRead.readLine();
            }

            System.out.println("Enter Number Of Legs");
            String noOfLegs = bufferRead.readLine();
            while (!fileExporter.validateIntInput(noOfLegs))
            {
                System.out.println("Enter a valid value for number Of Legs");
                noOfLegs = bufferRead.readLine();
            }
            
            System.out.println("Enter Home Planet");
            String homePlanet = bufferRead.readLine();
            while(!fileExporter.validateStringInput(homePlanet))
            {
                System.out.println("Enter a valid value for blood");
                homePlanet=bufferRead.readLine();
            }
            
            /*
            * getExportOptions function will read all the lines from the config file config.txt and store in a list.
            * for additional plugins to be added,each line should be in a predifined format as given below
            * enter <newNumber> for <newFormat>#<packageName>.<className>
            * ex: enter 3 for doc#package1.package2.NewLib
            */
            List<String> options = new GetExportOptions().getExportsOptions();
            for (int i = 0; i < options.size(); i++)
            {
                System.out.println(options.get(i).split("#")[0]);
            }
            
            String exportAs = bufferRead.readLine();
            while(!fileExporter.validateIntInput(exportAs))
            {
			System.out.println("Enter proper integer value from the menu above");
                exportAs = bufferRead.readLine();
            }

            System.out.println("ENTER folder path of the file to be saved");
            String folderLocation = bufferRead.readLine();
            File folder = new File(folderLocation);
            System.out.println(folder.exists());
            System.out.println(folder.isDirectory());
            while (!folder.exists() && !folder.isDirectory())
            {
                System.out.println("ENTER a valid folder path of the file to be saved");
                folderLocation = bufferRead.readLine();
                folder = new File(folderLocation);
            }
            /*
            * Export decider class decides which class to be called for handling 
            * various export options.
            */
            ExportDecider exportDecider = new ExportDecider();
            int exportType = Integer.parseInt(exportAs);
            DataExportInterface exporter = exportDecider.getExporter(exportType, options);
            System.out.println("Saving data");
            String fileName = exporter.addContent(folderLocation, codeName, bloodColor, Integer.parseInt(noOfAntennas), Integer.parseInt(noOfLegs), homePlanet);
            System.out.println(fileName);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    /*
    * validateStringInput method validates whether the user has provided a valid string or not
    */
    private boolean validateStringInput(String stringInput)
    {
        try
        {
            if (stringInput == null)
            {
                return false;
            }
            if (stringInput.trim().equalsIgnoreCase(""))
            {
                return false;
            }
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    /*
    * validateIntInput method validates whether the user has provided a valid integer or not
    */
    private boolean validateIntInput(String intInput)
    {
        try
        {
            int i = Integer.parseInt(intInput);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
