type Player = {
  playerID: string; // Assuming UUID or string is represented as string
  x: number;
  y: number;
};

type Board = {
  height: number;
  width: number;
  players: Record<Player["playerID"], Player>;
};

// The union type that matches either the Board type or a player-specific object
type GameState = {
  board: Board;
  playerID: Player["playerID"];
};

export type { GameState };
