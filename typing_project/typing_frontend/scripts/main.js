import { displayKeyboard } from "./handleKeyboard.js";
import { handleBackspace } from "./handleStats.js";
import { getQuote } from "./handleQuote.js";
import { WPM } from "./handleStats.js";
import { error_count } from "./handleStats.js";
import { rate } from "./handleStats.js";
import { personalBest } from "./handleStats.js";
import { updatePersonalBest } from "./handleStats.js";
const Quotable = 'https://api.quotable.io/random';

let counter = 0;
let quote;
let time = 0;
let keys = 0;
let current_key;
document.querySelector('#time-display').textContent = "WPM: ";
document.querySelector('#errors-display').textContent = "Errors: ";


function main(){

    if (sessionStorage.getItem('userName')){
        document.getElementById('name').innerHTML = sessionStorage.getItem('userName');
    }

    personalBest();

    getQuote(Quotable).then(result => {quote=result});

   document.querySelector('#restart').addEventListener('click', () => {getQuote(Quotable).then(result => {quote=result}); counter=0; time=0; keys=0});

   setInterval(() => {WPM(keys, time); time += 1}, 1000);

   document.querySelector('#text').addEventListener('input', () => {displayKeyboard(current_key, quote)});

   document.querySelector('#text').addEventListener('keydown', (newKey) => {
    if (newKey.key == 'Backspace'){
        
        handleBackspace();
        counter--;
        
    }

    else {
        keys += 1;
        current_key = newKey.key;
        counter += 1;
    }

    if (counter == quote.length + 1){
        console.log(error_count);
        console.log(Math.ceil(rate));
        updatePersonalBest({best_speed: Math.ceil(rate), best_accuracy: error_count});

           
    }
});
}



main();