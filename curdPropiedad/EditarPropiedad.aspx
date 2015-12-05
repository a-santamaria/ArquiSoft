﻿<%@ Page Title="" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true" CodeFile="EditarPropiedad.aspx.cs" Inherits="EditarPropiedad" %>

<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="FeaturedContent" Runat="Server">
     <section class="featured">
        <div class="content-wrapper">
            <hgroup class="title">
                <h2>Editar Propiedad</h2>
            </hgroup>
        </div>
    </section>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="MainContent" Runat="Server">

    <div>
        
       
        <asp:Table ID="Table1" runat="server">
            <asp:TableRow>
                <asp:TableCell>
                    <asp:Label ID="LabelId" runat="server" Text="id" />
                </asp:TableCell><asp:TableCell>
                    <asp:TextBox ID="TextBoxId" runat="server" ReadOnly="true"/>
                </asp:TableCell></asp:TableRow><asp:TableRow>
                <asp:TableCell>
                    <asp:Label ID="LabelRooms" runat="server" Text="rooms" />
                </asp:TableCell><asp:TableCell>
                   
                    <asp:DropDownList ID="DropDownListRooms" runat="server">
                        <asp:ListItem>1</asp:ListItem>
                        <asp:ListItem>2</asp:ListItem>
                        <asp:ListItem>3</asp:ListItem>
                        <asp:ListItem>4</asp:ListItem>
                        <asp:ListItem>5</asp:ListItem>
                        <asp:ListItem>6</asp:ListItem>
                        <asp:ListItem>7</asp:ListItem>
                        <asp:ListItem>8</asp:ListItem>
                        <asp:ListItem>9</asp:ListItem>
                        <asp:ListItem>10</asp:ListItem>
                        <asp:ListItem>11</asp:ListItem>
                        <asp:ListItem>12</asp:ListItem>
                    </asp:DropDownList>

                </asp:TableCell></asp:TableRow><asp:TableRow>
                <asp:TableCell>
                    <asp:Label ID="LabelAddress" runat="server" Text="address" />
                </asp:TableCell><asp:TableCell>
                    <asp:TextBox ID="TextBoxAddress" runat="server" ReadOnly="true"/>
                </asp:TableCell></asp:TableRow><asp:TableRow>
                <asp:TableCell>
                    <asp:Label ID="LabelRent" runat="server" Text="rent" />
                </asp:TableCell><asp:TableCell>
                    <asp:TextBox ID="TextBoxRent" runat="server" />

                    <asp:RangeValidator id="RangeValidatorRent" runat="server"
                        ControlToValidate="textboxRent"
                        Operator="DataTypeCheck"
                        Type="Double"
                        ErrorMessage="Debe ser un número"
                        Display="Dynamic"
                         />
                </asp:TableCell></asp:TableRow><asp:TableRow>
                <asp:TableCell>
                    <asp:Label ID="LabelType" runat="server" Text="type" />
                </asp:TableCell><asp:TableCell>
                    
                    <asp:DropDownList ID="DropDownListType" runat="server">
                        <asp:ListItem>apto</asp:ListItem>
                        <asp:ListItem>casa</asp:ListItem>
                    </asp:DropDownList>

                </asp:TableCell></asp:TableRow><asp:TableRow>
                <asp:TableCell>
                    <asp:Label ID="LabelId_Owner" runat="server" Text="id_Owner" />
                </asp:TableCell><asp:TableCell>
                    <asp:TextBox ID="TextBoxId_Owner" runat="server" />
                </asp:TableCell></asp:TableRow><asp:TableRow>
                <asp:TableCell>
                    <asp:Label ID="LabelLocation" runat="server" Text="location" />
                </asp:TableCell><asp:TableCell>
                    
                     <asp:DropDownList ID="DropDownListLocation" runat="server">
                    </asp:DropDownList>

                </asp:TableCell></asp:TableRow></asp:Table>
                <asp:Button ID="ButtonEdit" runat="server" Text="Editar" OnClick="edit" OnClientClick="return confirm('Editar?')"/>
                <asp:Button ID="ButtonCancel" runat="server" Text="Cancelar" OnClick="cancel" />


        <asp:LinqDataSource ID="LinqDataSource1" runat="server" ContextTypeName="DataClassesDataContext" EntityTypeName="" TableName="Properties" Where="Id == @Id">
            <WhereParameters>
                <asp:Parameter DefaultValue="1" Name="Id" Type="Int32" />
            </WhereParameters>
        </asp:LinqDataSource>
        
    </div>
</asp:Content>
