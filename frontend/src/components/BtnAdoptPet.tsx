"use client";

import { MODAL } from "@/constants";
import { useModalStore } from "@/store";
import { IoHeartOutline } from "react-icons/io5";

export const BtnAdoptPet = () => {
  const toggle = useModalStore((state) => state.toggle);
  return (
    <button
      onClick={() => toggle({ name: MODAL.PET, isOpen: true })}
      className="btn p-6 h-auto text-white text-2xl uppercase font-bold rounded-lg shadow-md"
    >
      Adoptar
      <IoHeartOutline size={40} />
    </button>
  );
};
