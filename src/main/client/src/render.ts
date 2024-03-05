import * as PIXI from "pixi.js";
import type { GameState } from "./types";

const boardDisplayWidth: number = 800;
const boardDisplayHeight: number = 800;

// this is a 16:9 aspect ratio
let game = new PIXI.Application<HTMLCanvasElement>({
  width: boardDisplayWidth,
  height: boardDisplayHeight,
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

  // number of x tiles
  const tileWidthCount = gameState.board.width;
  // number of y tiles
  const tileHeightCount = gameState.board.height;

  const tileDisplayWidth = boardDisplayWidth / tileWidthCount;
  const tileDisplayHeight = boardDisplayHeight / tileHeightCount;

  for (let x = 0; x < tileWidthCount; x++) {
    for (let y = 0; y < tileHeightCount; y++) {
      // Example color: red
      graphics.beginFill(0x000000); // Black color
      graphics.drawRect(
        x * tileDisplayWidth,
        y * tileDisplayHeight,
        tileDisplayWidth,
        tileDisplayHeight,
      );
      graphics.endFill();
    }
  }

  for (const p of Object.values(players)) {
    graphics.beginFill(parseInt(p.color, 16));
    graphics.drawRect(
      p.x * tileDisplayWidth,
      p.y * tileDisplayHeight,
      tileDisplayWidth,
      tileDisplayHeight,
    );
    graphics.endFill();
  }
};

export { addGameView, redraw };
