import { useUserStore } from "@/store/useUserStore";
import Avatar from "react-avatar";
import SearchMusync from "./SearchMusync";

export function Header() {
  const { user } = useUserStore();
  return (
    <header className="sticky top-0 flex items-center justify-center gap-16 bg-background/95 p-6 backdrop-blur-md">
      <SearchMusync />
      <div className="flex items-center gap-4">
        <Avatar name={user.username} size="50" round={true} color="#FF5722" />
        <div className="flex flex-col">
          <span className="text-gray-500 text-[14px] font-semibold capitalize">
            {user.username}
          </span>
          <span className="text-gray-500 text-[13px]">1,2k Followers</span>
        </div>
      </div>
    </header>
  );
}
