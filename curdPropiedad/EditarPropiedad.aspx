<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="EditarPropiedad.aspx.cs" Inherits="EditarPropiedad" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="FeaturedContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="MainContent" Runat="Server">

    <div>
        
       
        <asp:Table ID="Table1" runat="server">
            <asp:TableRow>
                <asp:TableCell>
                    <asp:Label ID="LabelId" runat="server" Text="id" />
                </asp:TableCell>
                <asp:TableCell>
                    <asp:TextBox ID="TextBoxId" runat="server" ReadOnly="true"/>
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
                    <asp:Label ID="LabelRent" runat="server" Text="rent" />
                </asp:TableCell>
                <asp:TableCell>
                    <asp:TextBox ID="TextBoxRent" runat="server" />
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

             <asp:TableRow>
                <asp:TableCell>
                    <asp:Label ID="LabelLocation" runat="server" Text="location" />
                </asp:TableCell>
                <asp:TableCell>
                    <asp:TextBox ID="TextBoxLocation" runat="server" />
                </asp:TableCell>
            </asp:TableRow>

        </asp:Table>

        <asp:Button ID="ButtonEdit" runat="server" Text="Editar" OnClick="edit" />
        <asp:Button ID="ButtonCancel" runat="server" Text="Cancelar" />



        <asp:RegularExpressionValidator runat="server" ID="PNRegEx"
            ControlToValidate="TextBoxRent"
            Display="None"
            ValidationExpression="\d+"
            ErrorMessage="solo números" />

        <asp:LinqDataSource ID="LinqDataSource1" runat="server" ContextTypeName="DataClassesDataContext" EntityTypeName="" TableName="Properties" Where="Id == @Id">
            <WhereParameters>
                <asp:Parameter DefaultValue="1" Name="Id" Type="Int32" />
            </WhereParameters>
        </asp:LinqDataSource>
        
    </div>
</asp:Content>

