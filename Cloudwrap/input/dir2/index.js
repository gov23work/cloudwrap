const functions = require('@google-cloud/functions-framework');

functions.http('helloWorld', (req, res) => {
  console.log('I am a log entry!');
  console.log("I am another entry")
  console.error('I am an error!');
  res.end();
});