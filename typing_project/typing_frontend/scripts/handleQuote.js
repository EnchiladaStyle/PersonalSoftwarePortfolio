import { displayKeyboard } from "./handleKeyboard.js";

let quote = "";
let jdata;
let current_key = 0;

export async function getQuote(url){
    quote = "";
    let response = await fetch(url);
    if (response.ok){
        jdata = await response.json();

        quote = jdata.content;
        document.querySelector('#quote').textContent = quote;

        displayKeyboard(current_key, quote);
        document.querySelector('#text').value = "";
        current_key = 0;
        document.querySelector('#text').focus();
        }

        return quote;

    }