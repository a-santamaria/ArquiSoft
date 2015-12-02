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
        property = pFacade.getProperty(id);

        TextBoxId.Text = property.Id.ToString();
        TextBoxAddress.Text = property.address;
        TextBoxId_Owner.Text = property.id_owner;
        TextBoxRooms.Text = property.rooms.ToString();
        TextBoxType.Text = property.type;
         
    }

    protected void edit(object sender, EventArgs e)
    {
        try
        {
            //property.Id = Int32.Parse(TextBoxId.Text);
            property.address = TextBoxAddress.Text;
            System.Windows.Forms.MessageBox.Show(TextBoxRooms.Text);
            /*property.id_owner = TextBoxId_Owner.Text;
            property.rooms = Int32.Parse(TextBoxRooms.Text);
            System.Windows.Forms.MessageBox.Show(TextBoxRooms.Text);
            property.type = TextBoxType.Text;
            pFacade.edit(property);*/

        }
        catch (Exception ex)
        {
            Console.WriteLine("An error occurred: '{0}'", ex);
        }
    }
}