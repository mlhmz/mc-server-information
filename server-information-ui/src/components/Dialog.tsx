import { Dispatch } from "react";
import { Information } from "../Information";

export const Dialog = ({
  selection,
  open,
  closeDialog,
}: {
  selection?: Information;
  open: boolean;
  closeDialog: Dispatch<void>;
}) => {
  if (!selection || !open) return <></>;
  return (
    <>
      <dialog
        className="p-5 my-5 rounded-md bg-stone-800 border border-stone-700 fixed flex flex-col gap-3 justify-center w-6/9"
      >
        <button className="text-white self-end" onClick={() => {closeDialog()}}>
          X
        </button>
        <h1 className="text-white text-2xl font-bold">
          {selection.name}'s Players
        </h1>
        <hr className="w-full border-stone-700" />
        <div className="flex flex-col items-center gap-3 w-full h-[200px] overflow-hidden overflow-y-auto">
          {selection.onlinePlayerNames?.map((player, index) => (
            <div className="w-full flex flex-col gap-3" key={index}>
              <p className="px-3 text-white">
                {index}. {player}
              </p>
              <hr className="w-full border-stone-700" />
            </div>
          ))}
        </div>
      </dialog>
    </>
  );
};

export default Dialog;
