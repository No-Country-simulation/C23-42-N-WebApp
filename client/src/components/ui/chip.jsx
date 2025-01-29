/* eslint-disable */
import { cn } from "@/lib/utils";

export function Chip({ selected, label, onClick }) {
  return (
    <button
      onClick={onClick}
      className={cn(
        "px-6 py-2 rounded-full text-sm font-medium transition-colors",
        "border border-transparent",
        selected
          ? "bg-[#4A7B6A] text-white"
          : "bg-white text-gray-500 hover:bg-gray-100",
      )}
    >
      {label}
    </button>
  );
}
