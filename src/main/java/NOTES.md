# Devlog 2024-03-02

## Overview

A progress report on our web based 2D enviromemtal education game and some more details for anyone interested in learning a bit about the technology
- Got a websocket server up and running in java
- Learned about STOMP (Simple/Streaming Text Oriented Messaging Protocol) and how it's a widely excepted standard for messaging with websockets
- I got a StompJS client running which is a library for connecting to a websocket using a nice API
- To run the project download code. Run `JavaGameServerappliaction.java` and visit `http:localhost:8080`

## Table of Contents
- [Whats New](#whats-new)
  - Spring Web Backend
  - Websocket Server Connection & Websocket POC 
- [Issues I Faced](#issues-faced)
- [What I learned](#what-i-learned)
  - [Java Packaging and Imports](#java-packages)
  - [What is Spring?](#what-is-spring)
  - [Websockets](#websockets)
    - Whats a websocket? 
    - Why use a protocol?
- [Whats Next](#whats-next)


<a id="whats-new"></a>
## What's New

### Spring Backend

I made a basic spring backend using springboot setup in intellij. You can make this in other editors but its fairly easy to get started in intellij. Its setup using Java 17 and Gradle Build system. 
To get it running on your own computer you can just clone the repo and start the `JavaGameServerapplication.java` file.

Once you do that you should be able to visit the page with the websocket connection at `http:localhost:8080/`

You can find out more about Spring Websockets [here](https://spring.io/guides/gs/messaging-stomp-websocket)

### Websocket Server Connection & Websocket POC

I set up a HTML page with some chat room styles styled by chatGPT using the tailwindcss library. It just has a mmessage feed and an input for sending a message.
There is not a huge amount of javascript thanks to StompJs a production ready websocket client library for javascript that is highly compattible with the websocket backend discussed in the last section.
I think its going to be really useful going forward for 'streaming' our game data from Java to the frontend. Since the body is JSON data it will fit the requirements we had for our games minimal viable product

You can find out more about the StompJs library [here](https://stomp-js.github.io/#getting-started)

<a id="issues-faced"></a>
## Issues Faced

With the original code I could not connect to the endpoint at all. I tried fixing it: 
- By changing my WiFi
- Trying different frontend imports
- By deleting the code and starting again

Ultimately the problem I was facing was with how spring manages packages. I had the Models in a models folder, Controllers in their own controllers folder and Configurations in a confurations folder but that was apparently the problem. When I put all the files in to the main packlage it just started working without any issue at all. I go in to more detail about it in the what I learned subsection [Java Package System](#java-packages)

<a id="#what-i-learned"></a>
## What I Learned

<a id="java-packages"></a>
### Java Packaging and Imports

<a id="what-is-spring"></a>
### What is Spring?

<a id="websockets"></a>
### Websockets

<a id="whats-next"></a>
## What's Next?

**Backend**
- We need to design on a way to model our classes on the backend
  - We are currently looking in to entity component systems as a good solution for this. Entity component systems are not frameworks it is more of a style of writing object oriented languages to be more compositional based instead of inheritance which creates problems in large code bases
- We are going to make a simple game loop and state on the backend to run the logic of the game

**Frontend**
- We are going to choose a way we will render our frontend and then implement a small 2D grid with the following minimal features
  - Square map
  - Crossroads
  - Gem
  - Player
  - Button to trigger movement towards gem

**Integration**
- Decide how we will model our json data that is between the back and frontend. 
- Get live rendering running 