export let error_count = -1;
export let rate;
const statsEndpoint = 'http://localhost:3000/stats';
let keys = 0;
let counter = 0;
let stats;


document.querySelector('#restart').addEventListener('click', () => {error_count = -1; keys=0; counter=0});

export function errors_display(_current_key, _quote, _counter){

    error_count += 1; 
    displayCount();
}

export function handleBackspace(){

    counter -= 2;
    keys -= 1;
    error_count -= 2;
    displayCount();
    if (error_count < 0){
        error_count = -1;
    }
}
 
function displayCount(){

    document.querySelector('#errors-display').textContent = "Errors: " + error_count;
}

export function WPM(keys, time){
    
    rate = (keys/6)/(time/60);
    document.querySelector('#time-display').textContent = "WPM: " + Math.trunc(rate);
}

export async function personalBest(){

    let accessToken = sessionStorage.getItem('accessToken');
    
        let response = await fetch(statsEndpoint, {
            headers: {
                authorization: "Bearer " + accessToken
            },
            method: "GET",
            mode: "cors"
        });
        
        
        if (response.ok){
            
            stats = await response.json();
            console.log(stats);
        }

        document.querySelector('#pb').innerHTML = `Personal Best: (Speed ${stats.best_speed || "X"}, errors ${stats.best_accuracy || "X"})`;
        return stats;
}

export async function updatePersonalBest(newStats){

        if (!stats.best_speed || newStats.best_speed > stats.best_speed || newStats.best_accuracy < stats.best_accuracy){
            
            let accessToken = sessionStorage.getItem('accessToken');

            await fetch(statsEndpoint, {
                headers: {
                    'content-type': 'application/json;charset=utf-8',
                    authorization: "Bearer " + accessToken
                },
                method: "PATCH",
                body: JSON.stringify({
                    best_speed: newStats.best_speed,
                    best_accuracy: newStats.best_accuracy
                }),
                mode: "cors"
            }).then(result => console.log(result));

            personalBest();
            }
    }
    
