/*var maxlight = 1;
for (var light = 0.001; light < maxlight; light += 0.001) {
    analogWrite(A8, light);
}*/
var counter = 0.005;
var light = function () {
    while (counter <= 1) {
        analogWrite(A8, counter);
        counter = counter + 0.005;
        wait(500);
    }
};