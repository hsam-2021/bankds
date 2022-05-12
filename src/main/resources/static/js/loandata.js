$(document)
		.ready(
				function() {
					var token;
					var myTable;

					myTable = $('#loanTable')
							.DataTable(
									{
										'sPaginationType' : 'full_numbers',
										responsive : true,
										dom : 'Bfrtip',
										ajax : {
											url : '/customer/v1/getLoanData',
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
										columns : [ {
											data : 'loanId',
											title : 'Loan Id'
										}, {
											data : 'gender',
											title : 'Gender'
										}, {
											data : 'dependents',
											title : 'Dependents'
										}, {
											data : 'education',
											title : 'Marital Status'
										}, {
											data : 'education',
											title : 'Graduated'
										}, {
											data : 'selfEmployed',
											title : 'Self Employed'
										}, {
											data : 'applicantIncome',
											title : 'Applicant Income'
										}, {
											data : 'coapplicantIncome',
											title : 'Co-Applicant Income'
										}, {
											data : 'loanamount',
											title : 'Loan Amount'
										}, {
											data : 'loanAmountTerm',
											title : 'Loan Term'
										}, {
											data : 'creditHistory',
											title : 'Credit History'
										}, {
											data : 'propertyArea',
											title : 'Locality'
										} ],

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
															loanId : finalSelectedData
														};

														$
																.ajax(
																		{
																			url : '/customer/v1/deleteLoanRecords',
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
																				200 : function(
																						xhr) {
																					alert("Loan Record Deleted Successfully");
																					$(
																							'#altEditor-modal-')
																							.modal(
																									'hide');
																					$(
																							'#loanTable')
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
																						'#loanTable')
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