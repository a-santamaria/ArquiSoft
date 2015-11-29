using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.Linq;

public partial class VistaPropiedad : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void Insert(object sender, EventArgs e)
    {
        DataClassesDataContext dc = new DataClassesDataContext();
        Properties p = new Properties
        {
            Id = 55,
            rent = 55,
            rooms = 5,
            address = "",
            type = "",
            id_owner = null,
            location = null,
        };

        dc.Properties.InsertOnSubmit(p);

        dc.SubmitChanges();
    }
}