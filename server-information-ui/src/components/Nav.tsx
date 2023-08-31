import { Icons } from "./Icons";

export const Nav = ({ lastRefresh }: { lastRefresh: string }) => {
  return (
    <nav className="bg-stone-800 p-4 border-b border-b-stone-700 shadow-md fixed w-full flex justify-between items-center">
      <div className="flex gap-3 justify-center items-center">
        <Icons.cloud className="text-red-400" />
        <h1 className="font-bold text-xl text-red-400">
          Minecraft Server Information
        </h1>
      </div>
      <p className="text-white">Last refresh at: {lastRefresh}</p>
    </nav>
  );
};
