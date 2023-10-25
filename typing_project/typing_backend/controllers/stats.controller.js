const models = require('../models');

//update takes the userId and the new stats from the request. It then
//uses the sequelize model to replace the data in the database.
function update(req, res){
    console.log("ran");
    const userId = req.userData.userId;
    const updatedStats = {
        best_speed: req.body.best_speed,
        best_accuracy: req.body.best_accuracy
    }

    models.User.update(updatedStats, {where: {id:userId}}).then(result => {
        return res.status(200).json({
            message: 'stats updated'
        });
    }).catch(error => {
        return res.status(500).json({
            message: 'could not update stats',
            error: error
        });
    });
}



//view takes the userId from the request. Then it uses sequelize to 
//access the database and return the stats that match that id.
function view(req, res){
    const userId = req.userData.userId;

    console.log(userId);

    models.User.findByPk(userId).then(result  => {
        return res.status(200).json({
            best_speed: result.best_speed,
            best_accuracy: result.best_accuracy
        });
    }).catch(error => {
        res.status(500).json({
            message: 'something went wrong',
            error: error
        });
    });
}

module.exports = {
    update: update,
    view: view
}