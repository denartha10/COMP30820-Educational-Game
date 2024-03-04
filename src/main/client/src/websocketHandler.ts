import { Client } from "@stomp/stompjs";
import { addGameView, redraw } from "./render";
import { GameState } from "./types";

const websocketURL: string = "ws://localhost:8080/gs-guide-websocket";
const playerIDKey: string = "playerID";

const stompClient = new Client({
  brokerURL: websocketURL,
});

// activate the stomp client
stompClient.activate();

// subscribe to the topic and set the callback function for when a message is received
stompClient.onConnect = () => {
  stompClient.subscribe("/topic/board", (frame) => {
    const gameState: GameState = JSON.parse(frame.body);
    const storedPlayerID = localStorage.getItem(playerIDKey);

    if (gameState.playerID && !storedPlayerID) {
      localStorage.setItem(playerIDKey, gameState.playerID);
      console.log("Your ID is " + localStorage.getItem(playerIDKey));
    }

    redraw(gameState);
  });
};

// remove the playerID from local storage when the websocket connection is closed so a new one is generated next time
stompClient.onWebSocketClose = () => {
  localStorage.removeItem(playerIDKey);
};

// send a message to the server to move the player
// send it to the /app/move endpoint
const handleMove = (direction: string) => () => {
  const playerID: string | null = localStorage.getItem(playerIDKey);
  if (!playerID) {
    console.error("Player ID not found");
    return;
  } else {
    const messageBody = JSON.stringify({
      direction: direction,
      playerID: playerID,
    });

    stompClient.publish({
      destination: "/app/move",
      body: messageBody,
    });
  }
};

// get the player's name from the input field and send a message to the server to initialise the game
// send it to the /app/initialise endpoint
// if successful, hide the start form and add an event listener to the document to listen for arrow key presses
const start = () => {
  const playerNameInput = document.getElementById(
    "playerName",
  ) as HTMLInputElement;
  const trimmedNameInput = playerNameInput.value.trim();

  if (trimmedNameInput.length < 3) {
    alert("Name needs to be three characters long");
  } else {
    const startForm = document.getElementById("start-form") as HTMLElement;
    startForm.classList.toggle("hidden");

    stompClient.publish({
      destination: "/app/initialise",
    });

    document.addEventListener("keydown", (event) => {
      switch (event.key) {
        case "ArrowLeft":
          handleMove("LEFT")();
          break;
        case "ArrowRight":
          handleMove("RIGHT")();
          break;
        case "ArrowUp":
          handleMove("UP")();
          break;
        case "ArrowDown":
          handleMove("DOWN")();
          break;
        default:
          break;
      }
    });

    addGameView();
  }
};

export { start };
