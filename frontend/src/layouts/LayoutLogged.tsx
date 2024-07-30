import { Footer, ModalTeam, NavbarLogged } from "@/components";

interface ILayoutLogged {
  children: React.ReactNode;
}

export const LayoutLogged = ({ children }: ILayoutLogged) => {
  return (
    <>
      <NavbarLogged />
      <main className="container__appPets py-10 flex flex-col gap-10">
        {children}
      </main>
      <Footer />
      <ModalTeam />
    </>
  );
};
