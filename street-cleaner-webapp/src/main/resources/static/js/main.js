"use strict";
var refreshTime = 1000;

var data = [
	{
		"orderId": 1,
		"imagePath": "https://pp.vk.me/c631423/v631423708/335f8/zEeM7THN3vU.jpg",
		"userName": "max",
		"phoneNumber": "89118465234",
		"latitude": "0.0",
		"longitude": "0.0",
		"orderStatus": "NOT_INITED"
	},
	{
		"orderId": 2,
		"imagePath": "https://pp.vk.me/c631423/v631423708/335f8/zEeM7THN3vU.jpg",
		"userName": "max",
		"phoneNumber": "89118465234",
		"latitude": "0.0",
		"longitude": "0.0",
		"orderStatus": "IN_PROGRESS"
	}
];

Vue.filter('statusFilter', function (value) {
	switch (value) {
		case "NOT_INITED":
			return "Не инфициализирован";
		break;
		case "COMPLETED":
			return "Завершено";
		break;
		case "IN_PROGRESS":
			return "Звоним";
		break;
		default:
			return "Не определён";
		break;
	}
});

Vue.filter('statusColor', function (value) {
	switch (value) {
		case "NOT_INITED":
			return "label-danger";
		break;
		case "COMPLETED":
			return "label-primary";
		break;
		case "IN_PROGRESS":
			return "label-success";
		break;
		default:
			return "label-default";
		break;
	}
});


var vm = new Vue({
	el: '#vue-app',
	data: {
		numberList: []
	},
	methods: {
		fetchData: function () {
			var self = this;
			$.ajax({
				url: '/allOrders',
				dataType: "json"
			}).done(function (data) {
				self.numberList = data;
			});
		},
		callTo: function (num, id) {
			$.ajax({
				url: '/call?number=' + num +'&id=' + id,
				jsonp: "callback",
				dataType: "jsonp"
			});
		},
		updateInfo: function () {
			//this.fetchData();
		}
	},
	ready: function () {
		var self = this;
		this.numberList = data;
		//this.fetchData();
		setInterval(self.updateInfo, refreshTime);
	}
});

$(document).ready(function() {
	$(".fancybox").fancybox();
});