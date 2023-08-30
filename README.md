# MC Server Information

## About
MC Server Information is a little toolchain that is splitted into a producer, a consumer mc plugin and a ui.

It provides overall information of minecraft servers into one central data source.

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
![Overall UI](https://github.com/mlhmz/mc-server-information/assets/66556288/4637ffb2-e6ae-40bb-88b2-62f66ed0f177)


Player Dialog
![Player Dialog](https://github.com/mlhmz/mc-server-information/assets/66556288/7fbe231b-683d-421c-88bc-f24c5c3edb92)

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

System Structure
![System Structure](https://github.com/mlhmz/mc-server-information/assets/66556288/7fb36a81-437a-4faa-a87c-e0042df98495)

