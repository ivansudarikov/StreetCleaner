"use strict";
var refreshTime = 1000;


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
		callTo: function (num) {
			$.ajax({
				url: '/call?number=' + num,
				jsonp: "callback",
				dataType: "jsonp"
			});
		},
		updateInfo: function () {
			this.fetchData();
		}
	},
	ready: function () {
		var self = this;
		this.fetchData();
		setInterval(self.updateInfo, refreshTime);
	}
});