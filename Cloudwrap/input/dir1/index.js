const functions = require('@google-cloud/functions-framework');

functions.http('helloWorld', (req, res) => {
  console.log('I am a log entry!');
  console.error('I am an error!');
  res.end();
});