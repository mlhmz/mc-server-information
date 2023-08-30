# MC Server Information

## About
MC Server Information is a little toolchain that is splitted into a producer, a consumer mc plugin and a ui.

The producers talk over Redis SubPub to the Consumers and publish their Server Information.
The producer server information is gathered over the Spigot API for Minecraft Plugins, with which the jar can be then put into a minecraft server.

The consumer consumes the events and puts them into a redis hash, that is collection json payloads of server objects.

Over a GET Route, the Information can be read then.

# Requirements
- Node & NPM
- Java 17
- Docker (for Redis and the Test Minecraft Server)

## Screenshots & Resources
Overall UI
![image](https://github.com/mlhmz/mc-server-information/assets/66556288/a7c8b9de-90ed-4a05-9bf6-4e6eb9659e71)

Player Dialog
![image](https://github.com/mlhmz/mc-server-information/assets/66556288/8367cff6-68a2-4a35-9ebf-9a9bd674d467)

Example JSON Payload
```json
{
  "motd": "A Vanilla Minecraft Server powered by Docker",
  "ip": "",
  "name": "lobby",
  "version": "git-Paper-169 (MC: 1.20.1)",
  "onlinePlayerNames": [
    "Player1",
    "Player2",
    "Player3",
    "Player4",
    "Player5",
    "Player6",
    "Player7",
    "Player8"
  ],
  "playerCount": 3,
  "maxPlayerCount": 20,
  "worldCount": 3,
  "lastFetched": "2023-08-30T09:46:06.831Z"
},
```
