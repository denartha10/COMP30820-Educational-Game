const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/gs-guide-websocket'
});

stompClient.activate();

stompClient.onConnect = (frame) => {
    console.log('Connected: ' + frame);
    console.log("TESTING")
    stompClient.subscribe("/topic/board", (f) => {console.log(f.body)})
}

function handleMove(direction) {
    stompClient.publish({
        destination: "/app/move",
        body: JSON.stringify({'direction' : direction})
    })
}


function start(){
    let name = document.getElementById('playerName').value
    if(name.trim().length < 3){
        alert("Name needs to be three characters long")
    }else{
        document.getElementById('start-form').classList.toggle("hidden")
        stompClient.publish({
            destination: "/app/initialise",
            body: ""
        })
        document.addEventListener('keydown', function(event) {
            if (event.key === 'ArrowLeft') {
                handleMove('LEFT')
            } else if (event.key === 'ArrowRight') {
                handleMove('RIGHT');
            } else if (event.key === 'ArrowUp'){
                handleMove('UP');
            } else if (event.key === 'ArrowDown'){
                handleMove('DOWN');
            }
        });
    }
}