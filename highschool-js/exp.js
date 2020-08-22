var va1 = function(x) {
	var counter = 1;
	for (var print = 1; x > print; print += 1) {
		counter = print * counter;
	}return counter;
}
console.log(va1(6));