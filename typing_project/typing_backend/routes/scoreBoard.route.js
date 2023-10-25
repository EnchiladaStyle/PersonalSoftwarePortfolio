const express = require('express');
const scoreBoardController = require('../controllers/scoreBoard.controller');

const router = express.Router();

router.get('/getScores', scoreBoardController.getScores);

module.exports = router; 