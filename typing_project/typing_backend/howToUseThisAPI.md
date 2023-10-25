Created User:
this is a post request. It looks like http://localhost:3000/user/sign_up.
the request must contain json for "user_name" and "password". These must be string data and they cannot be null.

Sign In:
this is a get request. It looks like http://localhost:3000/user/sign_in. the request must contain json for "user_name" and "password". These must be string data and they cannot be null. The request returns an encrypted authentication token. You must keep this token in order to access restricted functionality later.

Update Stats: 
this is a patch request. It looks like http://localhost:3000/stats. The request must contain the authentication token returned from the sign_in request. It must also contain json for "best_speed" and "best_accuracy". These must both be strings. These values will replace the corresponding values in the database.

View Stats:
this is a get request. it looks like http://localhost:3000/stats. the request must contain the authentication token returned from the sign_in request. No json is necessary.

View ScoreBoard:
this is a get request. It looks like http://localhost:3000/scoreBoard/getScores. No authentication or json is necessary