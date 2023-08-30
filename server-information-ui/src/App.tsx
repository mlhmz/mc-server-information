import { useEffect, useState } from "react";
import { Card } from "./components/Card";
import { Nav } from "./components/Nav";
import useInformation from "./hooks/use-information";
import { Information } from "./Information";
import Dialog from "./components/Dialog";

function App() {
  const { data, refresh } = useInformation();
  const [selection, setSelection] = useState<Information | undefined>(
    undefined
  );
  const [isDialogOpen, setIsDialogOpen] = useState(false);
  const [searchValue, setSearchValue] = useState("");
  const [lastRefresh, setLastRefresh] = useState<Date>(new Date());

  useEffect(() => {
    const interval = setInterval(() => {
      refresh();
      setLastRefresh(new Date());
    }, 1000 * 30);

    return () => clearInterval(interval);
  }, [refresh]);

  const isInformationContainingSearchValue = (information: Information) => {
    if (searchValue === "") return true;
    const name = information.name;
    if (name === undefined) return false;
    return name.toLowerCase().includes(searchValue.toLowerCase());
  };

  return (
    <>
      <div className="antialiased">
        <Nav
          lastRefresh={`${lastRefresh.toLocaleDateString()} ${lastRefresh.toLocaleTimeString()}`}
        />
        <Dialog
          selection={selection}
          open={isDialogOpen}
          closeDialog={() => {
            setIsDialogOpen(false)
          }}
        />
        <div className="pt-36">
          <div className="flex flex-col items-center md:w-9/12 lg:w-1/2 xl:w-9/12 m-auto gap-4">
            <input
              value={searchValue}
              onChange={(e) => setSearchValue(e.target.value)}
              placeholder="Search for Name"
              className="bg-stone-800 border border-stone-700 rounded-md py-2 px-2 w-1/2"
            />
            <div className="flex flex-col xl:flex-row xl:flex-wrap items-center justify-center">
              {data
                .filter(isInformationContainingSearchValue)
                .map((information, index) => (
                  <Card
                    key={index}
                    information={information}
                    handleSelection={(information) => {
                      setIsDialogOpen(true);
                      setSelection(information);
                    }}
                  />
                ))}
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default App;
