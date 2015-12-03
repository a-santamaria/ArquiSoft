using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : Page
{
    PropiedadFacade pFacade;
    protected void Page_Load(object sender, EventArgs e)
    {
        pFacade = new PropiedadFacade();
    }

    protected void delete(object sender, EventArgs e)
    {
        LinkButton b = sender as LinkButton;
        GridViewRow gvr = (GridViewRow)(((LinkButton)sender).Parent.Parent);
        int row = gvr.RowIndex;

        int id = Convert.ToInt32(GridView1.Rows[row].Cells[0].Text);

        pFacade.delete(id);
        GridView1.DataBind();
        //System.Windows.Forms.MessageBox.Show("Soy Delete " + id.ToString());
    }

    protected void edit(object sender, EventArgs e)
    {
        LinkButton b = sender as LinkButton;
        GridViewRow gvr = (GridViewRow)(((LinkButton)sender).Parent.Parent);
        int row = gvr.RowIndex;

        string id = GridView1.Rows[row].Cells[0].Text;

        Response.Redirect("EditarPropiedad.aspx?id=" + id);
        //System.Windows.Forms.MessageBox.Show("Soy edit " + id.ToString());
    }

    protected void create(object sender, EventArgs e)
    {
        Response.Redirect("CrearPropiedad.aspx");
    }
}