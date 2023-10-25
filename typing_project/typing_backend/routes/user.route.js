const express = require('express');
const userController = require('../controllers/user.controller');

const router = express.Router();

router.post('/sign_in', userController.sign_in);

router.post('/sign_up', userController.sign_up);

module.exports = router; 
