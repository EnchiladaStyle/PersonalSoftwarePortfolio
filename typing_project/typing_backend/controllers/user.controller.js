const jwt = require('jsonwebtoken');
const bcrypt = require('bcryptjs');
const models = require('../models');


//sign_in takes request data and compares it with usernames in the database.
//if it finds a match, it hashes the provided password and compares it
//to the password in the database. If the passwords match, then it 
//creates an encrypted access token and returns it to the client.
function sign_in(req, res){
    const credentials = {
        userName: req.body.user_name,
        password: req.body.password
    }

    models.User.findOne({where:{userName:credentials.userName}}).then(user => {
        if(user == null){
            res.status(401).json({
                message: 'invalid credentials'
            })
        }
        else{
            bcrypt.compare(credentials.password, user.password, function(error, result){
                if(result){
                    const accessToken = jwt.sign({
                        userName: credentials.userName,
                        userId: user.id
                    }, 'web_token_key', function(err, accessToken){
                        return res.status(201).json({
                            message: 'authenticated',
                            token: accessToken
                        })
                    });
                }
                else{
                    res.status(401).json({
                        message: 'invalid credentials'
                    })
                }
            });
        }
    }).catch(error => {
        res.status(401).json({
            message: 'invalid credentials'
        })
    })

}

//sign_up takes request data as a password and a username. It hashes
//the password and then creates a new user with the credentials.
function sign_up(req, res){

    bcrypt.genSalt(10, function(error, salt){

        bcrypt.hash(req.body.password, salt, function(error, hash){

            const credentials = {
                userName: req.body.user_name,
                password: hash
            }
        
            models.User.create(credentials).then(result => {
                res.status(200).json({
                    message: 'user created'
                })
            }).catch(error => {
                res.status(500).json({
                    message: 'user not created ):',
                    error: error
                })
            })

        })

    })

}

module.exports = {
    sign_in: sign_in,
    sign_up: sign_up
}