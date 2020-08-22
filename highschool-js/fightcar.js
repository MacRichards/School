function onInit() {
    pinMode(A8, "input_pullup");
    var startTime = 0;
    var run = null;
    timer = 0;

    function nomove() {
        digitalWrite(A6, 0); //A6 is left forward
        digitalWrite(A7, 0); //A7 is left reverse
        digitalWrite(B6, 0); //B6 is right forward
        digitalWrite(B7, 0); //B7 is right reverse
    }

    function sanicfast() {
        analogWrite(A6, 0.99, {
            freq: 100
        }); //A6 is left forward
        digitalWrite(A7, 0); //A7 is left reverse
        digitalWrite(B6, 1); //B6 is right forward
        digitalWrite(B7, 0); //B7 is right reverse
        console.log(" going forward");
    }

    function slowdown() {
        analogWrite(A6, 0.5, {
            freq: 100
        }); //A6 is left forward
        digitalWrite(A7, 0); //A7 is left reverse
        analogWrite(B6, 0.5, {
            freq: 100
        }); //B6 is right forward
        digitalWrite(B7, 0); //B7 is right reverse
        console.log("im going slow");
    }

    function Bright() {
        digitalWrite(A6, 0); //A6 is left forward
        digitalWrite(A7, 0); //A7 is left reverse
        digitalWrite(B6, 0); //B6 is right forward
        digitalWrite(B7, 1); //B7 is right reverse
        console.log("going back right");
    }

    function right() {
        digitalWrite(A6, 0); //A6 is left forward
        digitalWrite(A7, 0); //A7 is left reverse
        digitalWrite(B7, 0); //B6 is right forward
        analogWrite(B6, 0.3, {
            freq: 100
        }); //B7 is right reverse
        console.log("going forward right");
    }

    function reverse() {
        digitalWrite(A6, 0); //A6 is left forward
        digitalWrite(A7, 1); //A7 is left reverse
        digitalWrite(B6, 0); //B6 is right forward
        digitalWrite(B7, 1); //B7 is right reverse
        console.log("going back");
    }

    function Bleft() {
        digitalWrite(A6, 0); //A6 is left forward
        digitalWrite(A7, 1); //A7 is left reverse
        digitalWrite(B6, 0); //B6 is right forward
        digitalWrite(B7, 0); //B7 is right reverse
        console.log("going back left");
    }

    function aroundetc() {
        analogWrite(A6, 0.36, {
            freq: 100
        }); //A6 is left forward
        digitalWrite(A7, 0); //A7 is left reverse
        digitalWrite(B6, 0); //B6 is right forward
        analogWrite(B7, 0.36, {
            freq: 100
        }); //B7 is right reverse
        console.log("going around");
    }


    function leftwardly() {
        analogWrite(A6, 0.3, {
            freq: 100
        }); //A6 is left forward
        digitalWrite(A7, 0); //A7 is left reverse
        digitalWrite(B6, 0); //B6 is right forward
        digitalWrite(B7, 0); //B7 is right reverse
        console.log("going forward left");
    }

    function getIrL() {
        var raw = analogRead(B1);
        var dist = -138.05 * Math.pow(raw, 3) +
            293.98 * Math.pow(raw, 2) - 210.28 * raw + 54.4;
        dist = Math.round(dist);
        return dist;
    }

    function getIrR() {
        var raw = analogRead(A5);
        var dist = -138.05 * Math.pow(raw, 3) +
            293.98 * Math.pow(raw, 2) - 210.28 * raw + 54.4;
        dist = Math.round(dist);
        return dist;
    }

    function getLight(pin) {
        var c = 0;
        pin.set();
        while (pin.read()) c += 1;
        return c;
    }

    function report() {
        IRval = getLight(B4);
        console.log("IRval " + IRval);
        return IRval;
    }

    function all() {
        getIrL();
        getIrR();
        var now = getTime();
        var elapsedTime = now - startTime;
        elapsedTime = Math.ceil(elapsedTime);
        console.log(getIrL() + "      1");
        console.log(getIrR() + "      2");
        console.log(elapsedTime);
        if (elapsedTime <= 2) {
            stop();
        }
        if ((getIrR() <= 31) && (getIrL() <= 31) && (elapsedTime > 2)) {
            nomove();
            sanicfast();
            digitalWrite(LED1, 0);
            digitalWrite(LED2, 0);
        }
        if ((getIrR() <= 31) && (getIrL() > 31) && (elapsedTime > 2)) {
            nomove();
            right();
            digitalWrite(LED1, 1);
            digitalWrite(LED2, 0);
        }
        if ((getIrL() <= 31) && (getIrR() > 31) && (elapsedTime > 2)) {
            nomove();
            leftwardly();
            digitalWrite(LED2, 1);
            digitalWrite(LED1, 0);
        }
        if ((getIrL() > 31) && (getIrR() > 31) && (elapsedTime > 2)) {
            nomove();
            aroundetc();
            digitalWrite(LED1, 0);
            digitalWrite(LED2, 0);
        }
        if (report() > 5) {
            interupt();
        }
    }

    function all2() {
        run = setInterval(all, 10);
    }

    function start() { //stops all wheels
        digitalWrite(A6, 0); //A6 is left forward
        digitalWrite(A7, 0); //A7 is left reverse
        digitalWrite(B6, 0); //B6 is right forward
        digitalWrite(B7, 0); //B7 is right reverse
        startTime = getTime();
        all2();
        console.log("I will go in two seconds");
    }

    function interuptOff() { //ends the interupt and starts mainLoop
        nomove();
        all2();
    }

    function interupt() {
      console.log("Cleared");
      clearInterval(run);
      nomove();
      reverse();
      setTimeout(right, 300);
      setTimeout(interuptOff, 1500);
    }


    setWatch(start, BTN, {
        repeat: true,
        edge: "falling"
    });
}
save();
onInit();