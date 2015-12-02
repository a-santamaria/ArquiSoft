using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Windows;

public partial class _Default : System.Web.UI.Page
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

        int id = Convert.ToInt32(GridView1.Rows[row].Cells[1].Text);

        pFacade.delete(id);
        GridView1.DataBind();
        //System.Windows.Forms.MessageBox.Show("Soy Delete " + id.ToString());
    }

    protected void edit(object sender, EventArgs e)
    {
        LinkButton b = sender as LinkButton;
        GridViewRow gvr = (GridViewRow)(((LinkButton)sender).Parent.Parent);
        int row = gvr.RowIndex;

        int id = Convert.ToInt32(GridView1.Rows[row].Cells[1].Text);

        //System.Windows.Forms.MessageBox.Show("Soy edit " + id.ToString());
    }

   
}