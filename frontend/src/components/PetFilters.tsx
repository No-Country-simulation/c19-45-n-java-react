"use client";
import { MODAL } from "@/constants";
import { useModalStore } from "@/store";
import { IoFilter } from "react-icons/io5";

export const PetFilters = () => {
  const toggle = useModalStore((state) => state.toggle);
  return (
    <div className="flex justify-between">
      <h2 className="text-4xl font-bold">Especies</h2>
      <button
        onClick={() => toggle({ name: MODAL.FILTER, isOpen: true })}
        className="btn btn-active text-white btn-lg shadow-lg"
      >
        <IoFilter size={32} />
      </button>
    </div>
  );
};
