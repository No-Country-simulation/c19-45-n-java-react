import { LayoutMain } from "@/layouts";

const LayoutPets = ({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) => {
  return <LayoutMain>{children}</LayoutMain>;
};

export default LayoutPets;
