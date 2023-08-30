import { Icons } from "./Icons";

export const Nav = ({ lastRefresh }: { lastRefresh: string }) => {
  return (
    <nav className="bg-red-400 p-4 border-b-2 border-b-red-200 fixed w-full flex justify-between items-center">
      <div className="flex gap-3 justify-center items-center">
        <Icons.cloud />
        <h1 className="font-bold text-xl text-white">
          Minecraft Server Information
        </h1>
      </div>
      <p className="text-white">Last refresh at: {lastRefresh}</p>
    </nav>
  );
};
