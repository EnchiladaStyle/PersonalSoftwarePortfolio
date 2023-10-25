const jwt = require('jsonwebtoken');


//checkAuth starts by separating out the access token in the request
//and checking if it is valid. then it decodes the token and appends 
//the information into the request. Once it finishes, it passes the 
//request back to the app to be routed
function checkAuth(req, res, next){

    try{
        const token = req.headers.authorization.split(" ")[1];
        const decodedToken = jwt.verify(token, 'web_token_key');
        req.userData = decodedToken; //appends userId and name to the request to be used later
        next();
    }
    catch(error){
        return res.status(401).json({
            message: 'unauthorized'
        });
    }
    
}

module.exports = {
    checkAuth: checkAuth
}