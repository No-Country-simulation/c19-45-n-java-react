import React from "react";
import { Footer, ModalTeam, Navbar } from "@/components";

interface ILayoutMain {
  children: React.ReactNode;
}

export const LayoutMain = ({ children }: ILayoutMain) => {
  return (
    <>
      <Navbar />
      <main className="container__appPets py-10 flex flex-col gap-10">
        {children}
      </main>
      <Footer />
      <ModalTeam />
    </>
  );
};
