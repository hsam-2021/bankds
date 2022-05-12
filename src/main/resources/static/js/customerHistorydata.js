$(document)
		.ready(
				function() {
					var token;
					var myTable;

					var columnDefs = [
							{
								data : 'id',
								title : 'id'
							},
							{
								data : 'deletionTime',
								title : 'Archive Date',
								render : function(data, type, row) {
									return moment(row.updatedDate).format(
											'DD/MM/YYYY hh:mm:ss');
								}
							}, {
								data : 'age',
								title : 'Age'
							}, {
								data : 'job',
								title : 'Occupation'
							}, {
								data : 'marital',
								title : 'Marital Status'
							}, {
								data : 'education',
								title : 'Education Background'
							}, {
								data : 'balance',
								title : 'Account Balance'
							}, {
								data : 'housing',
								title : 'Housing Loan'
							}, {
								data : 'loan',
								title : 'Personal Loan'
							}, {
								data : 'contact',
								title : 'Communication Type'
							}, {
								data : 'day',
								title : 'Date Contacted'
							}, {
								data : 'month',
								title : 'Last Contacted Month'
							}, {
								data : 'duration',
								title : 'Last Call Duration'
							}, {
								data : 'campaign',
								title : 'Customer Contacted During Campaign'
							}, {
								data : 'previous',
								title : 'Customer Contacted Before Campaign'
							}, {
								data : 'poutcome',
								title : 'Campaign Outcome'
							}

					];

					myTable = $('#customerHistoryTable')
							.DataTable(
									{
										'sPaginationType' : 'full_numbers',
										scrollX : 1200,
										scrollCollapse : true,
										scrollY : 500,
										ajax : {
											url : '/customer/v1/getCustomerHistoricalData',
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