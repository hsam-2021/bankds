$(document).ready(function() {
	$('#loanPredictionForm').submit(function(event) {
       var predictionData;
		var loanPredictionData = {
				gender : $("#gender").val(),
				married : $("#married").val(),
				dependent : parseInt($("#dependent").val()),
				education : $("#education").val(),
				selfEmployed : $("#selfEmployed").val(),
				creditHistory : parseInt($("#creditHistory").val()),
				propertyArea : $("#propertyArea").val(),
				applicantIncome : parseInt($("#applicantIncome").val()),
				coApplicantIncome : parseInt($("#coApplicantIncome").val()),
				loanAmount : parseInt($("#loanAmount").val()),
				loanAmountTerm : parseInt($("#loanAmountTerm").val())
		};
		
		$.ajax({
			type : "POST",
			url : "http://192.168.0.241:9000/loan/result",
			data : JSON.stringify(loanPredictionData),
			contentType : 'application/json; charset=utf-8',
			encode : true,
			beforeSend : function(xhr) {
				$("#loaderDiv").show();
			},
			success : function(data) {
				if(data == 'Y'){
					predictionData = 'Y';
					cuteAlert({
						type : "question",
						title: "Congratulation!",
						message:"Loan will get approved.Do you want to save this Data for Model training?",
						confirmText: "Confirm!",
						cancelText: "Cancel!",
						img:"success.svg",
					}).then((e) => {
						if(e == "confirm"){


							var loanPredictionDataPersist = {
									gender : $("#gender").val(),
									married : $("#married").val(),
									dependent : parseInt($("#dependent").val()),
									education : $("#education").val(),
									selfEmployed : $("#selfEmployed").val(),
									creditHistory : parseInt($("#creditHistory").val()),
									propertyArea : $("#propertyArea").val(),
									applicantIncome : parseInt($("#applicantIncome").val()),
									coApplicantIncome : parseInt($("#coApplicantIncome").val()),
									loanAmount : parseInt($("#loanAmount").val()),
									loanAmountTerm : parseInt($("#loanAmountTerm").val()),
									loanStatus : predictionData
								};
							
							$
							.ajax(
									{
										url : '/customer/v1/createLoanPredictionRecord',
										type : 'POST',
										data : JSON
												.stringify(loanPredictionDataPersist),
										contentType : 'application/json; charset=utf-8',
										beforeSend : function(
												xhr) {
											$(
													"#loaderDiv")
													.show();
											
										},
										statusCode : {
											200 : function() {
												    alert('Loan Data Saved Successfully');
													$("#loaderDiv").hide();
													location.reload();
											}
										}
									})
							.fail(
									function(
											xhr,
											result,
											status) {
										alert('Error saving Loan Data');
										if (xhr.status != 200) {
											$(
													"#loaderDiv")
													.hide();
										}
										location.reload();
									});
						}else{
							location.reload();
						}
					});
				}else{
					predictionData = 'N';
					cuteAlert({
						type : "question",
						title: "Sorry..",
						message:"Loan will get rejected.Do you want to save this Data for Model training?",
						confirmText: "Confirm!",
						cancelText: "Cancel!",
						img:"error.svg",
						
					}).then((e) => {
						if(e == "confirm"){

							var loanPredictionDataPersist = {
									gender : $("#gender").val(),
									married : $("#married").val(),
									dependent : parseInt($("#dependent").val()),
									education : $("#education").val(),
									selfEmployed : $("#selfEmployed").val(),
									creditHistory : parseInt($("#creditHistory").val()),
									propertyArea : $("#propertyArea").val(),
									applicantIncome : parseInt($("#applicantIncome").val()),
									coApplicantIncome : parseInt($("#coApplicantIncome").val()),
									loanAmount : parseInt($("#loanAmount").val()),
									loanAmountTerm : parseInt($("#loanAmountTerm").val()),
									loanStatus : predictionData
								};
							
							$
							.ajax(
									{
										url : '/customer/v1/createLoanPredictionRecord',
										type : 'POST',
										data : JSON
												.stringify(loanPredictionDataPersist),
										contentType : 'application/json; charset=utf-8',
										beforeSend : function(
												xhr) {
											$(
													"#loaderDiv")
													.show();
											
										},
										statusCode : {
											200 : function() {
												    alert('Loan Data Saved Successfully');
													$("#loaderDiv").hide();
													location.reload();
											}
										}
									})
							.fail(
									function(
											xhr,
											result,
											status) {
										alert('Error saving Loan Data');
										if (xhr.status != 200) {
											$(
													"#loaderDiv")
													.hide();
										}
										location.reload();
									});
						
							
						
						}else{
							location.reload();
						}
					});
				}
			},
			statusCode : {
				200 : function() {
					$("#loaderDiv").hide();
				}
			}
		}).fail(function(xhr, result, status) {
			$("#loaderDiv").hide();
			alert('Loan Prediction ' + ' ' + xhr.responseText);
		});

		event.preventDefault();
	});
});
