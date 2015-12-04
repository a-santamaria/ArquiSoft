using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class EditarPropiedad : System.Web.UI.Page
{
    PropiedadFacade pFacade;
    Properties property;
    protected void Page_Load(object sender, EventArgs e)
    {
        pFacade = new PropiedadFacade();
        int id = Int32.Parse(Request.QueryString["id"]);
        if (!IsPostBack)
        {

            property = pFacade.getProperty(id);

            TextBoxId.Text = property.Id.ToString();
            TextBoxAddress.Text = property.address;
            TextBoxId_Owner.Text = property.id_owner;
            TextBoxRooms.Text = property.rooms.ToString();
            TextBoxType.Text = property.type;
            TextBoxLocation.Text = property.location;
            TextBoxRent.Text = property.rent.ToString();
        }

    }

    protected void edit(object sender, EventArgs e)
    {
        try
        {
            string address = TextBoxAddress.Text;
            int id = Int32.Parse(TextBoxId.Text);
            string id_owner = TextBoxId_Owner.Text;
            int rooms = Int32.Parse(TextBoxRooms.Text);
            string type = TextBoxType.Text;
            float rent = float.Parse(TextBoxRent.Text);
            string location = TextBoxLocation.Text;

            pFacade.edit(id, rooms, rent, address, type, id_owner, location);
            string returnURL = "Default.aspx";
            if (Request.Cookies["returnURL"] != null)
            {

                returnURL = Request.Cookies["returnURL"].Value;
            }
            Response.Redirect(returnURL);
        }
        catch (Exception ex)
        {

        }


    }

    protected void cancel(object sender, EventArgs e)
    {
        string returnURL = "Default.aspx";
        if (Request.Cookies["returnURL"] != null)
        {
            
            returnURL = Request.Cookies["returnURL"].Value;
        }
        Response.Redirect(returnURL);
    }
}