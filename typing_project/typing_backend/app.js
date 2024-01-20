const express = require('express');
const userRoute = require('./routes/user.route');
const statsRoute = require('./routes/stats.route');
const scoreBoardRoute = require('./routes/scoreBoard.route');
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();

app.use(bodyParser.json());
app.use(cors());

app.use('/user', userRoute);
app.use('/stats',statsRoute);
app.use('/scoreBoard', scoreBoardRoute);





module.exports = app; 