import {Client, Message} from '@stomp/stompjs';

const websocketURL: string = 'ws://localhost:8080/gs-guide-websocket';
const playerIDKey: string = 'playerID';

const stompClient = new Client({
    brokerURL: websocketURL
})

const handleMove = (direction) => () => {
    const playerID: string | null = localStorage.getItem(playerIDKey);
    if (!playerID) {
        console.error("Player ID not found");
        return;
    }else {
        stompClient.publish({
            destination: "/app/move",
            body: JSON.stringify({'direction': direction, 'playerID': playerID})
        });
    }
};

const start = () => {
    const playerNameInput = document.getElementById('playerName').value.trim();

    if (playerNameInput.length < 3) {
        alert("Name needs to be three characters long");
    } else {
        const startForm = document.getElementById('start-form');
        startForm.classList.toggle("hidden");

        stompClient.publish({
            destination: "/app/initialise",
        });

        document.addEventListener('keydown', (event) => {
            switch (event.key) {
                case 'ArrowLeft':
                    handleMove('LEFT')();
                    break;
                case 'ArrowRight':
                    handleMove('RIGHT')();
                    break;
                case 'ArrowUp':
                    handleMove('UP')();
                    break;
                case 'ArrowDown':
                    handleMove('DOWN')();
                    break;
                default:
                    break;
            }
        });
    }
};

stompClient.activate();

stompClient.onConnect = (frame) => {
    stompClient.subscribe("/topic/board", (frame) => {
        const gameState = JSON.parse(frame.body);
        const storedPlayerID = localStorage.getItem(playerIDKey);

        if (gameState.playerID && !storedPlayerID) {
            localStorage.setItem(playerIDKey, gameState.playerID);
            console.log("Your ID is " + localStorage.getItem(playerIDKey));
        }

        console.log(gameState)
    });
};

stompClient.onWebSocketClose = () => {
    localStorage.removeItem(playerIDKey);
};
