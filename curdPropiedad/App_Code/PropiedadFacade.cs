using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for PropiedadFacade
/// </summary>
public class PropiedadFacade
{
    public PropiedadFacade()
    {

    }

    public Property getProperty(int id)
    {
        DataClassesDataContext dc = new DataClassesDataContext();
        var result = from p in dc.Properties where p.Id == id select p;

        return result.First();
    }

    public void edit(int id, int rooms, float rent, string address, string type,
                     string id_owner, string location)
    {
        DataClassesDataContext dc = new DataClassesDataContext();
        
        Property result = (from p in dc.Properties where p.Id == id select p).SingleOrDefault();
        //System.Windows.Forms.MessageBox.Show(prop.rooms.ToString());
        result.rooms = rooms;
        result.rent = rent;
        result.address = address;
        result.type = type;
        result.id_owner = id_owner;
        result.location = location;
        dc.SubmitChanges();
    }

    public void delete(int id)
    {
        DataClassesDataContext dc = new DataClassesDataContext();
        var result = from p in dc.Properties where p.Id == id select p;

        Property prop = result.First();

        dc.Properties.DeleteOnSubmit(prop);
        dc.SubmitChanges();
    }
}