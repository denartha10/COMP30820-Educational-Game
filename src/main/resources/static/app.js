const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/gs-guide-websocket'
});

stompClient.activate();

stompClient.onConnect = (frame) => {
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/greetings', (greeting) => {
        showGreeting(JSON.parse(greeting.body).content);
    })
}

stompClient.onWebSocketError = (error) => {
    console.error('Error')
}

stompClient.onStompError = (frame) => {
    console.log('Broker reported error: ' + frame.headers['message']);
    console.log('Additional details: ' + frame.body);
}

function connect() {
    stompClient.activate();
}

function disconnect() {
    stompClient.deactivate();
    console.log('Disconnected');
}

function sendMessage(){
    stompClient.publish({
        destination: "/app/hello",
        body: JSON.stringify({'name' : document.getElementById('messageInput').value})
    })
}

function showGreeting(message) {
    const now = new Date()
    const HTMLOutput = `
    <div class="flex items-end space-x-2 mb-4">
        <div class="flex items-center justify-center w-10 h-10 rounded-full bg-indigo-500">
            <span class="text-white text-lg">YupCha</span>
        </div>
        <div class="flex flex-col leading-tight">
            <div class="text-sm text-gray-600">${message}</div>
            <div class="text-sm text-gray-400">${now.getHours()}:${now.getMinutes()}</div>
        </div>
    </div
    `
    const messageFeed = document.getElementById('message-feed');
    messageFeed.insertAdjacentHTML('beforeend', HTMLOutput);
}