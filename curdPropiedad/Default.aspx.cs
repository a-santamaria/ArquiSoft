using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void Buscar(object sender, EventArgs e)
    {
        string categoria = DropDownList1.SelectedValue;

        Response.Redirect("Propiedades.aspx?" + categoria + "=" + TextBox1.Text);
    }
}