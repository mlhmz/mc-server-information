import { useState } from "react";
import { Card } from "./components/Card";
import { Nav } from "./components/Nav";
import useInformation from "./hooks/use-information";

function App() {
  const { data } = useInformation();
  const [searchValue, setSearchValue] = useState("");

  return (
    <>
      <div className="antialiased">
        <Nav />
        <div className="pt-20">
          <div className="flex flex-col items-center md:w-9/12 lg:w-1/2 xl:w-1/3 m-auto">
            <input
              value={searchValue}
              onChange={(e) => setSearchValue(e.target.value)}
              placeholder="Search for Name"
              className="bg-stone-800 border border-stone-700 rounded-md py-2 px-2 w-9/12"
            />
            {data
              .filter((information) => {
                const name = information.name;
                if (name === undefined) return false;
                return name.toLowerCase().includes(searchValue.toLowerCase());
              })
              .map((information, index) => (
                <Card key={index} information={information} />
              ))}
          </div>
        </div>
      </div>
    </>
  );
}

export default App;
