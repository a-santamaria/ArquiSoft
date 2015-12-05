using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

/// <summary>
/// Descripción breve de autorizar
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
// [System.Web.Script.Services.ScriptService]
public class autorizar : System.Web.Services.WebService {

    public autorizar () {

        //Elimine la marca de comentario de la línea siguiente si utiliza los componentes diseñados 
        //InitializeComponent(); 
    }

    [WebMethod]
    public string HelloWorld() {
        return "Hola a todos";
    }


     [WebMethod]
    public bool autorizarPago(string type, string number, string holder, int amountPay)
    {
        DataClassesDataContext dc = new DataClassesDataContext();
   
        CreditCard c = (from s in dc.CreditCard where s.type == type && s.number ==number && s.holder == holder select s).SingleOrDefault();
        if (c == null)            return false;
        if (c.amount < amountPay) return false;

        c.amount = c.amount - amountPay;
        dc.CreditCard.InsertOnSubmit(c);

        Payments p = new Payments();
        p.Amount = amountPay;
        p.IdCreditCard = c.IdCreditCard;
        dc.Payments.InsertOnSubmit(p);


        dc.SubmitChanges();
        return true;
    }
    
}
