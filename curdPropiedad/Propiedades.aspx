<%@ Page Title="Home Page" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeFile="Propiedades.aspx.cs" Inherits="_Default" %>

<asp:Content runat="server" ID="FeaturedContent" ContentPlaceHolderID="FeaturedContent">
    <section class="featured">
        <div class="content-wrapper">
            <hgroup class="title">
                <h2>Propiedades</h2>
            </hgroup>
        </div>
    </section>
</asp:Content>

<asp:Content runat="server" ID="BodyContent" ContentPlaceHolderID="MainContent">
     <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataKeyNames="Id" CellPadding="4" ForeColor="#333333" GridLines="None">
            <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
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
            <EditRowStyle BackColor="#999999" />
            <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
            <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
            <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
            <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
            <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
            <SortedAscendingCellStyle BackColor="#E9E7E2" />
            <SortedAscendingHeaderStyle BackColor="#506C8C" />
            <SortedDescendingCellStyle BackColor="#FFFDF8" />
            <SortedDescendingHeaderStyle BackColor="#6F8DAE" />
        </asp:GridView>
        <br />
        <asp:Button ID="ButtonCreate" runat="server" Text="Crear Propiedad" OnClick="create"/>
        <asp:LinqDataSource ID="LinqDataSource1" runat="server" ContextTypeName="DataClassesDataContext" EnableInsert="True" EnableUpdate="True" EntityTypeName="" TableName="Properties" EnableDelete="True">
        </asp:LinqDataSource>
</asp:Content>