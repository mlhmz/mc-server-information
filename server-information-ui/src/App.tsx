import { Card } from "./components/Card";
import { Nav } from "./components/Nav";

function App() {
  const information = {
    motd: "a",
    name: "a",
    version: "a",
    onlinePlayerNames: [
      "a",
      "b",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
      "c",
    ],
    playerCount: 1,
    maxPlayerCount: 1,
    worldCount: 1,
    lastFetched: "a",
  };

  const createMockCards = (count: number) => {
    const cards = [];
    for (let i = 0; i < count; i++) {
      cards.push(<Card information={information} />);
    }
    return cards;
  };

  return (
    <>
      <div className="antialiased">
        <Nav />
        <div className="pt-20">
          <div className="flex flex-col items-center md:w-9/12 lg:w-1/2 xl:w-1/3 m-auto">
            {createMockCards(100)}
          </div>
        </div>
      </div>
    </>
  );
}

export default App;
