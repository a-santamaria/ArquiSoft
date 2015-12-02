using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Descripción breve de PropiedadFacade
/// </summary>
public class PropiedadFacade
{

	public PropiedadFacade()
	{
		
	}

    public Properties getProperty(int id)
    {
        DataClassesDataContext dc = new DataClassesDataContext();
        var result = from p in dc.Properties where p.Id == id select p;

        return result.First();
    }

    public void edit(Properties prop)
    {
        DataClassesDataContext dc = new DataClassesDataContext();
        Properties result = (from p in dc.Properties where p.Id == prop.Id select p).SingleOrDefault();
        //System.Windows.Forms.MessageBox.Show(prop.rooms.ToString());
        result.rooms = prop.rooms;
        dc.SubmitChanges();
    }

    public void delete(int id)
    {
        DataClassesDataContext dc = new DataClassesDataContext();
        var result = from p in dc.Properties where p.Id == id  select p;

        Properties prop = result.First();

        dc.Properties.DeleteOnSubmit(prop);
        dc.SubmitChanges();
    }
}