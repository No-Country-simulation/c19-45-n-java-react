"use client";
import { MODAL } from "../_constants";
import { useModalStore } from "../_store";

export const Footer = () => {
  const toggle = useModalStore((state) => state.toggle);
  return (
    <footer className="bg-[#FFAC31] p-8 text-center">
      <p className="text-2xl">
        Copyright © {new Date().getFullYear()} - All right reserved by No
        Country.{" "}
        <span
          className="font-bold cursor-pointer underline"
          onClick={() => toggle({ name: MODAL.TEAMS, isOpen: true })}
        >
          c19-45-n-java-react
        </span>
      </p>
    </footer>
  );
};
