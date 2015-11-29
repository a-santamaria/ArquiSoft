<%@ Page Language="C#" AutoEventWireup="true" CodeFile="VistaPropiedad.aspx.cs" Inherits="VistaPropiedad" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
    <form id="form1" runat="server">
    <div>
    <asp:ListView ID="ListView1" runat="server" DataKeyNames="Id" DataSourceID="LinqDataSource1" InsertItemPosition="LastItem">
        <AlternatingItemTemplate>
            <li style="background-color: #FAFAD2;color: #284775;">Id:
                <asp:Label ID="IdLabel" runat="server" Text='<%# Eval("Id") %>' />
                <br />
                rent:
                <asp:Label ID="rentLabel" runat="server" Text='<%# Eval("rent") %>' />
                <br />
                rooms:
                <asp:Label ID="roomsLabel" runat="server" Text='<%# Eval("rooms") %>' />
                <br />
                address:
                <asp:Label ID="addressLabel" runat="server" Text='<%# Eval("address") %>' />
                <br />
                type:
                <asp:Label ID="typeLabel" runat="server" Text='<%# Eval("type") %>' />
                <br />
                id_owner:
                <asp:Label ID="id_ownerLabel" runat="server" Text='<%# Eval("id_owner") %>' />
                <br />
                location:
                <asp:Label ID="locationLabel" runat="server" Text='<%# Eval("location") %>' />
                <br />
                <asp:Button ID="EditButton" runat="server" CommandName="Edit" Text="Editar" />
                <asp:Button ID="DeleteButton" runat="server" CommandName="Delete" Text="Eliminar" />
            </li>
        </AlternatingItemTemplate>
        <EditItemTemplate>
            <li style="background-color: #FFCC66;color: #000080;">Id:
                <asp:Label ID="IdLabel1" runat="server" Text='<%# Eval("Id") %>' />
                <br />
                rent:
                <asp:TextBox ID="rentTextBox" runat="server" Text='<%# Bind("rent") %>' />
                <br />
                rooms:
                <asp:TextBox ID="roomsTextBox" runat="server" Text='<%# Bind("rooms") %>' />
                <br />
                address:
                <asp:TextBox ID="addressTextBox" runat="server" Text='<%# Bind("address") %>' />
                <br />
                type:
                <asp:TextBox ID="typeTextBox" runat="server" Text='<%# Bind("type") %>' />
                <br />
                id_owner:
                <asp:TextBox ID="id_ownerTextBox" runat="server" Text='<%# Bind("id_owner") %>' />
                <br />
                location:
                <asp:TextBox ID="locationTextBox" runat="server" Text='<%# Bind("location") %>' />
                <br />
                <asp:Button ID="UpdateButton" runat="server" CommandName="Update" Text="Actualizar" />
                <asp:Button ID="CancelButton" runat="server" CommandName="Cancel" Text="Cancelar" />
            </li>
        </EditItemTemplate>
        <EmptyDataTemplate>
            No se han devuelto datos.
        </EmptyDataTemplate>
        <InsertItemTemplate>
            <li style="">Id:
                <asp:TextBox ID="IdTextBox" runat="server" Text='<%# Bind("Id") %>' />
                <br />rent:
                <asp:TextBox ID="rentTextBox" runat="server" Text='<%# Bind("rent") %>' />
                <br />rooms:
                <asp:TextBox ID="roomsTextBox" runat="server" Text='<%# Bind("rooms") %>' />
                <br />address:
                <asp:TextBox ID="addressTextBox" runat="server" Text='<%# Bind("address") %>' />
                <br />type:
                <asp:TextBox ID="typeTextBox" runat="server" Text='<%# Bind("type") %>' />
                <br />id_owner:
                <asp:TextBox ID="id_ownerTextBox" runat="server" Text='<%# Bind("id_owner") %>' />
                <br />location:
                <asp:TextBox ID="locationTextBox" runat="server" Text='<%# Bind("location") %>' />
                <br />
                <asp:Button ID="InsertButton" runat="server" onClick="Insert" Text="Insertar" />
                <asp:Button ID="CancelButton" runat="server" CommandName="Cancel" Text="Borrar" />
            </li>
        </InsertItemTemplate>
        <ItemSeparatorTemplate>
<br />
        </ItemSeparatorTemplate>
        <ItemTemplate>
            <li style="background-color: #FFFBD6;color: #333333;">Id:
                <asp:Label ID="IdLabel" runat="server" Text='<%# Eval("Id") %>' />
                <br />
                rent:
                <asp:Label ID="rentLabel" runat="server" Text='<%# Eval("rent") %>' />
                <br />
                rooms:
                <asp:Label ID="roomsLabel" runat="server" Text='<%# Eval("rooms") %>' />
                <br />
                address:
                <asp:Label ID="addressLabel" runat="server" Text='<%# Eval("address") %>' />
                <br />
                type:
                <asp:Label ID="typeLabel" runat="server" Text='<%# Eval("type") %>' />
                <br />
                id_owner:
                <asp:Label ID="id_ownerLabel" runat="server" Text='<%# Eval("id_owner") %>' />
                <br />
                location:
                <asp:Label ID="locationLabel" runat="server" Text='<%# Eval("location") %>' />
                <br />
                <asp:Button ID="EditButton" runat="server" CommandName="Edit" Text="Editar" />
                <asp:Button ID="DeleteButton" runat="server" CommandName="Delete" Text="Eliminar" />
            </li>
        </ItemTemplate>
        <LayoutTemplate>
            <ul id="itemPlaceholderContainer" runat="server" style="font-family: Verdana, Arial, Helvetica, sans-serif;">
                <li runat="server" id="itemPlaceholder" />
            </ul>
            <div style="text-align: center;background-color: #FFCC66;font-family: Verdana, Arial, Helvetica, sans-serif;color: #333333;">
            </div>
        </LayoutTemplate>
        <SelectedItemTemplate>
            <li style="background-color: #FFCC66;font-weight: bold;color: #000080;">Id:
                <asp:Label ID="IdLabel" runat="server" Text='<%# Eval("Id") %>' />
                <br />
                rent:
                <asp:Label ID="rentLabel" runat="server" Text='<%# Eval("rent") %>' />
                <br />
                rooms:
                <asp:Label ID="roomsLabel" runat="server" Text='<%# Eval("rooms") %>' />
                <br />
                address:
                <asp:Label ID="addressLabel" runat="server" Text='<%# Eval("address") %>' />
                <br />
                type:
                <asp:Label ID="typeLabel" runat="server" Text='<%# Eval("type") %>' />
                <br />
                id_owner:
                <asp:Label ID="id_ownerLabel" runat="server" Text='<%# Eval("id_owner") %>' />
                <br />
                location:
                <asp:Label ID="locationLabel" runat="server" Text='<%# Eval("location") %>' />
                <br />
                <asp:Button ID="EditButton" runat="server" CommandName="Edit" Text="Editar" />
                <asp:Button ID="DeleteButton" runat="server" CommandName="Delete" Text="Eliminar" />
            </li>
        </SelectedItemTemplate>
        </asp:ListView>
        <asp:LinqDataSource ID="LinqDataSource1" runat="server" ContextTypeName="DataClassesDataContext" EnableDelete="True" EnableInsert="True" EnableUpdate="True" EntityTypeName="" TableName="Properties">
        </asp:LinqDataSource>
    </div>
    </form>
    
</body>
</html>
