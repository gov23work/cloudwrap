
const functions = require('@google-cloud/functions-framework');
const escapeHtml = require('escape-html');
functions.http('helloHttp', (req, res) => {
    switch(mode){
        case "A":
            function1();
            function2();
            break;
        case "B":
            function2();
            function1();
            break;
        case "C":
            function1();
            break;
        case "D":
            function2();
            break;
        default:
            //threaded
            break;
    }
    res.send(`Hello ${escapeHtml(req.query.name || req.body.name || 'World')}!`);
})
function function1() {
   var trials = 10000000;
   var inVar = 0;
   var out = 0;
   var i = 0;
   var start = Date.now();
   while (i < trials) {
       var x = Math.random();
       var y = Math.random();
       var distance = Math.sqrt((x * x) + (y * y));
       if (distance <= 1) {
           inVar++;
       } else {
           out++;
       }
       i++;
   }
   var end = Date.now();
   
   console.log("in is " + inVar);
   console.log("out is " + out);
   
   var pi = 4.0 * ( inVar / trials);
   console.log("Pi is " + pi);
   
   console.log("Duration " + (end-start) + "ms");
}
function function2() {
   var trials = 11000000;
   
   var inVar = 0;
   var out = 0;
   var i = 0;
   var start = Date.now();
   while (i < trials) {
       var x = Math.random();
       var y = Math.random();
       var distance = Math.sqrt((x * x) + (y * y));
       if (distance <= 1) {
           inVar++;
       } else {
           out++;
       }
       i++;
   }
   var end = Date.now();
   
   console.log("in is " + inVar);
   console.log("out is " + out);
   
   var pi = 4.0 * ( inVar / trials);
   console.log("Pi is " + pi);
   
   console.log("Duration " + (end-start) + "ms");
}