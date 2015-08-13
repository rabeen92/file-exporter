/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fileexporter;

import java.util.List;

/**
 *
 * @author Rabeen R
 */
public class ExportDecider
{

    /*
    * getExporter method decides which implementation class object to be returned.
    */
    public DataExportInterface getExporter(int type, List<String> options)
    {
        DataExportInterface exporter = null;
        try
        {
            switch (type)
            {
                case 1:
                    exporter = new PdfExporter();
                    break;
                case 2:
                    exporter = new TxtExporter();
                    break;
                default:
                    /*
                    * The default block will handle the additional export options added at a later point of time.
                    */
                    boolean result = false;
                    for(int i=0;i<options.size();i++)
                    {
                        if(options.get(i).startsWith("enter "+type+" "))
                        {
                            String classNameWithPackage = options.get(i).split("#")[1];
                            exporter = new OtherPlugins(classNameWithPackage);
                            result = true;
                            break;
                        }
                    }
                    if(result==false)
                    {
                        System.out.println("Export plugin not found");
                    }
                    break;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            return exporter;
        }
    }
}
