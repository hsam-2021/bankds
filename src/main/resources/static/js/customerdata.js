$(document)
		.ready(
				function() {
					var token;
					var myTable;

					myTable = $('#customerTable')
							.DataTable(
									{
										'sPaginationType' : 'full_numbers',
										scrollX : 1200,
										scrollCollapse : true,
										responsive : true,
										dom : 'Bfrtip',
										ajax : {
											url : '/customer/v1/getCustomerData',
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
										columns : [
												{
													data : 'id',
													title : 'id'
												},
												{
													data : 'age',
													title : 'Age'
												},
												{
													data : 'job',
													title : 'Occupation'
												},
												{
													data : 'marital',
													title : 'Marital Status'
												},
												{
													data : 'education',
													title : 'Education Background'
												},
												{
													data : 'balance',
													title : 'Account Balance'
												},
												{
													data : 'housing',
													title : 'Housing Loan'
												},
												{
													data : 'loan',
													title : 'Personal Loan'
												},
												{
													data : 'contact',
													title : 'Communication Type'
												},
												{
													data : 'day',
													title : 'Date Contacted'
												},
												{
													data : 'month',
													title : 'Last Contacted Month'
												},
												{
													data : 'duration',
													title : 'Last Call Duration'
												},
												{
													data : 'campaign',
													title : 'Customer Contacted During Campaign'
												},
												{
													data : 'previous',
													title : 'Customer Contacted Before Campaign'
												}, {
													data : 'poutcome',
													title : 'Campaign Outcome'
												}

										],

										columnDefs : [ {
											orderable : false,
											targets : 0,
											checkboxes : {
												selectRow : true
											}
										} ],
										select : {
											style : 'multi'
										},
										order : [ [ 1, 'asc' ] ],
										altEditor : true,
										buttons : [
												{
													text : 'Delete',
													action : function() {
														var finalSelectedData = [];
														var jsonPayload = null;
														var rows_selected = myTable
																.column(0).checkboxes
																.selected()
																.toArray();
														if (rows_selected.length == 0) {
															alert('Please select atleast one record to delete');
															return true;
														}
														for (var i = 0; i < rows_selected.length; i++) {

															finalSelectedData
																	.push(rows_selected[i]);
														}

														jsonPayload = {
															custId : finalSelectedData
														};

														$
																.ajax(
																		{
																			url : '/customer/v1/deleteCustRecords',
																			type : 'POST',
																			data : JSON
																					.stringify(jsonPayload),
																			contentType : 'application/json; charset=utf-8',
																			beforeSend : function(
																					xhr) {
																				$(
																						"#loaderDiv")
																						.show();
																			},
																			statusCode : {
																				200 : function() {
																					alert("Customer Record Deleted Successfully");
																					$(
																							'#altEditor-modal-')
																							.modal(
																									'hide');
																					$(
																							'#customerTable')
																							.DataTable().ajax
																							.reload();
																					$(
																							"#loaderDiv")
																							.hide();
																				}
																			}
																		})
																.fail(
																		function(
																				xhr,
																				result,
																				status) {
																			alert(xhr.responseText);
																			if (xhr.status != 200) {
																				$(
																						'#customerTable')
																						.DataTable().ajax
																						.reload();
																				$(
																						"#loaderDiv")
																						.hide();
																			}
																		});
													}
												}, {
													text : 'Refresh List',
													name : 'refresh'
												} ]
									});
				});