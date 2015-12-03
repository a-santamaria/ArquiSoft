<%@ Page Title="Home Page" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<asp:Content runat="server" ID="FeaturedContent" ContentPlaceHolderID="FeaturedContent">
    <section class="featured">
        <div class="content-wrapper">
            <hgroup class="title">
                <h1><%: Title %></h1>
                <h2>OPRS</h2>
            </hgroup>
        </div>
    </section>
</asp:Content>

<asp:Content runat="server" ID="BodyContent" ContentPlaceHolderID="MainContent">
     <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataKeyNames="Id" DataSourceID="LinqDataSource1">
            <Columns>
                <asp:BoundField DataField="Id" HeaderText="Id" ReadOnly="True" SortExpression="Id" />
                <asp:BoundField DataField="rooms" HeaderText="rooms" SortExpression="rooms" />
                <asp:BoundField DataField="rent" HeaderText="rent" SortExpression="rent" />
                <asp:BoundField DataField="address" HeaderText="address" SortExpression="address" />
                <asp:BoundField DataField="type" HeaderText="type" SortExpression="type" />
                <asp:BoundField DataField="id_owner" HeaderText="id_owner" SortExpression="id_owner" />
                <asp:BoundField DataField="location" HeaderText="location" SortExpression="location" />

                 <asp:TemplateField HeaderText="">
                    <ItemTemplate>
                    <asp:LinkButton runat="server" ID="lnkViewDelete" 
                                    OnClick="delete" 
                                    >Borrar</asp:LinkButton>
                    </ItemTemplate>
                </asp:TemplateField>

                 <asp:TemplateField HeaderText="">
                    <ItemTemplate>
                    <asp:LinkButton runat="server" ID="lnkViewEdit" 
                                    OnClick="edit" 
                                    >Editar</asp:LinkButton>
                    </ItemTemplate>
                </asp:TemplateField>

            </Columns>
        </asp:GridView>
        <asp:LinqDataSource ID="LinqDataSource1" runat="server" ContextTypeName="DataClassesDataContext" EnableInsert="True" EnableUpdate="True" EntityTypeName="" TableName="Properties" EnableDelete="True">
        </asp:LinqDataSource>
</asp:Content>