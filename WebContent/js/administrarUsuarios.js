Ext.onReady(function(){
	
	Ext.define('EmpleadoModel', {
		
		extend: 'Ext.data.Model',
		fields:[
		        {name:'id_usuario', type:'int'},
		        {name:'nom_usuario', type:'string'},
		        {name:'pat_usuario', type:'string'},
		        {name:'mat_usuario', type:'string'},
		        {name:'area', type:'string'},
		        {name:'fecha_nacimiento', type:'string'},
		        {name:'login', type:'string'},
		        {name:'activo', type:'boolean'},
		        {name:'cumple', type:'string'},
		        {name:'tiene_foto', type:'boolean'}
		        ]
	}); 
	
	
	var storeEmpleados = Ext.create('Ext.data.Store', {
		
		model: 'EmpleadoModel',
		autoLoad:true,
		autoSync:true,
		proxy:{
			type:'ajax',
			api:{
				read:'ServletConsultar',
				update:'ServletUpdate'
			},
			reader:{	
				root:'empleados'
			},
			headers: {
	            'Content-Type': 'application/json; charset=utf-8'
	        }
		}
	});


	var accordionMenu = new Ext.panel.Panel({
		headers: {'Content-Type':'text/html; charset=utf-8'},
		title:'Administrar Empleados',
		witdth: 400,
		height: 800,
		layout: 'accordion',
		layoutConfig:{
			titleCollapse: false,
			animate: true,
			activeOnTop: true
		},
		items:[
		       	{
		       		title: 'Consultar',
		       		html: '<div id="consultarEmpleados">'
		       	},
		       	{
		       		title: 'Buscar',
		       		html: '<div id="buscarEmpleado">'
		       	},
		       	{
		       		title: 'Nuevo',
		       		html: '<div id="nuevoEmpleado">'
		       	}
		       
		       ]
		
	});

	var gridEmpleados = new Ext.grid.GridPanel({
		witdth: 400,
		height: 650,
		raggable : {
			insertProxy:false,
			onDrag:function(e){
				var el = this.proxy.getEl();
				this.x = el.getLeft(true);
				this.y = el.getTop(true);
			}
	      },
		
		title: 'Empleados',
		store:storeEmpleados,
		columns:[
		         {header:'ID', width:60, dataIndex:'id_usuario', sortable:true},
		         {header:'NOMBRE', width:100, dataIndex:'nom_usuario', editor:'textfield', sortable:true},
		         {header:'A. PATERNO', width:100, dataIndex:'pat_usuario', editor:'textfield', sortable:true},
		         {header:'A. MATERNO', width:100, dataIndex:'mat_usuario', editor:'textfield', sortable:true},
		         {header:'AREA', width:100, dataIndex:'area', editor:'textfield', sortable:true},
		         {header:'FECHA DE NACIMIENTO', width:150, dataIndex:'fecha_nacimiento', editor:'textfield', sortable:true},
		         {header:'LOGIN', width:100, dataIndex:'login', editor:'textfield', sortable:true},
		         {header:'CUMPLEAÑOS', width:100, dataIndex:'cumple', editor:'textfield', sortable:true},
		         
		         
		         ],
		        
		plugins:[
		         
		         	Ext.create('Ext.grid.plugin.RowEditing', {
		         		clicksToEdit: 1
		         	})
		         
		         ]         
	});
	
	
	var formularioAlta = new Ext.FormPanel({
		
		frame: true,
		title: 'Alta Empleado',
		width: 300,
		items: [ {
					xtype: 'textfield',
					name: 'nom_usuario',
					fieldLabel: 'Nombre'
		
				} , {
					xtype: 'textfield',
					name: 'pat_usuario',
					fieldLabel: 'A. Paterno'

					
				} , {
					xtype: 'textfield',
					name: 'mat_usuario',
					fieldLabel: 'A. Materno'

				} , {
		            xtype: 'textfield',
		            name: 'area',
		            fieldLabel: 'Area'
		        }, {
		            xtype: 'textfield',
		            name: 'fecha_nacimiento',
		            fieldLabel: 'Fecha Nacimiento'
		        },
		        {
		            xtype: 'textfield',
		            name: 'login',
		            fieldLabel: 'Login'
		        },
		        {
		            xtype: 'textfield',
		            name: 'cumple',
		            fieldLabel: 'Cumpleaños'
		        }
		],
		buttons : [ {
						text: 'Guardar',
						handler: function(boton, evento) {
							formularioAlta.getForm().submit({
								url: 'ServletNuevo',
								method:'POST',
								formBind: true,
								failure: function() {
									Ext.MessageBox.show({
										title: 'Error',
										msg: 'Los datos no se guardaron correctamente',
										buttons: Ext.MessageBox.OK,
										icons: Ext.MessageBox.ERROR
									});
									
								},
								success: function() {
									storeEmpleados.load();
								}
							});
						}
					}
		           ]
	});

	
	
	
	
	
	accordionMenu.render('administrarUsuarios');
	gridEmpleados.render('consultarEmpleados');
	formularioAlta.render('nuevoEmpleado');
	
	
	
	
});