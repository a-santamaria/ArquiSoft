﻿#pragma warning disable 1591
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Linq;
using System.Data.Linq.Mapping;
using System.Linq;
using System.Linq.Expressions;
using System.Reflection;



[global::System.Data.Linq.Mapping.DatabaseAttribute(Name="OPRS_DB2")]
public partial class DataClassesDataContext : System.Data.Linq.DataContext
{
	
	private static System.Data.Linq.Mapping.MappingSource mappingSource = new AttributeMappingSource();
	
  #region Extensibility Method Definitions
  partial void OnCreated();
  partial void InsertProperty(Property instance);
  partial void UpdateProperty(Property instance);
  partial void DeleteProperty(Property instance);
  #endregion
	
	public DataClassesDataContext() : 
			base(global::System.Configuration.ConfigurationManager.ConnectionStrings["OPRS_DB2ConnectionString"].ConnectionString, mappingSource)
	{
		OnCreated();
	}
	
	public DataClassesDataContext(string connection) : 
			base(connection, mappingSource)
	{
		OnCreated();
	}
	
	public DataClassesDataContext(System.Data.IDbConnection connection) : 
			base(connection, mappingSource)
	{
		OnCreated();
	}
	
	public DataClassesDataContext(string connection, System.Data.Linq.Mapping.MappingSource mappingSource) : 
			base(connection, mappingSource)
	{
		OnCreated();
	}
	
	public DataClassesDataContext(System.Data.IDbConnection connection, System.Data.Linq.Mapping.MappingSource mappingSource) : 
			base(connection, mappingSource)
	{
		OnCreated();
	}
	
	public System.Data.Linq.Table<Property> Properties
	{
		get
		{
			return this.GetTable<Property>();
		}
	}
}

[global::System.Data.Linq.Mapping.TableAttribute(Name="dbo.Properties")]
public partial class Property : INotifyPropertyChanging, INotifyPropertyChanged
{
	
	private static PropertyChangingEventArgs emptyChangingEventArgs = new PropertyChangingEventArgs(String.Empty);
	
	private int _Id;
	
	private System.Nullable<int> _rooms;
	
	private System.Nullable<double> _rent;
	
	private string _address;
	
	private string _type;
	
	private string _id_owner;
	
	private string _location;
	
    #region Extensibility Method Definitions
    partial void OnLoaded();
    partial void OnValidate(System.Data.Linq.ChangeAction action);
    partial void OnCreated();
    partial void OnIdChanging(int value);
    partial void OnIdChanged();
    partial void OnroomsChanging(System.Nullable<int> value);
    partial void OnroomsChanged();
    partial void OnrentChanging(System.Nullable<double> value);
    partial void OnrentChanged();
    partial void OnaddressChanging(string value);
    partial void OnaddressChanged();
    partial void OntypeChanging(string value);
    partial void OntypeChanged();
    partial void Onid_ownerChanging(string value);
    partial void Onid_ownerChanged();
    partial void OnlocationChanging(string value);
    partial void OnlocationChanged();
    #endregion
	
	public Property()
	{
		OnCreated();
	}
	
	[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_Id", AutoSync=AutoSync.OnInsert, DbType="Int NOT NULL IDENTITY", IsPrimaryKey=true, IsDbGenerated=true)]
	public int Id
	{
		get
		{
			return this._Id;
		}
		set
		{
			if ((this._Id != value))
			{
				this.OnIdChanging(value);
				this.SendPropertyChanging();
				this._Id = value;
				this.SendPropertyChanged("Id");
				this.OnIdChanged();
			}
		}
	}
	
	[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_rooms", DbType="Int")]
	public System.Nullable<int> rooms
	{
		get
		{
			return this._rooms;
		}
		set
		{
			if ((this._rooms != value))
			{
				this.OnroomsChanging(value);
				this.SendPropertyChanging();
				this._rooms = value;
				this.SendPropertyChanged("rooms");
				this.OnroomsChanged();
			}
		}
	}
	
	[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_rent", DbType="Float")]
	public System.Nullable<double> rent
	{
		get
		{
			return this._rent;
		}
		set
		{
			if ((this._rent != value))
			{
				this.OnrentChanging(value);
				this.SendPropertyChanging();
				this._rent = value;
				this.SendPropertyChanged("rent");
				this.OnrentChanged();
			}
		}
	}
	
	[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_address", DbType="NChar(100)")]
	public string address
	{
		get
		{
			return this._address;
		}
		set
		{
			if ((this._address != value))
			{
				this.OnaddressChanging(value);
				this.SendPropertyChanging();
				this._address = value;
				this.SendPropertyChanged("address");
				this.OnaddressChanged();
			}
		}
	}
	
	[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_type", DbType="NChar(10)")]
	public string type
	{
		get
		{
			return this._type;
		}
		set
		{
			if ((this._type != value))
			{
				this.OntypeChanging(value);
				this.SendPropertyChanging();
				this._type = value;
				this.SendPropertyChanged("type");
				this.OntypeChanged();
			}
		}
	}
	
	[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_id_owner", DbType="NChar(100)")]
	public string id_owner
	{
		get
		{
			return this._id_owner;
		}
		set
		{
			if ((this._id_owner != value))
			{
				this.Onid_ownerChanging(value);
				this.SendPropertyChanging();
				this._id_owner = value;
				this.SendPropertyChanged("id_owner");
				this.Onid_ownerChanged();
			}
		}
	}
	
	[global::System.Data.Linq.Mapping.ColumnAttribute(Storage="_location", DbType="NChar(10)")]
	public string location
	{
		get
		{
			return this._location;
		}
		set
		{
			if ((this._location != value))
			{
				this.OnlocationChanging(value);
				this.SendPropertyChanging();
				this._location = value;
				this.SendPropertyChanged("location");
				this.OnlocationChanged();
			}
		}
	}
	
	public event PropertyChangingEventHandler PropertyChanging;
	
	public event PropertyChangedEventHandler PropertyChanged;
	
	protected virtual void SendPropertyChanging()
	{
		if ((this.PropertyChanging != null))
		{
			this.PropertyChanging(this, emptyChangingEventArgs);
		}
	}
	
	protected virtual void SendPropertyChanged(String propertyName)
	{
		if ((this.PropertyChanged != null))
		{
			this.PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
		}
	}
}
#pragma warning restore 1591
