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
            DropDownListRooms.SelectedValue = property.rooms.ToString();
            DropDownListType.SelectedValue = property.type;

            DropDownListLocation.DataSource = pFacade.getLocationsNames();
            DropDownListLocation.DataBind();

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
            int rooms = Int32.Parse(DropDownListRooms.SelectedValue);
            string type = DropDownListType.SelectedValue;
            float rent = float.Parse(TextBoxRent.Text);
            string location = DropDownListLocation.SelectedValue;

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