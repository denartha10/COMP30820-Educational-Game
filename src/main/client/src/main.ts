import { start } from "./websocketHandler";

//get the element with the id of start-button and add an event listener to it
const startButton = document.getElementById(
  "start-button",
) as HTMLButtonElement | null;

if (startButton) {
  startButton.addEventListener("click", start);
}

