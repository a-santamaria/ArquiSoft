﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class CrearPropiedad : System.Web.UI.Page
{
    PropiedadFacade pFacade;
    protected void Page_Load(object sender, EventArgs e)
    {
        pFacade = new PropiedadFacade();

    }

    protected void create(object sender, EventArgs e)
    {
        try
        {
            string address = TextBoxAddress.Text;
            string id_owner = TextBoxId_Owner.Text;
            int rooms = Int32.Parse(TextBoxRooms.Text);
            string type = TextBoxType.Text;
            float rent = float.Parse(TextBoxRent.Text);
            string location = TextBoxLocation.Text;

            int id = pFacade.create(rooms, rent, address, type, id_owner, location);
            System.Windows.Forms.MessageBox.Show("Propiedad creda exitosamente con id "+ id);
            Response.Redirect("Default.aspx");
        }
        catch (Exception ex)
        {

        }


    }

    protected void cancel(object sender, EventArgs e)
    {
        Response.Redirect("Default.aspx");
    }
}