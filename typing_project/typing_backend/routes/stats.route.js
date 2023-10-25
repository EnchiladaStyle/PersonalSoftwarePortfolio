const express = require('express');
const statsController = require('../controllers/stats.controller');
const authorize = require('../checkAuthentication');

const router = express.Router();

router.patch('/', authorize.checkAuth, statsController.update);

router.get('/', authorize.checkAuth, statsController.view);

module.exports = router; 