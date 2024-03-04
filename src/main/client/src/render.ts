import * as PIXI from "pixi.js";
import type { GameState } from "./types";

const gameWidth: number = ((window.innerHeight * 0.9) / 10) * 16;
const gameHeight: number = window.innerHeight * 0.9;

// this is a 16:9 aspect ratio
let game = new PIXI.Application<HTMLCanvasElement>({
  width: gameWidth,
  height: gameHeight,
});

// create a pixi graphics
const graphics = new PIXI.Graphics();

// add graphics component to gae stage
game.stage.addChild(graphics);

// for adding the game canvas to the body of our page
const addGameView = () => {
  document.body.appendChild(game.view);
};

const redraw = (gameState: GameState) => {
  const players = gameState.board.players;
  const tileWidthSize = gameState.board.width;
  const tileHeightSize = gameState.board.height;

  const numTilesX = game.view.width / tileWidthSize;
  const numTilesY = game.view.height / tileHeightSize;

  for (let x = 0; x < numTilesX; x++) {
    for (let y = 0; y < numTilesY; y++) {
      // Example color: red
      graphics.beginFill(0xff0000); // Red color
      graphics.drawRect(
        x * tileWidthSize,
        y * tileHeightSize,
        tileWidthSize,
        tileHeightSize,
      );
      graphics.endFill();
    }
  }

  for (const p of Object.values(players)) {
    graphics.beginFill(0x000000);
    graphics.drawRect(
      p.x * tileWidthSize,
      p.y * tileHeightSize,
      tileWidthSize,
      tileHeightSize,
    );
    graphics.endFill();
  }
};

export { addGameView, redraw };
