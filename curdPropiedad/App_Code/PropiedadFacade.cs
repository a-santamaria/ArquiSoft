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

    public Properties getProperty(int id)
    {
        DataClassesDataContext dc = new DataClassesDataContext();
        var result = from p in dc.Properties where p.Id == id select p;

        return result.First();
    }

    public void edit(int id, int rooms, float rent, string address, string type,
                     string id_owner, string location)
    {
        DataClassesDataContext dc = new DataClassesDataContext();

        Properties result = (from p in dc.Properties where p.Id == id select p).SingleOrDefault();
        //System.Windows.Forms.MessageBox.Show(prop.rooms.ToString());
        result.rooms = rooms;
        result.rent = rent;
        result.address = address;
        result.type = type;
        result.id_owner = id_owner;
        result.location = location;
        dc.SubmitChanges();
    }

    public int create(int rooms, float rent, string address, string type,
                     string id_owner, string location)
    {
        
        DataClassesDataContext dc = new DataClassesDataContext();

        Properties prop = new Properties();
        
        prop.rooms = rooms;
        prop.rent = rent;
        prop.address = address;
        prop.type = type;
        prop.id_owner = id_owner;
        prop.location = location;
        
        dc.Properties.InsertOnSubmit(prop);

        dc.SubmitChanges();
        return prop.Id;
    }

    public List<Properties> getProperties()
    {
        DataClassesDataContext dc = new DataClassesDataContext();
        var result = from p in dc.Properties select p;
        List<Properties> lista = new List<Properties>();
        if(result != null)
        {
            foreach (Properties p in result)
            {
                lista.Add(p);
            }
            }

        return lista;
    }

    public List<Properties> getPropertiesBy(string categoria, string valor)
    {

        DataClassesDataContext dc = new DataClassesDataContext();
        List<Properties> lista = new List<Properties>();
        try
        {
            if (categoria == "id")
            {
                var result = from p in dc.Properties where p.Id == Int32.Parse(valor) select p;


                foreach (Properties p in result)
                {
                    lista.Add(p);
                }
            }
            else if (categoria == "rooms")
            {
                var result = from p in dc.Properties where p.rooms == Int32.Parse(valor) select p;


                foreach (Properties p in result)
                {
                    lista.Add(p);
                }
            }
            else if (categoria == "rent")
            {
                var result = from p in dc.Properties where p.rent == Int32.Parse(valor) select p;


                foreach (Properties p in result)
                {
                    lista.Add(p);
                }
            }
            else if (categoria == "address")
            {
                var result = from p in dc.Properties where p.address == valor select p;


                foreach (Properties p in result)
                {
                    lista.Add(p);
                }
            }
            else if (categoria == "type")
            {
                var result = from p in dc.Properties where p.type == valor select p;


                foreach (Properties p in result)
                {
                    lista.Add(p);
                }
            }
            else if (categoria == "id_owner")
            {
                var result = from p in dc.Properties where p.id_owner == valor select p;


                foreach (Properties p in result)
                {
                    lista.Add(p);
                }
            }
            else if (categoria == "location")
            {
                var result = from p in dc.Properties where p.location == valor select p;


                foreach (Properties p in result)
                {
                    lista.Add(p);
                }
            }

        }
        catch (Exception e)
        {
        }

        return lista;
    }

    public void delete(int id)
    {
        DataClassesDataContext dc = new DataClassesDataContext();
        var result = from p in dc.Properties where p.Id == id select p;

        Properties prop = result.First();

        dc.Properties.DeleteOnSubmit(prop);
        dc.SubmitChanges();
    }


    public List<String> getLocationsNames()
    {
        DataClassesDataContext dc = new DataClassesDataContext();
        var result = from l in dc.Locations select l.location;
        List<String> lista = new List<String>();
        if(result != null)
        {
            foreach (string p in result)
            {
                lista.Add(p);
            }
            }

        return lista;
    }


}