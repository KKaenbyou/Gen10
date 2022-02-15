$(document).ready(function(){
	
	var contentRows = $('#contentRows');
	$.ajax ({
		type: 'GET',
		url: 'http://tsg-vending.herokuapp.com/items',
		success: function (data, status) {
			$.each(data, function (index, item) {
				var row = '<tr>';
					row += '<td class="nr">' + item.id + '</td>';
					row += '<td>' + item.name + '</td>';
					row += '<td>' + item.price + '</td>';
					row += '<td>' + item.quantity + '</td>';
					row += '</tr>';
				contentRows.append(row);
			});
		}
	});
	
	var cash = 0;
	var id = 71;
	document.getElementById("cash").innerHTML = cash;
	document.getElementById("change").innerHTML = "None";
	document.getElementById("message").innerHTML = "None";
	document.getElementById("item").innerHTML = id;
	
	$('#dollar').click(function (event) {
		cash = cash + 1;
		cash = Math.round(cash * 1000)/1000
		document.getElementById("cash").innerHTML = cash;
	});
	$('#quarter').click(function (event) {
		cash = cash + 0.25;
		cash = Math.round(cash * 1000)/1000
		document.getElementById("cash").innerHTML = cash;
	});
	$('#dime').click(function (event) {
		cash = cash + 0.1;
		cash = Math.round(cash * 1000)/1000
		document.getElementById("cash").innerHTML = cash;
	});
	$('#nickel').click(function (event) {
		cash = cash + 0.05;
		cash = Math.round(cash * 1000)/1000
		document.getElementById("cash").innerHTML = cash;
	});
	
	$('#contentRows').click(function () {
		document.getElementById("item").innerHTML = $(this).find(".nr").text();
	});
	
	$('#purchase').click(function (event) {
		$.ajax ({
			type: 'POST',
			url: 'http://tsg-vending.herokuapp.com/money/' + cash + '/item/' + id,
			headers: {
				"Accept": "application/json",
				"Content-Type": "application/json"
			},
			success: function (coins) {
				document.getElementById("message").innerHTML = "Thank you!";
				document.getElementById("change").innerHTML = "Quarters:" + coins.quarters + " Dimes:" + coins.dimes + " Nickels:" + coins.nickels + " Pennies:" + coins.pennies;
				$('#contentRows').empty();
				$.ajax ({
					type: 'GET',
					url: 'http://tsg-vending.herokuapp.com/items',
					success: function (data, status) {
						$.each(data, function (index, item) {
							var row = '<tr>';
								row += '<td class="nr">' + item.id + '</td>';
								row += '<td>' + item.name + '</td>';
								row += '<td>' + item.price + '</td>';
								row += '<td>' + item.quantity + '</td>';
								row += '</tr>';
							contentRows.append(row);
						});
					}
				});
				cash = 0;
				document.getElementById("cash").innerHTML = cash;
			},
			error :function(data) {
				if(data.status === 422) {
					var error = $.parseJSON(data.responseText);
					document.getElementById("message").innerHTML = error.message;
				}
			}
		});
	});
	
	$('#makechange').click(function (event) {
		cash = cash * 100;
		var quarters = 0, dimes = 0, nickels = 0, pennies = 0;
		if(cash > 24) {
			quarters = Math.floor(cash / 25);
			cash = cash % 25;
		}
		if(cash > 9) {
			var dimes = Math.floor(cash / 10);
			cash = cash % 10;
		}
		if(cash > 4) {
			var nickels = Math.floor(cash / 5);
			cash = cash % 5;
		}
		var pennies = Math.floor(cash % 5);
		cash = 0;
		document.getElementById("cash").innerHTML = cash;
		document.getElementById("change").innerHTML = "Quarters:" + quarters + " Dimes:" + dimes + " Nickels:" + nickels + " Pennies:" + pennies;
	});
});