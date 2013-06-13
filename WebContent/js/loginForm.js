Ext.onReady(function () {

	
	var formularioLogin = new Ext.FormPanel({
		frame: true,
		title: 'Login',
		width: 300,
		items: [ 
		         {
					xtype: 'textfield',
					fieldLabel: 'Usuario',
					name: 'username'
		          }, 
		          {
					xtype: 'textfield',
					fieldLabel: 'Contraseña',
					inputType:'password',
					name: 'password'
				  }
		],
		buttons : [ {
						text: 'Entrar',
						formBind: true,
						handler: function() {
							formularioLogin.getForm().submit({
								url: 'ServletLogin',
								method:'POST',
								
								failure: function(form, action) {
									Ext.Msg.alert("Failed", "Usuario o pasword incorrecto");
								},
								success: function(form, action) {
									var redirect = 'AdministrarUsuarios.jsp'; 
			                        window.location = redirect;
								}
							});
						}
					}
		           ]
	});
	formularioLogin.render('loginForm');
});
