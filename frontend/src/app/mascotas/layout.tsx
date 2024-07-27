import React from "react";
import { Footer, Navbar } from "@/app/_components";

const LayoutPets = ({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) => {
  return (
    <>
      <Navbar />
      <main className="container__appPets py-10 flex flex-col gap-10">
        {children}
      </main>
      <Footer />
    </>
  );
};

export default LayoutPets;
