const models = require('../models');

//getScores uses sequelize to SELECT userName, best_speed FROM user;
//it returns the data to the client in descending order.
function getScores(req, res){
    models.User.findAll({order: [["best_speed", 'DESC']], attributes: ['userName', 'best_speed', 'best_accuracy']}).then(stats => {
        res.status(200).json(stats);
    }).catch(error => {
        res.status(500).json({
            message: 'failed to get data'
        });
    });
}

module.exports = {
    getScores: getScores
}