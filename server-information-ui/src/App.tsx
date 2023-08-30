import { useEffect } from "react";
import { Card } from "./components/Card";
import { Nav } from "./components/Nav";
import useInformation from "./hooks/use-information";

function App() {
  const { data, refresh } = useInformation();

  useEffect(() => {
    refresh();
  }, [refresh]);

  return (
    <>
      <div className="antialiased">
        <Nav />
        <div className="pt-20">
          <div className="flex flex-col items-center md:w-9/12 lg:w-1/2 xl:w-1/3 m-auto">
            {data.map((information, index) => <Card key={index} information={information} />)}
          </div>
        </div>
      </div>
    </>
  );
}

export default App;
