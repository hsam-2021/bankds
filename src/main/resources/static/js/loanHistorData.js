$(document)
		.ready(
				function() {
					var token;
					var myTable;
					var columnDefs = [
							{
								data : 'loanId',
								title : 'Loan Id'
							},
							{
								data : 'deletionTime',
								title : 'Archive Date',
								render : function(data, type, row) {
									 return moment(data).format('DD/MM/YYYY hh:mm:ss');
								}
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
							} ];
					myTable = $('#loanHistoryTable')
							.DataTable(
									{
										'sPaginationType' : 'full_numbers',
										scrollX : 1200,
										scrollCollapse : true,
										scrollY : 500,
										ajax : {
											url : '/customer/v1/getLoanHistoricalData',
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
											text : 'Refresh List',
											name : 'refresh'
										} ]
									});
				});