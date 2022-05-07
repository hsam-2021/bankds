$(document).ready(function() {
	$('#customerPredictionForm').submit(function(event) {
       var predictionData;
		var customerPredictionData = {
			job : $("#job").val(),
			marital_status : $("#marital_status").val(),
			education : $("#education").val(),
			contact : $("#contact").val(),
			month : $("#month").val(),
			poutcome : $("#poutcome").val(),
			age : $("#age").val(),
			balance : $("#balance").val(),
			day : $("#day").val(),
			duration : $("#duration").val(),
			campaign : $("#campaign").val(),
			previous : $("#previous").val(),
			housing : $("#housing").val(),
			loan : $("#loan").val()
		};
	
		$.ajax({
			type : "POST",
			url : "http://192.168.0.241:9000/customer/result",
			data : JSON.stringify(customerPredictionData),
			contentType : 'application/json; charset=utf-8',
			encode : true,
			beforeSend : function(xhr) {
				$("#loaderDiv").show();
			},
			dataType : 'json',
			success : function(data) {
				
				if(data == '1'){
					predictionData = 'yes';
					cuteAlert({
						type : "question",
						title: "Congratulation!",
						message:"Customer will subscribe for term deposit.Do you want to save this Data for Model training?",
						confirmText: "Confirm!",
						cancelText: "Cancel!",
						img:"success.svg",
					}).then((e) => {
						if(e == "confirm"){
							var customerPredictionDataPersist = {
									job : $("#job").val(),
									marital_status : $("#marital_status").val(),
									education : $("#education").val(),
									contact : $("#contact").val(),
									month : $("#month").val(),
									poutcome : $("#poutcome").val(),
									age : $("#age").val(),
									balance : $("#balance").val(),
									day : $("#day").val(),
									duration : $("#duration").val(),
									campaign : $("#campaign").val(),
									previous : $("#previous").val(),
									housing : $("#housing").val(),
									loan : $("#loan").val(),
									deposit : predictionData
								};
							
							
							$
							.ajax(
									{
										url : '/customer/v1/createPredictionRecord',
										type : 'POST',
										data : JSON
												.stringify(customerPredictionDataPersist),
										contentType : 'application/json; charset=utf-8',
										beforeSend : function(
												xhr) {
											$(
													"#loaderDiv")
													.show();
											
										},
										statusCode : {
											200 : function() {
												    alert('Customer Data Saved Successfully');
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
										alert('Error saving customer Data');
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
					predictionData = 'no';
					cuteAlert({
						type : "question",
						title: "Sorry..",
						message:"Customer will not subscribe for term deposit.Do you want to save this Data for Model training?",
						confirmText: "Confirm!",
						cancelText: "Cancel!",
						img:"error.svg",
						
					}).then((e) => {
						if(e == "confirm"){

							var customerPredictionDataPersist = {
									job : $("#job").val(),
									marital_status : $("#marital_status").val(),
									education : $("#education").val(),
									contact : $("#contact").val(),
									month : $("#month").val(),
									poutcome : $("#poutcome").val(),
									age : $("#age").val(),
									balance : $("#balance").val(),
									day : $("#day").val(),
									duration : $("#duration").val(),
									campaign : $("#campaign").val(),
									previous : $("#previous").val(),
									housing : $("#housing").val(),
									loan : $("#loan").val(),
									deposit : predictionData
								};
							
							
							$
							.ajax(
									{
										url : '/customer/v1/createPredictionRecord',
										type : 'POST',
										data : JSON
												.stringify(customerPredictionDataPersist),
										contentType : 'application/json; charset=utf-8',
										beforeSend : function(
												xhr) {
											$(
													"#loaderDiv")
													.show();
											
										},
										statusCode : {
											200 : function() {
												    alert('Customer Data Saved Successfully');
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
										alert('Error saving customer Data');
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
			alert('Customer Prediction ' + ' ' + xhr.responseText);
		});

		event.preventDefault();
	});
});
