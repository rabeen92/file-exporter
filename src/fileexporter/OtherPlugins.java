/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fileexporter;

import java.lang.reflect.Method;

/**
 *
 * @author Rabeen R
 */
public class OtherPlugins implements DataExportInterface
{

    private String classNameWithPackage = null;

    public OtherPlugins(String classNameWithPackage)
    {
        this.classNameWithPackage = classNameWithPackage;
    }

    @Override
    public String addContent(String location, String codeName, String bloodColour, int numberOfAntennas, int legs, String homePlanet)
    {
        try
        {
            Object foo = Class.forName(classNameWithPackage).newInstance();
            Method m = foo.getClass().getDeclaredMethod("addContent", String.class,String.class,String.class,int.class,int.class,String.class);
            m.invoke(foo,location,codeName,bloodColour,numberOfAntennas,legs,homePlanet);
            return "success";
        } catch (Exception e)
        {
            System.out.println(classNameWithPackage+" not found");
            return "failed";
        }
    }
}
