<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="FeaturedContent" Runat="Server">
    <section class="featured">
        <div class="content-wrapper">
            <hgroup class="title">
                <h2>Buscar Propiedad</h2>
            </hgroup>
        </div>
    </section>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="MainContent" Runat="Server">
    <asp:Label ID="Label1" runat="server" Text="Label">Categoria de Busqueda: </asp:Label>
    <asp:DropDownList ID="DropDownList1" runat="server">
        <asp:ListItem>id</asp:ListItem>
        <asp:ListItem>rooms</asp:ListItem>
        <asp:ListItem>location</asp:ListItem>
        <asp:ListItem>address</asp:ListItem>
         <asp:ListItem>type</asp:ListItem>
        <asp:ListItem>rent</asp:ListItem>
        <asp:ListItem>id_owner</asp:ListItem>
    </asp:DropDownList>
    <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
    <asp:Button ID="ButtonBuscar" runat="server" OnClick="buscar" Text="Buscar" />
    <br />
    <asp:Button ID="ButtonTodas" runat="server" OnClick="verTodas" Text="Ver Todas" />
    <br />
    <asp:Button ID="ButtonCrear" runat="server" OnClick="create" Text="Crear Propiedad"  />
</asp:Content>

