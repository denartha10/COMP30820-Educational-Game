//PixiJS is a rendering engine, and it supports additional features such as interaction management that are commonly needed when using a render engine. But it is not a framework like Unity or Phaser. Frameworks are designed to do all the things you'd need to do when building a game - user settings management, music playback, object scripting, art pipeline management... the list goes on. PixiJS is designed to do one thing really well - render graphical content. This lets us focus on keeping up with new technology, and makes downloading PixiJS blazingly fast.

const websocketURL = 'ws://localhost:8080/gs-guide-websocket';
const playerIDKey = 'playerID';

const stompClient = new StompJs.Client({
    brokerURL: websocketURL
});

const handleMove = (direction) => () => {
    const playerID = localStorage.getItem(playerIDKey);
    stompClient.publish({
        destination: "/app/move",
        body: JSON.stringify({ 'direction': direction, 'playerID': playerID })
    });
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
