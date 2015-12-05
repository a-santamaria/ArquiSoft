using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _Default : Page
{
    PropiedadFacade pFacade;
    List<Properties> propiedades;
    protected void Page_Load(object sender, EventArgs e)
    {
        propiedades = new List<Properties>();
        pFacade = new PropiedadFacade();
        Boolean searchHasProperties = updateBusqueda();
        if (!IsPostBack)
        {
            if (!searchHasProperties)
            {
                System.Windows.Forms.MessageBox.Show("La busqueda no retornó resultados");
                Response.Redirect("Default.aspx");
            }
            else
            {
                GridView1.DataSource = propiedades;
                GridView1.DataBind();
            }
        }
        

        
    }

    protected void delete(object sender, EventArgs e)
    {
        LinkButton b = sender as LinkButton;
        GridViewRow gvr = (GridViewRow)(((LinkButton)sender).Parent.Parent);
        int row = gvr.RowIndex;
        

        int id = Convert.ToInt32(GridView1.Rows[row].Cells[0].Text);

        pFacade.delete(id);
        if (!updateBusqueda())
        {
            Label1.Text = "No Hay propiedades con los campos de busqueda";
            Label1.Visible = true;
        }
        GridView1.DataSource = propiedades;
        GridView1.DataBind();
    }

    protected void edit(object sender, EventArgs e)
    {
        LinkButton b = sender as LinkButton;
        GridViewRow gvr = (GridViewRow)(((LinkButton)sender).Parent.Parent);
        int row = gvr.RowIndex;

        string id = GridView1.Rows[row].Cells[0].Text;
        HttpCookie cookieReturnURL = new HttpCookie("returnURL");
        cookieReturnURL.Value = Request.Url.AbsoluteUri;
        cookieReturnURL.Expires = DateTime.Now.AddHours(1);
        Response.SetCookie(cookieReturnURL);

        Response.Redirect("EditarPropiedad.aspx?id=" + id);
    }

    protected void back(object sender, EventArgs e)
    {
        Response.Redirect("Default.aspx");
    }

    protected Boolean updateBusqueda()
    {
        propiedades.Clear();
        if (Request.QueryString["id"] != null)
        {
            propiedades = pFacade.getPropertiesBy("id", Request.QueryString["id"]);
        }
        else if (Request.QueryString["rooms"] != null)
        {
            propiedades = pFacade.getPropertiesBy("rooms", Request.QueryString["rooms"]);
        }
        else if (Request.QueryString["rent"] != null)
        {
            propiedades = pFacade.getPropertiesBy("rent", Request.QueryString["rent"]);
        }
        else if (Request.QueryString["address"] != null)
        {
            propiedades = pFacade.getPropertiesBy("address", Request.QueryString["address"]);
        }
        else if (Request.QueryString["type"] != null)
        {
            propiedades = pFacade.getPropertiesBy("type", Request.QueryString["type"]);
        }
        else if (Request.QueryString["id_owner"] != null)
        {
            propiedades = pFacade.getPropertiesBy("id_owner", Request.QueryString["id_owner"]);
        }
        else if (Request.QueryString["location"] != null)
        {
            propiedades = pFacade.getPropertiesBy("location", Request.QueryString["location"]);
        }
        else
        {
            propiedades = pFacade.getProperties();
        }

        if (propiedades.Count == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}