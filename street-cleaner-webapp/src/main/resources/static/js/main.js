"use strict";
var refreshTime = 3000;
var testData = [
	{
		id: 1,
		name: "Alex",
		dialPhone: "+79214393990",
		image: "http://zebra-zebra.ru/gallery/77d337781bdccc94f3399f6f925d25a5_gallery.jpg",
		status: "Calling",
		coordinates: "59.925785,30.278274"
	},
	{
		id: 2,
		name: "Lex",
		dialPhone: "+79214393990",
		image: "http://zebra-zebra.ru/gallery/77d337781bdccc94f3399f6f925d25a5_gallery.jpg",
		status: "Pending",
		coordinates: "59.925785,30.278274"
	},
	{
		id: 3,
		name: "X",
		dialPhone: "+79214393990",
		image: "http://zebra-zebra.ru/gallery/77d337781bdccc94f3399f6f925d25a5_gallery.jpg",
		status: "Pending",
		coordinates: "59.925785,30.278274"
	}
];


var vm = new Vue({
	el: '#vue-app',
	data: {
		numberList: testData
	},
	methods: {
		fetchData: function () {
			var self = this;
			$.ajax({
				url: '/getData',
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
		setInterval(self.updateInfo, refreshTime);
	}
});