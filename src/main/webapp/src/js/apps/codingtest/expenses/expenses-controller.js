"use strict";

/******************************************************************************************

Expenses controller

******************************************************************************************/

var app = angular.module("expenses.controller", []);

app.controller("ctrlExpenses", ["$rootScope", "$scope", "Restangular", function ExpensesCtrl($rootScope, $scope, $Restangular) {
	// Update the headings
	$rootScope.mainTitle = "Expenses";
	$rootScope.mainHeading = "Expenses";
	
	// Update the tab sections
	$rootScope.selectTabSection("expenses", 0);
	
	$scope.dateOptions = {
		changeMonth: true,
		changeYear: true,
		dateFormat: "dd/mm/yy"
	};

	var loadExpenses = function() {
		// Retrieve a list of expenses via REST
		$Restangular.one("expenses").getList().then(function(expenses) {
			$scope.expenses = expenses;
		});
	}

	$scope.saveExpense = function() {
		if ($scope.expensesform.$valid) {
                    // Post the expense via REST
                    $Restangular.one("expenses").post(null, calculateVat($scope.newExpense)).then(function() {
			// Reload new expenses list
			loadExpenses();
                        // Clearing... 
                        $scope.clearExpense();
                    });
		}
	};

	var calculateVat = function(expense) {
            var vat = expense.amount * VAT_RATE;
            expense.vat = vat;
            return expense;
	}
        
	$scope.clearExpense = function() {
		$scope.newExpense = {};
	};

	// Initialise scope variables
        $Restangular.setBaseUrl('http://localhost:8084/alchemytec/');
        
        var VAT_RATE = (20 / 100);
        loadExpenses();
	$scope.clearExpense();
}]);