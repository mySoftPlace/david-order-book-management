'use strict';

angular.module('bookApp').controller('bookController',function($scope, $http, $window) {

					var closeBook;
					var orderBookClose;
					$scope.pageLink = "";
					$scope.display = false;

					// Form page to open a new order book
					$scope.bookForm = function() {
						$scope.display = false;
						$scope.pageLink = "../view/open_book.html";
						$scope.buttonTitle = "Open";
						$http.get("http://localhost:8080/user/instrument/all")
								.then(
										function(response) {
											$scope.financialInstruments = response.data;
										});
					}

					// Form page to add a new order
					$scope.orderForm = function() {
						$scope.display = false;
						$scope.pageLink = "../view/add_order.html";
						$scope.buttonTitle = "Save";
						$http.get("http://localhost:8080/user/orderBookOpen/all")
								.then(function(response) {
									$scope.orderBookopens = response.data;
								});
					}

					// Form page to close an order book
					$scope.closeBookForm = function() {
						$scope.display = false;
						$scope.pageLink = "../view/close_book.html";
						$scope.buttonTitle = "Close";
						$http.get("http://localhost:8080/user/orderBookOpen/all")
								.then(function(response) {
									$scope.orderBookopens = response.data;
								});
					}

					// Form page to execute an order book
					$scope.execOrderBookForm = function() {
						$scope.display = false;
						$scope.pageLink = "../view/execute_order_book.html";
						$scope.buttonTitle = "Execute Order Book";
						$http.get("http://localhost:8080/user/book/close/all")
								.then(function(response) {
									$scope.orderBookCloses = response.data;
								});
					}

					// Form page to calculate statistics per order book
					$scope.displayOrderBookStatForm = function() {
						$scope.pageLink = "../view/stat_book.html";
						$scope.buttonTitle = "Display Statistics per Order Book";
						$http.get("http://localhost:8080/user/book/all").then(
								function(response) {
									$scope.orderBooks = response.data;
								});
					}

					// Service to Open an order book
					$scope.openOrderBook = function(orderBookName,
							selectedInstr) {

						if (selectedInstr > 0 && orderBookName !== null
								&& orderBookName !== undefined) {
							var orderBook = {
								"orderBookName" : orderBookName,
								"financialInstrument" : {
									"finInstrId" : selectedInstr
								}
							};

							$http.post("http://localhost:8080/user/book/open",JSON.stringify(orderBook))
									.then(
											function(response) {
												$scope.save = "An order book is open and can accept orders.";
												$scope.pageLink = "../view/display_message.html";
											});
						}
					}

					// Service to Add a new order
					$scope.addNewOrder = function(selectedOrderBook, quantity,
							limitPrice) {

						if (selectedOrderBook > 0 && quantity > 0) {
							var newOrder = {
								"quantity" : quantity,
								"limitPrice" : limitPrice,
								"orderBook" : {
									"orderBookId" : selectedOrderBook
								}
							};

							$http.post("http://localhost:8080/user/order/save",JSON.stringify(newOrder))
									.then(
											function(response) {
												$scope.save = "Order added in the order book";
												$scope.pageLink = "../view/display_message.html";
											});
						}
					}

					// Service to close an order book
					$scope.closeOrderBook = function(selectedOrderBook) {
						if (selectedOrderBook > 0) {
							$http.get("http://localhost:8080/user/book?orderBookId="+ selectedOrderBook)
									.then(
											function(response) {
												orderBookClose = response.data;
												closeBook = {
													"orderBookId"         : selectedOrderBook,
													"orderBookName"       : orderBookClose.orderBookName,
													"executionPrice"      : orderBookClose.executionPrice,
													"validDemand"         : orderBookClose.validDemand,
													"isOpen"              : false,
													"isExecute"           : orderBookClose.isExecute,
													"financialInstrument" : orderBookClose.financialInstrument
												};

												$http.put("http://localhost:8080/user/book/update",JSON.stringify(closeBook))
														.then(
																function(
																		response) {
																	$scope.save = "The selected order book is closed";
																	$scope.pageLink = "../view/display_message.html";
																});
											});
						}
					}

					// Service to execute an order book
					$scope.execOrderBook = function(selectedOrderBook,
							execPrice, execQuantity) {
						if (selectedOrderBook > 0 && execPrice > 0
								&& execQuantity > 0) {
							$http.put("http://localhost:8080/user/book/execution/"+ selectedOrderBook + "/"+ execPrice + "/"+ execQuantity)
									.then(
											function(response) {
												$scope.save = "The order book is executed successfully";
												$scope.pageLink = "../view/display_message.html";
											});

						}
					}

					// Service to calculate statistics per order book
					$scope.displayOrderBookStat = function(selectedOrderBook) {
						if (selectedOrderBook > 0) {
							$http.get("http://localhost:8080/user/statistics/after/execution?orderBookId="+ selectedOrderBook)
									.then(
											function(response) {
												$scope.display = true;
												$scope.statisticPerBook = response.data;
											});
						}
					}

					// logout from the application
					$scope.logout = function() {
						$http.get("http://localhost:8080/user/logout")
								.then(
										function(response) {
											$window.location.href = 'http://localhost:8080/user/login.html';
										});
					}
				});
