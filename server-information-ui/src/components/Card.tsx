import { Dispatch } from "react";
import { Information } from "../Information";
import { formatDate, parseIsoDate } from "../utils/date";

export const Card = ({ information, handleSelection }: { information: Information, handleSelection: Dispatch<Information> }) => {
  return (
    <div 
    onClick={() => handleSelection(information)}
    className="m-3 p-3 rounded-md border border-stone-700 hover:bg-stone-700 hover:cursor-pointer bg-stone-800 flex flex-col items-center gap-5 xl:w-1/3"
    >
      <h2 className="text-2xl font-bold">{information.name}</h2>
      <div className="flex gap-3">
        <label htmlFor="lastFetched" className="font-bold">
          Last Fetched
        </label>
        <p>{information.lastFetched ? formatDate(parseIsoDate(information.lastFetched)) : "N/A"}</p>
      </div>
      <div className="grid grid-cols-2 grid-rows-3 gap-5">
        <div className="flex  gap-3">
          <label htmlFor="motd" className="font-bold">
            MOTD
          </label>
          <p>{information.motd}</p>
        </div>
        <div className="flex gap-3">
          <label htmlFor="ip" className="font-bold">
            IP
          </label>
          <p>{information.ip ?? "N/A"}</p>
        </div>
        <div className="flex gap-3">
          <label htmlFor="version" className="font-bold">
            Version
          </label>
          <p>{information.version ?? "N/A"}</p>
        </div>
        <div className="flex gap-3">
          <label htmlFor="playerCount" className="font-bold">
            Player Count
          </label>
          <p>{information.playerCount ?? "N/A"}</p>
        </div>
        <div className="flex gap-3">
          <label htmlFor="maxPlayerCount" className="font-bold">
            Max Player Count
          </label>
          <p>{information.maxPlayerCount ?? "N/A"}</p>
        </div>
        <div className="flex gap-3">
          <label htmlFor="worldCount" className="font-bold">
            World Count
          </label>
          <p>{information.worldCount ?? "N/A"}</p>
        </div>
      </div>
    </div>
  );
};
