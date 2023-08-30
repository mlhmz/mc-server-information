export interface Information {
  motd?: string;
  ip?: string;
  name?: string;
  version?: string;
  onlinePlayerNames?: string[];
  playerCount?: number;
  maxPlayerCount?: number;
  worldCount?: number;
  lastFetched?: string;
}
