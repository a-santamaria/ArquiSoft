using System;
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

        DropDownListLocation.DataSource = pFacade.getLocationsNames();
        DropDownListLocation.DataBind();

    }

    protected void create(object sender, EventArgs e)
    {
        try
        {
            string address = DropDownListAdd1.SelectedValue + " " + 
                             TextBoxAddress1.Text + " # " + TextBoxAddress2.Text
                             + "-" + TextBoxAddress3.Text;
            string id_owner = TextBoxId_Owner.Text;
            int rooms = Int32.Parse(DropDownListRooms.SelectedValue);
            string type = DropDownListType.SelectedValue;
            float rent = float.Parse(TextBoxRent.Text);
            string location = DropDownListLocation.SelectedValue;

            int id = pFacade.create(rooms, rent, address, type, id_owner, location);
            if (id == -1)
            {
                System.Windows.Forms.MessageBox.Show("La dirección no existe en SNR o no está habilitado");
            }
            else
            {
                System.Windows.Forms.MessageBox.Show("Propiedad creda exitosamente con id " + id);
            }
            Response.Redirect("Default.aspx");
        }
        catch (Exception ex)
        {
            //System.Windows.Forms.MessageBox.Show("entre ex " + ex.Message);
        }


    }

    protected void cancel(object sender, EventArgs e)
    {
        Response.Redirect("Default.aspx");
    }
}