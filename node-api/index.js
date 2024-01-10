const express = require("express");
const axios = require('axios');

const app = express();
const port = 3000;

const springApiUrl = 'http://localhost:8080/api/sendHelloToNode';

app.get('/', (req, res) => {
  res.send('Welcome to my server!');
});

app.get('/receiveAndSendHello', async (req, res) => {
  let springApiData = "";
  axios.get(springApiUrl)
    .then(response => {
      springApiData = response.data;
      res.send('Hello from node.js! ' + springApiData);
    })
    .catch(error => {
      console.error('Error fetching data from Spring API:', error.message);
    });
});

app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});

