<%@ Page Language="C#" AutoEventWireup="true" CodeFile="EditarPropiedad.aspx.cs" Inherits="EditarPropiedad" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        
       
        <asp:Table ID="Table1" runat="server">
            <asp:TableRow>
                <asp:TableCell>
                    <asp:Label ID="LabelId" runat="server" Text="id" />
                </asp:TableCell>
                <asp:TableCell>
                    <asp:TextBox ID="TextBoxId" runat="server" />
                </asp:TableCell>
            </asp:TableRow>

            <asp:TableRow>
                <asp:TableCell>
                    <asp:Label ID="LabelRooms" runat="server" Text="rooms" />
                </asp:TableCell>
                <asp:TableCell>
                    <asp:TextBox ID="TextBoxRooms" runat="server" />
                </asp:TableCell>
            </asp:TableRow>

            <asp:TableRow>
                <asp:TableCell>
                    <asp:Label ID="LabelAddress" runat="server" Text="address" />
                </asp:TableCell>
                <asp:TableCell>
                    <asp:TextBox ID="TextBoxAddress" runat="server" />
                </asp:TableCell>
            </asp:TableRow>

            <asp:TableRow>
                <asp:TableCell>
                    <asp:Label ID="LabelType" runat="server" Text="type" />
                </asp:TableCell>
                <asp:TableCell>
                    <asp:TextBox ID="TextBoxType" runat="server" />
                </asp:TableCell>
            </asp:TableRow>

            <asp:TableRow>
                <asp:TableCell>
                    <asp:Label ID="LabelId_Owner" runat="server" Text="id_Owner" />
                </asp:TableCell>
                <asp:TableCell>
                    <asp:TextBox ID="TextBoxId_Owner" runat="server" />
                </asp:TableCell>
            </asp:TableRow>
        </asp:Table>

        <asp:Button ID="ButtonEdit" runat="server" Text="Editar" OnClick="edit" />
        <asp:Button ID="ButtonCancel" runat="server" Text="Cancelar" />


        <asp:LinqDataSource ID="LinqDataSource1" runat="server" ContextTypeName="DataClassesDataContext" EntityTypeName="" TableName="Properties" Where="Id == @Id">
            <WhereParameters>
                <asp:Parameter DefaultValue="1" Name="Id" Type="Int32" />
            </WhereParameters>
        </asp:LinqDataSource>
        
    </div>
    </form>
</body>
</html>
