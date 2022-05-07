$(document)
		.ready(
				function() {
					var roleOption = {
						"ROLE_USER" : "User",
						"ROLE_ADMIN" : "Admin"
					};

					var columnDefs = [ {
						data : 'userId',
						title : 'User_Id',
						type : 'hidden',
						visible : false,
						searchable : false
					}, {
						data : 'name',
						title : 'Name'
					}, {
						data : 'userName',
						title : 'User Name',
					}, {
						data : 'eMail',
						title : 'Email'
					}, {
						data : 'password',
						title : 'Password',
						searchable : false,
						visible : false,
						type : 'password'
					}, {
						data : 'roleId',
						title : 'Role_Id',
						type : 'hidden',
						visible : false,
						searchable : false

					}, {
						data : 'roleName',
						title : 'Role',
						type : 'select',
						options : roleOption,
						render : function(data, type, row, meta) {
							if (data == null || !(data in roleOption))
								return null;
							return roleOption[data];
						}
					} ];

					var myTable;

					myTable = $('#loginManagementTable')
							.DataTable(
									{
										'sPaginationType' : 'full_numbers',
										ajax : {
											url : '/customer/v1/getUsersDetail',
											dataSrc : '',
											beforeSend : function(xhr) {

												$("#loaderDiv").show();
											},
											statusCode : {
												200 : function() {
													$("#loaderDiv").hide();
												}
											},
											error : function(xhr, result,
													status) {
												if (xhr.status != 200) {
													alert("You Have Encountered an Unexpected Error. Please Contact System Administrator for Assistance");
													$("#loaderDiv").hide();
												}
											}
										},
										columns : columnDefs,
										dom : 'Bfrtip',
										select : 'single',
										responsive : true,
										altEditor : true,
										buttons : [ {
											text : 'Add',
											name : 'add'
										}, {
											extend : 'selected',
											text : 'Edit',
											name : 'edit'
										}, {
											extend : 'selected',
											text : 'Delete',
											name : 'delete'
										}, {
											text : 'Refresh',
											name : 'refresh'
										} ],
										onAddRow : function(datatable, rowdata,
												success, error) {
											var newUserAccountPayload = {
												name : rowdata.name,
												username : rowdata.userName,
												email : rowdata.eMail,
												role : [ rowdata.roleName ],
												password : rowdata.password
											};
											$
													.ajax(
															{
																url : '/customer/v1/api/auth/signup',
																type : 'POST',
																data : JSON
																		.stringify(newUserAccountPayload),
																contentType : 'application/json; charset=utf-8',
																beforeSend : function(
																		xhr) {
																	$(
																			"#loaderDiv")
																			.show();
																},
																statusCode : {
																	200 : function() {
																		$(
																				'#altEditor-modal-')
																				.modal(
																						'hide');
																		$(
																				'#loginManagementTable')
																				.DataTable().ajax
																				.reload();
																	}
																}
															})
													.fail(
															function(xhr,
																	result,
																	status) {
																alert('Add User Account -'
																		+ ' '
																		+ xhr.responseText);
																$("#loaderDiv")
																		.hide();
															});
										},
										onDeleteRow : function(datatable,
												rowdata, success, error) {
											$
													.ajax(
															{
																url : '/customer/v1/deleteUsersDetail/'
																		+ rowdata.userName,
																type : 'DELETE',
																contentType : 'application/json; charset=utf-8',
																beforeSend : function(
																		xhr) {
																	$(
																			"#loaderDiv")
																			.show();
																},
																statusCode : {
																	200 : function() {
																		$(
																				'#altEditor-modal-')
																				.modal(
																						'hide');
																		$(
																				'#loginManagementTable')
																				.DataTable().ajax
																				.reload();
																	}
																}
															})
													.fail(
															function(xhr,
																	result,
																	status) {
																alert('Delete User Account -'
																		+ ' '
																		+ xhr.responseText);
																$("#loaderDiv")
																		.hide();
															});
										},
										onEditRow : function(datatable,
												rowdata, success, error) {

											var userAccountUpdatePayload = {
												id : rowdata.userId,
												username : rowdata.userName,
												name : rowdata.name,
												email : rowdata.eMail,
												role : [ rowdata.roleName ],
												password : rowdata.password
											};
											$
													.ajax(
															{
																url : '/customer/v1/updateUserDetails',
																type : 'POST',
																data : JSON
																		.stringify(userAccountUpdatePayload),
																contentType : 'application/json; charset=utf-8',
																beforeSend : function(
																		xhr) {
																	$(
																			"#loaderDiv")
																			.show();
																},
																statusCode : {
																	200 : function() {
																		$(
																				'#altEditor-modal-')
																				.modal(
																						'hide');
																		$(
																				'#loginManagementTable')
																				.DataTable().ajax
																				.reload();
																	}
																}
															})
													.fail(
															function(xhr,
																	result,
																	status) {
																alert('Update User Account -'
																		+ ' '
																		+ xhr.responseText);
																$("#loaderDiv")
																		.hide();

															});
										}
									});
				});