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

    public void delete(int id)
    {
        DataClassesDataContext dc = new DataClassesDataContext();
        var result = from p in dc.Properties where p.Id == id  select p;

        Properties prop = result.First();

        dc.Properties.DeleteOnSubmit(prop);
        dc.SubmitChanges();
    }
}