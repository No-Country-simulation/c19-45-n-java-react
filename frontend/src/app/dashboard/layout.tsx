import { LayoutLogged } from "@/layouts";

const LayoutDashboard = ({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) => {
  return (
    <LayoutLogged>
      <main className="my-12">{children}</main>
    </LayoutLogged>
  );
};

export default LayoutDashboard;
