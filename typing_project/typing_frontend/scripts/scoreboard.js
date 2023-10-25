const scoreboardEndpoint = 'http://localhost:3000/scoreBoard/getScores';

async function showScoreboard(){

    let response = await fetch(scoreboardEndpoint, {
        method: "GET",
        mode: "cors"
    })
    
    if (response.ok){
        data = await response.json();
        console.log(data);
    }

    for (let i=0; i<data.length; i++){
        var newRow = document.createElement("p");

        newRow.innerHTML = `${data[i].userName} Speed ${data[i].best_speed}, Errors ${data[i].best_accuracy}`;

        document.getElementById('userSlots').appendChild(newRow);
    }
}

showScoreboard();